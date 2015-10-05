package it.unibs.ing.Swing;

import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

public class SequenceCalculator {
	private ArrayList<String> sequence;
	private JFormattedTextField fieldB;
	private JTextField fieldA, fieldC;
	
	public SequenceCalculator(ArrayList<String> _sequence, JFormattedTextField _fieldB, JTextField _fieldA, JTextField _fieldC){
		sequence=_sequence;
		fieldB=_fieldB;
		fieldC=_fieldC;
		fieldA=_fieldA;
		computeSequence();
	}
	
	private void computeSequence(){

		try{
			for(int i=0;i<sequence.size();i++){
				if(sequence.get(i).equals("*")) {
					double number1=Double.parseDouble(sequence.get(i-1));
					double number2=Double.parseDouble(sequence.get(i+1));
					String temp=new Double(number1*number2).toString();
					sequence.remove(i);
					sequence.add(i, temp);
					sequence.remove(i-1);
					sequence.remove(i+1);
				}
				else if(sequence.get(i).equals("/")){
					double number1=Double.parseDouble(sequence.get(i-1));
					double number2=Double.parseDouble(sequence.get(i+1));
					String temp=new Double(number1/number2).toString();
					sequence.remove(i);
					sequence.add(i, temp);
					sequence.remove(i-1);
					sequence.remove(i+1);
				}
				
			}
			
			for(int i=0;i<sequence.size();i++){
				if(sequence.get(i).equals("+")) {
					double number1=Double.parseDouble(sequence.get(i-1));
					double number2=Double.parseDouble(sequence.get(i+1));
					String temp=new Double(number1+number2).toString();
					sequence.remove(i);
					sequence.add(i, temp);
					sequence.remove(i-1);
					sequence.remove(i+1);
				}
				
				else if(sequence.get(i).equals("-")) {
					double number1=Double.parseDouble(sequence.get(i-1));
					double number2=Double.parseDouble(sequence.get(i+1));
					String temp=new Double(number1-number2).toString();
					sequence.remove(i);
					sequence.add(i, temp);
					sequence.remove(i-1);
					sequence.remove(i+1);
				}
			
			}
			
			fieldB.setValue(Double.parseDouble(sequence.get(0)));
			sequence.clear();
			fieldA.setText(null);
			
		} catch(NumberFormatException e){
			fieldC.setText("Sintassi non corretta");
			fieldC.requestFocusInWindow();
		}
		
		catch(ArithmeticException e){
			fieldC.setText("Operazione impossibile");
			fieldC.requestFocusInWindow();
		}
		catch(ArrayIndexOutOfBoundsException e){
			fieldC.setText("Sintassi non corretta");
			fieldC.requestFocusInWindow();	
		}
		catch(IndexOutOfBoundsException e){
			fieldC.setText("Sintassi non corretta");
			fieldC.requestFocusInWindow();
		}
		
	}

	
	
}
