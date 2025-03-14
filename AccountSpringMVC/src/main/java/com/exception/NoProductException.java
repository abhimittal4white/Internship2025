package com.exception;

import java.util.Arrays;

public class NoProductException extends Exception {

	public NoProductException() {
		// TODO Auto-generated constructor stub
	}
	
	public NoProductException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}

	@Override
	public String toString() {
		return "NoProductException [getMessage()=" + getMessage() + ", getLocalizedMessage()=" + getLocalizedMessage()
				+ ", getCause()=" + getCause() + ", toString()=" + "]";
	}
	
	
}
