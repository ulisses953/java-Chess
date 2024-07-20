package main.java.com.ulisses.chess.pieces;

import main.java.com.ulisses.chess.bord.Board;
import main.java.com.ulisses.chess.utils.Color;

public class Bishop extends Piece{

	public Bishop(int x, int y, Color color) {
		super(x, y, color,(color == Color.black)?"chess/bishop1.png":"chess/bishop.png");
	}

	@Override
	public boolean isValidMove(int newX, int newY, Board board) {
		int deltaX = Math.abs(newX - x);
        int deltaY = Math.abs(newY - y);

        // Verificar se o movimento é diagonal
        if (deltaX == deltaY) {
            int stepX = (newX - x) / deltaX;
            int stepY = (newY - y) / deltaY;

            // Verificar se o caminho está livre
            for (int i = 1; i < deltaX; i++) {
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
        return false; // Movimento inválido
	}

}
