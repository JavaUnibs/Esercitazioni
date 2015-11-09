package it.unibs.pajc.lib.calc;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.EventListenerList;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class PnlOpBase extends JComponent implements ActionListener {
	static final int BTN_SIZE = 40;
	
	FlowLayout layout; 
	
	public PnlOpBase() {
		super();
		
		layout = new FlowLayout(FlowLayout.LEFT, 5, 5);
		setLayout(layout);
		
		addOps();
			
	}

	void addButton(String name) {
		addButton(name, BTN_SIZE, BTN_SIZE);
	}
	
	void addButton(String name, int width, int height) {
		JButton btn = new JButton(name);
		btn.setPreferredSize(new Dimension(width, height));
		this.add(btn);
		btn.addActionListener(this);
	}
	
	void removeAllButtons() {
		this.removeAll();
	}

	abstract void addOps();
	
	public void actionPerformed(ActionEvent e) {
		fireActionPerformed(e);
	}
	
	// Eventi
	//protected EventListenerList linxxxxxxxxxxxxxxstenerList = new EventListenerList();
	
	public void addActionListener(ActionListener l) {
		listenerList.add(ActionListener.class, l);
	}

	public void removeActionListener(ActionListener l) {
		listenerList.remove(ActionListener.class, l);
	}
	
	protected void fireActionPerformed(ActionEvent event) {
        // Guaranteed to return a non-null array
        Object[] listeners = listenerList.getListenerList();
        ActionEvent e = null;
        // Process the listeners last to first, notifying
        // those that are interested in this event
        for (int i = listeners.length-2; i>=0; i-=2) {
            if (listeners[i]==ActionListener.class) {
                // Lazily create the event:
                if (e == null) {
                      String actionCommand = event.getActionCommand();
                      if(actionCommand == null) {
                         actionCommand = getActionCommand();
                      }
                      e = new ActionEvent(this,
                                          ActionEvent.ACTION_PERFORMED,
                                          actionCommand,
                                          event.getWhen(),
                                          event.getModifiers());
                }
                ((ActionListener)listeners[i+1]).actionPerformed(e);
            }
        }
    }

	private String getActionCommand() {
		return null;
	}

	
}












