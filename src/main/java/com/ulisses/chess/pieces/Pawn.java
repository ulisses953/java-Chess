package main.java.com.ulisses.chess.pieces;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import main.java.com.ulisses.chess.bord.Board;
import main.java.com.ulisses.chess.utils.Color;

public class Pawn extends Piece{
	

	public Pawn(int x, int y, Color color) {
		super(x, y, color, (color == Color.black)?"chess/pawn1.png":"chess/pawn.png");
	}

	@Override
	public boolean isValidMove(int newX, int newY, Board board) {
		int direction = (color == Color.black) ? 1 : -1;  // Brancos movem-se para cima (-1), pretos movem-se para baixo (+1)
        int startRow = (color == Color.black) ? 1 : 6;    // Posição inicial dos peões brancos e pretos

        // Movimento normal (uma casa para frente)
        if (newX == x && newY == y + direction && board.getPiece(newX, newY) == null) {
        	System.out.println("Movimeto valido");

            return true;
        }

        // Movimento inicial (duas casas para frente)
        if (newX == x && newY == y + 2 * direction && y == startRow &&
            board.getPiece(newX, newY) == null && board.getPiece(newX, y + direction) == null) {
        	System.out.println("Movimeto valido");

            return true;
        }

       // Captura (uma casa na diagonal)
        if ((newX == x - 1 || newX == x + 1) && newY == y + direction) {
            Piece targetPiece = board.getPiece(newX, newY);
            if (targetPiece != null && targetPiece.getColor() != this.getColor()) {
            	System.out.println("Movimeto valido");
                return true;
            }
        }
    	System.out.println("Movimeto Invalido");

        return false;  // Movimento inválido
	}

}
