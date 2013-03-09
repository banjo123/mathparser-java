package com.xsoft.science.mathparser.validators;

public class ValidatorsFactory {

	public static Validator createExpressionValidator() {
		return new ExpressionValidator();
	}
}
