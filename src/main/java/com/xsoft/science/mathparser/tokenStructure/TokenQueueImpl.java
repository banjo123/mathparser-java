package com.xsoft.science.mathparser.tokenStructure;

import java.util.ArrayList;
import java.util.List;

public class TokenQueueImpl implements TokenQueue {
	private List<String> tokens;
	private StringBuffer expressionString;

	public TokenQueueImpl() {
		tokens = new ArrayList<String>();
		expressionString = new StringBuffer();
	}

	public List<String> getTokens() {
		return tokens;
	}

	public void addToken(String token) {
		tokens.add(token);
		expressionString.append(token);
	}

	public int size() {
		return tokens.size();
	}

	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append("[");
		for (int i = 0; i < tokens.size(); i++) {
			if (i == tokens.size() - 1) {
				buf.append(" ".concat(tokens.get(i)));
			} else {
				buf.append(" ".concat(tokens.get(i).concat(";")));
			}
		}
		buf.append("]");
		return buf.toString();
	}

	public String getTokenAt(int pointer) {
		return tokens.get(pointer);
	}

	public boolean hasMoreTokens() {
		return tokens.size() > 0;
	}

	public String toExpressionString() {
		return this.expressionString.toString();
	}

	public String getLastToken() {
		if(hasMoreTokens()) {
			return tokens.get(tokens.size()-1);
		}
		return null;
	}
}
