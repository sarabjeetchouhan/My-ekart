package com.myekart.utilities.enums;

/**
 * The Enum StatusCd.
 */
public enum StatusCd {

	/** The active. */
	ACTIVE("ACTIVE"),
	/** The inactive. */
	INACTIVE("INACTIVE"),
	/** The failed. */
	FAILED("FAILED"),
	/** The cancelled. */
	CANCELLED("CANCELLED"),
	/** The processing. */
	PROCESSING("PROCESSING"),
	/** The deleted. */
	DELETED("DELETED"),
	/** The delivered. */
	DELIVERED("DELIVERED"),
	/** The created. */
	CREATED("CREATED"),
	/** The replaced. */
	REPLACED("REPLACED"),
	/** The returned. */
	RETURNED("RETURNED"),
	/** The instock. */
	INSTOCK("INSTOCK"),
	/** The out of stock. */
	OUT_OF_STOCK("OUT_OF_STOCK");

	/** The code. */
	private String code;

	/**
	 * Instantiates a new status cd.
	 *
	 * @param code the code
	 */
	private StatusCd(String code) {
		this.code = code;
	}

	/**
	 * Status.
	 *
	 * @return the string
	 */
	public String status() {
		return code;
	}
}
