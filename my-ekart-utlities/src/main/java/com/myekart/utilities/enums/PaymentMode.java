package com.myekart.utilities.enums;

/**
 * The Enum PaymentMode.
 */
public enum PaymentMode {

	/** The card. */
	CARD(1, "CARD"),
	/** The upi. */
	UPI(2, "UPI"),
	/** The account transfer. */
	ACCOUNT_TRANSFER(3, "ACCOUNT_TRANSFER");

	/** The wallet to wallet transfer. */

	/** The channel. */
	private int channel;

	/** The type. */
	private String type;

	/**
	 * Instantiates a new payment mode.
	 *
	 * @param channel the channel
	 * @param type    the type
	 */
	private PaymentMode(int channel, String type) {
		this.channel = channel;
		this.type = type;
	}

	/**
	 * Channel.
	 *
	 * @return the int
	 */
	public int channel() {
		return channel;
	}

	/**
	 * Type.
	 *
	 * @return the string
	 */
	public String type() {
		return type;
	}

	/**
	 * Gets the enum.
	 *
	 * @param channel the channel
	 * @return the enum
	 */
	public static PaymentMode getEnum(int channel) {
		for (PaymentMode ch : PaymentMode.values()) {
			if (ch.channel == channel) {
				return ch;
			}
		}
		return null;
	}
}
