package it.unibs.ing.Swing;

import java.awt.EventQueue;
import java.text.NumberFormat;

import javax.swing.JFrame;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Prova {

	private JFrame frame;
	private NumberFormat format;
	private double number=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prova window = new Prova();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Prova() {
		format=NumberFormat.getNumberInstance();
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JFormattedTextField field = new JFormattedTextField(format);
		field.setHorizontalAlignment(SwingConstants.RIGHT);
		field.setValue(new Double(number));
		field.setBounds(87, 62, 252, 49);
		frame.getContentPane().add(field);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SwingUtilities.updateTextField(field, "1");
			}
		});
		btnNewButton.setBounds(168, 176, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}

}
