import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

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
			JOptionPane.showMessageDialog(null,"Hello, Welcome to Webale Chess Game. Instruction: \n\n"
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
			removeAll();
			repaint();
			revalidate();
			*/
	    }
	}
	
	class SaveActionListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	    }
	}
	
	class ExitActionListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	    	/*
	    	removeAll();
			repaint();
			revalidate();
			*/
	    }
	}
	
	class DrawActionListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	    }
	}
	
	class ResignActionListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	    }
	}


