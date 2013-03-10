package com.google.code.mathparser.factories;

/*
 MathParser Java - Cross Platform Mathematical Expressions Parser
 Copyright 2013 Rodríguez Hernández, Daniel.
 daniel.rguez.hdez[at]gmail.com

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */

import com.google.code.mathparser.factories.calculator.CalculatorFactory;
import com.google.code.mathparser.factories.calculator.impl.CalculatorFactoryImpl;
import com.google.code.mathparser.factories.exception.ExceptionFactory;
import com.google.code.mathparser.factories.exception.impl.ExceptionFactoryImpl;
import com.google.code.mathparser.factories.exception.messages.ExceptionMessageFactory;
import com.google.code.mathparser.factories.exception.messages.impl.ExceptionMessageFactoryImpl;
import com.google.code.mathparser.factories.parser.ParserFactory;
import com.google.code.mathparser.factories.parser.impl.ParserFactoryImpl;

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
