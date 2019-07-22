package com.emuzic.muzic;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class WrongFileException extends RuntimeException {
	public WrongFileException(String message) {
		super(message);
	}
	public WrongFileException(String message, Throwable cause) {
		super(message, cause);
	}

}

@ResponseStatus(HttpStatus.NOT_FOUND)
class ENotFoundException extends RuntimeException{
	public ENotFoundException(String message) {
		super(message);
	}
	public ENotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	
}