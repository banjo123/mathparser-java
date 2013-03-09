package com.xsoft.science.mathparser.operator;

import com.xsoft.science.mathparser.tokenStructure.TokenStack;

public interface OperatorBehaviour {
	public Double calculate(TokenStack arguments);
}
