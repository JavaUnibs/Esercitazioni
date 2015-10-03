package it.unibs.ing.Swing;

import java.text.ParseException;
import java.lang.Math;

import javax.swing.JFormattedTextField;

public class FunctionModel {

	private JFormattedTextField field;
	private String symbol;
	
	private double selectFunction(double value){
		try{
		switch (symbol){
		case("root"): return Math.sqrt(value);
		case("reciprocate"): return 1/value;
		case("negate"): return value*(-1);
		}
		} catch (ArithmeticException exc){}
		return 0;
	}
	
	
	private void computeFunction(){
		try{
			field.commitEdit();
			Number number= (Number)field.getValue();
			double value= number.doubleValue();
			value=selectFunction(value);
			field.setValue(new Double(value));
			}
		catch (ParseException exc){}
		
		}
	
	
	
	
	public FunctionModel( JFormattedTextField _field, String _symbol){
		field=_field;
		symbol=_symbol;
		computeFunction();
	}
	
}
