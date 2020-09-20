
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameBoardView extends JPanel {
	
	private GameBoardButton[][] btn = new GameBoardButton[8][7];
	private JPanel gameBoard = new JPanel(new GridLayout(8,7));
	
	GameBoardView(){
		
		initComponent();
	}	
	
	//Initialize game board buttons
	void initComponent() {
		
		gameBoard.setPreferredSize(new Dimension(550,550));
		for (int i=0; i < btn.length; i++) { //Row //Y axis
		    for (int j=0; j < btn[i].length; j++) { //Column //X axis
		    	btn[btn.length - 1 - i ][j] = new GameBoardButton(j, btn.length - 1 - i ); //button( X Y )
		        btn[btn.length - 1 - i ][j].setBackground(Color.WHITE);
		        btn[btn.length - 1 - i ][j].setPreferredSize(new Dimension(50, 50));
		        gameBoard.setBackground(Color.darkGray);
		        gameBoard.add(btn[btn.length - 1 - i ][j]);
		    }
        }
		this.add(gameBoard);
		this.setBackground(new Color(250, 240, 230));
	}
	
	//Add listener to all game board buttons
	void addBoardListener(ActionListener listenClickedBtn) {
		for (int i=0; i < btn.length; i++) {
		    for (int j=0; j < btn[i].length; j++) {
		    	btn[btn.length -1 -i][j].addActionListener(listenClickedBtn);
		    }
		}
	}
	
	public void setValidMoveIcon(int startX, int startY, Piece endPiece) {
		btn[startY][startX].setIcon(null);
		try {
			if (endPiece.getColor() == "R") {
				BufferedImage originalIcon = ImageIO.read(getClass().getResource(endPiece.getPieceIcon()));
				BufferedImage rotatedIcon = rotate(originalIcon, 180.0);
				Image icon = rotatedIcon.getScaledInstance(50,50,Image.SCALE_SMOOTH);
				btn[endPiece.getCurrentY()][endPiece.getCurrentX()].setIcon(new ImageIcon(icon));
				System.out.println("endPiece is red (updated)");
			} else if (endPiece.getColor() == "B") {
				BufferedImage originalIcon = ImageIO.read(getClass().getResource(endPiece.getPieceIcon()));
				Image icon = originalIcon.getScaledInstance(50,50,Image.SCALE_SMOOTH);
				btn[endPiece.getCurrentY()][endPiece.getCurrentX()].setIcon(new ImageIcon(icon));
				System.out.println("endPiece is blue (updated)");
			} else {
				throw new Exception("Pieces not found in setButtonIcon");
			}
		} catch (Exception e) {
			System.out.println("Pieces Image not found: setButtonIcon");
		}
	}
	
	public void setOneRotateIcon(Piece rotatePiece) {
		try {
			if (rotatePiece.getColor() == "R") {
				BufferedImage originalIcon = ImageIO.read(getClass().getResource(rotatePiece.getPieceIcon()));
				BufferedImage rotatedIcon = rotate(originalIcon, 180.0);
				Image icon = rotatedIcon.getScaledInstance(50,50,Image.SCALE_SMOOTH);
				btn[rotatePiece.getCurrentY()][rotatePiece.getCurrentX()].setIcon(new ImageIcon(icon));
				System.out.println("Piece is rotated to face north or up");
			} else if (rotatePiece.getColor() == "B") {
				BufferedImage originalIcon = ImageIO.read(getClass().getResource(rotatePiece.getPieceIcon()));
				Image icon = originalIcon.getScaledInstance(50,50,Image.SCALE_SMOOTH);
				btn[rotatePiece.getCurrentY()][rotatePiece.getCurrentX()].setIcon(new ImageIcon(icon));
				System.out.println("Piece is rotated to face south or down");
			} else {
				throw new Exception("Pieces not found in setButtonIcon");
			}
		} catch (Exception e) {
			System.out.println("Pieces Image not found: setButtonIcon");
		}
	}
	
	//Add icon to list of pieces
	public void setAllPiecesIcon(ArrayList<Piece> pieceList) {
		try {
			for(int i = 0; i<pieceList.size(); i++) {
				BufferedImage originalIcon = ImageIO.read(getClass().getResource(pieceList.get(i).getPieceIcon()));
				Image icon = originalIcon.getScaledInstance(50,50,Image.SCALE_SMOOTH);
				btn[pieceList.get(i).getCurrentY()][pieceList.get(i).getCurrentX()].setIcon(new ImageIcon(icon));
			}
	    }
	    catch (Exception ex) {
	    	System.out.println("Pieces Image not found: setPieceIcon");
	    }
	}
	
	//Add rotated icon to all list of pieces
	public void setAllPiecesRotatedIcon(ArrayList<Piece> pieceList) {
		try {
			for(int i = 0; i<pieceList.size(); i++) {
				BufferedImage originalIcon = ImageIO.read(getClass().getResource(pieceList.get(i).getPieceIcon()));
				BufferedImage rotatedIcon = rotate(originalIcon, 180.0);
				Image icon = rotatedIcon.getScaledInstance(50,50,Image.SCALE_SMOOTH);
				btn[pieceList.get(i).getCurrentY()][pieceList.get(i).getCurrentX()].setIcon(new ImageIcon(icon));
			}
	    }
	    catch (Exception ex) {
	    	System.out.println("Pieces Image not found: setPieceRotatedIcon");
	    }
	}
	
	
	//Rotate icon
	public BufferedImage rotate(BufferedImage image, Double degrees) {
	    // Calculate the new size of the image based on the angle of rotaion
	    double radians = Math.toRadians(degrees);
	    double sin = Math.abs(Math.sin(radians));
	    double cos = Math.abs(Math.cos(radians));
	    int newWidth = (int) Math.round(image.getWidth() * cos + image.getHeight() * sin);
	    int newHeight = (int) Math.round(image.getWidth() * sin + image.getHeight() * cos);

	    // Create a new image
	    BufferedImage rotate = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2d = rotate.createGraphics();
	    // Calculate the "anchor" point around which the image will be rotated
	    int x = (newWidth - image.getWidth()) / 2;
	    int y = (newHeight - image.getHeight()) / 2;
	    // Transform the origin point around the anchor point
	    AffineTransform at = new AffineTransform();
	    at.setToRotation(radians, x + (image.getWidth() / 2), y + (image.getHeight() / 2));
	    at.translate(x, y);
	    g2d.setTransform(at);
	    // Paint the originl image
	    g2d.drawImage(image, 0, 0, null);
	    g2d.dispose();
	    return rotate;
	}
	
}