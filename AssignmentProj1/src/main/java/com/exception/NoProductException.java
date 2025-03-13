package com.exception;

import java.util.Arrays;

public class NoProductException extends Exception {
	public NoProductException() {}
	public NoProductException(String msg) {
		super(msg);
	}
	@Override
	public String toString() {
		return "NoProductException [getMessage()=" + getMessage() + ", getLocalizedMessage()=" + getLocalizedMessage()
				+ ", getCause()=" + getCause() + ", toString()=" + "]";
	}
	
}
