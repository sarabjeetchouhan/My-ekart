package com.myekart.utilities.enums;

public enum UserType {

	ADMIN("ADMIN", "Admin"), USER("USER", "User");

	private String type;
	private String description;

	private UserType(String type, String description) {
		this.type = type;
		this.description = description;
	}

	public String type() {
		return type;
	}

	public String description() {
		return description;
	}

	public static String getType(String description) {
		for (UserType userType : UserType.values()) {
			if (description.equals(userType.description)) {
				return userType.type;
			}
		}
		return null;
	}

	public static String getDescription(String type) {
		for (UserType userType : UserType.values()) {
			if (type.equals(userType.type)) {
				return userType.description;
			}
		}
		return null;
	}
}
