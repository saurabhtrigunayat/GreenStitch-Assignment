package com.greenStitch.exceptions;

@SuppressWarnings("serial")
public class InvalidCommandException extends RuntimeException {
	public InvalidCommandException(String errorMessage) {
		super(String.format(errorMessage));
	}
}
