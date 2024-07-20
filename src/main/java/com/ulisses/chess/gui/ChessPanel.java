package main.java.com.ulisses.chess.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import main.java.com.ulisses.chess.bord.Board;
import main.java.com.ulisses.chess.pieces.Piece;

public class ChessPanel extends JPanel{
	private Board board;
	private int tileSize;//tamanho dos quadrados
	private Piece selectedPiece;
	
	
	public ChessPanel(Board board) {
		this.board = board;
		this.tileSize = 100; 
		
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int x = e.getX()/ tileSize;
				int y = e.getY()/ tileSize;
				
				System.out.println("click : "+x+","+y);
				
				 if (selectedPiece == null) {
                    
                     selectedPiece = board.getPiece(x, y);
                   
                 } else {
                     
                     if (board.movePiece(selectedPiece.getX(), selectedPiece.getY(), x, y)) {
                         selectedPiece = null;
                         
                     }
                 }
                 repaint();
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		board.draw(g2d, tileSize);
		
		// Desenhar destaque ao redor da célula selecionada
        if (selectedPiece != null) {
            g2d.setColor(Color.RED);
            g2d.setStroke(new BasicStroke(3));
            g2d.drawRect(selectedPiece.getX() * tileSize, selectedPiece.getY()  * tileSize, tileSize, tileSize);
        }
	}
}
