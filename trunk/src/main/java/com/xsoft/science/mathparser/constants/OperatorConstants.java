package com.xsoft.science.mathparser.constants;

/*
 MathParser Java - Cross Platform Mathematical Expressions Parser
 Copyright 2013 Rodríguez Hernández, Daniel.

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

import com.xsoft.science.mathparser.operator.Operator;
import com.xsoft.science.mathparser.operator.OperatorFactory;

public class OperatorConstants {

	public static final String DEFAULT_DECIMAL_SEPARATOR = ",";

	public static final Operator LEFT_PARENTHESES = OperatorFactory
			.createLeftParentheses();
	public static final Operator RIGHT_PARENTHESES = OperatorFactory
			.createRightParentheses();
	public static final Operator POW = OperatorFactory.createPowOperator();
	public static final Operator MULT = OperatorFactory.createMulOperator();
	public static final Operator DIV = OperatorFactory.createDivOperator();
	public static final Operator ADD = OperatorFactory.createAddOperator();
	public static final Operator SUBS = OperatorFactory.createSubsOperator();

	public static final String[] validOperatorsSymbols = {
			LEFT_PARENTHESES.getSymbol(), RIGHT_PARENTHESES.getSymbol(),
			POW.getSymbol(), MULT.getSymbol(), DIV.getSymbol(),
			ADD.getSymbol(), SUBS.getSymbol(), DEFAULT_DECIMAL_SEPARATOR };

	public static final Operator[] validOperators = { LEFT_PARENTHESES,
			RIGHT_PARENTHESES, POW, MULT, DIV, ADD, SUBS };

	public static final String[] parenthesesSymbols = {
			LEFT_PARENTHESES.getSymbol(), RIGHT_PARENTHESES.getSymbol() };

}
