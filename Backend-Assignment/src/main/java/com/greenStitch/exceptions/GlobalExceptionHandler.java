package com.greenStitch.exceptions;

import javax.net.ssl.SSLHandshakeException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(IllegalArgumentException.class)
	public void resourceNotFoundExceptionHandler(IllegalArgumentException ex) {
		String errorMessage = ex.getMessage();
		System.out.println(errorMessage);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public void resourceNotFoundExceptionHandler(ResourceNotFoundException ex) {
		String errorMessage = ex.getMessage();
		System.out.println(errorMessage);
	}

	@ExceptionHandler(SSLHandshakeException.class)
	public void handleSSLHandshakeException(SSLHandshakeException ex) {
		String errorMessage = ex.getMessage();
		System.out.println(errorMessage);
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public void handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
		String errorMessage = ex.getMessage();
		System.out.println(errorMessage);
	}

	@ExceptionHandler(NullPointerException.class)
	public void handleNullPointerException(NullPointerException ex) {
		String errorMessage = ex.getMessage();
		System.out.println(errorMessage);
	}

	@ExceptionHandler(IllegalStateException.class)
	public void handleIllegalStateException(IllegalStateException ex) {
		String errorMessage = ex.getMessage();
		System.out.println(errorMessage);
	}

	@ExceptionHandler(InvalidCommandException.class)
	public void handleInvalidCommandException(InvalidCommandException ex) {
		String errorMessage = ex.getMessage();
		System.out.println(errorMessage);
	}

}
