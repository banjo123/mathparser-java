package com.xsoft.science.mathparser.operator;

import com.xsoft.science.mathparser.operator.behaviour.AddOperatorBehaviour;
import com.xsoft.science.mathparser.operator.behaviour.DivOperatorBehaviour;
import com.xsoft.science.mathparser.operator.behaviour.MulOperatorBehaviour;
import com.xsoft.science.mathparser.operator.behaviour.NoOperatorBehaviour;
import com.xsoft.science.mathparser.operator.behaviour.PowOperatorBehaviour;
import com.xsoft.science.mathparser.operator.behaviour.SubsOperatorBehaviour;

public class OperatorBehaviourFactory {

	public static OperatorBehaviour createAddBehaviour(String symbol,
			int neededArguments) {
		return new AddOperatorBehaviour(symbol, neededArguments);
	}

	public static OperatorBehaviour createSubsBehaviour(String symbol,
			int neededArguments) {
		return new SubsOperatorBehaviour(symbol, neededArguments);
	}

	public static OperatorBehaviour createMulBehaviour(String symbol,
			int neededArguments) {
		return new MulOperatorBehaviour(symbol, neededArguments);
	}

	public static OperatorBehaviour createDivBehaviour(String symbol,
			int neededArguments) {
		return new DivOperatorBehaviour(symbol, neededArguments);
	}

	public static OperatorBehaviour createPowBehaviour(String symbol,
			int neededArguments) {
		return new PowOperatorBehaviour(symbol, neededArguments);
	}

	public static OperatorBehaviour createNoBehaviour() {
		return new NoOperatorBehaviour();
	}
}
