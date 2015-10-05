package it.unibs.ing.materiali;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;

public class NewModel extends DefaultComboBoxModel{
	
	
	public NewModel(ColorName[] list){
		super(list);
	}
	
	public ColorName getSelectedItem(){
		return (ColorName)super.getSelectedItem();
	}
	

	
	
	
	
	

}
