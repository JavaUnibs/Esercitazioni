package it.unibs.pajc.lib.calc;

import java.awt.DisplayMode;
import java.awt.EventQueue;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.BorderLayout;

import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.event.ChangeEvent;

public class MainFrame {

	private JFrame frame;
	private JTextField txtResult;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	// ↵ π
	public MainFrame() {
		initialize();
		
		pnlAction.removeAllButtons();
		pnlAction.addButton("CA");
		pnlAction.addButton("CL");
		//pnlAction.addButton("⬅︎");
		
		brain.addChangeListener(this::refreshOperators);
		refreshOperators(null);
	}
	
	void refreshOperators(ChangeEvent e) {
		pnlOperator.removeAllButtons();
		for(String s: brain.getKnownOps())
			pnlOperator.addButton(s);
		pnlOperator.addButton("=");
		
		pnlOperator.revalidate();
		pnlOperator.repaint();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 244, 331);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		txtResult = new JTextField();
		txtResult.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		txtResult.setText("0");
		txtResult.setHorizontalAlignment(SwingConstants.RIGHT);
		frame.getContentPane().add(txtResult, BorderLayout.NORTH);
		txtResult.setColumns(10);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		pnlKeypad = new PnlKeypad();
		pnlKeypad.setBounds(6, 51, 143, 185);
		panel.add(pnlKeypad);
		
		pnlOperator = new PnlOperator();
		pnlOperator.setBounds(141, 6, 119, 185);
		panel.add(pnlOperator);
		
		pnlAction = new PnlOperator();
		pnlAction.setBounds(6, 6, 143, 50);
		panel.add(pnlAction);
		
		JPanel pnlExtension = new JPanel();
		frame.getContentPane().add(pnlExtension, BorderLayout.SOUTH);
		
		JButton btnAddFa = new JButton("add f(a)");
		pnlExtension.add(btnAddFa);
		
		
		pnlKeypad.addActionListener(this::addDigit);
		pnlOperator.addActionListener(this::addOperation);
		pnlAction.addActionListener(this::addOperation);
		btnAddFa.addActionListener(this::createNewOperation);
	}
	
	
	boolean userIsTyping = false;
	CalcModel brain = new CalcModel();
	private PnlKeypad pnlKeypad;
	private PnlOperator pnlOperator;
	private PnlOperator pnlAction;
	
	void addDigit(ActionEvent e) {
		String dgt = e.getActionCommand();
		
		String val = userIsTyping ? txtResult.getText() + dgt :
			".".equals(dgt) ? "0." :
			dgt;
		
		try {
			Double.parseDouble(val);
			userIsTyping = true;
			txtResult.setText(val);
		} catch(Exception ex) {
			
		}
	}
	
	void addOperation(ActionEvent e) {
		String op = e.getActionCommand();
		if(userIsTyping)
			enter();
		
		Double res = brain.performOperation(op);
		setDisplayValue(res);
	}
	
	void enter() {
		setDisplayValue(userIsTyping ? 
				brain.pushOperand(getDisplayValue()) :
				brain.evaluate());
	}
	
	void setDisplayValue(Double value) {
		if(value == null) {
			txtResult.setText("ERROR");
		} else {
			double val = value;
			txtResult.setText( 
					(val == (long) val) ?
					String.format("%d", (long) val) :
					String.format("%f", val));
		}
		
		userIsTyping = false;
		dumpBrain();
	}
	
	Double getDisplayValue() {
		try {
			return Double.parseDouble(txtResult.getText());
		} catch(Exception ex) {
			return null;
		}
	}
	
	void dumpBrain(){
		System.out.println(brain.dump());
	}
	
	void createNewOperation(ActionEvent e){
		String symbol = JOptionPane.showInputDialog("Symbol");
		if(symbol == null) // ^3
			return;
		String fsrc = JOptionPane.showInputDialog("Corpo della funzione");
		
		if(fsrc == null)  // a*a*a
			return;
		
		JavaCompilerUtils jcu = JavaCompilerUtils.getInstance();
		List<String> classImports = new ArrayList<String>();
		classImports.add("it.unibs.pajc.lib.*");
		classImports.add("java.lang.*");
		List<String> classImplements = new ArrayList<String>();
		classImplements.add("UnaryOp");
		
		String className = String.format("UnaryOp$%s", System.currentTimeMillis());
		String classBody = String.format("public double eval(double a) { return %s; }", fsrc);
		
		try {
			Class newOp = jcu.createClass("it.unibs.pajc", classImports, className, 
					null, classImplements, classBody);
			
			brain.addKnownOp(symbol, (UnaryOp) newOp.newInstance());
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}






