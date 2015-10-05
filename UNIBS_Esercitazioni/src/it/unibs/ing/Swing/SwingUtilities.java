package it.unibs.ing.Swing;

import java.util.ArrayList;

import javax.swing.JTextField;

public class SwingUtilities {

	public static void updateTextField(JTextField field, String string){
		String text= field.getText();
		field.setText(text+string);
	}
	
	public static String arraylistToString(ArrayList<String> list){
		String stringList="";
		for (String s : list)
		{
		    stringList += s + " ";
		}
		
		return stringList;
		
	}
}
