package main.java.com.ulisses.chess.pieces;

import main.java.com.ulisses.chess.bord.Board;
import main.java.com.ulisses.chess.utils.Color;

public class King extends Piece{

	public King(int x, int y, Color color) {
		super(x, y, color, (color == Color.black)?"chess/king1.png":"chess/king.png");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isValidMove(int newX, int newY, Board board) {
		
		if (x+1 == newX || x-1 == newX ||y+1 == newY||y-1==newY) {
            Piece targetPiece = board.getPiece(newX, newY);
            if (targetPiece == null ||(targetPiece != null &&  targetPiece.getColor() !=this.color)) {
            	return true;
			}
			
		}
		return false;
	}

}
