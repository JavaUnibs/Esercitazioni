package it.unibs.ing.Swing;

import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

public class MemoryModel {
	private JFormattedTextField field;
	private JTextField fieldB;
	private String symbol;
	private Double memory;
	
	
	private void computeMemory(){
		try{
			field.commitEdit();
			Number number= (Number)field.getValue();
			double value= number.doubleValue();
			switch(symbol){
			case("MR"): memory=new Double(value); break;
			case("MC"): memory=null; break;
			case("MS"): field.setValue(memory); break;
			case("M+"): field.setValue(new Double(value+memory.doubleValue())); break;
			case("M-"): field.setValue(new Double(value-memory.doubleValue())); break;
			}
		}catch(ParseException exc){
			fieldB.setText("Input invalido");
			fieldB.requestFocusInWindow();
		}
		catch(NullPointerException exc){
			fieldB.setText("Memoria vuota");
			fieldB.requestFocusInWindow();
		}
	}
	
	
	public MemoryModel(JFormattedTextField _field, JTextField _fieldB, String _symbol, Double _memory){
		field=_field;
		fieldB=_fieldB;
		symbol=_symbol;
		memory=_memory;
		computeMemory();
		
	}
}
