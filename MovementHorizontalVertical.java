// by Liew Kuan Yung
public class MovementHorizontalVertical implements MovementBehavior {

	@Override
	public boolean checkValidMove(GameBoard board, GameBoardSpot start, GameBoardSpot end, boolean direction) {
		
    	int tempx = end.getX() - start.getX();
    	int tempy = end.getY() - start.getY();
    	int abstempx = java.lang.Math.abs(tempx);
    	int abstempy = java.lang.Math.abs(tempy);

    	if ( (abstempx == 1 && abstempy == 0) || (abstempx == 0 && abstempy == 1) ) 
    	{
    		return true; //If only move one spot, need no to check
    	} 
    	else if (tempx == 0 && tempy > 0 ) //Y axis moving up
    	{
    		try {
    			for (int i = 1; i < tempy ; i++)
    			{
    				if (!board.getSpot(start.getX(), start.getY()+i).isEmpty())
    				{
    					i = 0;//stop the loop when it detects the first obstacle
    					return false;
    				}
    				else if (i == tempy - 1)//if the end of the loop means no obstacle so return true
    				{
    					return true;
    				}					
    			}
    		} catch (Exception e) {
    			System.out.println("Exception: MovementHorizontalVertical");
    		}
    	}
    	else if (tempx == 0 && tempy < 0) //Y axis moving down
    	{
    		try {
    			for (int i = -1; i > tempy ; i--)
    			{
    				if (!board.getSpot(start.getX(), start.getY()+i).isEmpty())
    				{
    					i = 0;//stop the loop when it detects the first obstacle
    					return false;
    				}
    				else if (i == tempy + 1)//if the end of the loop means no obstacle so return true
    				{
    					return true;
    				}
    			}
    		} catch (Exception e) {
    			System.out.println("Exception: MovementHorizontalVertical");
    		}
    	}
    	else if (tempy == 0 && tempx > 0) //X axis moving right
    	{
    		try {
    			for (int i = 1; i < tempx ; i++)
    			{
    				if (!board.getSpot(start.getX()+i, start.getY()).isEmpty())
    				{
    					i = 0;//stop the loop when it detects the first obstacle
    					return false;
    				}
    				else if (i == tempx - 1)//if the end of the loop means no obstacle so return true
    				{
    					return true;
    				}
    			}
    		} catch (Exception e) {
    			System.out.println("Exception: MovementHorizontalVertical");
    		}

    	}
    	else if (tempy == 0 && tempx < 0) //meaning moving left
    	{
    		try {
    			for (int i = -1; i > tempx ; i--)
    			{
    				if (!board.getSpot(start.getX()+i, start.getY()).isEmpty())
    				{
    					i = 0;//stop the loop when it detects the first obstacle
    					return false;
    				}
    				else if (i == tempx + 1)//if the end of the loop means no obstacle so return true
    				{
    					return true;
    				}
    			}
    		} catch (Exception e) {
    			System.out.println("Exception: MovementHorizontalVertical");
    		}
    	}
    	else //If it is not the movement rule of Plus
    	{
    		return false;
    		//pop up display "Illegal movement"
    	}
		return false;
	}

}
