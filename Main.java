import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Main {
	public static void main(String args[]) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {		
		} catch (InstantiationException ex) {
		} catch (IllegalAccessException ex) {	
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {	
		}
		
		MainMenu mainMenu = new MainMenu();
		MainMenuController controller = new MainMenuController(mainMenu);

		
	}
}
