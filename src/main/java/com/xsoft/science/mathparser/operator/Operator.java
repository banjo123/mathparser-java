package com.xsoft.science.mathparser.operator;

import java.util.List;

import com.xsoft.science.mathparser.tokenStructure.TokenStack;

public class Operator implements Comparable<Operator> {

	private String symbol;
	private int precedence;
	private OperatorAssociativity associativity;
	private int neededArguments;
	private OperatorBehaviour behaviour;

	public Operator(String symbol, int precedence,
			OperatorAssociativity associativity, int neededArguments,
			OperatorBehaviour behaviour) {
		this.symbol = symbol;
		this.precedence = precedence;
		this.associativity = associativity;
		this.neededArguments = neededArguments;
		this.behaviour = behaviour;
	}

	public String getSymbol() {
		return symbol;
	}

	public int getPrecedence() {
		return precedence;
	}

	public OperatorAssociativity getAssociativity() {
		return associativity;
	}

	public int compareTo(Operator o) {
		if (this.precedence > o.precedence) {
			return 1;
		} else if (this.precedence < o.precedence) {
			return -1;
		} else {
			return 0;
		}
	}

	public int getNeededArguments() {
		return neededArguments;
	}

	public Double calculateWith(TokenStack arguments) {
		return behaviour.calculate(arguments);
	}

}
