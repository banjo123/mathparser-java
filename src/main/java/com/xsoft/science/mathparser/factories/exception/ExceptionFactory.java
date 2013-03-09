package com.xsoft.science.mathparser.factories.exception;


public interface ExceptionFactory {
	public void launchInsufficientParamtersException(String operator,
			int expectedArguments, int foundArguments);

	public void launchInvalidCharacterException(String invalidCharacter);

	public void launchInvalidExpressionException();

	public void launchInvalidOperatorException();

	public void launchMismatchedParenthesesException();

	public void launchTooManyValuesException();
}
