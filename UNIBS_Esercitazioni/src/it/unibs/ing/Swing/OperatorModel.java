package it.unibs.ing.Swing;

import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import it.unibs.ing.Swing.SwingUtility;

public class OperatorModel {
	
	private JTextField fieldA;
	private JFormattedTextField fieldB;
	private String symbol;
	private ArrayList<String> list;
	
	private void computeOperator(){
		
		try{
			fieldB.commitEdit();
			list.add(fieldB.getText());
			list.add(symbol);
			SwingUtility.updateTextField(fieldA, fieldB.getText().concat(symbol));	
			}
		catch (ParseException exc){}
		
		}

	
	public OperatorModel(JTextField _fieldA, JFormattedTextField _fieldB, String _symbol, ArrayList<String> _list){
		fieldA=_fieldA;
		fieldB=_fieldB;
		symbol=_symbol;
		list=_list;
		computeOperator();
	}
	
	

}
