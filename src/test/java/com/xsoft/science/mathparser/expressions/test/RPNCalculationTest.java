package com.xsoft.science.mathparser.expressions.test;

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

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xsoft.science.mathparser.factories.Factories;
import com.xsoft.science.mathparser.factories.exception.impl.InvalidCharacterException;
import com.xsoft.science.mathparser.factories.exception.impl.InvalidExpressionException;
import com.xsoft.science.mathparser.parser.Parser;
import com.xsoft.science.mathparser.parser.calculation.RPNCalculator;
import com.xsoft.science.mathparser.parser.calculation.Result;

public class RPNCalculationTest {

	private RPNCalculator rpnCalculator;
	private Parser parser;
	private Logger log;
	private Result result;

	private Result obtainResult(String expression) {
		parser.setExpression(expression);
		rpnCalculator.setRPNExpression(parser.getOutputTokensQueue());
		result = rpnCalculator.calculate();
		log.info("[RPN Calculator Test] Result: " + result.doubleValue());
		return result;
	}

	@Before
	public void init() {
		rpnCalculator = Factories.getCalculatorFactoryInstance().createRPNCalculator();
		parser = Factories.getParserFactoryInstance().createParser();
		log = LoggerFactory.getLogger(this.getClass());
	}

	@Test(expected = InvalidExpressionException.class)
	public void testNullString() {
		obtainResult(null);
	}

	@Test(expected = InvalidCharacterException.class)
	public void testInvalidChar() {
		obtainResult("asdasdasd");
	}

	@Test(expected = InvalidExpressionException.class)
	public void testInsufficientParameters() {
		obtainResult("4+");
	}

	@Test
	public void testSimpleExpression() {
		Assert.assertEquals(Double.valueOf(7.0).doubleValue(), obtainResult("4+3").doubleValue().doubleValue(), 0.0);
	}

	@Test
	public void testComplexExpression() {
		Assert.assertEquals(Double.valueOf(14.0).doubleValue(),	obtainResult("5 + ((1 + 2) * 4) - 3").doubleValue().doubleValue(), 0.0);
	}

	@Test
	public void testExpression01() {
		Assert.assertEquals(Double.valueOf(16.0).doubleValue(), obtainResult("6+2*5").doubleValue().doubleValue(), 0.0);
	}

	@Test
	public void testExpression02() {
		Assert.assertEquals(Double.valueOf(-9.0).doubleValue(), obtainResult("-8/2-5").doubleValue().doubleValue(), 0.0);
	}

	@Test
	public void testExpression03() {
		Assert.assertEquals(Double.valueOf(-9.0).doubleValue(),	obtainResult("-8/2-5").doubleValue().doubleValue(), 0.0);
	}

	@Test
	public void testExpression04() {
		Assert.assertEquals(Double.valueOf(22.0).doubleValue(),	obtainResult("5*3+(6+1)").doubleValue().doubleValue(), 0.0);
	}

	@Test
	public void testExpression05() {
		Assert.assertEquals(Double.valueOf(-3.0).doubleValue(),	obtainResult("-5+7-(5*1)").doubleValue().doubleValue(), 0.0);
	}

	@Test
	public void testExpression06() {
		Assert.assertEquals(Double.valueOf(2.0).doubleValue(), obtainResult("2-[-(7-2)+1]-4").doubleValue().doubleValue(), 0.0);
	}

	@Test
	public void testExpression07() {
		Assert.assertEquals(Double.valueOf(-15.0).doubleValue(), obtainResult("-5*[(-3*2)/(-3)+1]").doubleValue().doubleValue(), 0.0);
	}

	@Test
	public void testExpression08() {
		Assert.assertEquals(Double.valueOf(35.0).doubleValue(),	obtainResult("18+[9-(-3)+5]").doubleValue().doubleValue(), 0.0);
	}

	@Test
	public void testExpression09() {
		Assert.assertEquals(Double.valueOf(-20.0).doubleValue(), obtainResult("-[4-(-16)]").doubleValue().doubleValue(), 0.0);
	}

	@Test
	public void testExpression10() {
		Assert.assertEquals(Double.valueOf(-3.0).doubleValue(),	obtainResult("3-[4-(5-7)]-{9-[5-(-4)]}").doubleValue().doubleValue(), 0.0);
	}

	@Test
	public void testExpression11() {
		Assert.assertEquals(Double.valueOf(-3.0).doubleValue(), obtainResult("14-(8+7)-[4+2-3-(-4+5)]").doubleValue().doubleValue(), 0.0);
	}

	@Test
	public void testExpression12() {
		Assert.assertEquals(Double.valueOf(-5.0).doubleValue(),	obtainResult("15/(-3)").doubleValue().doubleValue(), 0.0);
	}

	@Test
	public void testExpression13() {
		Assert.assertEquals(Double.valueOf(-34.0).doubleValue(), obtainResult("7*(-3)+[2+3(-5)]").doubleValue().doubleValue(), 0.0);
	}

	@Test
	public void testExpression14() {
		Assert.assertEquals(Double.valueOf(5.0).doubleValue(), obtainResult("8+10/2-4*2").doubleValue().doubleValue(), 0.0);
	}

	@Test
	public void testExpression15() {
		Assert.assertEquals(Double.valueOf(-261.0).doubleValue(), obtainResult("29[(-10)+1]").doubleValue().doubleValue(), 0.0);
	}

	@Test
	public void testExpression16() {
		Assert.assertEquals(Double.valueOf(-19.0).doubleValue(), obtainResult("(-12)*7-13(-5)").doubleValue().doubleValue(), 0.0);
	}

	@Test
	public void testExpression17() {
		Assert.assertEquals(Double.valueOf(-208.0).doubleValue(), obtainResult("(4-20)13").doubleValue().doubleValue(), 0.0);
	}

	@Test
	public void testExpression18() {
		Assert.assertEquals(Double.valueOf(1.0).doubleValue(),	obtainResult("(-5)*7-9(-4)").doubleValue().doubleValue(), 0.0);
	}

	@Test
	public void testExpression19() {
		Assert.assertEquals(Double.valueOf(-1).doubleValue(), obtainResult("(-48+32)-(67-82)").doubleValue().doubleValue(),	0.0);
	}

	@Test
	public void testExpression20() {
		Assert.assertEquals(Double.valueOf(10.0).doubleValue(), obtainResult("-[-13+(24-68)]-(-48+95)").doubleValue().doubleValue(), 0.0);
	}

	@Test
	public void testExpression21() {
		Assert.assertEquals(Double.valueOf(-96.0).doubleValue(), obtainResult("12(-7)-12").doubleValue().doubleValue(), 0.0);
	}

	@Test
	public void testExpression22() {
		Assert.assertEquals(Double.valueOf(65.0).doubleValue(),	obtainResult("48-[15-(43-38)-27]").doubleValue().doubleValue(),	0.0);
	}

	@Test
	public void testExpression23() {
		Assert.assertEquals(Double.valueOf(-73.0).doubleValue(), obtainResult("-32-[19-(24-46)]").doubleValue().doubleValue(),0.0);
	}

	@Test
	public void testExpression24() {
		Assert.assertEquals(Double.valueOf(-20.0).doubleValue(), obtainResult("-(24-89+18)+(-91+24)").doubleValue().doubleValue(), 0.0);
	}
}
