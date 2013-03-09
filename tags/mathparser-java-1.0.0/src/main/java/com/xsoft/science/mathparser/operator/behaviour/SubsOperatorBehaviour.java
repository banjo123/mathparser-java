package com.xsoft.science.mathparser.operator.behaviour;

import com.xsoft.science.mathparser.factories.Factories;
import com.xsoft.science.mathparser.operator.OperatorBehaviour;
import com.xsoft.science.mathparser.tokenStructure.TokenStack;
import com.xsoft.science.mathparser.tokenStructure.TokenStructureFactory;

public class SubsOperatorBehaviour implements OperatorBehaviour {

	private Double minuend;
	private Double subtrahend;
	private String symbol;
	private int neededArguments;

	public SubsOperatorBehaviour(String symbol, int neededArguments) {
		this.symbol = symbol;
		this.neededArguments = neededArguments;
	}

	public Double calculate(TokenStack arguments) {
		buildArguments(arguments);
		return minuend - subtrahend;
	}

	private void buildArguments(TokenStack argumentsStack) {
		TokenStack duplicateStack = argumentsStack;
		TokenStack invertedStack = TokenStructureFactory.createStack();
		for (int i = 0; i < neededArguments; i++) {
			if (duplicateStack.hasMoreElements()) {
				invertedStack.push(duplicateStack.pop());
			}
		}
		
		if (hasSufficientArguments(invertedStack)) {
			minuend = Double.parseDouble((invertedStack.size() > 0) ? invertedStack.pop() : "0.0");
			subtrahend = Double.parseDouble((invertedStack.size() > 0) ? invertedStack.pop() : "0.0");
		}else{
			Factories.getExceptionFactoryInstance()
			.launchInsufficientParamtersException(symbol,
					neededArguments, invertedStack.size());
		}


	}
	
	private boolean hasSufficientArguments(TokenStack argumentsStack) {
		return argumentsStack.size() >= 1;
	}

}
