package main.java.com.ulisses.chess.gui;

import javax.swing.JFrame;

import main.java.com.ulisses.chess.bord.Board;

public class ChessGUI extends JFrame{
	private Board board;
	private ChessPanel chessPanel;
	public static final int HEIGHT = 800;
	public static final int WIDTH = 800;

	
	 public ChessGUI(){
		board = new Board();
		chessPanel = new ChessPanel(board);
		
		this.add(chessPanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(WIDTH,HEIGHT);
		this.setResizable(false);
		this.setVisible(true);
	}
	 
	
	
}
