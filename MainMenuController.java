import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class MainMenuController {
	 MainMenu mainMenu;

	public MainMenuController(MainMenu mainMenu) {
		this.mainMenu = mainMenu;
		
		//Add listener to view 
		mainMenu.btnStart.addActionListener(new StartActionListener(mainMenu));	
		mainMenu.btnInstruction.addActionListener(new InstructionActionListener());
		mainMenu.btnExitGame.addActionListener(new TerminateActionListener());
	}
}

	class StartActionListener implements ActionListener{
		 
		 MainMenu mainMenu;
		 GameMenu gameMenu;
		 GameMenuController controller;
		 
		 StartActionListener(MainMenu mainMenu){
			 this.mainMenu = mainMenu;
		 }
		public void actionPerformed(ActionEvent e) {
	
			gameMenu = new GameMenu();
			controller = new GameMenuController(gameMenu);
			mainMenu.getContentPane().removeAll();
			/*getContentPane().add();
			 //add board here//
			 */
			mainMenu.getContentPane().repaint();
			mainMenu.getContentPane().revalidate();
			mainMenu.setJMenuBar(gameMenu);
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

