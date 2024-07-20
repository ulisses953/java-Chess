package main.java.com.ulisses.chess.pieces;

import main.java.com.ulisses.chess.bord.Board;
import main.java.com.ulisses.chess.utils.Color;

public class Queen extends Piece{

	public Queen(int x, int y, Color color) {
		super(x, y, color, (color == Color.black)?"chess/queen1.png":"chess/queen.png");
	}

	@Override
	public boolean isValidMove(int newX, int newY, Board board) {
		   int deltaX = Math.abs(newX - x);
	        int deltaY = Math.abs(newY - y);

	        // Verificar se o movimento é em linha reta ou diagonal
	        if (deltaX == deltaY || newX == x || newY == y) {
	            int stepX = newX == x ? 0 : (newX - x) / deltaX;
	            int stepY = newY == y ? 0 : (newY - y) / deltaY;

	            // Verificar se o caminho está livre
	            int steps = Math.max(deltaX, deltaY);
	            for (int i = 1; i < steps; i++) {
	                int checkX = x + i * stepX;
	                int checkY = y + i * stepY;
	                if (board.getPiece(checkX, checkY) != null) {
	                    return false;
	                }
	            }

	            Piece targetPiece = board.getPiece(newX, newY);
	            // Verificar se a casa de destino está vazia ou tem uma peça de cor diferente
	            if (targetPiece == null || targetPiece.getColor() != this.getColor()) {
	                return true;
	            }
	        }
	        return false;
		
	}

}
