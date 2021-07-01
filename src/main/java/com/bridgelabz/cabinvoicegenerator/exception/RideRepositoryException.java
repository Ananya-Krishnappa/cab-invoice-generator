package com.bridgelabz.cabinvoicegenerator.exception;

import com.bridgelabz.cabinvoicegenerator.type.ExceptionType;

public class RideRepositoryException extends Exception {
	public ExceptionType type;

	public RideRepositoryException(String message, ExceptionType type) {
		super(message);
		this.type = type;
	}
}
