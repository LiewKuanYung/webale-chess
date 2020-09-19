public class Arrow extends Piece
{
    private boolean direction;
    Arrow(int x, int y, String color)
    {
    	super(x,y,color);
    	String pieceName = "ARR";
    	super.setPieceName(pieceName);
    	if(color == "R") {
    		super.setPieceIcon("images/Red_Arrow.png");
    	} else {
    		super.setPieceIcon("images/Blue_Arrow.png");
    	}
    	
    	if (color == "R")//top part
    	{
    	    boolean direction = false; // facing to South
    	}
    	else if (color == "B")//bottom part
    	{
    	    boolean direction = true; //facing to North
    	}
    }
    public boolean isValidMove(GameBoard board, GameBoardSpot start, GameBoardSpot end)//the input from click mouse position
    {
        if (super.getColor() == end.getPiece().getColor())//check if the clicked mouse position is an ally or not, if ally then return false else proceed to do checking for obstacles
        {
            return false;//if the end spot is ally then return false
        }
        else //else check for obstacle
        {
            int tempx = end.getX() - start.getX();
            int tempy = end.getY() - start.getY();
            if (direction)
            {
                if (tempy == 1 && tempx ==0)
                {
                    return true;//making 1 tile step so no need check for obstacle
                }
                else if (tempy == 2 && tempx ==0)
                {
                    try {
						if (!board.getSpot(end.getX(),end.getY()-1).isEmpty())
						{
						    return false;
						}
						else
						{
						    return true;
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
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
                if (tempy == -1 && tempx ==0)
                {
                    return true;//making 1 tile step so no need check for obstacle
                }
                else if (tempy == -2 && tempx ==0)
                {
                    try {
						if (!board.getSpot(end.getX(),end.getY()+1).isEmpty())
						{
						    return false;
						}
						else
						{
						    return true;
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
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
}