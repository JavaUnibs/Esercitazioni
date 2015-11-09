package it.unibs.pajc.game;


import it.unibs.pajc.game.Checkers.Piece;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Checkers {	
	enum Kind { MEN, KING };
	enum Color { WHITE, BLACK };
	
	public class Piece {	
		String id;
		Point position;
		Kind kind;
		Color color;
		Piece(String id, Point position, Kind kind, Color color) {
			this.id = id;
			this.position = position;
			this.kind = kind;
			this.color = color;
		}
		
		@Override
		public String toString() {
			return String.format("%s - %d,%d [%s, %s]", id, position.x, position.y, kind, color);
		}
			
		private boolean move(Point p, boolean left, boolean up) {
			int x = p.x + (left ? -1 : +1);
			int y = p.y + (up ? -1 : +1);
			if(isValidBoardPosition(x, y)) {
				p.x = x; p.y = y;
				return true;
			}
			return false;
		}
		
		public class MoveAndEat {
			Point position;
			ArrayList<Piece> eatedPieces;
			
			MoveAndEat(Point position, ArrayList<Piece> eatedPieces) {
				this.position = (Point)position.clone();
				this.eatedPieces = (eatedPieces != null) ? (ArrayList<Piece>)eatedPieces.clone() :
					 new ArrayList<Piece>();
			}
		}
	
		public List<MoveAndEat> validMoves() {
			return validMoves(new MoveAndEat(position, null), new ArrayList<MoveAndEat>(), false);
		}
		
		public List<MoveAndEat> validMoves(MoveAndEat start, List<MoveAndEat> moves, boolean mustEat) {			
			MoveAndEat move = new MoveAndEat(start.position, start.eatedPieces);

			boolean direction = true;
			
			if(move(move.position, direction, color == Color.BLACK)) {
				Piece eat = getPieceAtPos(move.position);
				if(eat == null && !mustEat) {
					moves.add(move);
				} else if (eat != null &&
						eat.color != this.color &&
						move(move.position, direction, color == Color.BLACK) &&
						getPieceAtPos(move.position) == null) {
					move.eatedPieces.add(eat);
					moves.add(move);
					validMoves(move, moves, true);
				}
			}
					
			move = new MoveAndEat(start.position, start.eatedPieces);
			direction = false;
			
			if(move(move.position, direction, color == Color.BLACK)) {
				Piece eat = getPieceAtPos(move.position);
				if(eat == null && !mustEat) {
					moves.add(move);
				} else if (eat != null &&
						eat.color != this.color &&
						move(move.position, direction, color == Color.BLACK) &&
						getPieceAtPos(move.position) == null) {
					move.eatedPieces.add(eat);
					moves.add(move);
					validMoves(move, moves, true);
				}
			}
			
			return moves;
		}

	}
	
	HashMap<String, Checkers.Piece> pieces = new HashMap<String, Checkers.Piece>();
	
	private void addPiece(String id, int x, int y, Kind kind, Color color) {
		pieces.put(id, this.new Piece(id, new Point(x, y), kind, color));
	}
	
	private int size;
	int getSize() {
		return size;
	}

	boolean isValidBoardPosition(int x, int y) {
		return x>=0 && y>=0 && x<size && y<size;
	}
	
	public Checkers(int size) {
		this.size = size;
		int k = 0;
		for(int j=0, i=1; j<3; j++, i-=size+1)
			for(; i<size; i+=2) 
				addPiece(""+k++, i, j, Kind.MEN, Color.WHITE);
		
		for(int j=0, i=0; j<3; j++, i-=size+1)
			for(; i<size; i+=2) 
				addPiece(""+k++, i, size-j-1, Kind.MEN, Color.BLACK);
	}
	
	public Collection<Checkers.Piece> listPieces() {
		return pieces.values();
	}
	
	public boolean move(String pieceId, int x, int y) {
		Piece piece = pieces.get(pieceId);
		for(Piece.MoveAndEat move: piece.validMoves()) {
			Point p = move.position;
			if(p.x == x && p.y == y) {
				piece.position.x = x;
				piece.position.y = y;
				move.eatedPieces.forEach(ep -> {delete(ep.id);} );
				return true;
			}
		}
		
		return false;
	}
	
	public void delete(String pieceId) {
		pieces.remove(pieceId);
	}
	
	public void promote(String pieceId) {
		pieces.get(pieceId).kind = Kind.KING;
	}
	
	Piece getPieceAtPos(Point pos) {
		for(Piece p: listPieces())
			if(p.position.equals(pos))
				return p;
		return null;
	}

	Piece getPiece(String pieceId) {
		return pieces.get(pieceId);
	}
	
}
