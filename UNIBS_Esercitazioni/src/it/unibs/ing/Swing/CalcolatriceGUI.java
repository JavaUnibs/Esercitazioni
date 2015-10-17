package it.unibs.ing.Swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import it.unibs.ing.Swing.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import it.unibs.ing.Swing.TextChangeListener;

public class CalcolatriceGUI {
	private final String INCORRECT_INPUT="Input non corretto";
	private final String INCORRECT_SINTAX="Sintassi non corretta";
	private final String IMPOSSIBLE_OPERATION="Operazione impossibile";
	private final String EMPTY_MEMORY="Memoria vuota";
	private double number=0;
	private JFrame frame;
	private JFormattedTextField textB;
	private JTextField textA;
	private NumberFormat textBFormat;
	private JTextField textC;
	/**
	 * Launch the application.
	 * 
	 */
	
	private void giveWarning(String message){
		textC.setText(message);
		textC.requestFocusInWindow();
	}
	
	
	private Double getTextValue(){
		try{
			textB.commitEdit();
			return (Double)textB.getValue();
		}catch (ParseException exc){
			giveWarning(INCORRECT_INPUT);
		}
		
		return null;
		
	}
	
	
	private class FunctionListener implements ActionListener{
		private String function;
		FunctionListener(String _function){
			function=_function;
			
		}

		public void actionPerformed(ActionEvent e) {
			try{
				Double temp= getTextValue();
				if(temp!=null) textB.setValue(new Double(FunctionModel.selectFunction(temp.doubleValue(), function)));
				
			}catch (ArithmeticException exc){
				giveWarning(IMPOSSIBLE_OPERATION);
			
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalcolatriceGUI window = new CalcolatriceGUI();
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
	public CalcolatriceGUI() {
		textBFormat=NumberFormat.getNumberInstance();
		
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		MemoryModel memory= new MemoryModel();
		SequenceModel sequence= new SequenceModel();
		SequenceCalculator sequenceCalculator= new SequenceCalculator(sequence.getSequence());
		sequence.addTextChangeListener(new TextChangeListener(){
			public void textChanged(){
			String temp=sequence.toString();
			textA.setText(temp);
			sequenceCalculator.setSequence(sequence.getSequence());
			
			}
		});
		
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textB =new JFormattedTextField(textBFormat);
		textB.setBackground(Color.WHITE);
		textB.setValue(new Double(number));
		textB.setHorizontalAlignment(SwingConstants.RIGHT);
		textB.setBounds(216, 46, 218, 32);
		frame.getContentPane().add(textB);
		
		textA = new JTextField();
		textA.setBackground(new Color(255, 255, 255));
		textA.setEditable(false);
		textA.setBounds(10, 11, 424, 32);
		frame.getContentPane().add(textA);
		textA.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 86, 424, 175);
		frame.getContentPane().add(panel);
		
		JButton btnMC = new JButton("MC");
		btnMC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memory.clearMemory();
			}
		});
		btnMC.setPreferredSize(new Dimension(52, 38));
		btnMC.setMinimumSize(new Dimension(52, 38));
		btnMC.setMaximumSize(new Dimension(52, 38));
		panel.add(btnMC);
		
		JButton btnMS = new JButton("MS");
		btnMS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double temp= memory.getMemory();
				if(temp!=null) textB.setValue(temp);
				else {
					giveWarning(EMPTY_MEMORY);
				}
			}
		});
		btnMS.setPreferredSize(new Dimension(52, 38));
		btnMS.setMinimumSize(new Dimension(52, 38));
		btnMS.setMaximumSize(new Dimension(52, 38));
		panel.add(btnMS);
		
		JButton btnMR = new JButton("MR");
		btnMR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double temp= getTextValue();
				if(temp!=null) memory.setMemory(temp);
			}
		});
		btnMR.setPreferredSize(new Dimension(52, 38));
		btnMR.setMinimumSize(new Dimension(52, 38));
		btnMR.setMaximumSize(new Dimension(52, 38));
		panel.add(btnMR);
		
		JButton btnMPlus = new JButton("M+");
		btnMPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double temp= getTextValue();
				if(temp!=null){
					if(memory.isEmpty()) giveWarning(EMPTY_MEMORY);
					else textB.setValue(new Double(memory.getMemory().doubleValue()+temp.doubleValue()));
				}
			}
		});
		btnMPlus.setPreferredSize(new Dimension(52, 38));
		btnMPlus.setMinimumSize(new Dimension(52, 38));
		btnMPlus.setMaximumSize(new Dimension(52, 38));
		panel.add(btnMPlus);
		
		JButton btnMMinus = new JButton("M-");
		btnMMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double temp= getTextValue();
				if(temp!=null){
					if(memory.isEmpty()) giveWarning(EMPTY_MEMORY);
					else textB.setValue(new Double(temp.doubleValue()-memory.getMemory().doubleValue()));
				}
			}
		});
		btnMMinus.setPreferredSize(new Dimension(52, 38));
		btnMMinus.setMinimumSize(new Dimension(52, 38));
		btnMMinus.setMaximumSize(new Dimension(52, 38));
		panel.add(btnMMinus);
		
		JButton btnBackspace = new JButton("\u2190");
		btnBackspace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text=textB.getText().substring(0, textB.getText().length()-1);
				textB.setText(text);
			}
		});
		btnBackspace.setPreferredSize(new Dimension(52, 38));
		btnBackspace.setMinimumSize(new Dimension(52, 38));
		btnBackspace.setMaximumSize(new Dimension(52, 38));
		panel.add(btnBackspace);
		
		JButton btnCE = new JButton("CE");
		btnCE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textB.setValue(new Double(0));
			}
		});
		btnCE.setPreferredSize(new Dimension(52, 38));
		btnCE.setMinimumSize(new Dimension(52, 38));
		btnCE.setMaximumSize(new Dimension(52, 38));
		panel.add(btnCE);
		
		JButton btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textB.setValue(new Double(0));
				sequence.clearSequence();
			}
		});
		btnC.setPreferredSize(new Dimension(52, 38));
		btnC.setMinimumSize(new Dimension(52, 38));
		btnC.setMaximumSize(new Dimension(52, 38));
		panel.add(btnC);
		
		JButton btnNegate = new JButton("\u00B1");
		btnNegate.addActionListener(new FunctionListener("negate"));
	
		btnNegate.setPreferredSize(new Dimension(52, 38));
		btnNegate.setMinimumSize(new Dimension(52, 38));
		btnNegate.setMaximumSize(new Dimension(52, 38));
		panel.add(btnNegate);
		
		JButton btnRoot = new JButton("\u221A");
		btnRoot.addActionListener(new FunctionListener("root"));
		btnRoot.setPreferredSize(new Dimension(52, 38));
		btnRoot.setMinimumSize(new Dimension(52, 38));
		btnRoot.setMaximumSize(new Dimension(52, 38));
		panel.add(btnRoot);
		
		JButton btnFor = new JButton("*");
		btnFor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Double value =getTextValue();
			if(value!=null){
				sequence.addToSequence(textB.getText());
				sequence.addToSequence("*");
			}
			}
		});
		btnFor.setPreferredSize(new Dimension(52, 38));
		btnFor.setMinimumSize(new Dimension(52, 38));
		btnFor.setMaximumSize(new Dimension(52, 38));
		panel.add(btnFor);
		
		JButton btnPlus = new JButton("+");
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Double value =getTextValue();
				if(value!=null){
					sequence.addToSequence(textB.getText());
					sequence.addToSequence("+");
				}
			}
		});
		btnPlus.setPreferredSize(new Dimension(52, 38));
		btnPlus.setMinimumSize(new Dimension(52, 38));
		btnPlus.setMaximumSize(new Dimension(52, 38));
		panel.add(btnPlus);
		
		JButton btnDivide = new JButton("/");
		btnDivide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double value =getTextValue();
				if(value!=null){
					sequence.addToSequence(textB.getText());
					sequence.addToSequence("/");
				}
			}
		});
		btnDivide.setPreferredSize(new Dimension(52, 38));
		btnDivide.setMinimumSize(new Dimension(52, 38));
		btnDivide.setMaximumSize(new Dimension(52, 38));
		panel.add(btnDivide);
		
		JButton btnMinus = new JButton("-");
		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double value =getTextValue();
				if(value!=null){
					sequence.addToSequence(textB.getText());
					sequence.addToSequence("*");
				}
			}
		});
		btnMinus.setPreferredSize(new Dimension(52, 38));
		btnMinus.setMinimumSize(new Dimension(52, 38));
		btnMinus.setMaximumSize(new Dimension(52, 38));
		panel.add(btnMinus);
		
		JButton btnReciprocate = new JButton("1/x");
		btnReciprocate.addActionListener(new FunctionListener("reciprocate"));
		btnReciprocate.setPreferredSize(new Dimension(52, 38));
		btnReciprocate.setMinimumSize(new Dimension(52, 38));
		btnReciprocate.setMaximumSize(new Dimension(52, 38));
		panel.add(btnReciprocate);
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.updateTextField(textB, "1");
			}
		});
		btn1.setPreferredSize(new Dimension(52, 38));
		btn1.setMinimumSize(new Dimension(52, 38));
		btn1.setMaximumSize(new Dimension(52, 38));
		panel.add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.updateTextField(textB, "2");
			}
		});
		btn2.setPreferredSize(new Dimension(52, 38));
		btn2.setMinimumSize(new Dimension(52, 38));
		btn2.setMaximumSize(new Dimension(52, 38));
		panel.add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.updateTextField(textB, "3");
			}
		});
		btn3.setPreferredSize(new Dimension(52, 38));
		btn3.setMinimumSize(new Dimension(52, 38));
		btn3.setMaximumSize(new Dimension(52, 38));
		panel.add(btn3);
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.updateTextField(textB, "4");
			}
		});
		btn4.setPreferredSize(new Dimension(52, 38));
		btn4.setMinimumSize(new Dimension(52, 38));
		btn4.setMaximumSize(new Dimension(52, 38));
		panel.add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.updateTextField(textB, "5");
			}
		});
		btn5.setPreferredSize(new Dimension(52, 38));
		btn5.setMinimumSize(new Dimension(52, 38));
		btn5.setMaximumSize(new Dimension(52, 38));
		panel.add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.updateTextField(textB, "6");
			}
		});
		btn6.setPreferredSize(new Dimension(52, 38));
		btn6.setMinimumSize(new Dimension(52, 38));
		btn6.setMaximumSize(new Dimension(52, 38));
		panel.add(btn6);
		
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.updateTextField(textB, "7");
			}
		});
		btn7.setPreferredSize(new Dimension(52, 38));
		btn7.setMinimumSize(new Dimension(52, 38));
		btn7.setMaximumSize(new Dimension(52, 38));
		panel.add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.updateTextField(textB, "8");
			}
		});
		btn8.setPreferredSize(new Dimension(52, 38));
		btn8.setMinimumSize(new Dimension(52, 38));
		btn8.setMaximumSize(new Dimension(52, 38));
		panel.add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.updateTextField(textB, "9");
			}
		});
		btn9.setPreferredSize(new Dimension(52, 38));
		btn9.setMinimumSize(new Dimension(52, 38));
		btn9.setMaximumSize(new Dimension(52, 38));
		panel.add(btn9);
		
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.updateTextField(textB, "0");
			}
		});
		btn0.setPreferredSize(new Dimension(52, 38));
		btn0.setMinimumSize(new Dimension(52, 38));
		btn0.setMaximumSize(new Dimension(52, 38));
		panel.add(btn0);
		
		JButton btnDot = new JButton(".");
		btnDot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.updateTextField(textB, ".");
			}
		});
		btnDot.setPreferredSize(new Dimension(52, 38));
		btnDot.setMinimumSize(new Dimension(52, 38));
		btnDot.setMaximumSize(new Dimension(52, 38));
		panel.add(btnDot);
		
		JButton btnEqual = new JButton("=");
		btnEqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Double value=getTextValue();
				if(value!=null){
					sequence.addToSequence(textB.getText());
					try{
						textB.setValue(sequenceCalculator.computeSequence());
						sequence.clearSequence();
						
					}catch (ArithmeticException exc) {
						giveWarning(IMPOSSIBLE_OPERATION);
					}
					catch  (IndexOutOfBoundsException exc){
						giveWarning(INCORRECT_SINTAX);
					}
					catch (ParseException exc){
						giveWarning(INCORRECT_INPUT);
					}

					
				}
				
			}
		});
		btnEqual.setPreferredSize(new Dimension(108, 38));
		btnEqual.setMinimumSize(new Dimension(52, 38));
		btnEqual.setMaximumSize(new Dimension(52, 38));
		panel.add(btnEqual);
		
		textC = new JTextField();
		textC.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				textC.setText(null);
			}
		});
		textC.setBackground(Color.WHITE);
		textC.setEditable(false);
		textC.setBounds(10, 52, 131, 20);
		frame.getContentPane().add(textC);
		textC.setColumns(10);
	}
}
