package com.xsoft.science.mathparser.expressions.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.xsoft.science.mathparser.MathParser;
import com.xsoft.science.mathparser.MathParserFactory;
import com.xsoft.science.mathparser.parser.calculation.Result;

public class MathParserTest {
	private MathParser math4j;
	private Result result;

	@Before
	public void init() {
		math4j = MathParserFactory.create();
	}

	@Test
	public void calculation001() {
		result = math4j.calculate("4+3");
		Assert.assertEquals(7.0, result.doubleValue(), 0.0);
	}
	
	@Test
	public void calculation002() {
		result = math4j.calculate("5 + ((1 + 2) * 4) - 3");
		Assert.assertEquals(14.0, result.doubleValue(), 0.0);
	}
	
	@Test
	public void calculation003() {
		result = math4j.calculate("6+2*5");
		Assert.assertEquals(16.0, result.doubleValue(), 0.0);
	}
	
	@Test
	public void calculation004() {
		result = math4j.calculate("-8/2-5");
		Assert.assertEquals(-9.0, result.doubleValue(), 0.0);
	}
	
	@Test
	public void calculation005() {
		result = math4j.calculate("5*3+(6+1)");
		Assert.assertEquals(22.0, result.doubleValue(), 0.0);
	}
	
	@Test
	public void calculation006() {
		result = math4j.calculate("-5+7-(5*1)");
		Assert.assertEquals(-3.0, result.doubleValue(), 0.0);
	}
	
	@Test
	public void calculation007() {
		result = math4j.calculate("2-[-(7-2)+1]-4");
		Assert.assertEquals(2.0, result.doubleValue(), 0.0);
	}
	
	@Test
	public void calculation008() {
		result = math4j.calculate("-5*[(-3*2)/(-3)+1]");
		Assert.assertEquals(-15.0, result.doubleValue(), 0.0);
	}
	
	@Test
	public void calculation009() {
		result = math4j.calculate("18+[9-(-3)+5]");
		Assert.assertEquals(35.0, result.doubleValue(), 0.0);
	}
	
	@Test
	public void calculation010() {
		result = math4j.calculate("-[4-(-16)]");
		Assert.assertEquals(-20.0, result.doubleValue(), 0.0);
	}
	
	@Test
	public void calculation011() {
		result = math4j.calculate("3-[4-(5-7)]-{9-[5-(-4)]}");
		Assert.assertEquals(-3.0, result.doubleValue(), 0.0);
	}
	
	@Test
	public void calculation012() {
		result = math4j.calculate("14-(8+7)-[4+2-3-(-4+5)]");
		Assert.assertEquals(-3.0, result.doubleValue(), 0.0);
	}
	
	@Test
	public void calculation013() {
		result = math4j.calculate("15/(-3)");
		Assert.assertEquals(-5.0, result.doubleValue(), 0.0);
	}
	
	@Test
	public void calculation014() {
		result = math4j.calculate("7*(-3)+[2+3(-5)]");
		Assert.assertEquals(-34.0, result.doubleValue(), 0.0);
	}
	
	@Test
	public void calculation015() {
		result = math4j.calculate("8+10/2-4*2");
		Assert.assertEquals(5.0, result.doubleValue(), 0.0);
	}
	
	@Test
	public void calculation016() {
		result = math4j.calculate("29[(-10)+1]");
		Assert.assertEquals(-261.0, result.doubleValue(), 0.0);
	}
	
	@Test
	public void calculation017() {
		result = math4j.calculate("(-12)*7-13(-5)");
		Assert.assertEquals(-19.0, result.doubleValue(), 0.0);
	}
	
	@Test
	public void calculation018() {
		result = math4j.calculate("(4-20)13");
		Assert.assertEquals(-208.0, result.doubleValue(), 0.0);
	}
	
	@Test
	public void calculation019() {
		result = math4j.calculate("(-5)*7-9(-4)");
		Assert.assertEquals(1.0, result.doubleValue(), 0.0);
	}
	
	@Test
	public void calculation020() {
		result = math4j.calculate("(-48+32)-(67-82)");
		Assert.assertEquals(-1.0, result.doubleValue(), 0.0);
	}
	
	@Test
	public void calculation021() {
		result = math4j.calculate("-[-13+(24-68)]-(-48+95)");
		Assert.assertEquals(10.0, result.doubleValue(), 0.0);
	}
	
	@Test
	public void calculation022() {
		result = math4j.calculate("12(-7)-12");
		Assert.assertEquals(-96.0, result.doubleValue(), 0.0);
	}
	
	@Test
	public void calculation023() {
		result = math4j.calculate("48-[15-(43-38)-27]");
		Assert.assertEquals(65.0, result.doubleValue(), 0.0);
	}
	
	@Test
	public void calculation024() {
		result = math4j.calculate("-32-[19-(24-46)]");
		Assert.assertEquals(-73.0, result.doubleValue(), 0.0);
	}
	
	@Test
	public void calculation025() {
		result = math4j.calculate("-(24-89+18)+(-91+24)");
		Assert.assertEquals(-20.0, result.doubleValue(), 0.0);
	}
}
