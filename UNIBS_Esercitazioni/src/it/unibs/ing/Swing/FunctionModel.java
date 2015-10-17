package it.unibs.ing.Swing;

import java.lang.Math;



public class FunctionModel {

	public static double selectFunction (double value, String function) throws ArithmeticException{
		
		switch (function){
		case("root"): return Math.sqrt(value);
		case("reciprocate"): return 1/value;
		case("negate"): return value*(-1);
		
		}
		
		return 0;
		}
	
}
