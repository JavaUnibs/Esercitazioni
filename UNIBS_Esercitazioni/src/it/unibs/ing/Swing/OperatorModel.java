package it.unibs.ing.Swing;

import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import it.unibs.ing.Swing.SwingUtilities;

public class OperatorModel {
	
	private JTextField fieldA, fieldC;
	private JFormattedTextField fieldB;
	private String symbol;
	private ArrayList<String> list;
	
	private boolean isOperator(){
		try{
			switch(list.get(list.size()-1)){
				case("+"): return true;
				case("-"): return true;
				case("*"): return true;
				case("/"): return true;
			}
		}catch(NullPointerException e){}
		return false;
	}
	
	private void computeOperator(){
		if(isOperator()) {
			list.remove(list.size()-1);
			list.add(symbol);
			fieldA.setText(SwingUtilities.arraylistToString(list));
		}
		else
		try{
			fieldB.commitEdit();
			list.add(fieldB.getText());
			list.add(symbol);
			fieldA.setText(SwingUtilities.arraylistToString(list));	
			}
		catch (ParseException exc){
			fieldC.setText("Input invalido");
			fieldC.requestFocusInWindow();
		}
		
		}

	
	public OperatorModel(JTextField _fieldA, JTextField _fieldC, JFormattedTextField _fieldB, String _symbol, ArrayList<String> _list){
		fieldA=_fieldA;
		fieldB=_fieldB;
		fieldC=_fieldC;
		symbol=_symbol;
		list=_list;
		computeOperator();
	}
	
	

}
