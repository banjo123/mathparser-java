package com.xsoft.science.mathparser.factories.exception.impl;

import com.xsoft.science.mathparser.factories.Factories;

public class InvalidOperatorException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 830529775315876618L;

	InvalidOperatorException() {
		super(Factories.getExceptionMessageFactoryInstance()
				.createInvalidOperatorMessage());
	}
}
