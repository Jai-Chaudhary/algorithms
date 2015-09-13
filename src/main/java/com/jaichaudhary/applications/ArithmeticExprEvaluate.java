package com.jaichaudhary.applications;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


import com.jaichaudhary.collections.Stack;

public class ArithmeticExprEvaluate {
	public static void main(String[] args) {
		Stack<Character> operators = new Stack<Character> ();
		Stack<Integer> operands = new Stack<Integer> ();
	
		String expr = StdIn.readString();

		for(int i = 0; i < expr.length(); i++) {

			if (expr.charAt(i) == '('); // Do Nothing
			else if (Character.isDigit(expr.charAt(i)))	operands.push(Character.getNumericValue(expr.charAt(i)));
			else if (expr.charAt(i) == ')') {
				Character op = operators.pop();
				int rightOperand = operands.pop();
				int leftOperand = operands.pop();

				if(op == '+') operands.push(leftOperand + rightOperand);
				if(op == '-') operands.push(leftOperand - rightOperand);
				if(op == '*') operands.push(leftOperand * rightOperand);
			}
			else if("+-*".indexOf(expr.charAt(i)) != -1) operators.push(expr.charAt(i));
			else throw new IllegalArgumentException();
		}
		StdOut.println(operands.pop());
	}
}