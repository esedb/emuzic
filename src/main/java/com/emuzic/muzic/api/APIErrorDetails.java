package com.emuzic.muzic.api;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class APIErrorDetails {
	
	private String errorCode;
	private String errorMessage;
	private String devErrorMessage;
	private Map<String, Object> additionalData = new HashMap<>();

}
