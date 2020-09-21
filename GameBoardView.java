import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
//by Liew Kuan Yung
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
	
	//first click
	public void showButtonColor(int x, int y, String color) {
		if(color == "R") {
			btn[y][x].setBackground(new Color(255, 255, 100));
		} else if (color == "B") {
			btn[y][x].setBackground(new Color(150, 240, 230));
		}
	}
	
	public void doNotShowButtonColor(int x, int y) {
		btn[y][x].setBackground(Color.white);
	}
	
	
	//Set icon for valid move piece 
	public void setValidMoveIcon(int startX, int startY, Piece endPiece) {
		btn[startY][startX].setIcon(null);
		setOneIcon(endPiece);
	}
	
	//Set one icon
	public void setOneIcon(Piece p) {
		try {
			if(p instanceof Arrow) {
				setOneRotateIcon((Arrow)p);
			}else if (p.getColor() == "R") {
				BufferedImage originalIcon = ImageIO.read(getClass().getResource(p.getPieceIcon()));
				BufferedImage rotatedIcon = rotate(originalIcon, 180.0);
				Image icon = rotatedIcon.getScaledInstance(50,50,Image.SCALE_SMOOTH);
				btn[p.getCurrentY()][p.getCurrentX()].setIcon(new ImageIcon(icon));
				System.out.println("p is red (updated)");
			} else if (p.getColor() == "B") {
				BufferedImage originalIcon = ImageIO.read(getClass().getResource(p.getPieceIcon()));
				Image icon = originalIcon.getScaledInstance(50,50,Image.SCALE_SMOOTH);
				btn[p.getCurrentY()][p.getCurrentX()].setIcon(new ImageIcon(icon));
				System.out.println("p is blue (updated)");
			} else {
				throw new Exception("Pieces not found in setButtonIcon");
			}
		} catch (Exception e) {
			System.out.println("Pieces Image not found: setButtonIcon");
		}
	}
	
	//Set one icon that might rotate base on direction
	public void setOneRotateIcon(Arrow rotatePiece) {
		try {
			if (rotatePiece.getDirection()) { //Use original icon (face up) if piece reaches the bottom
				BufferedImage originalIcon = ImageIO.read(getClass().getResource(rotatePiece.getPieceIcon()));
				Image icon = originalIcon.getScaledInstance(50,50,Image.SCALE_SMOOTH);
				btn[rotatePiece.getCurrentY()][rotatePiece.getCurrentX()].setIcon(new ImageIcon(icon));
			} else if (!rotatePiece.getDirection()) { //Use rotated icon (face down) if piece reaches the top
				BufferedImage originalIcon = ImageIO.read(getClass().getResource(rotatePiece.getPieceIcon()));
				BufferedImage rotatedIcon = rotate(originalIcon, 180.0);
				Image icon = rotatedIcon.getScaledInstance(50,50,Image.SCALE_SMOOTH);
				btn[rotatePiece.getCurrentY()][rotatePiece.getCurrentX()].setIcon(new ImageIcon(icon));
				
			} else {
				throw new Exception("Exception: rotateOneIcon");
			}
			
			Icon originalIcon = btn[rotatePiece.getCurrentY()][rotatePiece.getCurrentX()].getIcon();
			
			System.out.println("rotated one icon");
		} catch (Exception e) {
			System.out.println("Exception: Pieces Image not found in rotateOneIcon");
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
	
	public void clearBoardView() {
		for (int i=0; i < 8; i++) {
			System.out.print(i + " ");
		    for (int j=0; j < 7; j++) {
		    	System.out.print(j);
		    	btn[i][j].setIcon(null);
		    }
		    System.out.println("end of loop");
		}

	}
	
}