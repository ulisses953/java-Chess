package main.java.com.ulisses.chess.bord;

import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.util.Iterator;

import main.java.com.ulisses.chess.pieces.Bishop;
import main.java.com.ulisses.chess.pieces.King;
import main.java.com.ulisses.chess.pieces.Pawn;
import main.java.com.ulisses.chess.pieces.Piece;
import main.java.com.ulisses.chess.pieces.Queen;
import main.java.com.ulisses.chess.pieces.Rook;
import main.java.com.ulisses.chess.utils.Color;
import main.java.com.ulisses.chess.pieces.Knight;

public class Board {
	private Piece[][] board;

	public Board() {
		board = new Piece[8][8];
		setupPieces();
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

        board[3][0] = new Queen(3, 0,main.java.com.ulisses.chess.utils.Color.black);
        board[3][7] = new Queen(3, 7,main.java.com.ulisses.chess.utils.Color.white);
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

        if (piece != null && piece.isValidMove(endX, endY, this)) {
            board[endX][endY] = piece;
            board[startX][startY] = null;

            piece.setX(endX);
            piece.setY(endY);


            return true;
        }
        return false;
    }

    public King findByKing(Color color) {
    	for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] instanceof King && board[i][j].getColor() == color) {
					return (King)board[i][j];
				}
			}
		}
    	return null;
    }

    public boolean isInCheck(Color color) {
    	King king = findByKing(color);

    	if (king == null) {
			return false;
		}

    	for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				Piece piece = board[i][j];
				if (piece != null && piece.getColor() != color && piece.isValidMove(king.getX(), king.getY(), this)) {
					return true;
				}
			}

		}
    	return false;
    }
    /**
     * Esse método é responsável por verificar se o rei esta em check mate
     * @param color cor do rei que deseja verificar
     * @return
     */

    public boolean isInCheckMate(Color color) {
    	if (!isInCheck(color)) {
			return false;
		}

    	for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				Piece piece = board[i][j];
				if (piece != null && piece.getColor() == color) {
					for (int x = 0; x < board.length; x++) {
						for (int y = 0; y < board.length; y++) {
							if (piece.isValidMove(x, y, this)) {
								Piece originalPiece = board[x][y];
								board[x][y] = piece;
								board[x][y] = piece;

								if (!isInCheck(color)) {
								    board[i][j] = piece;
								    board[x][y] = originalPiece;
								    return false;
								}

								board[i][j] = piece;
	                            board[x][y] = originalPiece;
							}
						}
					}
				}
			}
		}
        return true;
    }

}
