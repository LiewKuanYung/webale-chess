
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameBoardView extends JPanel {
	
	private JButton[][] btn = new JButton[8][7];
	private JPanel gameBoard = new JPanel(new GridLayout(8,7));
	
	GameBoardView(){
		
		this.setLayout(new BorderLayout());
		
		for (int i=0; i < btn.length; i++) {
		    for (int j=0; j < btn[i].length; j++) {
		    	
		        btn[i][j] = new JButton("[" + i + "][" + j + "]");
		        btn[i][j].setBackground(Color.WHITE);
		        gameBoard.setBackground(Color.yellow);
		        gameBoard.add(btn[i][j]);
		    }
        }
		
		this.add(gameBoard, BorderLayout.CENTER);
	}

}