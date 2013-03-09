package com.xsoft.science.mathparser.parser;

import com.xsoft.science.mathparser.constants.OperatorConstants;
import com.xsoft.science.mathparser.constants.utils.MathParserUtils;
import com.xsoft.science.mathparser.factories.Factories;
import com.xsoft.science.mathparser.factories.exception.ExceptionFactory;
import com.xsoft.science.mathparser.factories.parser.ParserFactory;
import com.xsoft.science.mathparser.operator.utils.OperatorUtils;
import com.xsoft.science.mathparser.tokenStructure.TokenQueue;
import com.xsoft.science.mathparser.tokenStructure.TokenStack;
import com.xsoft.science.mathparser.tokenStructure.TokenStructureFactory;

public class Parser {

	private final ParserFactory parserFactory = Factories
			.getParserFactoryInstance();
	private final ExceptionFactory exceptionFactory = Factories
			.getExceptionFactoryInstance();
	private final LexicalTokenizer lexicalTokenizer = parserFactory
			.createLexicalTokenizer();

	private String expression;
	private TokenQueue tokensQueue;
	private TokenQueue outputTokensQueue;
	private TokenStack operatorStack;

	private int tokenQueueSize;

	private String actualToken;
	private int pointer;

	public Parser() {
	}

	public void setExpression(String expression) {
		this.expression = expression;
		initialize();
		shuntingYardAlgorithm();
	}

	private void initialize() {
		outputTokensQueue = TokenStructureFactory.createQueue();
		operatorStack = TokenStructureFactory.createStack();
		pointer = 0;
	}

	public TokenQueue getOutputTokensQueue() {
		return this.outputTokensQueue;
	}

	public Double calculate() {
		shuntingYardAlgorithm();
		return null;
	}

	private void shuntingYardAlgorithm() {
		splitExpressionInTokens();
		while (hasMoreTokens()) {
			readToken();
			if (tokenIsNumber()) {
				addTokenToOutputQueue();
			} else if (tokenIsFunction()) {

			} else if (tokenIsArgumentSeparator()) {

			} else if (tokenIsLeftParentheses()) {
				pushActualOpToOperatorsStack();
			} else if (tokenIsRightParentheses()) {
				popOpToOutputUntilFindLeftParentheses();
			} else if (tokenIsOperator()) {
				if (thereAreOperatorsInTheStack()) {
					popOpToOutputIsPrecedenceIsLess();
				}
				pushActualOpToOperatorsStack();
			}
			updatePointer();
		}
		addResidualOperatorsFromTheStack();
	}

	private boolean thereAreOperatorsInTheStack() {
		return operatorStack.hasMoreElements();
	}

	private void updatePointer() {
		pointer++;
	}

	private void addResidualOperatorsFromTheStack() {
		while (operatorStack.hasMoreElements()) {
			evalIsNotParentheses();
			addOpFromStackToOutputQueue();
		}
	}

	private void addOpFromStackToOutputQueue() {
		outputTokensQueue.addToken(operatorStack.pop());
	}

	private void evalIsNotParentheses() {
		if (OperatorUtils.isAParentheses(operatorStack.getTop())) {
			exceptionFactory.launchMismatchedParenthesesException();
		}
	}

	private void popOpToOutputUntilFindLeftParentheses() {
		try {
			while (operatorStack.hasMoreElements()
					&& !OperatorUtils.isAParentheses(operatorStack.getTop())) {
				addTokenIfIsNotLeftParentheses(operatorStack.pop());
			}
			removeLeftParenthesesFromTheTopOfTheStack();
		} catch (IndexOutOfBoundsException e) {
			exceptionFactory.launchMismatchedParenthesesException();
		}

	}

	private void removeLeftParenthesesFromTheTopOfTheStack() {
		if (operatorStack.hasMoreElements()
				&& OperatorUtils.isAParentheses(operatorStack.getTop())) {
			operatorStack.pop();
		}
	}

	private void addTokenIfIsNotLeftParentheses(String operatorCandidate) {
		if (!operatorCandidate.equals(OperatorConstants.LEFT_PARENTHESES
				.getSymbol())) {
			outputTokensQueue.addToken(operatorCandidate);
		}

	}

	private boolean tokenIsRightParentheses() {
		return actualToken.equals(OperatorConstants.RIGHT_PARENTHESES
				.getSymbol());
	}

	private boolean tokenIsLeftParentheses() {
		return actualToken.equals(OperatorConstants.LEFT_PARENTHESES
				.getSymbol());
	}

	private void pushActualOpToOperatorsStack() {
		operatorStack.push(actualToken);
	}

	private void popOpToOutputIsPrecedenceIsLess() {
		if (isLeftAssociativeAndPrecedenceLessOrEquals() || isPrecedenceLess()) {
			outputTokensQueue.addToken(operatorStack.pop());
		}
	}

	private boolean isPrecedenceLess() {
		int comparation = OperatorUtils.comparePrecedence(actualToken,
				operatorStack.getTop());
		boolean precedenceLess = comparation < 0;
		return precedenceLess;
	}

	private boolean isLeftAssociativeAndPrecedenceLessOrEquals() {
		boolean isLeftAssociative = OperatorUtils
				.isLeftAssociativity(actualToken);

		int comparation = OperatorUtils.comparePrecedence(actualToken,
				operatorStack.getTop());
		boolean precedenceLessOrEquals = comparation <= 0;

		return isLeftAssociative && precedenceLessOrEquals;
	}

	private void addTokenToOutputQueue() {
		outputTokensQueue.addToken(actualToken);
	}

	private boolean tokenIsOperator() {
		return OperatorUtils.isAnOperator(actualToken);
	}

	private boolean tokenIsArgumentSeparator() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean tokenIsFunction() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean tokenIsNumber() {
		return MathParserUtils.tokenIsNumber(actualToken);
	}

	private void readToken() {
		actualToken = tokensQueue.getTokenAt(pointer);
	}

	private boolean hasMoreTokens() {
		return pointer < tokenQueueSize;
	}

	private void splitExpressionInTokens() {
		lexicalTokenizer.setExpression(expression);
		tokensQueue = lexicalTokenizer.getTokens();
		tokenQueueSize = tokensQueue.size();
	}
}
