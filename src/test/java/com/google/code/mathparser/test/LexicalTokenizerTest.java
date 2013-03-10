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
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.code.mathparser.factories.Factories;
import com.google.code.mathparser.factories.exception.impl.InvalidCharacterException;
import com.google.code.mathparser.factories.exception.impl.InvalidExpressionException;
import com.google.code.mathparser.parser.LexicalTokenizer;
import com.google.code.mathparser.tokenStructure.TokenQueue;

public class LexicalTokenizerTest {

	private LexicalTokenizer lexicalTokenizer;
	private TokenQueue tokenGroup;
	private Logger log = LoggerFactory.getLogger(LexicalTokenizerTest.class);

	private int obtainTokensCountFrom(String expression) {
		lexicalTokenizer.setExpression(expression);
		tokenGroup = lexicalTokenizer.getTokens();
		log.info(tokenGroup.toString());
		return tokenGroup.size();
	}

	private String[] obtainOutputTokensByParserArray(String expression) {
		lexicalTokenizer.setExpression(expression);
		tokenGroup = lexicalTokenizer.getTokens();
		return tokenGroup.getTokens().toArray(new String[0]);
	}

	@Before
	public void init() {
		lexicalTokenizer = Factories.getParserFactoryInstance()
				.createLexicalTokenizer();
		tokenGroup = null;
	}

	@Test(expected = InvalidExpressionException.class)
	public void testNullExpression() {
		Assert.assertEquals(5, obtainTokensCountFrom(null));
	}

	@Test(expected = InvalidCharacterException.class)
	public void testNotValidExpression() {
		Assert.assertEquals(5, obtainTokensCountFrom("asdasd"));
	}

	@Test
	public void testExpression01() {
		Assert.assertEquals(3, obtainTokensCountFrom("4+3"));
	}

	@Test
	public void testExpression02() {
		Assert.assertEquals(5, obtainTokensCountFrom("4+3*5"));
	}

	@Test(expected = InvalidCharacterException.class)
	public void testExpression03() {
		Assert.assertEquals(0, obtainTokensCountFrom("4as+s2"));
	}

	@Test
	public void testExpression04() {
		Assert.assertEquals(7, obtainTokensCountFrom("5*(5+4)"));
	}

	@Test
	public void testExpression05() {
		Assert.assertEquals(7, obtainTokensCountFrom("52*(45+4,56)"));
	}

	@Test(expected = InvalidExpressionException.class)
	public void testExpression06() {
		Assert.assertEquals(7, obtainTokensCountFrom("52*(45+4,5,6)"));
	}

	@Test
	public void testExpression07() {
		Assert.assertEquals(21, obtainTokensCountFrom("(5*(5+4)^2)/((2+3)*4)"));
	}

	@Test
	public void testExpression08() {
		Assert.assertEquals(21,
				obtainTokensCountFrom("(545*(51,89+445,8)^2)/((24+320)*412,8)"));
	}

	@Test
	public void testExpression09() {
		String[] expected = {"+", "(", "0", "-", "1", ")", "*", "2", "^", "2" };
		Assert.assertArrayEquals(expected, obtainOutputTokensByParserArray("-2^2"));
	}

	@Test
	public void testExpression10() {
		String[] expected = { "+","(", "0", "-", "1", ")", "*", "2", "^", "2" };
		Assert.assertArrayEquals(expected, obtainOutputTokensByParserArray("-2 ^ 2"));
	}
}
