package user.myutil.box;

import javax.swing.JFrame;


public class EmptyFrameViewer {
	public static void main (String[] args) {
		JFrame frame = new JFrame();

		frame.setSize(300, 400);
		frame.setTitle("Box vuoto");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setVisible(true);
		
	}
}
