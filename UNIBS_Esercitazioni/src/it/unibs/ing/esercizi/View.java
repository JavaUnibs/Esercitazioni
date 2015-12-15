package it.unibs.ing.esercizi;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;
import javax.swing.Timer;

public class View extends JComponent{
	
	float r=0;
	
	
	
	public View(){
		new Timer(5, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				r+=0.1f;
			    repaint();
			   
			}
		}).start();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponents(g);
		Graphics2D g2= (Graphics2D)g;
		Dimension sz=  this.getSize();
		AffineTransform f= g2.getTransform();
		f.rotate(r);
		double s = Math.min(sz.width, sz.height)/1000.;
		g2.scale(s, -s); //le y si ribaltano usando s negativo
		g2.translate(500, -500);
		g2.setColor(Color.BLACK);
		g2.fillRect(-500, -500, 1000, 1000);
		g2.setColor(Color.WHITE);
		Shape triangolo= new Area(new Polygon(
				new int[] {-30, 30, -30},
				new int[] {15, 0, -15},

					3));
		g2.draw(f.createTransformedShape(triangolo));
		
		
	}

}
