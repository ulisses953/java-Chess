package main.java.com.ulisses.chess.pieces;

import main.java.com.ulisses.chess.bord.Board;
import main.java.com.ulisses.chess.utils.Color;

public class Bishop extends Piece{

	public Bishop(int x, int y, Color color) {
		super(x, y, color,(color == Color.black)?"chess/bishop1.png":"chess/bishop.png");
	}

	@Override
	public boolean isValidMove(int newX, int newY, Board board) {
	        int deltaX = Math.abs(newX - this.getX());
	        int deltaY = Math.abs(newY - this.getY());

	        // Verifica se o movimento é diagonal
	        if (deltaX == deltaY) {
	            int stepX = (newX > this.getX()) ? 1 : -1;
	            int stepY = (newY > this.getY()) ? 1 : -1;
	            int x = this.getX() + stepX;
	            int y = this.getY() + stepY;

	            // Verifica se o caminho está livre
	            while (x != newX && y != newY) {
	                if (board.getPiece(x, y) != null) {
	                    return false;
	                }
	                x += stepX;
	                y += stepY;
	            }

	            // Verifica se a posição final está vazia ou contém uma peça inimiga
	            Piece targetPiece = board.getPiece(newX, newY);
	            if (targetPiece == null || targetPiece.getColor() != this.getColor()) {
	                return true;
	            }
	        }

	        return false;
	}

}
