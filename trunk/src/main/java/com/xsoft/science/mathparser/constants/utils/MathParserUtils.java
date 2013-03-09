package com.xsoft.science.mathparser.constants.utils;

public class MathParserUtils {
	public static boolean tokenIsNumber(String token) {
		try {
			Double.parseDouble(token.replace(
					MathParserConstants.DEFAULT_DECIMAL_SEPARATOR,
					MathParserConstants.DEFAULT_JAVA_DECIMAL_SEPARATOR));
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	public static String transformGropCharsIntoParentheses(String expression) {
		expression = expression.replaceAll("\\[", "(");
		expression = expression.replaceAll("]", ")");
		expression = expression.replaceAll("\\{", "(");
		expression = expression.replaceAll("}", ")");
		return expression;
	}
}
