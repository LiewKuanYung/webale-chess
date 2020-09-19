import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class MainMenuController {
	 public MainMenu mainMenu;
	 public GameBoardController boardControl;

	public MainMenuController(MainMenu mainMenu, GameBoardController boardControl) {
		this.mainMenu = mainMenu;
		this.boardControl = boardControl;
		
		//Add listener to view 
		mainMenu.btnStart.addActionListener(new StartActionListener(mainMenu, boardControl));	
		mainMenu.btnInstruction.addActionListener(new InstructionActionListener());
		mainMenu.btnExitGame.addActionListener(new TerminateActionListener());
	}
}

	class StartActionListener implements ActionListener{
		 
		 MainMenu mainMenu;
		 GameMenu gameMenu;
		 GameMenuController controller;
		 GameBoardController boardControl;
		 
		 StartActionListener(MainMenu mainMenu, GameBoardController boardControl){
			 this.mainMenu = mainMenu;
			 this.boardControl = boardControl;
		 }
		public void actionPerformed(ActionEvent e) {
	
			gameMenu = new GameMenu();
			controller = new GameMenuController(gameMenu);
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

