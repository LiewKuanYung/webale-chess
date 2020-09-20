import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.util.ArrayList;

//A view class for main menu
public class MainMenu extends JFrame{
	
	JPanel panelBody;
	JLabel title;
	JButton btnStart;
	JButton btnInstruction;
	JButton btnLoadGame;
	JButton btnExitGame;
	
	public MainMenu() {
	
		super("Webale Chess Game");
		javax.swing.UIManager.put("OptionPane.messageFont", new Font("Comic Sans MS", Font.BOLD, 15));
		
		//Add a panelBody
		panelBody = new JPanel();
		panelBody.setBackground(new Color(250, 240, 230));
	    //Supply a layout manager for the body of the content
	    panelBody.setLayout(new GridBagLayout());
	    
	    //Add a title for main menu
	    title = new JLabel("Webale Chess Game");
	    title.setForeground(new Color(210, 105, 30));
	    title.setFont(new Font("STXinwei", Font.BOLD, 40));
	    GridBagConstraints gbc1 = new GridBagConstraints();
	    gbc1.gridx = 0;
		gbc1.gridy = 0;
	    gbc1.insets = new Insets(0, 0,60, 0);
	    panelBody.add(title,gbc1);
	    
	    //Add a start button to main menu
		btnStart = new JButton("Start New Game");
		btnStart.setForeground(Color.WHITE);
		btnStart.setBackground(new Color(244, 164, 96));
		btnStart.setFont(new Font("STXinwei", Font.BOLD, 20));
		btnStart.setPreferredSize(new Dimension(200, 30));
		GridBagConstraints gbc_btnStart = new GridBagConstraints();
	    gbc_btnStart.gridx = 0;
		gbc_btnStart.gridy = 1;
	    gbc_btnStart.insets = new Insets(0, 0,30, 0);
	    panelBody.add(btnStart,gbc_btnStart);
		
	    //Add an instruction button to main menu
		btnInstruction = new JButton("Instruction\r\n");
		btnInstruction.setBackground(new Color(244, 164, 96));
		btnInstruction.setForeground(Color.WHITE);
		btnInstruction.setFont(new Font("STXinwei", Font.BOLD, 20));
		btnInstruction.setPreferredSize(new Dimension(200, 30));
		GridBagConstraints gbc3 = new GridBagConstraints();
	    gbc3.gridx = 0;
		gbc3.gridy = 2;
	    gbc3.insets = new Insets(0, 0,30, 0);
		panelBody.add(btnInstruction,gbc3);
	    
		//Add a load game button to main menu
		btnLoadGame = new JButton("Load Game");
		btnLoadGame.setBackground(new Color(244, 164, 96));
		btnLoadGame.setForeground(Color.WHITE);
		btnLoadGame.setFont(new Font("STXinwei", Font.BOLD, 20));
		btnLoadGame.setPreferredSize(new Dimension(200, 30));
		GridBagConstraints gbc4 = new GridBagConstraints();
	    gbc4.gridx = 0;
		gbc4.gridy = 3;
	    gbc4.insets = new Insets(0, 0,30, 0);
		panelBody.add(btnLoadGame,gbc4);
		
		//Add an exit button to main menu
		btnExitGame = new JButton("Exit Game");
		btnExitGame.setBackground(new Color(244, 164, 96));
		btnExitGame.setForeground(Color.WHITE);
		btnExitGame.setFont(new Font("STXinwei", Font.BOLD, 20));
		btnExitGame.setPreferredSize(new Dimension(200, 30));
		GridBagConstraints gbc5 = new GridBagConstraints();
	    gbc5.gridx = 0;
		gbc5.gridy = 4;
	    gbc5.insets = new Insets(0, 0,30, 0);
		panelBody.add(btnExitGame,gbc5);
		getContentPane().add(panelBody);
		
		/*
		JLabel iconLabel = new JLabel("");
		try {
	    	Image originalIcon = ImageIO.read(getClass().getResource("images/BlueChess.PNG"));
	    	Image icon = originalIcon.getScaledInstance(1000, 1000, Image.SCALE_DEFAULT);
	    	iconLabel.setIcon(new ImageIcon(icon));
	    }
	    catch (Exception ex) {
	    	System.out.println("Image not found");
	    }*/
		getContentPane().setBackground(new Color(250, 240, 230));
		getContentPane().setPreferredSize(new Dimension(1000, 1000));
		setSize(1000,1000);
		setResizable(true);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
	}     
}
