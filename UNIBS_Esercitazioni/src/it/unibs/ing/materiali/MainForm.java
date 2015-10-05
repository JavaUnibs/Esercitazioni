package it.unibs.ing.materiali;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.BoxLayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;



/***
 * L'esempio mostra l'utilizzo base di alcuni componenti della GUI Java
 * 
 * Assignment base: 
 * Completare ed estendere l'esempio, in particolare:
 * 1. nel combobox dei colori far comparire etichette esplicative (rosso, verde, ...)
 * 2. utilizzare il model per gestire il colore attualmente selezionato
 * 
 * Assignment avanzati:
 * 3. al cambio del colore nel model procedere con l'aggiornamento dell'interfaccia (utilizzo degli eventi)
 * 4. introdurre un pattern MVC completo per la gestione dell'applicazione
 */

public class MainForm {

	private JFrame frame;
	private JTextField txtInput;
	private JTextArea txtLog;
	private JScrollPane scrollPane;
	private JLabel lblTitle;
	private JSlider slider;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm window = new MainForm();
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
	public MainForm() {
		initialize();
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 640, 657);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		lblTitle = new JLabel("bla bla bla...");
		lblTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		panel.add(lblTitle, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.SOUTH);
		
		comboBox = new JComboBox();
		
		NewModel myModel = new NewModel(
				new ColorName[] { new ColorName("Nero", Color.black), new ColorName("Blue", Color.blue), 
						new ColorName("Rosso",  Color.red), new ColorName("Verde",  Color.green), new ColorName("Rosa", Color.pink)});
		
		comboBox.setModel(myModel);
		
		
		panel_1.add(comboBox);
		
		slider = new JSlider();
		slider.setValue(14);
		slider.setMinimum(14);
		slider.setMaximum(72);
		panel_1.add(slider);
		
		txtInput = new JTextField();
		panel_1.add(txtInput);
		txtInput.setColumns(10);
		
		JButton btnGo = new JButton("go!");
		panel_1.add(btnGo);
		panel_1.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtInput, btnGo}));
		
		scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		txtLog = new JTextArea();
		txtLog.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		scrollPane.setViewportView(txtLog);
		frame.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtInput, btnGo, txtLog, frame.getContentPane(), panel, lblTitle, panel_1, scrollPane}));
		
		
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateLog(txtInput.getText());
			}
		});
		
		
		txtInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateLog(txtInput.getText());
			}
		});
		
		txtInput.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				updateLog("focus Lost");
			}
		});


		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				//updateLog(String.format("Slider: %d", slider.getValue()));
				txtLog.setFont(new Font("Lucida Grande", Font.PLAIN, slider.getValue()));
			}
		});

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateLog(String.format("Colore selezionato: %s", 
						myModel.getSelectedItem().toString()));
				
				//Color[] colors = {Color.black, Color.blue, 
				//		Color.green, Color.red };
				
				//txtLog.setForeground(colors[comboBox.getSelectedIndex()]);
				
				txtLog.setForeground(myModel.getSelectedItem().getColor());
				
				//myModel.setCurrentColor((Color)comboBox.getSelectedItem());
			}
		});
		
	}
	
	private void updateLog(String text) {
		lblTitle.setText(text);
		txtLog.append(String.format("%4d - %s\n", txtLog.getLineCount(), text));
		txtInput.selectAll();
	}
}
