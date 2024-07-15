package main.java.com.ulisses.chess.bord;

import java.awt.Color;
import java.awt.Graphics2D;

import main.java.com.ulisses.chess.pieces.Pawn;
import main.java.com.ulisses.chess.pieces.Piece;

public class Board {
	private Piece[][] board;
	
	public Board() {
		board = new Piece[8][8];
		setupPieces();
	}
	
	private void setupPieces() {
		board[1][1] = new Pawn(2, 0, main.java.com.ulisses.chess.pieces.Color.black);
	}
	
	public Piece getPice(int x, int y) {
		return board[x][y];
	}
	
	public void draw(Graphics2D g2d, int tileSize) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    g2d.setColor(Color.WHITE);
                } else {
                    g2d.setColor(Color.GRAY);
                }
                g2d.fillRect(i * tileSize, j * tileSize, tileSize, tileSize);
                
                Piece piece = board[i][j];
                if (piece != null) {
                    piece.draw(g2d, tileSize);
                }
            }
        }
            
	}
	
	
}
