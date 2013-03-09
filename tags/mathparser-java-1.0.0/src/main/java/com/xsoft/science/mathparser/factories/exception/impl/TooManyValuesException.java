package com.xsoft.science.mathparser.factories.exception.impl;

import com.xsoft.science.mathparser.factories.Factories;

public class TooManyValuesException extends RuntimeException {

	/**
	 * 
	 */
	private String message;
	private static final long serialVersionUID = -8371949652527873851L;

	TooManyValuesException() {
		super(Factories.getExceptionMessageFactoryInstance()
				.createTooManyValuesMessage());
	}

}
