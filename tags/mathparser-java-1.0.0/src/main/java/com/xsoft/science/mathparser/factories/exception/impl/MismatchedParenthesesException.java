package com.xsoft.science.mathparser.factories.exception.impl;

import com.xsoft.science.mathparser.factories.Factories;

public class MismatchedParenthesesException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4524432345373551670L;

	MismatchedParenthesesException() {
		super(Factories.getExceptionMessageFactoryInstance()
				.createMismatchedParenthesesMessage());
	}
}
