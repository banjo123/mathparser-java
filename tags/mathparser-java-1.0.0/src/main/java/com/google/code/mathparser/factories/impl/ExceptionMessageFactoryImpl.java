package com.google.code.mathparser.factories.impl;

/*
 MathParser Java - Cross Platform Mathematical Expressions Parser
 Copyright 2013 Rodríguez Hernández, Daniel.
 daniel.rguez.hdez[at]gmail.com

 Licensed under the Apache License, Version 2.0 [the "License"]
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */

import com.google.code.mathparser.constants.ErrorMessage;
import com.google.code.mathparser.factories.exception.messages.ExceptionMessageFactory;

public class ExceptionMessageFactoryImpl implements ExceptionMessageFactory {
	
	ExceptionMessageFactoryImpl(){};

	public String createInsufficientParametersMessage(String operator, int numberExpectedArguments, int numberFoundArguments) {
		String message = ErrorMessage.INSUFFICIENT_PARAMETERS;
		message = message.replace("%OPERATOR%", operator);
		message = message.replace("%EXPECTED%",	String.valueOf(numberExpectedArguments));
		message = message.replace("%FOUND%", String.valueOf(numberFoundArguments));
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
