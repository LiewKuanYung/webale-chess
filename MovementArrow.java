/**
 * @author Eugene
 * @author Liew Kuan Yung
 */
public class MovementArrow implements MovementBehavior {

	@Override
	public boolean checkValidMove(GameBoard board, GameBoardSpot start, GameBoardSpot end, boolean direction) {
		
		//else check for obstacle
    	int tempx = end.getX() - start.getX();
    	int tempy = end.getY() - start.getY();
    	
    	if (direction)
    	{
    		if (tempy == -1 && tempx ==0)
    		{
    			return true;//making 1 tile step so no need check for obstacle
    		}
    		else if (tempy == -2 && tempx ==0)
    		{
    			try {
    				if (!board.getSpot(end.getX(),end.getY()+1).isEmpty())
    				{System.out.println("Arrow false move");
    					return false;
    				}
    				else
    				{
    					return true;
    				}
    			} catch (Exception e) {
    				System.out.println("Exception: MovementArrow");
    			}
    		}
    		else //if it is not the movement rule of Arrow
    		{
    			return false;
    			//pop up display "Illegal movement"
    		}
    	}
    	else if (!direction)
    	{
    		if (tempy == 1 && tempx ==0)
    		{
    			return true;//making 1 tile step so no need check for obstacle
    		}
    		else if (tempy == 2 && tempx ==0)
    		{
    			try {
    				if (!board.getSpot(end.getX(),end.getY()-1).isEmpty())
    				{System.out.println("Arrow false move");
    					return false;
    				}
    				else
    				{
    					return true;
    				}
    			} catch (Exception e) {
    				System.out.println("Exception: MovementArrow");
    			}
    		}
    		else //if it is not the movement rule of Arrow
    		{
    			return false;
    			//pop up display "Illegal movement"
    		}
    	}
		return false;
	}

}
