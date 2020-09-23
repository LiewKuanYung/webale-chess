/**
 * @author Ivan Yap Mou En 
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;  

//A view class for game menu
public class GameMenu extends JMenuBar {  
	JMenu menu1,menu2;
	JMenuItem i1, i2, i3, i4, i5,i6;  
	
	//GameMenu constructor
	GameMenu() {  
     
		menu1=new JMenu("Game");
		menu2 = new JMenu("Move");
		i1=new JMenuItem("Game Instruction");
		i2=new JMenuItem("New Game");  
		i3=new JMenuItem("Save");  
		i4=new JMenuItem("Exit");
		i5=new JMenuItem("Offer Draw");  
		i6=new JMenuItem("Resign"); 
		         
		menu1.add(i1); menu1.add(i2); menu1.add(i3); menu1.add(i4); 
		menu2.add(i5); menu2.add(i6);
		          
		this.add(menu1); 
		this.add(menu2);
	}  
}