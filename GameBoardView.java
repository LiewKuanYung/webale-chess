
import javax.swing.*; 
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
		this.setLayout(new BorderLayout());
		
		for (int i=0; i < btn.length; i++) {
		    for (int j=0; j < btn[i].length; j++) {
		    	String text = ("[" + i + "][" + j + "]");
		    	btn[i][j] = new GameBoardButton(text, i, j);
		    	//btn[i][j]= new JButton(text);
		        btn[i][j].setBackground(Color.WHITE);
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