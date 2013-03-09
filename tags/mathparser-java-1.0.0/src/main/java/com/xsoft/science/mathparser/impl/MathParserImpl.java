package com.xsoft.science.mathparser.impl;

import com.xsoft.science.mathparser.MathParser;
import com.xsoft.science.mathparser.factories.Factories;
import com.xsoft.science.mathparser.parser.Parser;
import com.xsoft.science.mathparser.parser.calculation.RPNCalculator;
import com.xsoft.science.mathparser.parser.calculation.Result;

public class MathParserImpl implements MathParser {

	private RPNCalculator rpnCalculator = Factories.getCalculatorFactoryInstance().createRPNCalculator();
	private Parser parser = Factories.getParserFactoryInstance().createParser();
	private Result result = Factories.getCalculatorFactoryInstance().createResult();;

	public Result calculate(String expression) {
		parser.setExpression(expression);
		rpnCalculator.setRPNExpression(parser.getOutputTokensQueue());
		result = rpnCalculator.calculate();
		return result;
	}

}
