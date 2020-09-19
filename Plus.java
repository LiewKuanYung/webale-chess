public class Plus extends Piece
{
    
	//public constructor to initialize the position and color
    Plus(int x, int y, String color)
    {
    	super(x,y,color);
    	String pieceName = "PLS";
    	super.setPieceName(pieceName);
    	if(color == "R") {
    		super.setPieceIcon("images/Red_Plus.png");
    	} else {
    		super.setPieceIcon("images/Blue_Plus.png");
    	}
    }
    
    @Override
    public boolean isValidMove(GameBoard board, GameBoardSpot start, GameBoardSpot end)
    {
    	//Check if "end" has same color with "current"
    	if (super.getColor() == end.getPiece().getColor())
    	{
            return false;//if the end spot is ally then return false
        }
        else //else check for obstacle
        {
			int tempx = end.getX() - start.getX();
			int tempy = end.getY() - start.getY();
			
			if (java.lang.Math.abs(tempx) == 1 || java.lang.Math.abs(tempy) == 1) 
			{
				return true; //If only move one spot, need no to check
			} 
			else if (tempx == 0 && tempy > 0 ) //Y axis moving up
            {
				try {
					for (int i = 1; i < tempy ; i++)
					{
						if (!board.getSpot(end.getX(), i).isEmpty())
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
					System.out.println("Exception: Plus");
				}
            }
            else if (tempx == 0 && tempy < 0) //Y axis moving down
            {
            	try {
                    for (int i = -1; i > tempy ; i--)
                    {
                    	if (!board.getSpot(end.getX(), i).isEmpty())
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
            		System.out.println("Exception: Plus");
				}
            }
            else if (tempy == 0 && tempx > 0) //X axis moving right
            {
            	try {
                    for (int i = 1; i < tempx ; i++)
                    {
                    	if (!board.getSpot(i, end.getY()).isEmpty())
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
            		System.out.println("Exception: Plus");
				}
                
            }
            else if (tempy == 0 && tempx < 0) //meaning moving left
            {
            	try {
                    for (int i = -1; i > tempx ; i--)
                    {
                    	if (!board.getSpot(i, end.getY()).isEmpty())
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
					System.out.println("Exception: Plus");
				}
            }
            else //If it is not the movement rule of Plus
            {
                return false;
              //pop up display "Illegal movement"
            }
			
			//If it is not the movement rule of Plus
			return false;
        }
    	
    }
}