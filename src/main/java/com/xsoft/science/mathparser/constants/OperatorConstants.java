package com.xsoft.science.mathparser.constants;

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
