/** 
 * @author Lim Ying Shen
 */

import java.util.*;
public class Player
{
    public boolean player1;
    public String color;

    public Player(boolean player1, String color) throws Exception
    {
        this.player1 = player1;
        if(color == "R" || color == "B") {
        	this.color = color;
        } else {
        	throw new Exception("Player Exception: Invalid Color"); 
        }
    }
    
    public boolean isPlayer1() {
    	return player1;
    }
    
    public boolean isColorRed() {
    	return (color == "R");
    }
    
    public String getColor() {
    	return color;
    }
}