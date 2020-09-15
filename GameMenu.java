import javax.swing.*;  
public class GameMenu extends JPanel
{  
          JMenu menu1,menu2,menu3 ,submenu;  
          JMenuItem i1, i2, i3, i4, i5;  
          GameMenu	(){  
          JFrame f= new JFrame("Webale Chess Game");  
          JMenuBar mb=new JMenuBar();  
          menu1=new JMenu("Game");
          menu2 = new JMenu("Instruction");	
          menu3 = new JMenu("Move");
          submenu=new JMenu("Sub Menu");  
          i1=new JMenuItem("New");  
          i2=new JMenuItem("Save");  
          i3=new JMenuItem("Exit"); 
          i4=new JMenuItem("Offer Draw");  
          i5=new JMenuItem("Resign"); 
    
     
          menu1.add(i1); menu1.add(i2); menu1.add(i3); 
          menu3.add(i4); menu3.add(i5);
          
          mb.add(menu1); 
          mb.add(menu2);
          mb.add(menu3);
   
          f.setJMenuBar(mb);  
          f.setSize(400,400);  
          f.setLayout(null);  
          f.setVisible(true);  
}  
public static void main(String args[])  
{  
new GameMenu();  
}}