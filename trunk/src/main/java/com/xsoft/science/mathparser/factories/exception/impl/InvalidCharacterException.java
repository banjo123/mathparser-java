package com.xsoft.science.mathparser.factories.exception.impl;

import com.xsoft.science.mathparser.factories.Factories;

public class InvalidCharacterException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2652833991021728686L;

	InvalidCharacterException(String invalidCharacter) {
		super(Factories.getExceptionMessageFactoryInstance()
				.createInvalidCharacterMessage(invalidCharacter));
	}
}
