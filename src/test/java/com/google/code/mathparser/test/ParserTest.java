package com.google.code.mathparser.test;

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

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.code.mathparser.factories.Factories;
import com.google.code.mathparser.factories.exception.impl.InvalidCharacterException;
import com.google.code.mathparser.factories.exception.impl.InvalidExpressionException;
import com.google.code.mathparser.parser.Parser;

public class ParserTest {

	private Parser parser;
	private Logger log;

	private int obtainTokensCountFrom(String expression) {
		parser.setExpression(expression);
		log.info(parser.getOutputTokensQueue().toString());
		return parser.getOutputTokensQueue().size();
	}

	private String[] obtainOutputTokensByParserArray(String expression) {
		parser.setExpression(expression);
		log.info(parser.getOutputTokensQueue().toString());
		return parser.getOutputTokensQueue().getTokens().toArray(new String[0]);
	}

	@Before
	public void init() {
		parser = Factories.getParserFactoryInstance().createParser();
		log = LoggerFactory.getLogger(ParserTest.class);
	}

	@Test(expected = InvalidExpressionException.class)
	public void testNull() {
		obtainTokensCountFrom(null);
	}

	@Test(expected = InvalidCharacterException.class)
	public void testNotValid() {
		obtainTokensCountFrom("asd");
	}

	@Test(expected = InvalidExpressionException.class)
	public void testInsufficientParams1() {
		Assert.assertEquals(5, obtainTokensCountFrom("4+"));
	}

	@Test(expected = InvalidExpressionException.class)
	public void testInsufficientParams2() {
		Assert.assertEquals(5, obtainTokensCountFrom("4-"));
	}

	@Test(expected = InvalidExpressionException.class)
	public void testInsufficientParams3() {
		Assert.assertEquals(5, obtainTokensCountFrom("4*"));
	}

	@Test(expected = InvalidExpressionException.class)
	public void testInsufficientParams4() {
		Assert.assertEquals(5, obtainTokensCountFrom("4/"));
	}

	@Test(expected = InvalidExpressionException.class)
	public void testInsufficientParams5() {
		Assert.assertEquals(5, obtainTokensCountFrom("4^"));
	}

	@Test(expected = InvalidExpressionException.class)
	public void testInsufficientParams6() {
		Assert.assertEquals(5, obtainTokensCountFrom("*4"));
	}

	@Test(expected = InvalidExpressionException.class)
	public void testInsufficientParams7() {
		Assert.assertEquals(5, obtainTokensCountFrom("/4"));
	}

	@Ignore
	@Test
	public void testExpression01() {
		String[] expected = { "4", "3", "+" };
		Assert.assertArrayEquals(expected, obtainOutputTokensByParserArray("4+3"));
	}

	@Ignore
	@Test
	public void testExpression02() {
		String[] expected = { "3", "4", "2", "*", "1", "5", "-", "2", "3", "^",	"^", "/", "+" };
		Assert.assertArrayEquals(expected, obtainOutputTokensByParserArray("3 + 4 * 2 / ( 1 - 5 ) ^ 2 ^ 3"));
	}

}
