/**
 * @author Yap Mou En
 */

import java.awt.*;  
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

//Provide a controller class for MainMenu class
public class MainMenuController {
	
	 public MainMenu mainMenu;
	 public GameBoardController boardController;
	 
	 //MainMenuController constructor
	 public MainMenuController(MainMenu mainMenu, GameBoardController boardController) {
		 
		this.mainMenu = mainMenu;
		this.boardController = boardController;
		
		//Add listener to view 
		mainMenu.btnStart.addActionListener(new StartActionListener(mainMenu, boardController));	
		mainMenu.btnInstruction.addActionListener(new InstructionActionListener());
		mainMenu.btnLoadGame.addActionListener(new LoadActionListener(mainMenu, boardController));
		mainMenu.btnExitGame.addActionListener(new TerminateActionListener());
	}
}


//Provide action listener to start button
class StartActionListener implements ActionListener{

	MainMenu mainMenu;
	GameMenu gameMenu;
	GameMenuController frameController;
	GameBoardController boardController;

	StartActionListener(MainMenu mainMenu, GameBoardController boardController){
		this.mainMenu = mainMenu;
		this.boardController = boardController;
	}
	public void actionPerformed(ActionEvent e) {

		//initiate the game board and game menu
		gameMenu = new GameMenu();
		frameController = new GameMenuController(gameMenu, boardController);
		mainMenu.getContentPane().removeAll();
		mainMenu.getContentPane().repaint();
		mainMenu.getContentPane().revalidate();
		mainMenu.setJMenuBar(gameMenu);
		mainMenu.add(boardController.getBoardView());
	}
}


//Provide action listener to load game button
class LoadActionListener implements ActionListener{
	
	MainMenu mainMenu;
	GameMenu gameMenu;
	GameMenuController frameController;
	GameBoardController boardController;
	private ArrayList<String> loadPiecesList = new ArrayList<>();
	private int totalMoveCount;
	
	LoadActionListener(MainMenu mainMenu, GameBoardController boardController){
		this.mainMenu = mainMenu;
		this.boardController = boardController;
	}
	
	public void actionPerformed(ActionEvent e) {
		try {

			File file = new File("saveFile.txt");
			Scanner scan = new Scanner(file);
			
			int numberOfLines = 0;
			while(scan.hasNextLine() && numberOfLines < 6) { //Skip to line 7 
				numberOfLines++;
				System.out.println(scan.nextLine());
				System.out.println(numberOfLines); 
			}  
			
			// add Move Count
			totalMoveCount = Integer.valueOf(scan.next());
			System.out.println("\n\nMove Count: "+totalMoveCount);
			
			// add board pieces
			while (scan.hasNext()) {
				String data = scan.next();
		        if(data.length()>4){
		        	loadPiecesList.add(data);
		        }
		        System.out.print(data + " ");
		      }
			System.out.println("Succesfully loaded all data");
			scan.close();
		}
		catch(Exception ex){
			System.out.println("Load Game Error.");
		}
		
		//initiate the game board and game menu
		gameMenu = new GameMenu();
		frameController = new GameMenuController(gameMenu, boardController);
		mainMenu.getContentPane().removeAll();
		mainMenu.getContentPane().repaint();
		mainMenu.getContentPane().revalidate();
		mainMenu.setJMenuBar(gameMenu);
		boardController.loadBoard(loadPiecesList, totalMoveCount);
		mainMenu.add(boardController.getBoardView());
	}
}

//Provide action listener to exit game button
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

