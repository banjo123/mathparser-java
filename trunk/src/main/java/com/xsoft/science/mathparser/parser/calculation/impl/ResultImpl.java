package com.xsoft.science.mathparser.parser.calculation.impl;

import com.xsoft.science.mathparser.parser.calculation.Result;

public class ResultImpl implements Result {

	private Double result;

	public ResultImpl() {
		result = null;
	}

	public Double doubleValue() {
		return result;
	}

	public void setResult(Object result) {
		this.result = (Double) result;
	}

}
