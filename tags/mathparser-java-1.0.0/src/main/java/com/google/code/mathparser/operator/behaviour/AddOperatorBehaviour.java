package com.google.code.mathparser.operator.behaviour;

/*
 MathParser Java - Cross Platform Mathematical Expressions Parser
 Copyright 2013 Rodríguez Hernández, Daniel.
 daniel.rguez.hdez[at]gmail.com

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

import com.google.code.mathparser.factories.Factories;
import com.google.code.mathparser.operator.OperatorBehaviour;
import com.google.code.mathparser.tokenStructure.TokenStack;
import com.google.code.mathparser.tokenStructure.TokenStructureFactory;

public class AddOperatorBehaviour implements OperatorBehaviour {

	private Double argument1;
	private Double argument2;
	private int neededArguments;
	private String symbol;

	public AddOperatorBehaviour(String symbol, int neededArguments) {
		this.symbol = symbol;
		this.neededArguments = neededArguments;
	}

	public Double calculate(TokenStack arguments) {
		buildArguments(arguments);
		return argument1 + argument2;
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
			argument1 = Double.parseDouble((invertedStack.size() > 0) ? invertedStack.pop() : "0.0");
			argument2 = Double.parseDouble((invertedStack.size() > 0) ? invertedStack.pop() : "0.0");
		} else {
			Factories.getExceptionFactoryInstance().launchInsufficientParamtersException(symbol, neededArguments, invertedStack.size());
		}
	}

	private boolean hasSufficientArguments(TokenStack argumentsStack) {
		return argumentsStack.size() >= 1;
	}
}
