/**
 * @author Liew Kuan Yung
 * @ID 1191301064
 */


import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
public class GameBoardView extends JPanel {
	
	private GameBoardButton[][] btn = new GameBoardButton[8][7];
	private JPanel gameView = new JPanel(new BorderLayout());
	private JPanel gameBoard = new JPanel(new GridLayout(8,7));
	private JPanel sideBar = new JPanel(new BorderLayout());
	private JPanel undoPanel = new JPanel(new BorderLayout());
	private JButton currentPlayer;
	private JButton undoButton;
	
	GameBoardView(){
		
		this.setBackground(new Color(250, 240, 230));
		initGameBoard();
		initSideBar();
		this.add(gameView);
	}	
	
	//Initialize game board buttons
	private void initGameBoard() {
		
		/**
		 * Coordinate of the JButton
		 * XY XY XY . . XY
		 * 00 10 20 . . 60
		 * 01
		 * 02
		 * .
		 * .
		 * 07
		 */
		gameBoard.setPreferredSize(new Dimension(550,550));
		for (int i=0; i < btn.length; i++) { //Row //Y axis
		    for (int j=0; j < btn[i].length; j++) { //Column //X axis
		    	btn[i][j] = new GameBoardButton(j, i ); //button( X Y )
		        btn[i][j].setBackground(Color.WHITE);
		        btn[i][j].setPreferredSize(new Dimension(50, 50));
		        gameBoard.setBackground(Color.darkGray);
		        gameBoard.add(btn[i][j]);
		    }
        }
		gameView.add(gameBoard, BorderLayout.CENTER);
	}
	
	// initialize side bar at the right
	private void initSideBar() {
		
		currentPlayer = new JButton();
		currentPlayer.setPreferredSize(new Dimension(100,400));
		currentPlayer.setBackground(Color.WHITE);
		
		undoButton = new JButton();
		undoButton.setPreferredSize(new Dimension(70,80));
		undoButton.setBackground(Color.green);
		undoButton.setText("UNDO");
		undoPanel.setPreferredSize(new Dimension(120,150));
		undoPanel.setBackground(Color.darkGray);
		undoPanel.add(undoButton, BorderLayout.CENTER);

		sideBar.setPreferredSize(new Dimension(120,550));
		sideBar.setBackground(Color.darkGray);
		sideBar.add(currentPlayer, BorderLayout.PAGE_END);
		sideBar.add(undoPanel, BorderLayout.PAGE_START);
		gameView.add(sideBar, BorderLayout.LINE_END);
		
		currentPlayer.setText("Red Start");
		currentPlayer.setForeground(Color.white);
		currentPlayer.setBackground(new Color(255, 102, 102));;
	}
	
	public void changeSideBar(int totalMoveCount, GameStatus status) {
		
		if((totalMoveCount) % 2 == 0) { //Current player is blue
			if(status != GameStatus.ACTIVE) {
				currentPlayer.setText("!Blue Lost!");
				currentPlayer.setForeground(Color.white);
				currentPlayer.setBackground(new Color(100, 204, 255));
			} else {
				currentPlayer.setText("Blue To Move");
				currentPlayer.setForeground(Color.white);
				currentPlayer.setBackground(new Color(100, 204, 255));
			}
		} else { //Current player is red
			if(status != GameStatus.ACTIVE) {
				currentPlayer.setText("!Red Lost!");
				currentPlayer.setForeground(Color.white);
				currentPlayer.setBackground(new Color(255, 102, 102));
			} else {
				currentPlayer.setText("Red To Move");
				currentPlayer.setForeground(Color.white);
				currentPlayer.setBackground(new Color(255, 102, 102));
			}
		}
		
	}
	
	//Add listener to all game board buttons
	void addBoardListener(ActionListener listenClickedBtn) {
		for (int i=0; i < btn.length; i++) {
		    for (int j=0; j < btn[i].length; j++) {
		    	btn[i][j].addActionListener(listenClickedBtn);
		    }
		}
		
		undoButton.addActionListener(listenClickedBtn);
	}
	
	public JButton getUndoButton() {
		return undoButton;
	}
	
	
	//first click
	public void showButtonColor(int x, int y, String color) {
		if(color == "R") {
			btn[y][x].setBackground(new Color(255, 255, 100));
		} else if (color == "B") {
			btn[y][x].setBackground(new Color(150, 240, 230));
		}
	}
	
	//second click
	public void clearButtonColor() {
		for (int i=0; i < btn.length; i++) {
		    for (int j=0; j < btn[i].length; j++) {
		    	btn[i][j].setBackground(Color.white);
		    }
		}
	}
	
	//second click
		public void testButtonColor() {
			for (int i=0; i < btn.length; i++) {
			    for (int j=0; j < btn[i].length; j++) {
			    	btn[i][j].setBackground(Color.lightGray);
			    }
			}
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
				//setArrowIcon((Arrow)p, flip);
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
	
	
	/**
	 * Specially for Arrow
	 * 
	 * Set one icon that might rotate base on direction 
	 * 
	 * if direction = true, face up or north
	 * if direction = false, face down or south
	 * Color is irrelevant, just use direction as reference
	 * if flip = false: original view (red up, blue down)
	 * if flip = true : flip the board(blue up, red down)
	 * 
	 * 4 possible scenario
	 * -------------------------------------
	 * | flip	| direction| face | Y - axis| 
	 * |--------|----------|------|---------|
	 * |	F	|	  T	   |  Up  |   Y	    | 
	 * |	F	|  	  F    | Down |   Y	    | 
	 * |	T	|	  T    | Down | 7 - Y	| 
	 * |	T	|	  F	   |  Up  | 7 - Y	| 
	 * --------------------------------------
	 * 
	 * To face up	: flip must == direction
	 * To face down	: flip or direction == true
	 */
	public void setArrowIcon(Arrow arrowPiece, boolean flip) {
		try {
			int tempy = arrowPiece.getCurrentY();
			int tempx = arrowPiece.getCurrentX();
			if(flip) {
				tempy = 7 - tempy;
				tempx = 6 - tempx;
			} 
			if ((arrowPiece.getDirection() && flip) || (!arrowPiece.getDirection() && !flip)) { //Use rotated icon (face down) if piece reaches the top
				BufferedImage originalIcon = ImageIO.read(getClass().getResource(arrowPiece.getPieceIcon()));
				BufferedImage rotatedIcon = rotate(originalIcon, 180.0);
				Image icon = rotatedIcon.getScaledInstance(50,50,Image.SCALE_SMOOTH);
				btn[tempy][tempx].setIcon(new ImageIcon(icon));
			} else if (arrowPiece.getDirection() || flip) { //Use original icon (face up) if piece reaches the bottom
				BufferedImage originalIcon = ImageIO.read(getClass().getResource(arrowPiece.getPieceIcon()));
				Image icon = originalIcon.getScaledInstance(50,50,Image.SCALE_SMOOTH);
				btn[tempy][tempx].setIcon(new ImageIcon(icon));
			}else {
				throw new Exception("Exception: rotateOneIcon");
			}
		} catch (Exception e) {
			System.out.println("Exception: Pieces Image not found in rotateOneIcon");
		}
	}
	
	/***
	 *  For the entire game board
	 * 
	 * 	 4 possible scenario
	 * ---------------------------------------------------
	 * |  flip	|  color |   view	|  model   |Direction| X - axis
	 * |		|		 | Position | Position | facing	 | 
	 * |--------|--------|----------|----------|---------|
	 * |	F	|	 R	 |   top    | bottom   |  down	 | 
	 * |	F	|  	 B   |  bottom  |	top	   |  up	 |
	 * |	T	|	 R   |  bottom  | bottom   |  up	 | inverse 
	 * |	T	|	 B	 |   top	|   top    |  down	 | inverse
	 * ---------------------------------------------------
	 * 
	 * To face up	: (!flip && B) || (Flip && R) // original image
	 * To face down	: (!flip && R) || (Flip && B) // rotate image
	 * (!flip && board[i][j].getPiece().getColor() == "R") || (flip && board[i][j].getPiece().getColor() == "B")
	 * 
	 * View position
	 * Model position R always at bottom
	 * 		if !flip : use original XY
	 * 		if flip  : use inverse X & inverse Y 
	 * Model position B always at top
	 * 		if !flip : use original XY
	 * 		if flip  : use inverse X & inverse Y
	 */
	public void displayBoard(GameBoardSpot[][] board, boolean flip) {
		try {
			clearBoardView();
			System.out.print("\n******displayBoard******\n" 
							+ " Y_" + board.length + " X_" + board[0].length + "  flip: " + flip
							+ "\n****** ********** ******\n");
			for(int i = 0; i<board.length; i++) {//Row //Y axis
				for(int j = 0; j<board[i].length; j++) {//Column //X axis
					if(board[i][j].getPiece() == null) {System.out.print("null   ");continue;}					
					int tempy = board[i][j].getPiece().getCurrentY();
					int tempx = board[i][j].getPiece().getCurrentX();
					if(flip) { 
						tempy = 7 - tempy;
						tempx = 6 - tempx;
					}
					if(board[i][j].getPiece() instanceof Arrow) {
						System.out.print(board[i][j].getPiece().getPieceInfo()+" ");
						setArrowIcon((Arrow)board[i][j].getPiece(), flip);
					} else if ( (!flip && board[i][j].getPiece().getColor() == "R") || (flip && board[i][j].getPiece().getColor() == "B") ){
						System.out.print(board[i][j].getPiece().getPieceInfo() + " ");
						BufferedImage originalIcon = ImageIO.read(getClass().getResource(board[i][j].getPiece().getPieceIcon()));
						Image icon = originalIcon.getScaledInstance(50,50,Image.SCALE_SMOOTH);
						btn[tempy][tempx].setIcon(new ImageIcon(icon));
					} else if ( (!flip && board[i][j].getPiece().getColor() == "B") || (flip && board[i][j].getPiece().getColor() == "R") ) {
						System.out.print(board[i][j].getPiece().getPieceInfo() + " ");
						BufferedImage originalIcon = ImageIO.read(getClass().getResource(board[i][j].getPiece().getPieceIcon()));
						BufferedImage rotatedIcon = rotate(originalIcon, 180.0);
						Image icon = rotatedIcon.getScaledInstance(50,50,Image.SCALE_SMOOTH);
						btn[tempy][tempx].setIcon(new ImageIcon(icon));
					}
				} System.out.print("\n");
			}System.out.println("********** **********\n" 
							  + " Display boardView "
							  + "\n********** **********\n");
		}
		catch (Exception ex) {
			System.out.println("Pieces Image not found: setPieceIcon");
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
		    for (int j=0; j < 7; j++) {
		    	btn[i][j].setIcon(null);
		    }
		}
		System.out.println("cleared all icon");
	}
	
}