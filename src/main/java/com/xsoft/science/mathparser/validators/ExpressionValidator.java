package com.xsoft.science.mathparser.validators;

import com.xsoft.science.mathparser.constants.OperatorConstants;
import com.xsoft.science.mathparser.constants.utils.MathParserUtils;
import com.xsoft.science.mathparser.factories.Factories;
import com.xsoft.science.mathparser.factories.exception.ExceptionFactory;
import com.xsoft.science.mathparser.operator.Operator;
import com.xsoft.science.mathparser.operator.utils.OperatorUtils;

public class ExpressionValidator extends Validator {

	private Object expressionObject;
	private String expression;
	private ExceptionFactory exceptionFactory = Factories
			.getExceptionFactoryInstance();

	@Override
	public void validate(Object value) {
		expressionObject = value;
		evalIfExpressionIsNullOrEmpty();
		evalIfExpressionIsWellFormed();

	}

	private void evalIfExpressionIsWellFormed() {
		expression = expressionObject.toString().trim();
		this.expression = MathParserUtils.transformGropCharsIntoParentheses(this.expression);
		evalIfExpressionStartIsCorrect();
		evalIfExpressionEndIsCorrect();
	}


	private void evalIfExpressionEndIsCorrect() {
		String expressionChar = findFirstExpressionCharThatIsNotARightParenthesesFromTheEnding();
		if (OperatorUtils.isAnOperator(expressionChar)) {
			Operator operator = OperatorUtils.getOperator(expressionChar);
			if (isMulOperator(operator) || isDivOperator(operator)
					|| isPowOperator(operator) || isSubOperator(operator)
					|| isAddOperator(operator)) {
				launchInvalidExpressionException();
			}
		}
	}

	private String findFirstExpressionCharThatIsNotARightParenthesesFromTheEnding() {
		char[] expressionArray = expression.toCharArray();
		int pointer = expressionArray.length - 1;
		String expressionChar = "";
		do {
			expressionChar = String.valueOf(expressionArray[pointer]);
			pointer -= 1;
		} while (pointer >= 0
				&& (expressionChar.equals("") || expressionChar.equals(")")));

		if (pointer < 0) {
			expressionChar = "";
		}

		return expressionChar;
	}

	private boolean isSubOperator(Operator operator) {
		return OperatorConstants.ADD.equals(operator);
	}

	private boolean isAddOperator(Operator operator) {
		return OperatorConstants.SUBS.equals(operator);
	}

	private void evalIfExpressionStartIsCorrect() {
		String firstChar = findFirstExpressionCharThatIsNotALeftParenthesesFromTheStart();
		if (OperatorUtils.isAnOperator(firstChar)) {
			Operator operator = OperatorUtils.getOperator(firstChar);
			if (isMulOperator(operator) || isDivOperator(operator)
					|| isPowOperator(operator)) {
				launchInvalidExpressionException();
			}
		}
	}

	private String findFirstExpressionCharThatIsNotALeftParenthesesFromTheStart() {
		char[] expressionArray = expression.toCharArray();
		int pointer = 0;
		String expressionChar = "";
		do {
			expressionChar = String.valueOf(expressionArray[pointer]);
			pointer += 1;
		} while (pointer < expressionArray.length
				&& (expressionChar.equals("") || expressionChar.equals("(")));

		if (pointer == expressionArray.length) {
			expressionChar = "";
		}

		return expressionChar;
	}

	private boolean isMulOperator(Operator operator) {
		return OperatorConstants.MULT.equals(operator);
	}

	private boolean isPowOperator(Operator operator) {
		return OperatorConstants.POW.equals(operator);
	}

	private boolean isDivOperator(Operator operator) {
		return OperatorConstants.DIV.equals(operator);
	}

	private void evalIfExpressionIsNullOrEmpty() {
		if (expressionObject == null
				|| expressionObject.toString().length() == 0) {
			launchInvalidExpressionException();
		}
	}

	private void launchInvalidExpressionException() {
		exceptionFactory.launchInvalidExpressionException();
	}

}
