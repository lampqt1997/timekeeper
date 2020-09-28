package com.isc.timekeeper.multipledb.api;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.isc.timekeeper.multipledb.timekeeper.dto.TimeKeeperSpecialDayDTO;
import com.isc.timekeeper.multipledb.timekeeper.entity.TimeKeeperSpecialDay;
import com.isc.timekeeper.multipledb.timekeeper.service.TimeKeeperSpecialDayService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/holiday")
public class SpecialDayResource {

	@Autowired
	private TimeKeeperSpecialDayService tkSpecialDayService;

	@GetMapping
	public ResponseEntity<?> getAll() {
		List<TimeKeeperSpecialDay> tks = tkSpecialDayService.getAll();
		List<TimeKeeperSpecialDayDTO> result = null;
		if (tks.isEmpty()) {
			return new ResponseEntity<Object>(HttpStatus.OK);
		} else {
			result = new ArrayList<TimeKeeperSpecialDayDTO>();
			for (TimeKeeperSpecialDay t : tks) {
				result.add(TimeKeeperSpecialDayDTO.builder().title(t.getSpName()).date(t.getSpdate()).build());
			}
			return new ResponseEntity<Object>(result, HttpStatus.OK);
		}

	}

	@PutMapping
	public ResponseEntity<?> add(@RequestBody TimeKeeperSpecialDayDTO special) {
		System.out.println(special.toString());
		TimeKeeperSpecialDay tk = TimeKeeperSpecialDay.builder()
				.spCoefficient(2)
				.spName(special.getTitle())
				.spdate(special.getDate())
				.isDisable(false)
				.build();
		TimeKeeperSpecialDay isAdd = tkSpecialDayService.add(tk);

		return new ResponseEntity<Object>(isAdd, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> update(@RequestBody TimeKeeperSpecialDayDTO special) {
		System.out.println(special.toString());
		TimeKeeperSpecialDay tk = TimeKeeperSpecialDay.builder().spCoefficient(2).spName(special.getTitle())
				.spdate(special.getDate()).build();
		int id = tkSpecialDayService.update(special);
		TimeKeeperSpecialDay tkDay = tkSpecialDayService.get(id).get();

		return new ResponseEntity<Object>(tkDay, HttpStatus.OK);
	}
	@PostMapping(path="/delete")
	public ResponseEntity<?> delete(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
		System.out.println(date);

		int id = tkSpecialDayService.delete(date);
		TimeKeeperSpecialDay  tkpsd = tkSpecialDayService.get(id).get();
		
		return new ResponseEntity<Object>(tkpsd, HttpStatus.OK);

	}
	
}
