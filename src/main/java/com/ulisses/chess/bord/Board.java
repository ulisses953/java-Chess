package main.java.com.ulisses.chess.bord;

import java.awt.Graphics2D;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import main.java.com.ulisses.chess.pieces.Bishop;
import main.java.com.ulisses.chess.pieces.King;
import main.java.com.ulisses.chess.pieces.Pawn;
import main.java.com.ulisses.chess.pieces.Piece;
import main.java.com.ulisses.chess.pieces.Queen;
import main.java.com.ulisses.chess.pieces.Rook;
import main.java.com.ulisses.chess.utils.Color;
import main.java.com.ulisses.chess.pieces.Knight;

public class Board {
	private static final Logger logger = Logger.getLogger(Board.class.getName());
	private Piece[][] board;
	public Color currentPlayer = Color.white;

	public Board() {
		board = new Piece[8][8];
		setupPieces();
	}

	private void switchPlayer() {
		currentPlayer = (currentPlayer == Color.white) ? Color.black : Color.white;
	}

	private void setupPieces() {
		for (int i = 0; i <= 7; i++) {
			board[i][1] = new Pawn(i, 1, main.java.com.ulisses.chess.utils.Color.black);
		}

		for (int i = 0; i <= 7; i++) {
			board[i][6] = new Pawn(i, 6, main.java.com.ulisses.chess.utils.Color.white);
		}

		board[0][0] = new Rook(0, 0, main.java.com.ulisses.chess.utils.Color.black);
		board[7][0] = new Rook(7, 0, main.java.com.ulisses.chess.utils.Color.black);

		board[7][7] = new Rook(7, 7, main.java.com.ulisses.chess.utils.Color.white);
		board[0][7] = new Rook(0, 7, main.java.com.ulisses.chess.utils.Color.white);

		board[4][0] = new King(4, 0, main.java.com.ulisses.chess.utils.Color.black);
		board[4][7] = new King(4, 7, main.java.com.ulisses.chess.utils.Color.white);

		board[1][0] = new Knight(1, 0, main.java.com.ulisses.chess.utils.Color.black);
		board[6][0] = new Knight(6, 0, main.java.com.ulisses.chess.utils.Color.black);
		board[1][7] = new Knight(1, 7, main.java.com.ulisses.chess.utils.Color.white);
		board[6][7] = new Knight(6, 7, main.java.com.ulisses.chess.utils.Color.white);

		board[2][0] = new Bishop(2, 0, main.java.com.ulisses.chess.utils.Color.black);
		board[5][0] = new Bishop(5, 0, main.java.com.ulisses.chess.utils.Color.black);
		board[2][7] = new Bishop(2, 7, main.java.com.ulisses.chess.utils.Color.white);
		board[5][7] = new Bishop(5, 7, main.java.com.ulisses.chess.utils.Color.white);

		board[3][0] = new Queen(3, 0, main.java.com.ulisses.chess.utils.Color.black);
		board[3][7] = new Queen(3, 7, main.java.com.ulisses.chess.utils.Color.white);
	}

	public Piece getPiece(int x, int y) {
		return board[x][y];
	}

	public void draw(Graphics2D g2d, int tileSize) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if ((i + j) % 2 == 0) {
					g2d.setColor(java.awt.Color.WHITE);
				} else {
					g2d.setColor(java.awt.Color.GRAY);
				}
				g2d.fillRect(i * tileSize, j * tileSize, tileSize, tileSize);

				Piece piece = board[i][j];
				if (piece != null) {
					piece.draw(g2d, tileSize);
				}
			}
		}

	}

	public boolean movePiece(int startX, int startY, int endX, int endY) {

		Piece piece = board[startX][startY];

		// roque
		if (piece != null && piece instanceof King && roque((King) piece, endX, endY)) {
			logger.info("rock");
			switchPlayer();
			logger.info("roque");


			return true;
		}

		// jogada normal
		if (piece != null && piece.isValidMove(endX, endY, this) && piece.getColor() == currentPlayer) {

			board[endX][endY] = piece;
			board[startX][startY] = null;

			piece.setX(endX);
			piece.setY(endY);

			if (piece instanceof King) {
				((King)piece).hasMoved = true;
			}
			if (piece instanceof Rook) {
				((Rook)piece).hasMoved = true;
			}

			switchPlayer();
			return true;
		}
		return false;
	}

	public King findByKing(Color color) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] instanceof King && board[i][j].getColor() == color) {
					return (King) board[i][j];
				}
			}
		}
		return null;
	}

	/**
	 *
	 * @param color
	 * @return
	 */
	public boolean isInCheck(Color color) {
		King king = findByKing(color);

		if (king == null) {
			return false;
		}
		int kingX = king.getX();
		int kingY = king.getY();

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				Piece piece = board[i][j];
				if (piece != null && piece.getColor() != color && piece.isValidMove(kingX, kingY, this)) {
					logger.info(piece.toString());
					return true;
				}
			}
		}
		return false;
	}

	public boolean endGame() {
		if (findByKing(Color.black) != null || findByKing(Color.black) != null) {
			return false;
		}

		resetGame();
		return true;

	}

	public void resetGame() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = null;
			}
		}
		setupPieces();
		currentPlayer = Color.white;
	}

	public void promotePawn(Piece piece) {
		int x = piece.getX();
		int y = piece.getY();
		board[x][y] = piece;
	}

	public boolean roque(King king, int newX, int newY) {
		if (!king.validateRoque(this, newX, newY)) {
			return false;
		}
		Piece rook;

		//rock longo branco
		if (newX ==2 && newY == 7) {
			logger.info("rock longo branco");
			rook = board[0][7];
			board[newX][newY] = king;
			board[3][7] = rook;

			king.setX(newX);
			king.setY(newY);

			rook.setX(3);
			rook.setY(7);



			king.hasMoved = true;
			((Rook)rook).hasMoved = true;
			return true;
		}
		//rock curto branco
		if (newX ==6 && newY == 7) {
			logger.info("rock curto branco");
			rook = board[7][7];
			board[newX][newY] = king;
			board[5][7] = rook;

			king.setX(newX);
			king.setY(newY);

			rook.setX(5);
			rook.setY(7);

			king.hasMoved = true;
			((Rook)rook).hasMoved = true;
			return true;
		}
		//rock longo preto
		if (newX ==2 && newY == 0) {
			logger.info("rock longo preto");

			rook = board[0][0];
			board[newX][newY] = king;
			board[3][0] = rook;

			king.setX(newX);
			king.setY(newY);

			rook.setX(3);
			rook.setY(0);

			king.hasMoved = true;
			((Rook)rook).hasMoved = true;
			return true;
		}
		//rock curto preto

		if (newX ==6 && newY == 0) {
			logger.info("rock curto preto");


			rook = board[7][0];
			board[newX][newY] = king;
			board[5][0] = rook;

			king.setX(newX);
			king.setY(newY);

			rook.setX(5);
			rook.setY(0);

			king.hasMoved = true;
			((Rook)rook).hasMoved = true;
			return true;
		}


		return false;

	}
}
