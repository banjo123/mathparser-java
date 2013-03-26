package com.google.code.mathparser.operator.utils;

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

import java.util.Arrays;

import com.google.code.mathparser.constants.OperatorConstants;
import com.google.code.mathparser.factories.impl.Factories;
import com.google.code.mathparser.operator.Operator;
import com.google.code.mathparser.operator.OperatorAssociativity;

public final class OperatorUtils {
	
	private OperatorUtils(){};

	public static Operator getOperator(String operator) {
		try {
			int index = Arrays.asList(OperatorConstants.VALID_OPERATORS_SYMBOLS).indexOf(operator);
			return OperatorConstants.VALID_OPERATORS[index];
		} catch (IndexOutOfBoundsException e) {
			Factories.getExceptionFactoryInstance().launchInvalidOperatorException();
			return null;
		}
	}

	public static boolean isAnValidSymbol(String candidate) {
		return Arrays.asList(OperatorConstants.VALID_OPERATORS_SYMBOLS).indexOf(candidate) != -1;
	}

	public static boolean isAParentheses(String candidate) {
		return Arrays.asList(OperatorConstants.PARENTHESES_SYMBOLS).indexOf(candidate) != -1;
	}

	public static boolean isAnOperator(String candidate) {
		return Arrays.asList(OperatorConstants.VALID_OPERATORS_SYMBOLS).indexOf(candidate) != -1;
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
