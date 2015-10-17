package it.unibs.ing.Swing;

import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

public class SequenceCalculator {
	private ArrayList<String> sequence;
	
	public SequenceCalculator(ArrayList<String> _sequence){
		sequence=_sequence;
	}
	

	public void setSequence(ArrayList<String> _sequence){
		sequence=_sequence;
	}
	
	public  double computeSequence() throws ArithmeticException, IndexOutOfBoundsException, ParseException {

		
			for(int i=0;i<sequence.size();i++){
				if(sequence.get(i).equals("*")) {
					double number1=Double.parseDouble(sequence.get(i-1));
					double number2=Double.parseDouble(sequence.get(i+1));
					String temp=new Double(number1*number2).toString();
					sequence.remove(i);
					sequence.add(i, temp);
					sequence.remove(i-1);
					sequence.remove(i);
				}
				else if(sequence.get(i).equals("/")){
					double number1=Double.parseDouble(sequence.get(i-1));
					double number2=Double.parseDouble(sequence.get(i+1));
					String temp=new Double(number1/number2).toString();
					sequence.remove(i);
					sequence.add(i, temp);
					sequence.remove(i-1);
					sequence.remove(i);
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
					sequence.remove(i);
				}
				
				else if(sequence.get(i).equals("-")) {
					double number1=Double.parseDouble(sequence.get(i-1));
					double number2=Double.parseDouble(sequence.get(i+1));
					String temp=new Double(number1-number2).toString();
					sequence.remove(i);
					sequence.add(i, temp);
					sequence.remove(i-1);
					sequence.remove(i);
				}
			
			}
			
			return Double.parseDouble(sequence.get(0));
			
		
	}

	
	
}
