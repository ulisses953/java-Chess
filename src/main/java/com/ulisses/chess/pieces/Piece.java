package main.java.com.ulisses.chess.pieces;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import javax.imageio.ImageIO;

import main.java.com.ulisses.chess.bord.Board;
import main.java.com.ulisses.chess.utils.Color;

public abstract class Piece {
	protected int x,y;
	protected Color color;
	protected BufferedImage image;

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Color getColor() {
		return color;
	}

	protected void loadImage(String path) {
		  try {
			  //String path2 = this.getClass().getResource("../../../resorce/").getPath();

	            image = ImageIO.read(new File("./resorce/"+path));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}

	public abstract boolean isValidMove(int newX, int newY,Board board);

	  public void draw(Graphics2D g2d, int tileSize) {
	        int drawX = this.x * tileSize;
	        int drawY = this.y * tileSize;
	        g2d.drawImage(image, drawX, drawY, tileSize, tileSize, null);
	    }

	public Piece(int x, int y, Color color,String imagePath) {
		this.x = x;
		this.y = y;
		this.color = color;
        loadImage(imagePath);
	}
	public Piece(String imagePath) {
		loadImage(imagePath);
	}

	@Override
	public String toString() {
		return "Piece [x=" + x + ", y=" + y + ", color=" + color + "]";
	}
}
