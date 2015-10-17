package it.unibs.ing.Swing;

import java.util.ArrayList;

import javax.swing.JTextField;

public class SwingUtilities {

	public static void updateTextField(JTextField field, String string){
		String text= field.getText();
		field.setText(text+string);
	}
	

}
