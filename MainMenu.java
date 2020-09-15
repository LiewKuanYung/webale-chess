import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu extends JFrame{
	
	public MainMenu() {
	
	super("Webale Chess Game");
	getContentPane().setBackground(new Color(250, 240, 230));
 
    // Supply a layout manager for the body of the content
    getContentPane().setLayout(new GridBagLayout());
    
    // Title
    JLabel title = new JLabel("Webale Chess Game");
    title.setForeground(new Color(210, 105, 30));
    title.setFont(new Font("STXinwei", Font.BOLD, 40));
    GridBagConstraints gbc1 = new GridBagConstraints();
    gbc1.gridx = 0;
	gbc1.gridy = 0;
    gbc1.insets = new Insets(0, 0,60, 0);
    getContentPane().add(title,gbc1);
    
    // Buttons
	JButton btnNewButton = new JButton("Start New Game");
	btnNewButton.setForeground(Color.WHITE);
	btnNewButton.setBackground(new Color(244, 164, 96));
	btnNewButton.setFont(new Font("STXinwei", Font.BOLD, 20));
	btnNewButton.setPreferredSize(new Dimension(200, 30));
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			/*
			removeAll();
			repaint();
			revalidate();
			*/
		}
	});
	GridBagConstraints gbc2 = new GridBagConstraints();
    gbc2.gridx = 0;
	gbc2.gridy = 1;
    gbc2.insets = new Insets(0, 0,30, 0);
    getContentPane().add(btnNewButton,gbc2);
	
	JButton btnInstruction = new JButton("Instruction\r\n");
	btnInstruction.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		
		}
	});
	btnInstruction.setBackground(new Color(244, 164, 96));
	btnInstruction.setForeground(Color.WHITE);
	btnInstruction.setFont(new Font("STXinwei", Font.BOLD, 20));
	btnInstruction.setPreferredSize(new Dimension(200, 30));
	GridBagConstraints gbc3 = new GridBagConstraints();
    gbc3.gridx = 0;
	gbc3.gridy = 2;
    gbc3.insets = new Insets(0, 0,30, 0);
	getContentPane().add(btnInstruction,gbc3);

	JButton btnLoadGame = new JButton("Load Game");
	btnLoadGame.setBackground(new Color(244, 164, 96));
	btnLoadGame.setForeground(Color.WHITE);
	btnLoadGame.setFont(new Font("STXinwei", Font.BOLD, 20));
	btnLoadGame.setPreferredSize(new Dimension(200, 30));
	GridBagConstraints gbc4 = new GridBagConstraints();
    gbc4.gridx = 0;
	gbc4.gridy = 3;
    gbc4.insets = new Insets(0, 0,30, 0);
	getContentPane().add(btnLoadGame,gbc4);
	
	JButton btnExitGame = new JButton("Exit Game");
	btnExitGame.setBackground(new Color(244, 164, 96));
	btnExitGame.setForeground(Color.WHITE);
	btnExitGame.setFont(new Font("STXinwei", Font.BOLD, 20));
	btnExitGame.setPreferredSize(new Dimension(200, 30));
	btnExitGame.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int dialogButton = JOptionPane.showConfirmDialog (null, "Are you sure want to exit?","WARNING",JOptionPane.YES_NO_OPTION);
			if(dialogButton == JOptionPane.YES_OPTION) {
			System.exit(0);
			}
			else {
			}
		}
	});
	GridBagConstraints gbc5 = new GridBagConstraints();
    gbc5.gridx = 0;
	gbc5.gridy = 4;
    gbc5.insets = new Insets(0, 0,30, 0);
	getContentPane().add(btnExitGame,gbc5);
	
	/*
	JLabel iconLabel = new JLabel("");

	try {
    	Image originalIcon = ImageIO.read(getClass().getResource("images/background1.JPG"));
    	Image icon = originalIcon.getScaledInstance(1000, 1000, Image.SCALE_DEFAULT);
    	iconLabel.setIcon(new ImageIcon(icon));
    }
    catch (Exception ex) {
    	System.out.println("Image not found");
    }
    
	getContentPane().add(iconLabel);
	*/
	getContentPane().setPreferredSize(new Dimension(1000, 1000));
	setSize(1000,1000);
	setResizable(true);
	setVisible(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setExtendedState(Frame.MAXIMIZED_BOTH);
	setLocationRelativeTo(null);

	}
        
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
		new MainMenu();
	}
}
