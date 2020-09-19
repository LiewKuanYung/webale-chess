public class Triangle extends Piece
{
    Triangle(int x, int y, String color)
    {
    	super(x,y,color);
    	String pieceName = "Triangle";
    	super.setPieceName(pieceName);
        
    }
    public boolean isValidMove(GameBoard board, GameBoardSpot start, GameBoardSpot end)//check if the clicked mouse position is an ally or not, if ally then return false else proceed to do checking for obstacles
    {
        if (super.getColor() == end.getPiece().getColor())//check if the clicked mouse position is an ally or not, if ally then return false else proceed to do checking for obstacles
        {
            return false;//if the end spot is ally then return false
        }
        else //else check for obstacle
        {
            int tempx = end.getX() - start.getX();
            int tempy = end.getY() - start.getY();
            if (tempx == tempy)
            {
                if (tempx > 0)//meaning the top right
                {
                    if (end.getX() == start.getX() + 1)
                    {
                        return true; //making 1 tile step so no need check for obstacle
                    }
                    else
                    {
                        for (int i = 1; i < tempx ; i++)
                        {
                            if (!GameBoardSpot.IsEmpty(start.getX()+i,start.getY()+i))
                            {
                                i = 0;//stop the loop when it detects the first obstacle
                                return false;
                            }
                            else if (i == tempx - 1) //if the end of the loop means no obstacle so return true
                            {
                                return true;
                            }
                        }
                    }
                }
                else if (tempx < 0)//meaning the bottom left
                {
                    if (end.getY() == start.getY() - 1)
                    {
                        return true; //making 1 tile step so no need check for obstacle
                    }
                    else
                    {
                        for (int i = -1; i > tempx ; i--)
                        {
                            if (!GameBoardSpot.IsEmpty(start.getX()-i,start.getY()-i))
                            {
                                i = 0;//stop the loop when it detects the first obstacle
                                return false;
                            }
                            else if (i == tempx + 1) //if the end of the loop means no obstacle so return true
                            {
                                return true;
                            }
                        }
                    }
                }
            }
            else if (tempx == -tempy)//meaning the bottom right
            {
                if (end.getX() == start.getX() + 1)
                {
                    return true; //making 1 tile step so no need check for obstacle
                }
                else
                {
                    for (int i = 1; i < tempx ; i++)
                    {
                        if (!GameBoardSpot.IsEmpty(start.getX()+i,start.getY()-i))
                        {
                            i = 0;//stop the loop when it detects the first obstacle
                            return false;
                        }
                        else if (i == tempx - 1) //if the end of the loop means no obstacle so return true
                        {
                            return true;
                        }
                    }
                }
            }
            else if (-tempx == tempy) //meaning the top left
            {
                if (end.getY() == start.getY() + 1)
                {
                    return true; //making 1 tile step so no need check for obstacle
                }
                else
                {
                    for (int i = 1; i < tempy ; i++)
                    {
                        if (!GameBoardSpot.IsEmpty(start.getX()-i,start.getY()+i))
                        {
                            i = 0;//stop the loop when it detects the first obstacle
                            return false;
                        }
                        else if (i == tempy - 1) //if the end of the loop means no obstacle so return true
                        {
                            return true;
                        }
                    }
                }
            }
            else //if it is not the movement rule of Triangle
            {
                return false;
                //pop up display "Illegal movement"
            }
        }
    }
}