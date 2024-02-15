package com.greenStitch.exceptions;

@SuppressWarnings("serial")
public class ResourceNotFoundException extends RuntimeException {
	public ResourceNotFoundException(String errorMessage) {
		super(String.format(errorMessage));
	}
}
