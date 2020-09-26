package com.isc.timekeeper.multipledb.api.token;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.springframework.stereotype.Component;


@Component
public class AES {
	

	public String encrypt(String key, String initVector, String value) {
		try {
			IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
			SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

			byte[] encrypted = cipher.doFinal(value.getBytes());

			return DatatypeConverter.printBase64Binary(encrypted);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return null;

	}

	public String decrypt(String key, String initVector, String encrypted) {
		try {
			IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
			SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

			byte[] original = cipher.doFinal(DatatypeConverter.parseBase64Binary(encrypted));

			return new String(original);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return null;
	}

	public String encrypt(String value) {
		String encryptString = encrypt(WebProperties.KEY, WebProperties.INIT_VECTOR, value);
		// delete == in base64
		return encryptString.substring(0, encryptString.length() - 2);
	}


	public String decrypt(String value) {
		// add == for base64
		String newValue = value+"==";
		return this.decrypt(WebProperties.KEY, WebProperties.INIT_VECTOR, newValue);
	}
}
