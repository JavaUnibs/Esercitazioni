package it.unibs.ing.Swing;

import java.text.ParseException;
import java.lang.Math;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

public class FunctionModel {

	private JFormattedTextField field;
	private JTextField fieldB;
	private String symbol;
	
	private double selectFunction(double value){
		try{
		switch (symbol){
		case("root"): return Math.sqrt(value);
		case("reciprocate"): return 1/value;
		case("negate"): return value*(-1);
		}
		} catch (ArithmeticException exc){
			fieldB.setText("Operazione impossibile");
			fieldB.requestFocusInWindow();
		}
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
		catch (ParseException exc){
			fieldB.setText("Input invalido");
			fieldB.requestFocusInWindow();
		}
		
		}
	
	
	
	
	public FunctionModel( JFormattedTextField _field, JTextField _fieldB,  String _symbol){
		field=_field;
		fieldB=_fieldB;
		symbol=_symbol;
		computeFunction();
	}
	
}
