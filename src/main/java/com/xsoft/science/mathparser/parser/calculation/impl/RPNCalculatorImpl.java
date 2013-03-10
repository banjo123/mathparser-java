package com.xsoft.science.mathparser.parser.calculation.impl;

/*
 MathParser Java - Cross Platform Mathematical Expressions Parser
 Copyright 2013 Rodríguez Hernández, Daniel.

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

import com.xsoft.science.mathparser.constants.utils.MathParserUtils;
import com.xsoft.science.mathparser.factories.Factories;
import com.xsoft.science.mathparser.factories.calculator.CalculatorFactory;
import com.xsoft.science.mathparser.factories.exception.ExceptionFactory;
import com.xsoft.science.mathparser.operator.Operator;
import com.xsoft.science.mathparser.operator.utils.OperatorUtils;
import com.xsoft.science.mathparser.parser.calculation.RPNCalculator;
import com.xsoft.science.mathparser.parser.calculation.Result;
import com.xsoft.science.mathparser.tokenStructure.TokenQueue;
import com.xsoft.science.mathparser.tokenStructure.TokenStack;
import com.xsoft.science.mathparser.tokenStructure.TokenStructureFactory;

public class RPNCalculatorImpl implements RPNCalculator {

	private final CalculatorFactory calculatorFactory = Factories.getCalculatorFactoryInstance();
	private final ExceptionFactory exceptionFactory = Factories.getExceptionFactoryInstance();

	private TokenQueue expressionInTokens;
	private TokenStack rpnStack;
	private Result result;
	private String actualToken;
	private Operator actualOperator;
	private int pointer;

	public void setRPNExpression(TokenQueue expression) {
		initialize();
		expressionInTokens = expression;
	}

	private void initialize() {
		pointer = 0;
		result = calculatorFactory.createResult();
		rpnStack = TokenStructureFactory.createStack();
	}

	public Result calculate() {
		if (resultHasNotBeenCalculatedYet()) {
			rpnAlgorithm();
		}
		return result;
	}

	private void rpnAlgorithm() {
		while (queueHasMoreElementsToIterate()) {
			readNextToken();
			evalTokenAndRealizeAction();
			updatePointer();
		}
		throwExceptionIfThereAreMoreThanOneValueInStack();
		saveStackValueIntoResult();
	}

	private void evalTokenAndRealizeAction() {
		if (tokenIsNumber()) {
			pushTokenIntoStack();
		} else {
			matchTokenWithAnOperator();
			doCalculation();
		}
	}

	private boolean resultHasNotBeenCalculatedYet() {
		return result.doubleValue() == null;
	}

	private void throwExceptionIfThereAreMoreThanOneValueInStack() {
		if (rpnStack.size() > 1) {
			exceptionFactory.launchTooManyValuesException();
		}
	}

	private void saveStackValueIntoResult() {
		result.setResult(Double.valueOf(rpnStack.pop()));
	}

	private void doCalculation() {
		rpnStack.push(String.valueOf(actualOperator.calculateWith(rpnStack)));
	}

	private void matchTokenWithAnOperator() {
		this.actualOperator = OperatorUtils.getOperator(actualToken);
	}

	private void pushTokenIntoStack() {
		rpnStack.push(actualToken);
	}

	private boolean tokenIsNumber() {
		return MathParserUtils.tokenIsNumber(actualToken);
	}

	private void updatePointer() {
		pointer += 1;
	}

	private void readNextToken() {
		actualToken = expressionInTokens.getTokenAt(pointer);
	}

	private boolean queueHasMoreElementsToIterate() {
		return pointer < expressionInTokens.size();
	}

}
