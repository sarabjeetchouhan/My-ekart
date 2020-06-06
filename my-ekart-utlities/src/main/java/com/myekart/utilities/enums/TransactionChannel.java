package com.myekart.utilities.enums;

public enum TransactionChannel {

	CARD(1, "CARD"), UPI(2, "UPI"), ACCOUNT_TRANSFER(3, "ACCOUNT_TRANSFER"),
	WALLET_TO_WALLET_TRANSFER(4, "WALLET_TO_WALLET_TRANSFER");

	private int channel;

	private String type;

	private TransactionChannel(int channel, String type) {
		this.channel = channel;
		this.type = type;
	}

	public int channel() {
		return channel;
	}

	public String type() {
		return type;
	}

	public static TransactionChannel getEnum(int channel) {
		for (TransactionChannel ch : TransactionChannel.values()) {
			if (ch.channel == channel) {
				return ch;
			}
		}
		return null;
	}
}
