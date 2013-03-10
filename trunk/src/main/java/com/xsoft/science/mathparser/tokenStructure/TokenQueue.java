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

import java.util.List;

public interface TokenQueue {

	public List<String> getTokens();

	public void addToken(String token);

	public int size();

	public String toString();

	public String toExpressionString();

	public String getTokenAt(int pointer);

	public boolean hasMoreTokens();

	public String getLastToken();
}