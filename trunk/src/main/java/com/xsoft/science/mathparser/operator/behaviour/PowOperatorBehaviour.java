package com.xsoft.science.mathparser.operator.behaviour;

import com.xsoft.science.mathparser.factories.Factories;
import com.xsoft.science.mathparser.operator.OperatorBehaviour;
import com.xsoft.science.mathparser.tokenStructure.TokenStack;
import com.xsoft.science.mathparser.tokenStructure.TokenStructureFactory;

public class PowOperatorBehaviour implements OperatorBehaviour {

	private Double base;
	private Double exponent;
	private String symbol;
	private int neededArguments;

	public PowOperatorBehaviour(String symbol, int neededArguments) {
		this.symbol = symbol;
		this.neededArguments = neededArguments;
	}

	public Double calculate(TokenStack argumentsStack) {
		buildArguments(argumentsStack);
		return Math.pow(base, exponent);
	}

	private void buildArguments(TokenStack argumentsStack) {
		TokenStack duplicateStack = argumentsStack;
		TokenStack invertedStack = TokenStructureFactory.createStack();
		for (int i = 0; i < neededArguments; i++) {
			if (duplicateStack.hasMoreElements()) {
				invertedStack.push(argumentsStack.pop());
			}
		}

		if (hasSufficientArguments(invertedStack)) {
			base = Double.parseDouble(invertedStack.pop());
			exponent = Double.parseDouble(invertedStack.pop());
		} else {
			Factories.getExceptionFactoryInstance()
					.launchInsufficientParamtersException(symbol,
							neededArguments, invertedStack.size());
		}
	}

	private boolean hasSufficientArguments(TokenStack argumentsStack) {
		return argumentsStack.size() > 1;
	}
}
