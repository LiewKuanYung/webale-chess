import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
//by Yap Mou En
// Driver class for Webale Chess Game
public class Main {
	public static void main(String args[]) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} 
		catch (ClassNotFoundException ex) {		
		} 
		catch (InstantiationException ex) {
		} 
		catch (IllegalAccessException ex) {	
		} 
		catch (javax.swing.UnsupportedLookAndFeelException ex) {	
		}
			
		GameBoardView boardView = new GameBoardView();
		GameBoard boardModel = GameBoard.getInstance();
		Player player1 = null;
		Player player2 = null;
		
		try {
			player1 = new Player(true, "R");
			player2 = new Player(false, "B");
		} 
		catch (Exception e) {
			System.out.println("Exception: Main.java Player setting");
		}
		
		GameWebale gameWebale = new GameWebale(boardModel, player1, player2);
		GameBoardController boardController = new GameBoardController(boardView, boardModel, gameWebale);	
		MainMenu mainMenu = new MainMenu();
		MainMenuController controller = new MainMenuController(mainMenu, boardController);	
	}
}
