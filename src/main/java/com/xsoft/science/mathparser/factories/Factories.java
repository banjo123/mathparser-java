package com.xsoft.science.mathparser.factories;

import com.xsoft.science.mathparser.constants.OperatorConstants;
import com.xsoft.science.mathparser.factories.calculator.CalculatorFactory;
import com.xsoft.science.mathparser.factories.calculator.impl.CalculatorFactoryImpl;
import com.xsoft.science.mathparser.factories.exception.ExceptionFactory;
import com.xsoft.science.mathparser.factories.exception.impl.ExceptionFactoryImpl;
import com.xsoft.science.mathparser.factories.exception.messages.ExceptionMessageFactory;
import com.xsoft.science.mathparser.factories.exception.messages.impl.ExceptionMessageFactoryImpl;
import com.xsoft.science.mathparser.factories.parser.ParserFactory;
import com.xsoft.science.mathparser.factories.parser.impl.ParserFactoryImpl;

public class Factories {

	private static ParserFactory parserFactoryInstance;
	private static CalculatorFactory calculatorFactoryInstance;
	private static ExceptionMessageFactory exceptionMessageFactoryInstance;
	private static ExceptionFactory exceptionFactoryInstance;

	static {
		parserFactoryInstance = new ParserFactoryImpl();
		calculatorFactoryInstance = new CalculatorFactoryImpl();
		exceptionMessageFactoryInstance = new ExceptionMessageFactoryImpl();
		exceptionFactoryInstance = new ExceptionFactoryImpl();
	}

	public static ParserFactory getParserFactoryInstance() {
		return parserFactoryInstance;
	}

	public static CalculatorFactory getCalculatorFactoryInstance() {
		return calculatorFactoryInstance;
	}

	public static ExceptionMessageFactory getExceptionMessageFactoryInstance() {
		return exceptionMessageFactoryInstance;
	}

	public static ExceptionFactory getExceptionFactoryInstance() {
		return exceptionFactoryInstance;
	}

}
