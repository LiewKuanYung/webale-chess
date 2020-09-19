
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.*;
import java.awt.event.*;

public class GameBoardView extends JPanel {
	
	
	private GameBoardButton[][] btn = new GameBoardButton[8][7];
	private JPanel gameBoard = new JPanel(new GridLayout(8,7));
	
	GameBoardView(){
		
		initComponent();
	}	
	
	//Initialize game board buttons
	void initComponent() {
		
		gameBoard.setPreferredSize(new Dimension(500,500));
		
		System.out.println(btn.length + " " + btn[0].length);
		
		for (int i=0; i < btn.length; i++) { //Row
		    for (int j=0; j < btn[i].length; j++) { //Column
		    	btn[i][j] = new GameBoardButton(i, j);
		        btn[i][j].setBackground(Color.WHITE);
		        btn[i][j].setPreferredSize(new Dimension(50, 50));
		        gameBoard.setBackground(Color.yellow);
		        gameBoard.add(btn[i][j]);
		    }
        }
		this.add(gameBoard);
	}
	
	//Add listener to all game board buttons
	void addBoardListener(ActionListener listenClickedBtn) {
		for (int i=0; i < btn.length; i++) {
		    for (int j=0; j < btn[i].length; j++) {
		    	btn[i][j].addActionListener(listenClickedBtn);
		    }
		}
	}
	
}