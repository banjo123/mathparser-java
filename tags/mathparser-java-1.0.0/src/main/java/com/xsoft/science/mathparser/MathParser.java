package com.xsoft.science.mathparser;

import com.xsoft.science.mathparser.parser.calculation.Result;

public interface MathParser {
	public Result calculate(String expression);
}
