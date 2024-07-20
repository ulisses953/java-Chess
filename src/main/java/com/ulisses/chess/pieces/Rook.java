package main.java.com.ulisses.chess.pieces;

import java.util.Iterator;

import main.java.com.ulisses.chess.bord.Board;
import main.java.com.ulisses.chess.utils.Color;

public class Rook extends Piece {

	public Rook(int x, int y, Color color) {
		super(x, y, color, (color == Color.black)?"chess/rook1.png":"chess/rook.png");
		
	}

	@Override
	public boolean isValidMove(int newX, int newY, Board board) {
		//inicia em 0,0 e 0,7 para preto
		//inicia em 7,0 e 7,7 para preto
		
		if(x==newX || y == newY) {
			int maxX = Math.max(x, newX);
			int minX = Math.min(x, newX);
			
			int maxY = Math.max(y, newY);
			int minY = Math.min(y, newY);
			
			 if (y != newY) {
	                for (int i = minY + 1; i < maxY; i++) {
	                    if (board.getPiece(newX, i) != null) {
	                        return false;
	                    }
	                }
	            }

	            // Verificar movimento vertical
	            if (x == newX) {
	                for (int i = minX + 1; i < maxX; i++) {
	                    if (board.getPiece(i, newY) != null) {
	                        return false;
	                    }
	                }
	            }
			
            Piece targetPiece = board.getPiece(newX, newY);
			if (targetPiece == null || targetPiece.color != this.color) {
				return true;
			}
		}
		
		
		return false;
	}

}
