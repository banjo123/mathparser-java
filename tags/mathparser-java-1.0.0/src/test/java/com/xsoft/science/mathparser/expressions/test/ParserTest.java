package com.xsoft.science.mathparser.expressions.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xsoft.science.mathparser.factories.Factories;
import com.xsoft.science.mathparser.factories.exception.impl.InsufficientParametersException;
import com.xsoft.science.mathparser.factories.exception.impl.InvalidCharacterException;
import com.xsoft.science.mathparser.factories.exception.impl.InvalidExpressionException;
import com.xsoft.science.mathparser.factories.parser.ParserFactory;
import com.xsoft.science.mathparser.parser.Parser;

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
		Assert.assertArrayEquals(expected,
				obtainOutputTokensByParserArray("4+3"));
	}

	@Ignore
	@Test
	public void testExpression02() {
		String[] expected = { "3", "4", "2", "*", "1", "5", "-", "2", "3", "^",
				"^", "/", "+" };
		Assert.assertArrayEquals(
				expected,
				obtainOutputTokensByParserArray("3 + 4 * 2 / ( 1 - 5 ) ^ 2 ^ 3"));
	}

	@Test
	public void testExpression03() {
		String[] expected = { "5", "1", "2", "+", "4", "*", "+", "3", "-" };

		Assert.assertArrayEquals(expected,
				obtainOutputTokensByParserArray("5 + ((1 + 2) * 4) - 3"));

	}

}
