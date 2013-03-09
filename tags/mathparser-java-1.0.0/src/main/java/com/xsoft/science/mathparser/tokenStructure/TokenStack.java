package com.xsoft.science.mathparser.tokenStructure;

public interface TokenStack {

	public void push(String token);

	public String pop();

	public String getTop();

	public boolean hasMoreElements();

	public int size();
}
