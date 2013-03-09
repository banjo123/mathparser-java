package com.xsoft.science.mathparser;

import com.xsoft.science.mathparser.impl.MathParserImpl;

public class MathParserFactory {
	public static MathParser create(){
		return new MathParserImpl();
	}
}
