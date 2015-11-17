package it.unibs.ing.asteroids;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;

import javax.swing.JComponent;
import javax.swing.Timer;

public class SpaceView extends JComponent {
	

	public SpaceView() {
		new Timer(30, new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				r+=0.1f;
			    repaint();
				
			}
		}).start();
		

	}

	float r=0;





	
	
	public void paintComponent(Graphics g){
		super.paintComponents(g);
		Graphics2D g2= (Graphics2D)g;

		AffineTransform af = new AffineTransform();
		Dimension sz=  this.getSize();
		double s = Math.min(sz.width, sz.height)/1000.;
		g2.scale(s, -s); //le y si ribaltano usando s negativo
		g2.translate(500, -500); //
		
		g2.setColor(Color.BLACK);
		g2.fillRect(-500, -500, 1000, 1000);
		
		g2.setColor(Color.WHITE);
//		g2.drawLine(-500, 0, 500, 0);
//		g2.drawLine(0, 500, 0, -500);
//		
//		g2.setColor(Color.RED);
//		Rectangle rect= new Rectangle(-50, -50, 100, 100);
//		//g2.draw(rect);
//
//		af.rotate(r);
//		g2.setColor(Color.GREEN);
//		g2.draw(af.createTransformedShape(rect));
		drawSpace(g2);
		
		
	
		
	}
	
	SpaceShip ship = new SpaceShip();
	private void drawSpace(Graphics2D g2){
		if(ship!=null){
			g2.draw(ship.shape);
		}
	}
	 
		
	   

}
