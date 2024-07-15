package main.java.com.ulisses.chess.pieces;

import java.awt.Graphics2D;

import main.java.com.ulisses.chess.bord.Board;

public abstract class Piece {
	protected int x,y;
	protected Color color;
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Color getColor() {
		return color;
	}
	
	public abstract boolean isValidMove(int newX, int newY,Board board);
	
	public abstract void draw(Graphics2D g2d, int tileSize);

	public Piece(int x, int y, Color color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}
}
