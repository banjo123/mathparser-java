package com.xsoft.science.mathparser.factories.exception.messages.impl;

import com.xsoft.science.mathparser.constants.ErrorMessage;
import com.xsoft.science.mathparser.factories.exception.messages.ExceptionMessageFactory;

public class ExceptionMessageFactoryImpl implements ExceptionMessageFactory {

	public String createInsufficientParametersMessage(String operator,
			int numberExpectedArguments, int numberFoundArguments) {
		String message = ErrorMessage.INSUFFICIENT_PARAMETERS;
		message = message.replace("%OPERATOR%", operator);
		message = message.replace("%EXPECTED%",
				String.valueOf(numberExpectedArguments));
		message = message.replace("%FOUND%",
				String.valueOf(numberFoundArguments));
		return message;
	}

	public String createInvalidCharacterMessage(String invalidCharacter) {
		String message = ErrorMessage.INVALID_CHARACTER;
		message = message.replace("%CHAR%", invalidCharacter);
		return message;
	}

	public String createInvalidExpressionMessage() {
		return ErrorMessage.NULL_OR_EMPTY_EXPRESSION;
	}

	public String createInvalidOperatorMessage() {
		return ErrorMessage.INVALID_OPERATOR;
	}

	public String createMismatchedParenthesesMessage() {
		return ErrorMessage.MISMATCHED_PARENTHESES;
	}

	public String createTooManyValuesMessage() {
		return ErrorMessage.TOO_MANY_VALUES;
	}

}
