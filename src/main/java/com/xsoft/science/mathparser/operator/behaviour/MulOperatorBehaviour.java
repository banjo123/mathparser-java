package com.xsoft.science.mathparser.operator.behaviour;

import com.xsoft.science.mathparser.factories.Factories;
import com.xsoft.science.mathparser.operator.Operator;
import com.xsoft.science.mathparser.operator.OperatorBehaviour;
import com.xsoft.science.mathparser.operator.OperatorFactory;
import com.xsoft.science.mathparser.operator.utils.OperatorUtils;
import com.xsoft.science.mathparser.tokenStructure.TokenStack;
import com.xsoft.science.mathparser.tokenStructure.TokenStructureFactory;

public class MulOperatorBehaviour implements OperatorBehaviour {

	private Double multiplicant;
	private Double multiplicator;
	private String symbol;
	private int neededArguments;

	public MulOperatorBehaviour(String symbol, int neededArguments) {
		this.symbol = symbol;
		this.neededArguments = neededArguments;
	}

	public Double calculate(TokenStack arguments) {
		buildArguments(arguments);
		return multiplicant * multiplicator;
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
			multiplicant = Double.parseDouble(invertedStack.pop());
			multiplicator = Double.parseDouble(invertedStack.pop());
		} else {
			Factories.getExceptionFactoryInstance()
					.launchInsufficientParamtersException(symbol,
							neededArguments, invertedStack.size());
		}

	}

	private boolean hasSufficientArguments(TokenStack arguments) {
		return arguments.size() > 1;
	}

}
