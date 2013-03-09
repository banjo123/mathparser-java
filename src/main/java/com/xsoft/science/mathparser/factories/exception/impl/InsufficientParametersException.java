package com.xsoft.science.mathparser.factories.exception.impl;

import com.xsoft.science.mathparser.factories.Factories;

public class InsufficientParametersException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3860253776192660453L;

	InsufficientParametersException(String operator,
			int numberExpectedArguments, int numberFoundArguments) {
		super(Factories.getExceptionMessageFactoryInstance()
				.createInsufficientParametersMessage(operator,
						numberExpectedArguments, numberFoundArguments));
	}

}
