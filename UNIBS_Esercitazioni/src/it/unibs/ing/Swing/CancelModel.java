package it.unibs.ing.Swing;

import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

public class CancelModel {
	
	private JTextField fieldA, fieldC;
	private JFormattedTextField fieldB;
	private String symbol;
	private ArrayList<String> list;
	
	private void computeCancel(){
		switch(symbol){
		case("C"): {
			fieldA.setText(null);
			fieldB.setValue(new Double(0));
			list.clear();
		}
		break;
		case("CE"): fieldB.setValue(new Double(0)); 
		break;
		case("backspace"):{
			try{
				fieldB.commitEdit();
				String text=fieldB.getText().substring(0, fieldB.getText().length()-1);
				fieldB.setText(text);
				
			}catch(ParseException exc){
				fieldC.setText("Input invalido");
				fieldC.requestFocusInWindow();
			}
		}
		break;
		}
	}
	public CancelModel(JTextField _fieldA, JFormattedTextField _fieldB, JTextField _fieldC, String _symbol, ArrayList<String> _list){
		fieldA=_fieldA;
		fieldB=_fieldB;
		fieldC=_fieldC;
		symbol=_symbol;
		list=_list;
		computeCancel();
	}

}
