package main.java.com.ulisses.chess.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import main.java.com.ulisses.chess.bord.Board;
import main.java.com.ulisses.chess.pieces.Bishop;
import main.java.com.ulisses.chess.pieces.Knight;
import main.java.com.ulisses.chess.pieces.Pawn;
import main.java.com.ulisses.chess.pieces.Piece;
import main.java.com.ulisses.chess.pieces.Queen;
import main.java.com.ulisses.chess.pieces.Rook;

public class ChessPanel extends JPanel {
	private static final Logger logger = Logger.getLogger(ChessPanel.class.getName());
	private Board board;
	private int tileSize;// tamanho dos quadrados
	private Piece selectedPiece;

	public ChessPanel(Board board) {
		this.board = board;
		this.tileSize = 100;

		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				handleMouseClick(e);
			}
		});
	}

	private void handleMouseClick(MouseEvent e) {
		int x = e.getX() / tileSize;
		int y = e.getY() / tileSize;

		logger.info("click : " + x + "," + y);

		if (selectedPiece == null) {
			selectPiece(x, y);
		} else {
			moveOrDeselectPiece(x, y);
		}

		repaint();
	}

	private void selectPiece(int x, int y) {
		selectedPiece = board.getPiece(x, y);

		if (selectedPiece != null && selectedPiece.getColor() != board.currentPlayer) {
			deselectPiece();
		}
	}

	private void moveOrDeselectPiece(int x, int y) {
		if (x == selectedPiece.getX() && y == selectedPiece.getY()) {
			deselectPiece();
		} else {
			if (board.movePiece(selectedPiece.getX(), selectedPiece.getY(), x, y)) {
				
				deselectPiece();
				checkGameState();
			}
		}
	}

	private void deselectPiece() {
		promotePawn();
		selectedPiece = null;
	}

	private void checkGameState() {
		SwingUtilities.invokeLater(() -> {
			if (board.endGame()) {
				JOptionPane.showMessageDialog(null, "Vitória");
			}

			if (board.isInCheck(main.java.com.ulisses.chess.utils.Color.white)) {
				JOptionPane.showMessageDialog(null, "Cheque no rei branco!");
			} else if (board.isInCheck(main.java.com.ulisses.chess.utils.Color.black)) {
				JOptionPane.showMessageDialog(null, "Cheque no rei preto!");
			}
		});

	}

	public void promotePawn() {
		if (selectedPiece != null && selectedPiece instanceof Pawn && ((Pawn) selectedPiece).validatePromote()) {
			String[] options = { "Rainha", "Torre", "Bispo", "Cavalo" };
			int choice = JOptionPane.showOptionDialog(null, "Escolha a peça para a promoção do peão:",
					"Promoção do Peão", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options,
					options[0]);
			int x = selectedPiece.getX();
			int y = selectedPiece.getY();
			main.java.com.ulisses.chess.utils.Color color = selectedPiece.getColor();

		       Piece newPiece;
	            switch (choice) {
	                case 0:
	                    newPiece = new Queen(x, y, color);
	                    break;
	                case 1:
	                    newPiece = new Rook(x, y, color);
	                    break;
	                case 2:
	                    newPiece = new Bishop(x, y, color);
	                    break;
	                case 3:
	                    newPiece = new Knight(x, y, color);
	                    break;
	                default:
	                    newPiece = new Queen(x, y, color);
	                    break;
	            }
	            board.promotePawn(newPiece);

		}

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
			g2d.drawRect(selectedPiece.getX() * tileSize, selectedPiece.getY() * tileSize, tileSize, tileSize);
		}
	}
}
