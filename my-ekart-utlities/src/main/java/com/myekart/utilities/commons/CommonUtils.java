package com.myekart.utilities.commons;

import java.util.Base64;
import java.util.Random;
import java.util.UUID;

public final class CommonUtils {

	private static final String ACCOUNT_NUMBER_SUFFIX = "AC";

	private static final int ACCOUNT_NUMBER_LENGHT = 12;

	private static final String TRANSACTION_ID_SUFFIX = "TXN";

	private static final int TRANSACTION_ID_LENGHT = 15;

	public static String generateId() {
		String id = UUID.randomUUID().toString();
		return id.replaceAll("-", "");
	}

	public static String accountNumber() {
		Random random = new Random();
		char[] digits = new char[ACCOUNT_NUMBER_LENGHT];
		digits[0] = (char) (random.nextInt(9) + '1');
		for (int i = 1; i < ACCOUNT_NUMBER_LENGHT; i++) {
			digits[i] = (char) (random.nextInt(10) + '0');
		}
		return ACCOUNT_NUMBER_SUFFIX + new String(digits);
	}

	public static String transactionId() {
		Random random = new Random();
		char[] digits = new char[TRANSACTION_ID_LENGHT];
		digits[0] = (char) (random.nextInt(9) + '1');
		for (int i = 1; i < TRANSACTION_ID_LENGHT; i++) {
			digits[i] = (char) (random.nextInt(10) + '0');
		}
		return TRANSACTION_ID_SUFFIX + new String(digits);
	}

	public static String encrypt(String input) {
		return Base64.getEncoder().encode(input.getBytes()).toString();
	}

	public static String decrypt(String input) {
		return Base64.getDecoder().decode(input).toString();
	}
}
