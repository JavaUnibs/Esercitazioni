package it.unibs.ing.asteroids;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;

import javax.swing.JComponent;
import javax.swing.Timer;

public class SpaceView extends JComponent{
	

	public SpaceView() {
		this.setFocusable(true);
		this.requestFocusInWindow();
		
		this.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void keyPressed(KeyEvent e) {
				SpaceShip ship = space !=null ? space.ship: null;
				switch(e.getKeyCode()){
				case KeyEvent.VK_LEFT: if(ship!=null) ship.turn(0.1f); break;
				case KeyEvent.VK_RIGHT: if(ship!=null) ship.turn(-0.1f); break;
				case KeyEvent.VK_UP: if(ship!=null) ship.accelerate(1f); break;
				  //case KeyEvent.VK_N: new SpaceShip(space);
				case KeyEvent.VK_SPACE: if(ship!=null) ship.fire(); break;
		
		}
//				
				
				
			}
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		new Timer(5, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(space!=null){
					space.stepNext();
				}
			    repaint();
			    
			}
		}).start();
		

	}





	
	
	public void paintComponent(Graphics g){
		super.paintComponents(g);
		Graphics2D g2= (Graphics2D)g;
		AffineTransform old = g2.getTransform();
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
		g2.setTransform(old);
		if(space!=null){
			g2.drawString(space.toString(), 0, 10);
		}
		
		

		
	}
	
	BattleField space= new BattleField();
	private void drawSpace(Graphics2D g2){
		if(space!=null){
			for(SpaceObject o: space.objects)
			g2.draw(o.getShape());

		}
	}

	 
		
	   

}
