package it.unibs.ing.Swing;

import java.text.ParseException;

import javax.swing.JFormattedTextField;

public class MemoryModel {
	private JFormattedTextField field;
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
		}catch(ParseException exc){}
		catch(NullPointerException exc){}
	}
	
	
	public MemoryModel(JFormattedTextField _field, String _symbol, Double _memory){
		field=_field;
		symbol=_symbol;
		memory=_memory;
		computeMemory();
		
	}
}
