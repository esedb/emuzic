package com.emuzic.muzic.api;

public class CUtility {
	static boolean isNull(String value) {
		if(value == null || value.equalsIgnoreCase("")) {
			return true;
		}
		return false;
	}

}
