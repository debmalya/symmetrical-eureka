package hr;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.Stack;

public class AsterikExpressions {

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)){
			int n = in.nextInt();
			String[] result = new String[n];
			for (int i = 0; i< n; i++) {
				result[i] = evaluateExpressions(in.next());
			}
			
			for (int i = 0; i< n; i++) {
				System.out.println(result[i]);
			}
			
		}

	}

	/**
	 * 
	 * @param expression
	 *            to be evaluated.
	 * @return either numeric value after evaluating the expression or
	 *         "Syntax Error".
	 */
	public static String evaluateExpressions(String expression) {
		if (expression.startsWith("*") || expression.endsWith("*") || expression.indexOf("***") > -1) {
			return "Syntax Error";
		}

		// There are at most 17 consecutive digits in an expression.
		Stack<BigInteger> operandStack = new Stack<>();
		char[] v = expression.toCharArray();

		BigInteger eachOperand = BigInteger.ZERO;
		boolean isExponentiation = false;
		for (int index = 0; index < v.length; index++) {
			if (v[index] == '*') {
				if (index > 0 && v[index - 1] == '*') {
					isExponentiation = true;
				} else {
					if (isExponentiation) {
						BigInteger firstOperand = operandStack.pop();
						// TODO if exponent is bigger than integer.
						firstOperand = firstOperand.pow(eachOperand.intValue());
//						for (BigInteger loopIndex = BigInteger.ZERO; loopIndex.equals(eachOperand); loopIndex.add(BigInteger.ONE)){
//							firstOperand = firstOperand.shiftLeft(1);
//						}
						operandStack.push(firstOperand);
						isExponentiation = false;
					} else {
						operandStack.push(eachOperand);
					}
				}

				eachOperand = BigInteger.ZERO;
			} else {
				// must be a number (operand).
				if (!eachOperand.equals(BigInteger.ZERO)) {
					// Not the first digit, have to multiply with ten.
					eachOperand = eachOperand.multiply(BigInteger.TEN);
				}
				eachOperand = eachOperand.add(new BigInteger("" + v[index]));
			}
		}
		// the last element
		operandStack.push(eachOperand);
		BigInteger modulo = new BigInteger("1000000007");
	
		BigInteger result = operandStack.pop();
		while (!operandStack.isEmpty()){
			result = result.multiply(operandStack.pop());
		}
		return result.mod(modulo).toString();
	}

}
