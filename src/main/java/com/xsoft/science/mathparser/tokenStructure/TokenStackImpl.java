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
