package it.unibs.ing.Swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.lang.Double;

public class Calcolatrice {
    private double number1=0;
    private double number2=0;
    private double risultato=0;
    private boolean addedNumber1=false;
    private boolean addedNumber2=false;
    private char operator='?';
	private JFrame frame;
	private JTextField textFieldA;
	private JTextField textFieldB;
	
	private double getDouble(){
		return Double.parseDouble(textFieldB.getText());
	}

	private void addTestoA(String stringa){
		
		textFieldA.setText(textFieldA.getText().concat(stringa));
	}
	
	private void addTestoB(String stringa){
		textFieldB.setText(textFieldB.getText().concat(stringa));
	}
	
	private void clearTestoA(){
		textFieldA.setText("");
	}
	
	private void clearTestoB(){
		textFieldB.setText("0");
	}
	
	private double operazione(){
		switch(operator){
		case '+': return number1+number2;
		case '-': return number1-number2;
		case '*': return number1*number2;
		case '/': if(number2==0) {
			clearTestoA();
			clearTestoB();
		} else return number1/number2;
		}
		return 0;
	}
	
	
	private boolean checkZero(){
		if(textFieldB.getText()=="0") return true;
		return false;
	}
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calcolatrice window = new Calcolatrice();
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
	public Calcolatrice() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Calcolatrice");
		frame.setBounds(100, 100, 429, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textFieldA = new JTextField();
		textFieldA.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldA.setBounds(10, 11, 393, 37);
		frame.getContentPane().add(textFieldA);
		textFieldA.setColumns(10);
		
		textFieldB = new JTextField();
		textFieldB.setEditable(false);
		textFieldB.setText("0");
		textFieldB.setBounds(192, 59, 211, 34);
		frame.getContentPane().add(textFieldB);
		textFieldB.setColumns(10);
		
		JButton btnMc = new JButton("MC");
		btnMc.setBounds(10, 120, 48, 37);
		frame.getContentPane().add(btnMc);
		
		JButton btnMr = new JButton("MR");
		btnMr.setBounds(68, 120, 48, 37);
		frame.getContentPane().add(btnMr);
		
		JButton btnMs = new JButton("MS");
		btnMs.setBounds(126, 120, 48, 37);
		frame.getContentPane().add(btnMs);
		
		JButton btnMPlus = new JButton("M+");
		btnMPlus.setBounds(181, 120, 48, 37);
		frame.getContentPane().add(btnMPlus);
		
		JButton btnMinus = new JButton("M-");
		btnMinus.setBounds(239, 120, 48, 37);
		frame.getContentPane().add(btnMinus);
		
		JButton btnCancel = new JButton("<--");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnCancel.setBounds(297, 120, 48, 37);
		frame.getContentPane().add(btnCancel);
		
		JButton btnCe = new JButton("CE");
		btnCe.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCe.setBounds(355, 120, 48, 37);
		frame.getContentPane().add(btnCe);
		
		JButton btnC = new JButton("C");
		btnC.setBounds(10, 168, 48, 37);
		frame.getContentPane().add(btnC);
		
		JButton negate = new JButton("\u00B1");
		negate.setBounds(67, 168, 48, 37);
		frame.getContentPane().add(negate);
		
		JButton root = new JButton("\u221A");
		root.setBounds(124, 168, 48, 37);
		frame.getContentPane().add(root);
		
		JButton plus = new JButton("+");
		plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!addedNumber1) {
					addTestoA(textFieldB.getText());
					addedNumber1=true;
					operator='+';
					addTestoA("+");
				} else if(!addedNumber2){
					operator='+';
					textFieldA.setText(textFieldA.getText().substring(0, textFieldA.getText().length())+"+");
				}
				else {
					number1=operazione();
					textFieldB.setText(new Double(number1).toString());
				}
			}
		});
		plus.setBounds(181, 168, 48, 37);
		frame.getContentPane().add(plus);
		
		JButton minus = new JButton("-");
		minus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		minus.setBounds(238, 168, 48, 37);
		frame.getContentPane().add(minus);
		
		JButton multiplication = new JButton("*");
		multiplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		multiplication.setBounds(296, 168, 48, 37);
		frame.getContentPane().add(multiplication);
		
		JButton division = new JButton("/");
		division.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		division.setBounds(355, 168, 48, 37);
		frame.getContentPane().add(division);
		
		JButton one = new JButton("1");
		one.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkZero()) textFieldB.setText("1");	
				else addTestoB("1");
			}
		});
		one.setBounds(10, 216, 48, 37);
		frame.getContentPane().add(one);
		
		JButton two = new JButton("2");
		two.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkZero()) textFieldB.setText("2");	
				else addTestoB("2");
			}
		});
		two.setBounds(67, 216, 48, 37);
		frame.getContentPane().add(two);
		
		JButton three = new JButton("3");
		three.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkZero()) textFieldB.setText("3");	
				else addTestoB("3");
			}
		});
		three.setBounds(124, 216, 48, 37);
		frame.getContentPane().add(three);
		
		JButton four = new JButton("4");
		four.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkZero()) textFieldB.setText("4");	
				else addTestoB("4");
			}
		});
		four.setBounds(181, 216, 48, 37);
		frame.getContentPane().add(four);
		
		JButton five = new JButton("5");
		five.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkZero()) textFieldB.setText("5");	
				else addTestoB("5");
			}
		});
		five.setBounds(238, 216, 48, 37);
		frame.getContentPane().add(five);
		
		JButton six = new JButton("6");
		six.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkZero()) textFieldB.setText("6");	
				else addTestoB("6");
			}
		});
		six.setBounds(296, 216, 48, 37);
		frame.getContentPane().add(six);
		
		JButton seven = new JButton("7");
		seven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkZero()) textFieldB.setText("7");	
				else addTestoB("7");
			}
		});
		seven.setBounds(355, 216, 48, 37);
		frame.getContentPane().add(seven);
		
		JButton eight = new JButton("8");
		eight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkZero()) textFieldB.setText("8");	
				else addTestoB("8");
			}
		});
		eight.setBounds(10, 264, 48, 37);
		frame.getContentPane().add(eight);
		
		JButton nine = new JButton("9");
		nine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkZero()) textFieldB.setText("9");	
				else addTestoB("9");
			}
		});
		nine.setBounds(67, 264, 48, 37);
		frame.getContentPane().add(nine);
		
		JButton zero = new JButton("0");
		zero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkZero()) textFieldB.setText("0");	
				else addTestoB("0");
			}
		});
		zero.setBounds(124, 264, 48, 37);
		frame.getContentPane().add(zero);
		
		JButton dot = new JButton(",");
		dot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textFieldA.getText().contains(",")) addTestoB(",");
			}
		});
		dot.setBounds(181, 264, 48, 37);
		frame.getContentPane().add(dot);
		
		JButton equal = new JButton("=");
		equal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		equal.setBounds(239, 264, 106, 37);
		frame.getContentPane().add(equal);
		
		
	}
}
