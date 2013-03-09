package com.xsoft.science.mathparser.factories.exception.impl;

import com.xsoft.science.mathparser.factories.Factories;

public class InvalidExpressionException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8538179524323829757L;

	InvalidExpressionException() {
		super(Factories.getExceptionMessageFactoryInstance()
				.createInvalidExpressionMessage());
	}

}
