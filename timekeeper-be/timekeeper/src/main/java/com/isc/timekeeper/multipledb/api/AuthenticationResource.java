package com.isc.timekeeper.multipledb.api;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DeviceUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isc.timekeeper.multipledb.api.template.ApiResponse;
import com.isc.timekeeper.multipledb.api.token.JwtTokenUtil;
import com.isc.timekeeper.multipledb.api.token.Token;
import com.isc.timekeeper.multipledb.api.token.TokenCustom;
import com.isc.timekeeper.multipledb.api.token.UserTokenState;
import com.isc.timekeeper.multipledb.api.token.WebProperties;
import com.isc.timekeeper.multipledb.timekeeper.dto.AccountDTO;
import com.isc.timekeeper.multipledb.timekeeper.entity.TimeKeeperUser;
import com.isc.timekeeper.multipledb.timekeeper.service.TimeKeeperUserService;

@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
@RequestMapping("/login")
public class AuthenticationResource {
	
	@Autowired
	private JwtTokenUtil tokenHelper;
	
	@Autowired
	private TimeKeeperUserService tkUserService;
	
	@PostMapping
	public ResponseEntity<?> login(@RequestBody AccountDTO account, HttpServletResponse response,HttpServletRequest request){
		
		
		boolean isTrue = tkUserService.authenticate(account);
		Device device = DeviceUtils.getCurrentDevice(request);
		System.out.println("devide: "+device);

		String token = tokenHelper.generateToken(account.getUsername(), device);
//		String token = "...";
		
		System.out.println("token: "+token);
		int expiresIn = tokenHelper.getExpiredIn(device);
		
		System.out.println("expiresIn: "+expiresIn);
		response.addCookie(createAuthCookie(token, expiresIn));
		
		TimeKeeperUser u = tkUserService.getUserByUserName(account.getUsername());
		
		Token.addToken(TokenCustom.builder().token(token).user(u).build());

		return ResponseEntity.ok(ApiResponse.builder()
				.errorCode(0)
				.data(UserTokenState.builder()
						.access_token(token)
						.expires_in((long) expiresIn)
						.build())
				.build());

	}


	@GetMapping(path="/refresh")
	public ResponseEntity<?> refreshAuthenticationToken(HttpServletRequest request, HttpServletResponse response) {
		String authToken = tokenHelper.getToken(request);
		Device device = DeviceUtils.getCurrentDevice(request);
		String userName = tokenHelper.getUsernameFromToken(authToken);

		if (authToken != null && tokenHelper.validateToken(authToken, userName)) {

			// TODO check user password last update
			String refreshedToken = tokenHelper.refreshToken(authToken, device);
			int expiresIn = tokenHelper.getExpiredIn(device);

			// Add cookie to response
			TokenCustom tkCustom = Token.getTokenCustom(WebProperties.JWT_PREFIX+"-"+authToken);
//			System.out.println(tkCustom);
			if (tkCustom!=null) {
				Token.addToken(TokenCustom.builder()
						.token(refreshedToken)
						.user(tkCustom.getUser())
						.build());
				Token.deleteToken(WebProperties.JWT_PREFIX+"-"+authToken);
			}
			response.addCookie(createAuthCookie(refreshedToken, expiresIn));
			
			return ResponseEntity.ok(UserTokenState.builder()
					.access_token(refreshedToken)
					.expires_in((long) expiresIn)
					.build());
		} else {
			// UserTokenState userTokenState = new UserTokenState();
			ApiResponse apiMessage = ApiResponse.builder()
					.errorCode(1)
					.data("token valid")
					.build(); 
			return new ResponseEntity<Object>(apiMessage, HttpStatus.OK);
			// return ResponseEntity.accepted().body(userTokenState);
		}
		

		
	}

	
	
	
	
	private Cookie createAuthCookie(String jwt, int expiresIn) {
		jwt = jwt.substring(7);
		Cookie authCookie = new Cookie(WebProperties.JWT_COOKIE, jwt);
		authCookie.setPath("/");
		authCookie.setHttpOnly(true);
		authCookie.setMaxAge(expiresIn);
		return authCookie;
	}
}
