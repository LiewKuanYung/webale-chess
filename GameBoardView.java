
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
		    	btn[i][j] = new GameBoardButton(j, i);
		        btn[i][j].setBackground(Color.WHITE);
		        btn[i][j].setPreferredSize(new Dimension(50, 50));
		        gameBoard.setBackground(Color.yellow);
		        gameBoard.add(btn[i][j]);
		    }
        }
		this.add(gameBoard);
	}
	
	//Add listener to all game board buttons
	void addBoardListener(ActionListener listenClickedBtn) {
		for (int i=0; i < btn.length; i++) {
		    for (int j=0; j < btn[i].length; j++) {
		    	btn[i][j].addActionListener(listenClickedBtn);
		    }
		}
	}
	
	public void setButtonIcon(int startX, int startY, Piece endPiece) {
		System.out.println("start setButtonIcon");
		btn[startY][startX].setIcon(null);
		System.out.println(endPiece.getColor());
		System.out.println(endPiece.getCurrentX());
		System.out.println(endPiece.getCurrentY());
		try {
			if (endPiece.getColor() == "R") {
				System.out.println("endPiece is red");
				BufferedImage originalIcon = ImageIO.read(getClass().getResource(endPiece.getPieceIcon()));
				BufferedImage rotatedIcon = rotate(originalIcon, 180.0);
				Image icon = rotatedIcon.getScaledInstance(50,50,Image.SCALE_SMOOTH);
				btn[endPiece.getCurrentY()][endPiece.getCurrentX()].setIcon(new ImageIcon(icon));
				System.out.println("endPiece is red (updated)");
			} else if (endPiece.getColor() == "B") {
				System.out.println("endPiece is blue");
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
	
	//Add icon to list of pieces
	public void setPieceIcon(ArrayList<Piece> pieceList) {
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
	public void setPieceRotatedIcon(ArrayList<Piece> pieceList) {
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