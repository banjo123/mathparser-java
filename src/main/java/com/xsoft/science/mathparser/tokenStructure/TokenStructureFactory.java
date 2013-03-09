package com.xsoft.science.mathparser.tokenStructure;

public class TokenStructureFactory {
	public static TokenQueue createQueue() {
		return new TokenQueueImpl();
	}

	public static TokenStack createStack() {
		return new TokenStackImpl();
	}
}
