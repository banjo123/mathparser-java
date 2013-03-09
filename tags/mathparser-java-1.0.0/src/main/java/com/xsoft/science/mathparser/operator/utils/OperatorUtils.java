package com.xsoft.science.mathparser.operator.utils;

import java.util.Arrays;

import com.xsoft.science.mathparser.constants.OperatorConstants;
import com.xsoft.science.mathparser.constants.OperatorConstantsFactory;
import com.xsoft.science.mathparser.factories.Factories;
import com.xsoft.science.mathparser.operator.Operator;
import com.xsoft.science.mathparser.operator.OperatorAssociativity;

public final class OperatorUtils {

	public static Operator getOperator(String operator) {
		try {
			int index = Arrays.asList(OperatorConstants.validOperatorsSymbols)
					.indexOf(operator);
			return OperatorConstants.validOperators[index];
		} catch (IndexOutOfBoundsException e) {
			Factories.getExceptionFactoryInstance()
					.launchInvalidOperatorException();
			return null;
		}
	}

	public static boolean isAnValidSymbol(String candidate) {
		return Arrays.asList(OperatorConstants.validOperatorsSymbols).indexOf(
				candidate) != -1;
	}

	public static boolean isAParentheses(String candidate) {
		return Arrays.asList(OperatorConstants.parenthesesSymbols).indexOf(
				candidate) != -1;
	}

	public static boolean isAnOperator(String candidate) {
		return Arrays.asList(OperatorConstants.validOperatorsSymbols).indexOf(
				candidate) != -1;
	}

	public static boolean isLeftAssociativity(String operator) {
		return OperatorUtils.getOperator(operator).getAssociativity() == OperatorAssociativity.LEFT;
	}

	public static boolean isRightAssociativity(String operator) {
		return OperatorUtils.getOperator(operator).getAssociativity() == OperatorAssociativity.RIGHT;
	}

	public static int comparePrecedence(String operator1, String operator2) {
		Operator operatorObj1 = OperatorUtils.getOperator(operator1);
		Operator operatorObj2 = OperatorUtils.getOperator(operator2);

		return operatorObj1.compareTo(operatorObj2);
	}
	
	public static boolean isNumber(String candidate) {
		try {
			Integer.parseInt(candidate);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
