package com.xsoft.science.mathparser.operator;

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

import com.xsoft.science.mathparser.operator.behaviour.AddOperatorBehaviour;
import com.xsoft.science.mathparser.operator.behaviour.DivOperatorBehaviour;
import com.xsoft.science.mathparser.operator.behaviour.MulOperatorBehaviour;
import com.xsoft.science.mathparser.operator.behaviour.NoOperatorBehaviour;
import com.xsoft.science.mathparser.operator.behaviour.PowOperatorBehaviour;
import com.xsoft.science.mathparser.operator.behaviour.SubsOperatorBehaviour;

public class OperatorBehaviourFactory {

	public static OperatorBehaviour createAddBehaviour(String symbol, int neededArguments) {
		return new AddOperatorBehaviour(symbol, neededArguments);
	}

	public static OperatorBehaviour createSubsBehaviour(String symbol, int neededArguments) {
		return new SubsOperatorBehaviour(symbol, neededArguments);
	}

	public static OperatorBehaviour createMulBehaviour(String symbol, int neededArguments) {
		return new MulOperatorBehaviour(symbol, neededArguments);
	}

	public static OperatorBehaviour createDivBehaviour(String symbol, int neededArguments) {
		return new DivOperatorBehaviour(symbol, neededArguments);
	}

	public static OperatorBehaviour createPowBehaviour(String symbol, int neededArguments) {
		return new PowOperatorBehaviour(symbol, neededArguments);
	}

	public static OperatorBehaviour createNoBehaviour() {
		return new NoOperatorBehaviour();
	}
}
