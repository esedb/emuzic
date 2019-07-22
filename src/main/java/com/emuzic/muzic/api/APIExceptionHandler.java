package com.emuzic.muzic.api;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class APIExceptionHandler {
	
	 @ExceptionHandler(ServletRequestBindingException.class)
	 public ResponseEntity<?> servletRequestBindingException(ServletRequestBindingException e) {
		 APIErrorDetails errorDetails = new APIErrorDetails();
		 errorDetails.setErrorMessage(e.getMessage());
		 errorDetails.setDevErrorMessage(getStackTraceAsString(e));
		 return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	 }
	 
	 @ExceptionHandler(Exception.class)
	 public ResponseEntity<?> exception(Exception e) {
		 APIErrorDetails errorDetails = new APIErrorDetails();
		 errorDetails.setErrorMessage(e.getMessage());
		 errorDetails.setDevErrorMessage(getStackTraceAsString(e));
		 return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	 }
	 
	 private String getStackTraceAsString(Exception e)
	 {
		 StringWriter sw = new StringWriter();
		 PrintWriter pw = new PrintWriter(sw);
		 e.printStackTrace(pw);
		 return sw.toString();
	 }
	

}
