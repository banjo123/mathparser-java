package com.xsoft.science.mathparser.operator.behaviour;

import com.xsoft.science.mathparser.factories.Factories;
import com.xsoft.science.mathparser.operator.Operator;
import com.xsoft.science.mathparser.operator.OperatorBehaviour;
import com.xsoft.science.mathparser.operator.OperatorFactory;
import com.xsoft.science.mathparser.operator.utils.OperatorUtils;
import com.xsoft.science.mathparser.tokenStructure.TokenStack;
import com.xsoft.science.mathparser.tokenStructure.TokenStructureFactory;

public class DivOperatorBehaviour implements OperatorBehaviour {

	private Double numerator;
	private Double denominator;
	private String symbol;
	private int neededArguments;

	public DivOperatorBehaviour(String symbol, int neededArguments) {
		this.symbol = symbol;
		this.neededArguments = neededArguments;
	}

	public Double calculate(TokenStack arguments) {
		buildArguments(arguments);
		return numerator / denominator;
	}

	private boolean hasSufficientArguments(TokenStack argumentsStack) {
		return argumentsStack.size() > 1;
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
			numerator = Double.parseDouble(invertedStack.pop());
			denominator = Double.parseDouble(invertedStack.pop());
		} else {
			Factories.getExceptionFactoryInstance()
					.launchInsufficientParamtersException(symbol,
							neededArguments, invertedStack.size());
		}
	}
}
