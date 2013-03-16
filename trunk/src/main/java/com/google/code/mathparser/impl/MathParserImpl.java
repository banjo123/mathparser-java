package com.google.code.mathparser.impl;

/*
 MathParser Java - Cross Platform Mathematical Expressions Parser
 Copyright 2013 Rodríguez Hernández, Daniel.
 daniel.rguez.hdez[at]gmail.com

 Licensed under the Apache License, Version 2.0 [the "License"]
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */

import com.google.code.mathparser.MathParser;
import com.google.code.mathparser.factories.impl.Factories;
import com.google.code.mathparser.parser.Parser;
import com.google.code.mathparser.parser.calculation.RPNCalculator;
import com.google.code.mathparser.parser.calculation.Result;

public class MathParserImpl implements MathParser {

	private RPNCalculator rpnCalculator = Factories.getCalculatorFactoryInstance().createRPNCalculator();
	private Parser parser = Factories.getParserFactoryInstance().createParser();
	
	public Result calculate(String expression) {
		parser.setExpression(expression);
		rpnCalculator.setRPNExpression(parser.getOutputTokensQueue());
		return rpnCalculator.calculate();
	}

}
