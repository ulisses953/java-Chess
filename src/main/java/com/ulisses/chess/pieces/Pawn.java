package main.java.com.ulisses.chess.pieces;

import java.awt.Graphics2D;

import main.java.com.ulisses.chess.bord.Board;

public class Pawn extends Piece{

	public Pawn(int x, int y, Color color) {
		super(x, y, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isValidMove(int newX, int newY, Board board) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void draw(Graphics2D g2d, int tileSize) {
		int drawX = this.x * tileSize;
		int drawy = this.y * tileSize;
		
		if (this.color == Color.black) {
			g2d.setColor(java.awt.Color.black);
		}else {
			g2d.setColor(java.awt.Color.white);
		}
		
		g2d.fillOval(drawX, drawy, tileSize, tileSize);
		
	}

}
