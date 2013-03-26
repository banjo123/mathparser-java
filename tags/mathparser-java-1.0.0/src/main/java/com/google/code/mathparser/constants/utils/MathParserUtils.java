package com.google.code.mathparser.constants.utils;

import com.google.code.mathparser.constants.OperatorConstants;

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

public final class MathParserUtils {
	
	private MathParserUtils(){};
	
	public static boolean tokenIsNumber(String token) {
		try {
			Double.parseDouble(token.replace(OperatorConstants.DEFAULT_DECIMAL_SEPARATOR, OperatorConstants.DEFAULT_JAVA_DECIMAL_SEPARATOR));
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static String transformGropCharsIntoParentheses(String expression) {
		String expressionToReturn = expression;
		expressionToReturn = expressionToReturn.replaceAll("\\[", "(");
		expressionToReturn = expressionToReturn.replaceAll("]", ")");
		expressionToReturn = expressionToReturn.replaceAll("\\{", "(");
		expressionToReturn = expressionToReturn.replaceAll("}", ")");
		return expressionToReturn;
	}
}
