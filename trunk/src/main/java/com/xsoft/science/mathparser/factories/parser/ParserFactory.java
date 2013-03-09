package com.xsoft.science.mathparser.factories.parser;

import com.xsoft.science.mathparser.parser.LexicalTokenizer;
import com.xsoft.science.mathparser.parser.Parser;

public interface ParserFactory {
	public LexicalTokenizer createLexicalTokenizer();

	public Parser createParser();
}
