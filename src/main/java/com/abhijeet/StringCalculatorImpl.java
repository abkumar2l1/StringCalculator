package com.abhijeet;

import java.util.Stack;

public class StringCalculatorImpl implements StringCalculator {

	public String procerssString(String expression) {
		// TODO Auto-generated method stub
		
		if (expression == null) 
			return "Invalid Expression";
		char[] charExpression = expression.toCharArray();
		
		if (charExpression.length == 0 ||  charExpression[0] == '+' || charExpression[0] == '-' || charExpression[0] == '*' || charExpression[0] == '/') {
			return "Invalid Expression";
		}
		
		Stack<Integer> values = new Stack<Integer>();
		
		Stack<Character> operators = new Stack<Character>();
		
		boolean isOperator = false;
		boolean isDigit = false;
		
		for (int i = 0 ; i < charExpression.length; i++) {
			if (charExpression[i] == ' ') 
				return "Invalid Expression";
			
			if (charExpression[i] >= '0' && charExpression[i] <= '9') 
            { 
				if (!isDigit) {
					values.push(Integer.parseInt(String.valueOf(charExpression[i])));
					isDigit = true;
					isOperator = false;
				} else {
					return "Invalid Expression";
				}
            }	
			else if (charExpression[i] == '(') 
				operators.push(charExpression[i]);
			
			else if (charExpression[i] == ')') 
            { 
                while (operators.peek() != '(') 
                  values.push(calculate(operators.pop(), values.pop(), values.pop())); 
                operators.pop(); 
            }
			
			else if (charExpression[i] == '+' || charExpression[i] == '-' || charExpression[i] == '*' || charExpression[i] == '/' || charExpression[i] == '^') 
           { 
			   if (!isOperator) {
				   while (!operators.empty() && hasPrecedence(charExpression[i], operators.peek())) {
					   values.push(calculate(operators.pop(), values.pop(), values.pop()));
				   }
				   isOperator = true;
				   isDigit = false;
			   } else {
				   return "Invalid Expression";
			   }
               operators.push(charExpression[i]); 
           }
		}
		
		while (!operators.empty()) 
	        values.push(calculate(operators.pop(), values.pop(), values.pop())); 

	    return values.pop().toString();
	}
	
	private  int calculate(char op, int b, int a) 
    { 
        switch (op) 
        { 
        case '+': 
            return a + b; 
        case '-': 
            return a - b; 
        case '*': 
            return a * b; 
        case '/': 
            if (b == 0) 
                throw new UnsupportedOperationException("Cannot divide by zero"); 
            return a / b;
        case '^': 
            return a ^ b;
        } 
        return 0; 
    }
	
	public static boolean hasPrecedence(char op1, char op2) { 
        if (op2 == '(' || op2 == ')') 
            return false; 
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) 
            return false; 
        else
            return true; 
    }
	
	

}
