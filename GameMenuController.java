import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.util.*;

public class GameMenuController {
	private GameMenu gameMenu;
	
	public GameMenuController(GameMenu gameMenu) {
		this.gameMenu = gameMenu; 
		
		//Add listener to view 
		gameMenu.i1.addActionListener(new InstructionActionListener());
		gameMenu.i2.addActionListener(new NewGameActionListener());
		gameMenu.i3.addActionListener(new SaveActionListener());
		gameMenu.i4.addActionListener(new ExitActionListener());
		gameMenu.i5.addActionListener(new DrawActionListener());
		gameMenu.i6.addActionListener(new ResignActionListener());
	}	

}

	class InstructionActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null,"Hello, Welcome to Webale Chess Game.\n\nInstruction: \n\n"
		 		+ "a. The Sun can only move one step in any direction. The game ends when the Sun is captured by the other side.\n"
				 + "b. The Chevron moves in an L shape: 2 steps in one direction then 1 step perpendicular to it. (Similar\r\n" + 
				 "to the Knight in normal chess.) It is the only piece that can skip over the other pieces.\n"
				  + "c. The Triangle can move any number of steps diagonally.\n"
				   + "d. The Plus can move any number of steps up and down, or left and right.\n"
				    + "e. The Arrow can only move 1 or 2 steps forward each time, but when it reaches the other edge of the\r\n" + 
				    "board, it turns around and heads back in the opposite direction.");
		}
	}
	
	class NewGameActionListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	    	/*
			intialize a new board
			*/
	    }
	}
	
	class SaveActionListener implements ActionListener {
		 GameBoard gbm = new GameBoard();
		    public void actionPerformed(ActionEvent e) {
		    	try {
		    	  FileWriter writer = new FileWriter("saveFile.txt");
		    	  writer.write("Piece name: SUN = SUN, CHEVRON = CHV, TRIANGLE = TRI, PLUS = PLS, ARROW = ARR\n"+ 
		    	  "Color: R for Red, B for Blue\n" + "Piece Name + Color\n\n" + "***Null means there is no chess piece on that spot***\n" );
		    	  
		    	  
		    		  for(int y = 0; y < 8; y++){
		    			  for(int x = 0; x < 7; x++){
			              if(gbm.getSpot(x,y).isEmpty()){
			                  writer.write("NULL ");
			              }
			              else{
			            	  writer.write(gbm.getSpot(x,y).getPiece().getPieceName()
			            			  + gbm.getSpot(x,y).getPiece().getColor() + " ");		             
			              }
		    		  }
		    		  // write new line
		    		  writer.write("\r\n");  
		          }		    	
		            writer.close();
		    	}
		    	catch (Exception ex) {
		    	    System.out.println("ERROR");
		    	}
		   }
	}
	
	class ExitActionListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	    		
			int dialogButton = JOptionPane.showConfirmDialog (null, "Are you sure want to exit?","WARNING",JOptionPane.YES_NO_OPTION);
			if(dialogButton == JOptionPane.YES_OPTION) {
			System.exit(0);
			}
			else {
			}
			
	    }
	}
	
	class DrawActionListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	    	int dialogButton_1 = JOptionPane.showConfirmDialog (null, "Do you want to accept the draw request?","WARNING",JOptionPane.YES_NO_OPTION);
			if(dialogButton_1 == JOptionPane.YES_OPTION) {
				int dialogButton_2 = JOptionPane.showConfirmDialog (null, "Both players have agreed that this game should be a draw.","Draw",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if(dialogButton_2 == 0) {
					int dialogButton_3 = JOptionPane.showConfirmDialog (null, "The chess match is ended. Program will now exit...","Exit",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if(dialogButton_3 == 0) {
						System.exit(0);
					}
				}
			}
	    }
	}
	
	class ResignActionListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	    	int dialogButton_1 = JOptionPane.showConfirmDialog (null, "Are you sure want to resign the game?","WARNING",JOptionPane.YES_NO_OPTION);
			if(dialogButton_1 == JOptionPane.YES_OPTION) {
				int dialogButton_2 = JOptionPane.showConfirmDialog (null, "Opponent has won the game !!!","Congratulations",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if(dialogButton_2 == 0) {
					int dialogButton_3 = JOptionPane.showConfirmDialog (null, "The chess match is ended. Program will now exit...","Exit",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if(dialogButton_3 == 0) {
						System.exit(0);
					}
				}
			}
	    }
	}


