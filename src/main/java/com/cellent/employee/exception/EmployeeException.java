package com.cellent.employee.exception;

public class EmployeeException extends RuntimeException {

	String s;

	public EmployeeException(String s) {
		this.s = s;
	}

	@Override
	public String toString() {
		return s;
	}
}
