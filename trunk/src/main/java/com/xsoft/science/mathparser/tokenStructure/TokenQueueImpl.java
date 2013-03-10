package com.xsoft.science.mathparser.tokenStructure;

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
			if (i == tokens.size() - 1) { buf.append(" ".concat(tokens.get(i)));} 
			else { buf.append(" ".concat(tokens.get(i).concat(";"))); }
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
		if (hasMoreTokens()) {
			return tokens.get(tokens.size() - 1);
		}
		return null;
	}
}
