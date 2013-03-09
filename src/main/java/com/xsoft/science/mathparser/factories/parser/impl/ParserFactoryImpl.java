package com.xsoft.science.mathparser.factories.parser.impl;

import com.xsoft.science.mathparser.factories.parser.ParserFactory;
import com.xsoft.science.mathparser.parser.LexicalTokenizer;
import com.xsoft.science.mathparser.parser.Parser;

public class ParserFactoryImpl implements ParserFactory {
	public LexicalTokenizer createLexicalTokenizer() {
		return new LexicalTokenizer();
	}

	public Parser createParser() {
		return new Parser();
	}
}
