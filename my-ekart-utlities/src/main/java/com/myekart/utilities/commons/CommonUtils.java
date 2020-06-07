package com.myekart.utilities.commons;

import java.util.Base64;
import java.util.UUID;

public final class CommonUtils {

	public static String generateId() {
		String id = UUID.randomUUID().toString();
		return id.replaceAll("-", "");
	}

	public static String encrypt(String input) {
		return Base64.getEncoder().encode(input.getBytes()).toString();
	}

	public static String decrypt(String input) {
		return Base64.getDecoder().decode(input).toString();
	}
}
