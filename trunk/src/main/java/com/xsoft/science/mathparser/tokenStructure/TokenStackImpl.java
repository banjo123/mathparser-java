package com.xsoft.science.mathparser.tokenStructure;

import java.util.ArrayList;
import java.util.List;

public class TokenStackImpl implements TokenStack {
	private List<String> tokens;

	public TokenStackImpl() {
		tokens = new ArrayList<String>();
	}

	public void push(String token) {
		tokens.add(token);
	}

	public String pop() {
		String value = tokens.get(tokens.size() - 1);
		tokens.remove(tokens.size() - 1);
		return value;
	}

	public String getTop() {

		return tokens.get(tokens.size() - 1);
	}

	public boolean hasMoreElements() {
		return tokens.size() > 0;
	}

	public int size() {
		return tokens.size();
	}
}
