package com.xsoft.science.mathparser.factories.calculator;

import com.xsoft.science.mathparser.parser.calculation.RPNCalculator;
import com.xsoft.science.mathparser.parser.calculation.Result;

public interface CalculatorFactory {
	public Result createResult();

	public RPNCalculator createRPNCalculator();
}
