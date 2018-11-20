package com.abhijeet;
import java.util.Scanner;

public class InputScanner {
	
	public static void main(String[] args) {
		Scanner input;
		input = new Scanner(System.in);
		
		int noOfCase = input.nextInt();
		
		if( noOfCase >= 100 || noOfCase <= 0) {
			System.out.println("Input should not be greater then 100 and negative");
			return;
		}
		
		StringCalculator stringCalculator = new StringCalculatorImpl();
		
		String[] inputs = new String[noOfCase];
		
		for(int i = 0 ; i < noOfCase ; i++) {
			input = new Scanner(System.in);
			inputs[i] = input.nextLine();
		}
		
		for (int i = 0; i < inputs.length ; i++) {
			System.out.println("Case # "+ (i + 1) + ": " + stringCalculator.procerssString(inputs[i]));
		}
	}

}
