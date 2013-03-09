package com.xsoft.science.mathparser.operator.behaviour;

import com.xsoft.science.mathparser.operator.OperatorBehaviour;
import com.xsoft.science.mathparser.tokenStructure.TokenStack;

public class NoOperatorBehaviour implements OperatorBehaviour {

	public NoOperatorBehaviour() {
		// TODO Auto-generated constructor stub
	}

	public Double calculate(TokenStack arguments) {
		throw new UnsupportedOperationException();
	}
}
