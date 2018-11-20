package com.abhijeet;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void test() {
		StringCalculator calculator = new StringCalculatorImpl();
		
		assertEquals("Invalid Expression", calculator.procerssString("+22"), "Invalid Expression");
		assertEquals("4", calculator.procerssString("2+2"), "4");
	}

}
