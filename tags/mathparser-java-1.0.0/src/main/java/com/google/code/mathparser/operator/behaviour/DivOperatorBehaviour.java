package com.google.code.mathparser.operator.behaviour;

/*
 MathParser Java - Cross Platform Mathematical Expressions Parser
 Copyright 2013 Rodríguez Hernández, Daniel.
 daniel.rguez.hdez[at]gmail.com

 Licensed under the Apache License, Version 2.0 [the "License"]
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */

import com.google.code.mathparser.factories.impl.Factories;
import com.google.code.mathparser.operator.OperatorBehaviour;
import com.google.code.mathparser.tokenStructure.TokenStack;
import com.google.code.mathparser.tokenStructure.TokenStructureFactory;

public class DivOperatorBehaviour implements OperatorBehaviour {

	private Double numerator;
	private Double denominator;
	private String symbol;
	private int neededArguments;

	DivOperatorBehaviour(String symbol, int neededArguments) {
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
			Factories.getExceptionFactoryInstance().launchInsufficientParamtersException(symbol, neededArguments, invertedStack.size());
		}
	}
}
