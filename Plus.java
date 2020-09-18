public class Plus implements MovementBehavior
{
    int currentx;
    int currenty;
    String currentcolor;
    Plus(int x,int y,String color)//public constructor to initialize the position and color
    {
        currentx = x;
        currenty = y;
        currentcolor = color;
    }
    public boolean move(int x,int y ,String color)//check if the clicked mouse position is an ally or not, if ally then return false else proceed to do checking for obstacles
    {
        if (currentcolor == color)//check if the clicked mouse position is an ally or not, if ally then return false else proceed to do checking for obstacles
        {
            return false;
        }
        else
        {
            int tempx = x - currentx;
            int tempy = y - currenty;
            if (tempx == 0 && tempy > 0 )
            {
                if (tempy == 1)
                {
                    return true;
                }
                else
                {
                    for (int i = 1; i < tempy ; i++)
                    {
                        if (!Spot.IsEmpty(x,i))
                        {
                            i = 0;//stop the loop when it detects the first obstacle
                            return false;
                        }
                        else if (i == tempy - 1)
                        {
                            return true;
                        }
                    }
                }
            }
            else if (tempx == 0 && tempy < 0)
            {
                if (tempy == -1)
                {
                    return true;
                }
                else
                {
                    for (int i = -1; i > tempy ; i--)
                    {
                        if (!Spot.IsEmpty(x,i))
                        {
                            i = 0;//stop the loop when it detects the first obstacle
                            return false;
                        }
                        else if (i == tempy + 1)
                        {
                            return true;
                        }
                    }
                }
            }
            else if (tempy == 0 && tempx > 0)
            {
                if (tempx == 1)
                {
                    return true;
                }
                else
                {
                    for (int i = 1; i < tempx ; i++)
                    {
                        if (!Spot.IsEmpty(i,y))
                        {
                            i = 0;//stop the loop when it detects the first obstacle
                            return false;
                        }
                        else if (i == tempx - 1)
                        {
                            return true;
                        }
                    }
                }
            }
            else if (tempy == 0 && tempx < 0)
            {
                if (tempx == -1)
                {
                    return true;
                }
                else
                {
                    for (int i = -1; i > tempx ; i--)
                    {
                        if (!Spot.IsEmpty(i,y))
                        {
                            i = 0;//stop the loop when it detects the first obstacle
                            return false;
                        }
                        else if (i == tempx + 1)
                        {
                            return true;
                        }
                    }
                }
            }
            else 
            {
                return false;
                //pop up display "Illegal movement"
            }
        }
    }
}