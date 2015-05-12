package user.myutil.box;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;

public class RectangleComponent extends JComponent {
	public void paintComponent(Graphics g){
		// recupera il riferimento a Graphics2D
		
		Graphics2D g2 = (Graphics2D) g;
		
		//Costruisce un rettangolo e lo disegna
		Rectangle box = new Rectangle(5, 10, 20, 30);
		g2.draw(box);
		
		//sposta il rettangolo di 15 unita a dx e 25 verso il basso
		box.translate(15, 25);
		
		//disegna il rettangolo nella nuova posizione
		g2.draw(box);
		
		
	}
}
