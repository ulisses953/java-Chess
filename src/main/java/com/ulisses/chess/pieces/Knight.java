package main.java.com.ulisses.chess.pieces;

import main.java.com.ulisses.chess.bord.Board;
import main.java.com.ulisses.chess.utils.Color;

public class Knight extends Piece{

	public Knight(int x, int y, Color color) {
		super(x, y, color, (color == Color.black)?"chess/knight1.png":"chess/knight.png");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isValidMove(int newX, int newY, Board board) {
		if ((x+1 == newX||x-1 == newX)&&(y+2 == newY||y-2 == newY)||(x+2 == newX||x-2 == newX)&&(y+1 == newY||y-1 == newY)) {
			Piece targetPiece = board.getPiece(newX, newY);
			if (targetPiece == null ||(targetPiece != null && targetPiece.getColor() !=this.color)) {
            	return true;
			}
		}
		return false;
	}

}
