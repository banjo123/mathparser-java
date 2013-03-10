package com.google.code.mathparser.parser;

/*
 MathParser Java - Cross Platform Mathematical Expressions Parser
 Copyright 2013 Rodríguez Hernández, Daniel.
 daniel.rguez.hdez[at]gmail.com

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */

import com.google.code.mathparser.constants.OperatorConstants;
import com.google.code.mathparser.constants.utils.MathParserUtils;
import com.google.code.mathparser.factories.Factories;
import com.google.code.mathparser.factories.exception.ExceptionFactory;
import com.google.code.mathparser.operator.utils.OperatorUtils;
import com.google.code.mathparser.tokenStructure.TokenQueue;
import com.google.code.mathparser.tokenStructure.TokenStructureFactory;
import com.google.code.mathparser.validators.Validator;
import com.google.code.mathparser.validators.ValidatorsFactory;

public class LexicalTokenizer {

	private Validator expressionValidator = ValidatorsFactory.createExpressionValidator();
	private ExceptionFactory exceptionFactory = Factories.getExceptionFactoryInstance();
	private TokenQueue tokens;

	private String expression;
	private int lengthExpression;

	private int pointer;

	private StringBuffer queue;
	private String actualChar;

	public void setExpression(String expression) {
		cleanOldAttributes();
		assignNewExpression(expression);
	}

	private void cleanOldAttributes() {
		tokens = TokenStructureFactory.createQueue();
		pointer = 0;
		queue = null;
		actualChar = null;
	}

	private void assignNewExpression(String expression) {
		this.expression = expression;
		validateExpression();
		trimExpression();
		transformGropCharsIntoParentheses();
		addConversorsForPositiveModificators();
		addConversorsForNegativeModificators();
		removePositiveOperatorsExcedent();
		this.lengthExpression = this.expression.length();
	}


	private void transformGropCharsIntoParentheses() {
		this.expression = MathParserUtils.transformGropCharsIntoParentheses(this.expression);
	}

	private void trimExpression() {
		this.expression = expression.trim().replace(" ", "");

	}

	public TokenQueue getTokens() {
		splitExpressionInTokens();
		return tokens;
	}

	private void splitExpressionInTokens() {
		cleanQueue();
		while (hasNextCaracter()) {
			obtainNextChar();
			saveTokenOrPushQueueForNextNumber();
			updatePointer();
		}
		evalIfQueueHasContentAndSaveItAsToken();
	}
	
	private void removePositiveOperatorsExcedent() {
		expression = expression.replace("(+(", "((");
	}

	private void addConversorsForPositiveModificators() {
		//Nothing to add
	}

	private void addConversorsForNegativeModificators() {
		expression = expression.replace("-", "+(0-1)*");
	}

	private void evalIfQueueHasContentAndSaveItAsToken() {
		if (queue.toString().length() > 0) {
			if (formerOperatorIsRightParentheses()) {
				addMultiplicatorToken();
			}

			tokens.addToken(queue.toString());
		}
	}

	private void validateExpression() {
		expressionValidator.validate(expression);
	}

	private void saveTokenOrPushQueueForNextNumber() {
		if (actualCharIsNumber()) {
			pushActualCharInQueue();
		} else if (actualCharIsDecimalSeparator()) {
			evalExistAnotherDecimalSeparatorAndThrowExceptionIsSo();
			pushActualCharInQueue();
		} else if (actualCharIsAnOperatorOrParentheses()) {
			evalIfQueueHasContentAndSaveItAsToken();
			cleanQueue();
			saveTokenFromActualChar();
		} else {
			exceptionFactory.launchInvalidCharacterException(actualChar);
		}
	}

	private boolean actualCharIsAnOperatorOrParentheses() {
		return OperatorUtils.isAnValidSymbol(actualChar);
	}

	private void updatePointer() {
		pointer++;
	}

	private void saveTokenFromActualChar() {
		if (actualCharIsLeftParentheses() && formerTokenIsANumber()) {
			addMultiplicatorToken();
		}

		tokens.addToken(actualChar);
	}

	private boolean formerTokenIsANumber() {
		return OperatorUtils.isNumber(tokens.getLastToken());
	}

	private boolean formerOperatorIsRightParentheses() {
		return OperatorConstants.RIGHT_PARENTHESES.getSymbol().equals(tokens.getLastToken());
	}

	private boolean actualCharIsLeftParentheses() {
		return OperatorConstants.LEFT_PARENTHESES.getSymbol().equals(actualChar);
	}

	private void addMultiplicatorToken() {
		tokens.addToken(OperatorConstants.MULT.getSymbol());
	}

	private void evalExistAnotherDecimalSeparatorAndThrowExceptionIsSo() {
		int positionAnotherDecimalSeparator = queue
				.indexOf(OperatorConstants.DEFAULT_DECIMAL_SEPARATOR);
		if (positionAnotherDecimalSeparator > -1) {
			exceptionFactory.launchInvalidExpressionException();
		}
	}

	private boolean actualCharIsDecimalSeparator() {
		return actualChar.equalsIgnoreCase(OperatorConstants.DEFAULT_DECIMAL_SEPARATOR);
	}

	private boolean actualCharIsNumber() {
		try {
			Integer.parseInt(actualChar);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private void pushActualCharInQueue() {
		queue.append(actualChar);
	}

	private void cleanQueue() {
		queue = new StringBuffer();
	}

	private void obtainNextChar() {
		actualChar = String.valueOf(expression.charAt(pointer));
	}

	private boolean hasNextCaracter() {
		return pointer < lengthExpression;
	}

}
