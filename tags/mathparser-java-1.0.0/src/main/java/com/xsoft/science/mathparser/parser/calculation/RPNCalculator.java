package com.xsoft.science.mathparser.parser.calculation;

import com.xsoft.science.mathparser.tokenStructure.TokenQueue;

public interface RPNCalculator {

	public void setRPNExpression(TokenQueue expression);

	public Result calculate();
}
