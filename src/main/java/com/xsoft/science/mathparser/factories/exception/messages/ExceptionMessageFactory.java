package com.xsoft.science.mathparser.factories.exception.messages;

public interface ExceptionMessageFactory {
	public String createInsufficientParametersMessage(String operator,
			int numberExpectedArguments, int numberFoundArguments);

	public String createInvalidCharacterMessage(String invalidCharacter);

	public String createInvalidExpressionMessage();

	public String createInvalidOperatorMessage();

	public String createMismatchedParenthesesMessage();

	public String createTooManyValuesMessage();

}
