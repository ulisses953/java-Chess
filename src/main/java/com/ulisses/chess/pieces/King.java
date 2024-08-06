package main.java.com.ulisses.chess.pieces;

import java.util.logging.Logger;

import main.java.com.ulisses.chess.bord.Board;
import main.java.com.ulisses.chess.utils.Color;

public class King extends Piece {
	private static final Logger logger = Logger.getLogger(Board.class.getName());
	public boolean hasMoved = false;




	public King(int x, int y, Color color) {
		super(x, y, color, (color == Color.black) ? "chess/king1.png" : "chess/king.png");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isValidMove(int newX, int newY, Board board) {
		// O rei pode se mover uma casa em qualquer direção
		int deltaX = Math.abs(newX - x);
		int deltaY = Math.abs(newY - y);

		// Verificar se o movimento é válido
		if ((deltaX <= 1 && deltaY <= 1) && (newX != x || newY != y)) {
			Piece targetPiece = board.getPiece(newX, newY);
			if (targetPiece == null || targetPiece.getColor() != this.getColor()) {
				return true;
			}
		}

		return false;
	}



	public boolean validateRoque(Board board, int newX, int newY) {
		Piece pice;

		if (hasMoved) {
			logger.info("nao passou no roque, pois o rei já foi movido");
			return false;
		}

		pice = board.getPiece(7, 7);

		// roque pequeno branca
		if (this.getColor() == Color.white && this.getX() + 2 == newX && newY == this.getY() && pice != null
				&& pice instanceof Rook && !((Rook) pice).hasMoved && board.getPiece(5, 7) == null
				&& board.getPiece(6, 7) == null) {
			return true;
		}

		pice = board.getPiece(7, 0);

		// roque grande branca
		if (this.getColor() == Color.white && this.getX() - 2 == newX && newY == this.getY() && pice != null
				&& pice instanceof Rook && !((Rook) pice).hasMoved && board.getPiece(3, 7) == null
				&& board.getPiece(2, 7) == null && board.getPiece(1, 7) == null) {
			return true;
		}

		// roque pequeno preta
		if (this.getColor() == Color.black && this.getX() + 2 == newX && newY == this.getY() && pice != null
				&& pice instanceof Rook && !((Rook) pice).hasMoved && board.getPiece(5, 0) == null
				&& board.getPiece(6, 0) == null) {
			return true;
		}

		pice = board.getPiece(7, 0);

		// roque grande preta
		if (this.getColor() == Color.black && this.getX() - 2 == newX && newY == this.getY() && pice != null
				&& pice instanceof Rook && !((Rook) pice).hasMoved && board.getPiece(3, 0) == null
				&& board.getPiece(2, 0) == null && board.getPiece(1, 0) == null) {
			return true;
		}

		return false;

	}

}
