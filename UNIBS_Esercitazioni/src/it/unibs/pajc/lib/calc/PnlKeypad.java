package it.unibs.pajc.lib.calc;

import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PnlKeypad extends PnlOpBase implements ActionListener {

	void addOps() {
		for(int i=9; i>0; i--)
			addButton("" + i);
		
		addButton("0", BTN_SIZE * 2 + layout.getHgap(), BTN_SIZE);
		addButton(".");
	}

}
