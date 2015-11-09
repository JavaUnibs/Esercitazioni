package it.unibs.pajc.game;

import it.unibs.pajc.game.Checkers.Piece;
import it.unibs.pajc.game.Checkers.Piece.MoveAndEat;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.Timer;

public class GameBoard extends JComponent 
	implements MouseMotionListener, MouseListener
{

	int nrepeat = 0;
	Point pos = null;
	Point pieceFinalPosOnBoard = null;
	String selectedPieceId = null;
	Image pieceImgBlack;
	Image pieceImgWhite;
	Checkers game;
	
	public GameBoard() {
		super();
		addMouseMotionListener(this);
		addMouseListener(this);
		
		game = new Checkers(8);
		
		try {
			pieceImgBlack = ImageIO.read(new File("resources/piece_black.png"));
			pieceImgWhite = ImageIO.read(new File("resources/piece_white.png"));
		} catch(IOException ex) {
			System.err.print(ex);
		}
	}
	
	int cellSize;
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		
		cellSize = getBoardCellSize();
		paintBoard(g);
		paintPieces(g);
		paintSelectedCell(g, pos);
		
		g.drawString(String.format("\n%d", nrepeat++), 
				0, g.getClipBounds().height);		
	}
	
	void paintPieces(Graphics g) {
		if(selectedPieceId != null) {
			Piece selectedPiece = game.getPiece(selectedPieceId); 
			fillCell(g, selectedPiece.position, Color.red);
			
			for(MoveAndEat m: selectedPiece.validMoves())
				fillCell(g, m.position, Color.yellow);
		}
		
		for(Checkers.Piece p: game.listPieces())
			paintPiece(g, p);
	}
	
	void fillCell(Graphics g, Point boardPos, Color color) {
		g.setColor(color);
		Point p = boardToScreen(boardPos);
		g.fillRect(p.x, p.y, cellSize, cellSize);
	}
	
	void paintPiece(Graphics g, Checkers.Piece piece) {
		Point p = boardToScreen(piece.position);
		
		if(piece.color == Checkers.Color.BLACK)
			g.drawImage(pieceImgBlack, p.x, p.y, cellSize, cellSize, null);
		else
			g.drawImage(pieceImgWhite, p.x, p.y, cellSize, cellSize, null);
		
//		System.out.printf("\n%s", piece.id);
	}
	
	Point boardToScreen(Point bc) {
		return new Point((int)(bc.x * cellSize), (int)(bc.y * cellSize));
	}

	Point screenToBoard(Point sc) {
		return new Point((int)(sc.x / cellSize), (int)(sc.y / cellSize));
	}

	
	private void paintSelectedCell(Graphics g, Point cursor) {
		if(cursor == null)
			return;
		
		g.setColor(Color.red);
		int i = ((int)(cursor.x / cellSize));
		int j = ((int)(cursor.y / cellSize));
		int x = i * cellSize;
		int y = j * cellSize;
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(3));
		
		g.drawRect(x, y, cellSize, cellSize);
	}

	private void paintBoard(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0,  0,  cellSize*8, cellSize*8);
		g.setColor(Color.lightGray);
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				if((i+j) % 2 != 0) {
					int x = i * cellSize;
					int y = j * cellSize;
					g.fillRect(x, y, cellSize, cellSize);
				}
			}
		}
	}

	private int getBoardCellSize() {
		return (getHeight() < getWidth()) ? getHeight() / 8 :
			getWidth() / 8;
	}

	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void mouseMoved(MouseEvent e) {
		pos = e.getPoint();
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Point boardPos = screenToBoard(e.getPoint());
		if(selectedPieceId == null) { 
			Piece selectedPiece = game.getPieceAtPos(boardPos);
			selectedPieceId = selectedPiece != null ? game.getPieceAtPos(boardPos).id : null;
		} else {
			game.move(selectedPieceId, boardPos.x, boardPos.y);
			selectedPieceId = null;
		}
		repaint();
		
//		if(pieceFinalPosOnBoard == null) {
//			pieceFinalPosOnBoard = screenToBoard(e.getPoint());
//			
//			repaint();
//			new Timer(100, this::movePiece).start();
//		}
	}
	
	void movePiece(ActionEvent e) {
//		int dx = (int) Math.signum(pieceFinalPosOnBoard.x - piecePosOnBoard.x);
//		int dy = (int) Math.signum(pieceFinalPosOnBoard.y - piecePosOnBoard.y);
//		piecePosOnBoard.x += dx;
//		piecePosOnBoard.y += dy;
//		repaint();
//		
//		if(piecePosOnBoard.equals(pieceFinalPosOnBoard)) {
//			((Timer)e.getSource()).stop();
//			pieceFinalPosOnBoard = null;
//		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}














