package com.google.code.mathparser.operator;

import com.google.code.mathparser.operator.behaviour.OperatorBehaviourFactory;


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

public final class OperatorFactory {

	private static final String ADD_SYMBOL = "+";
	private static final String SUBS_SYMBOL = "-";
	private static final String MUL_SYMBOL = "*";
	private static final String DIV_SYMBOL = "/";
	private static final String POW_SYMBOL = "^";
	private static final String LEFT_PARENTHESES_SYMBOL = "(";
	private static final String RIGHT_PARENTHESES_SYMBOL = ")";
	
	private static final int TWO_ARGUMENTS = 2;
	private static final int ZERO_ARGUMENTS = 0;
	
	private static final int ADD_OP_PRECEDENCE = 2;
	private static final int SUBS_OP_PRECEDENCE = 2;
	private static final int MUL_OP_PRECEDENCE = 3;
	private static final int DIV_OP_PRECEDENCE = 3;
	private static final int POW_OP_PRECEDENCE = 4;
	private static final int PARENTHESES_PRECEDENCE = 1;
	
	private static String symbol;
	private static int neededArguments;
	private static int precedence;
	
	private OperatorFactory(){};

	private static Operator createOperator(String symbol, int precedence, OperatorAssociativity associativity, int neededArguments,	OperatorBehaviour operatorBehaviour) {
		return new Operator(symbol, precedence, associativity, neededArguments,	operatorBehaviour);
	}

	public static Operator createAddOperator() {
		symbol = ADD_SYMBOL;
		neededArguments = TWO_ARGUMENTS;
		precedence = ADD_OP_PRECEDENCE;
		return OperatorFactory.createOperator(symbol, precedence, OperatorAssociativity.LEFT, neededArguments, OperatorBehaviourFactory.createAddBehaviour(symbol, neededArguments));
	}

	public static Operator createSubsOperator() {
		symbol = SUBS_SYMBOL;
		neededArguments = TWO_ARGUMENTS;
		precedence = SUBS_OP_PRECEDENCE;
		return OperatorFactory.createOperator(symbol, precedence, OperatorAssociativity.LEFT, neededArguments, OperatorBehaviourFactory.createSubsBehaviour(symbol,	neededArguments));
	}

	public static Operator createMulOperator() {
		symbol = MUL_SYMBOL;
		neededArguments = TWO_ARGUMENTS;
		precedence = MUL_OP_PRECEDENCE;
		return OperatorFactory.createOperator(symbol, precedence, OperatorAssociativity.LEFT, neededArguments, OperatorBehaviourFactory.createMulBehaviour(symbol, neededArguments));
	}

	public static Operator createDivOperator() {
		symbol = DIV_SYMBOL;
		neededArguments = TWO_ARGUMENTS;
		precedence = DIV_OP_PRECEDENCE;
		return OperatorFactory.createOperator(symbol, precedence, OperatorAssociativity.LEFT, neededArguments, OperatorBehaviourFactory.createDivBehaviour(symbol, neededArguments));
	}

	public static Operator createPowOperator() {
		symbol = POW_SYMBOL;
		neededArguments = TWO_ARGUMENTS;
		precedence = POW_OP_PRECEDENCE;
		return OperatorFactory.createOperator(symbol, precedence, OperatorAssociativity.RIGHT, neededArguments, OperatorBehaviourFactory.createPowBehaviour(symbol, neededArguments));
	}

	public static Operator createLeftParentheses() {
		symbol = LEFT_PARENTHESES_SYMBOL;
		neededArguments = ZERO_ARGUMENTS;
		precedence = PARENTHESES_PRECEDENCE;
		return OperatorFactory.createOperator(symbol, precedence, OperatorAssociativity.LEFT, neededArguments, OperatorBehaviourFactory.createNoBehaviour());
	}

	public static Operator createRightParentheses() {
		symbol = RIGHT_PARENTHESES_SYMBOL;
		neededArguments = ZERO_ARGUMENTS;
		precedence = PARENTHESES_PRECEDENCE;
		return OperatorFactory.createOperator(symbol, neededArguments, OperatorAssociativity.LEFT, precedence, OperatorBehaviourFactory.createNoBehaviour());
	}
}
