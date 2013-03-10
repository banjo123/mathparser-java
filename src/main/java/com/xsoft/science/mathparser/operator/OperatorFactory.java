package com.xsoft.science.mathparser.operator;

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

public class OperatorFactory {

	private static String symbol;
	private static int neededArguments;
	private static int precedence;

	private static Operator createOperator(String symbol, int precedence, OperatorAssociativity associativity, int neededArguments,	OperatorBehaviour operatorBehaviour) {
		return new Operator(symbol, precedence, associativity, neededArguments,	operatorBehaviour);
	}

	public static Operator createAddOperator() {
		symbol = "+";
		neededArguments = 2;
		precedence = 2;
		return OperatorFactory.createOperator(symbol, precedence, OperatorAssociativity.LEFT, neededArguments, OperatorBehaviourFactory.createAddBehaviour(symbol, neededArguments));
	}

	public static Operator createSubsOperator() {
		symbol = "-";
		neededArguments = 2;
		precedence = 2;
		return OperatorFactory.createOperator(symbol, precedence, OperatorAssociativity.LEFT, neededArguments, OperatorBehaviourFactory.createSubsBehaviour(symbol,	neededArguments));
	}

	public static Operator createMulOperator() {
		symbol = "*";
		neededArguments = 2;
		precedence = 3;
		return OperatorFactory.createOperator(symbol, precedence, OperatorAssociativity.LEFT, neededArguments, OperatorBehaviourFactory.createMulBehaviour(symbol, neededArguments));
	}

	public static Operator createDivOperator() {
		symbol = "/";
		neededArguments = 2;
		precedence = 3;
		return OperatorFactory.createOperator(symbol, precedence, OperatorAssociativity.LEFT, neededArguments, OperatorBehaviourFactory.createDivBehaviour(symbol, neededArguments));
	}

	public static Operator createPowOperator() {
		symbol = "^";
		neededArguments = 2;
		precedence = 4;
		return OperatorFactory.createOperator(symbol, precedence, OperatorAssociativity.RIGHT, neededArguments, OperatorBehaviourFactory.createPowBehaviour(symbol, neededArguments));
	}

	public static Operator createLeftParentheses() {
		symbol = "(";
		neededArguments = 0;
		precedence = 1;
		return OperatorFactory.createOperator(symbol, precedence, OperatorAssociativity.LEFT, neededArguments, OperatorBehaviourFactory.createNoBehaviour());
	}

	public static Operator createRightParentheses() {
		symbol = ")";
		neededArguments = 0;
		precedence = 1;
		return OperatorFactory.createOperator(symbol, neededArguments, OperatorAssociativity.LEFT, precedence, OperatorBehaviourFactory.createNoBehaviour());
	}
}
