import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.util.*;

public class MainMenuController {
	 public MainMenu mainMenu;
	 public GameBoardController boardControl;
	 public GameBoard gameBoard;

	public MainMenuController(MainMenu mainMenu, GameBoardController boardControl, GameBoard gameBoard) {
		this.mainMenu = mainMenu;
		this.boardControl = boardControl;
		this.gameBoard = gameBoard;
		
		//Add listener to view 
		mainMenu.btnStart.addActionListener(new StartActionListener(mainMenu, boardControl,gameBoard));	
		mainMenu.btnInstruction.addActionListener(new InstructionActionListener());
		mainMenu.btnLoadGame.addActionListener(new LoadActionListener());
		mainMenu.btnExitGame.addActionListener(new TerminateActionListener());
	}
}

	class StartActionListener implements ActionListener{
		 
		 MainMenu mainMenu;
		 GameMenu gameMenu;
		 GameMenuController controller;
		 GameBoardController boardControl;
		 GameBoard gameBoard;
		 
		 StartActionListener(MainMenu mainMenu, GameBoardController boardControl, GameBoard gameBoard){
			 this.mainMenu = mainMenu;
			 this.boardControl = boardControl;
			 this.gameBoard = gameBoard;
		 }
		public void actionPerformed(ActionEvent e) {
	
			gameMenu = new GameMenu();
			controller = new GameMenuController(gameMenu,gameBoard);
			mainMenu.getContentPane().removeAll();
			/*
			 //add board here//
			mainMenu.getContentPane().add();
			*/
			mainMenu.getContentPane().repaint();
			mainMenu.getContentPane().revalidate();
			mainMenu.setJMenuBar(gameMenu);
			mainMenu.add(boardControl.getBoardView());
		}
	}
	
	
	class LoadActionListener implements ActionListener{
		GameBoard gbm = new GameBoard();
		public void actionPerformed(ActionEvent e) {
			try {
			File file = new File("saveFile.txt");
	        Scanner scan = new Scanner(file);
	        scan.skip("Piece name: SUN = SUN, CHEVRON = CHV, TRIANGLE = TRI, PLUS = PLS, ARROW = ARR\n"+ 
			    	  "Color: R for Red, B for Blue\n" + "Piece Name + Color\n\n" + "***Null means there is no chess piece on that spot***\n");
	    	
	        for(int y = 0; y < 8; y++){
	    		  for(int x = 0; x < 7; x++){
	    			  
	    			scan.next();
	    		  } 
			}
			}
			catch(Exception ex){
				System.out.println("Error.");
			}
		}
	}
	class TerminateActionListener implements ActionListener{
		 
		public void actionPerformed(ActionEvent e) {
	
			int dialogButton = JOptionPane.showConfirmDialog (null, "Are you sure want to exit?","WARNING",JOptionPane.YES_NO_OPTION);
			if(dialogButton == JOptionPane.YES_OPTION) {
			System.exit(0);
			}
			else {
			}
		}
	}

