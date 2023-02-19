/*
 * @author Lima Waziri
 * @date 2/18/2023
 */

public class Notation {
	/*
	 * Will convert an infix expression into a postfix expression
	 * 
	 * @param infix
	 * 
	 * @return will return a string that contains the infixToPostfix expression
	 * 
	 * @throws InvalidNotationFormatException
	 */
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException {
		MyStack<Character> stack = new MyStack<>();
		MyQueue<String> queue = new MyQueue<>();
		try {
			for (int i = 0; i < infix.length(); i++) {
				char character = infix.charAt(i);
				if (character == ' ') {
					continue;
				} else if (Character.isDigit(character)) {
					queue.enqueue(String.valueOf(character));
				} else if (character == '(') {
					stack.push(character);
				} else if (operator(character)) {
					while (!stack.isEmpty() && operator(stack.top()) && higherPrec(stack.top(), character)) {
						queue.enqueue(String.valueOf(stack.pop()));
					}
					stack.push(character);

				} else if (character == ')') {
					while (!stack.isEmpty() && operator(stack.top())) {
						queue.enqueue(String.valueOf(stack.pop()));
					}
					if (stack.isEmpty() && stack.top() == '(') {
						throw new InvalidNotationFormatException(null);
					} else {
						stack.pop();
					}
				}
			}
			while (!stack.isEmpty() && operator(stack.top())) {
				queue.enqueue(String.valueOf(stack.pop()));
			}
		} catch (Exception e) {
			throw new InvalidNotationFormatException(e);
		}
		return queue.toString();
	}

	/*
	 * Will convert an postfix expression into a infix expression
	 * 
	 * @param postFix
	 * 
	 * @return will return a string that contains the postfixToInfix expression
	 * 
	 * @throws InvalidNotationFormatException
	 */
	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException {
		MyStack<String> stack = new MyStack<>();
		try {
			for (int i = 0; i < postfix.length(); i++) {
				char character = postfix.charAt(i);
				if (character == ' ') {
					continue;
				} else if (Character.isDigit(character)) {
					stack.push(Character.toString(character));

				} else if (operator(character)) {
					if (stack.size() < 2) {
						throw new InvalidNotationFormatException(null);
					}
					String op2 = stack.pop();
					String op1 = stack.pop();

					String result = "(" + op1 + character + op2 + ")";
					stack.push(result);

				}
			}
			if (stack.size() != 1) {
				throw new InvalidNotationFormatException(null);
			}
		} catch (StackUnderflowException | StackOverflowException e) {
			throw new InvalidNotationFormatException(e);
		}
		try {
			return stack.pop();
		} catch (StackUnderflowException e) {
			throw new InvalidNotationFormatException(e);
		}
	}

	/*
	 * Will evaluate a postfix expression
	 * 
	 * @param postFix
	 * 
	 * @return will a double that holds the answer after evaluating the postfix
	 * expression
	 * 
	 * @throws InvalidNotationFormatException
	 */
	public static double evaluatePostfixExpression(String postFix) throws InvalidNotationFormatException {
		MyStack<Double> stack = new MyStack<>();
		try {
			for (int i = 0; i < postFix.length(); i++) {
				char character = postFix.charAt(i);
				if (character == ' ') {
					continue;
				} else if (Character.isDigit(character) || character == '(') {
					stack.push((double) (character - '0'));
				} else if (operator(character)) {
					if (stack.size() < 2) {
						throw new InvalidNotationFormatException(null);
					}
					double op1 = stack.pop();
					double op2 = stack.pop();
					double result = 0.0;
					if (character == '*') {
						result = op2 * op1;
					} else if (character == '/') {
						result = op2 / op1;
					} else if (character == '+') {
						result = op1 + op2;
					} else if (character == '-') {
						result = op2 - op1;
					}
					stack.push(result);
				}
			}
			if (stack.size() != 1) {
				throw new InvalidNotationFormatException(null);
			}
		} catch (StackUnderflowException | StackOverflowException e) {
			throw new InvalidNotationFormatException(e);
		}
		try {
			return stack.pop();
		} catch (StackUnderflowException e) {
			throw new InvalidNotationFormatException(e);
		}
	}

	/*
	 * Will set which operator should go first when evaluating
	 * 
	 * @param character
	 * 
	 * @return 1 if operator is addition or subtraction, and 2 if its multiplication
	 * or addition. Will return 0 otherwise
	 */
	private static int checkPrecedence(char characeter) {
		switch (characeter) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		default:
			return 0;
		}
	}

	/*
	 * Will check if a character is an operator
	 * 
	 * @param character
	 * 
	 * @return true if it is an operator, false other wise
	 */
	private static boolean operator(char character) {
		if (character == '+' || character == '-' || character == '/' || character == '*') {
			return true;
		}
		return false;
	}

	/*
	 * Will check which operator has an higher precedence
	 * 
	 * @param operatorOne, operatorTwo
	 * 
	 * @return true if operatorOne has a higher precedence than operatorTwo, and
	 * false otherwise
	 */
	private static boolean higherPrec(char operatorOne, char operatorTwo) {
		return checkPrecedence(operatorOne) > checkPrecedence(operatorTwo);
	}

}
