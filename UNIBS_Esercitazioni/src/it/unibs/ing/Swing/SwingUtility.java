package it.unibs.ing.Swing;

import javax.swing.JTextField;

public class SwingUtility {

	public static void updateTextField(JTextField field, String string){
		String text= field.getText();
		text.concat(string);
		field.setText(text);
	}
}
