package com.xsoft.science.mathparser.factories.calculator.impl;

import com.xsoft.science.mathparser.factories.calculator.CalculatorFactory;
import com.xsoft.science.mathparser.parser.calculation.RPNCalculator;
import com.xsoft.science.mathparser.parser.calculation.Result;
import com.xsoft.science.mathparser.parser.calculation.impl.RPNCalculatorImpl;
import com.xsoft.science.mathparser.parser.calculation.impl.ResultImpl;

public class CalculatorFactoryImpl implements CalculatorFactory {
	public Result createResult() {
		return new ResultImpl();
	}

	public RPNCalculator createRPNCalculator() {
		return new RPNCalculatorImpl();
	}
}
