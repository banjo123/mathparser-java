package com.xsoft.science.mathparser.tokenStructure;

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
