package com.isc.timekeeper.multipledb.api.token;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.isc.timekeeper.multipledb.timekeeper.entity.TimeKeeperUser;



public class Token {

	public static Set<TokenCustom> tokens = new HashSet<TokenCustom>();
	
	public TimeKeeperUser getUserbyToken(String token) {
		for (TokenCustom tokenCustom : tokens) {
			if (token.equals(tokenCustom.getToken())) {
				return tokenCustom.getUser();
			}
		}
		return null;
	}
	public static TokenCustom getTokenCustom(String token) {
		for (TokenCustom tokenCustom : tokens) {
			if (token.equals(tokenCustom.getToken())) {
				return tokenCustom;
			}
		}
		return null;
	}
	public static void addToken(TokenCustom token) {
		tokens.add(token);
	}
	
	public static void deleteToken(String token) {
		List<TokenCustom> toRemove = new ArrayList<TokenCustom>();
		for (TokenCustom tokenCustom : tokens) {
		   
		    if (token.equals(tokenCustom.getToken())) {
		    	toRemove.add(tokenCustom);
			}
		}
		tokens.removeAll(toRemove);
		
	}
	public static void displayTokens() {
		System.out.println("----");
		for (TokenCustom tokenCustom : tokens) {
			System.out.println(tokenCustom);
		}
		System.out.println("----");
	}
}
