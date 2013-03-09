package com.xsoft.science.mathparser.operator;

public class OperatorFactory {

	private static String symbol;
	private static int neededArguments;
	private static int precedence;

	private static Operator createOperator(String symbol, int precedence,
			OperatorAssociativity associativity, int neededArguments,
			OperatorBehaviour operatorBehaviour) {
		return new Operator(symbol, precedence, associativity, neededArguments,
				operatorBehaviour);
	}

	public static Operator createAddOperator() {
		symbol = "+";
		neededArguments = 2;
		precedence = 2;
		return OperatorFactory.createOperator(symbol, precedence,
				OperatorAssociativity.LEFT, neededArguments,
				OperatorBehaviourFactory.createAddBehaviour(symbol,
						neededArguments));
	}

	public static Operator createSubsOperator() {
		symbol = "-";
		neededArguments = 2;
		precedence = 2;
		return OperatorFactory.createOperator(symbol, precedence,
				OperatorAssociativity.LEFT, neededArguments,
				OperatorBehaviourFactory.createSubsBehaviour(symbol,
						neededArguments));
	}

	public static Operator createMulOperator() {
		symbol = "*";
		neededArguments = 2;
		precedence = 3;
		return OperatorFactory.createOperator(symbol, precedence,
				OperatorAssociativity.LEFT, neededArguments,
				OperatorBehaviourFactory.createMulBehaviour(symbol,
						neededArguments));
	}

	public static Operator createDivOperator() {
		symbol = "/";
		neededArguments = 2;
		precedence = 3;
		return OperatorFactory.createOperator(symbol, precedence,
				OperatorAssociativity.LEFT, neededArguments,
				OperatorBehaviourFactory.createDivBehaviour(symbol,
						neededArguments));
	}

	public static Operator createPowOperator() {
		symbol = "^";
		neededArguments = 2;
		precedence = 4;
		return OperatorFactory.createOperator(symbol, precedence,
				OperatorAssociativity.RIGHT, neededArguments,
				OperatorBehaviourFactory.createPowBehaviour(symbol,
						neededArguments));
	}

	public static Operator createLeftParentheses() {
		symbol = "(";
		neededArguments = 0;
		precedence = 1;
		return OperatorFactory.createOperator(symbol, precedence,
				OperatorAssociativity.LEFT, neededArguments,
				OperatorBehaviourFactory.createNoBehaviour());
	}

	public static Operator createRightParentheses() {
		symbol = ")";
		neededArguments = 0;
		precedence = 1;
		return OperatorFactory.createOperator(symbol, neededArguments,
				OperatorAssociativity.LEFT, precedence,
				OperatorBehaviourFactory.createNoBehaviour());
	}
}
