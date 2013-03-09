package com.xsoft.science.mathparser.factories.exception.impl;

import com.xsoft.science.mathparser.factories.exception.ExceptionFactory;

public class ExceptionFactoryImpl implements ExceptionFactory {

	public void launchInsufficientParamtersException(String operator,
			int expectedArguments, int foundArguments) {
		throw new InsufficientParametersException(operator, expectedArguments,
				foundArguments);
	}

	public void launchInvalidCharacterException(String invalidCharacter) {
		throw new InvalidCharacterException(invalidCharacter);
	}

	public void launchInvalidExpressionException() {
		throw new InvalidExpressionException();
	}

	public void launchInvalidOperatorException() {
		throw new InvalidOperatorException();
	}

	public void launchMismatchedParenthesesException() {
		throw new MismatchedParenthesesException();
	}

	public void launchTooManyValuesException() {
		throw new TooManyValuesException();
	}

}
