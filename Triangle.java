public class Triangle implements MovementBehavior
{
    int currentx;
    int currenty;
    String currentcolor;
    Triangle(int x,int y,String color)//public constructor to initialize the position and color
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
            if (tempx == tempy)//make sure that x and y has absolute value
            {
                if (tempx > 0)
                {
                    if (x == currentx + 1)
                    {
                        return true;
                    }
                    else
                    {
                        for (int i = 1; i < tempx ; i++)
                        {
                            if (!Spot.IsEmpty(currentx+i,currenty+i))
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
                else if (tempx < 0)
                {
                    if (y == currenty - 1)
                    {
                        return true;
                    }
                    else
                    {
                        for (int i = -1; i > tempx ; i--)
                        {
                            if (!Spot.IsEmpty(currentx-i,currenty-i))
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
            }
            else if (tempx == -tempy)
            {
                if (x == currentx + 1)
                {
                    return true;
                }
                else
                {
                    for (int i = 1; i < tempx ; i++)
                    {
                        if (!Spot.IsEmpty(currentx+i,currenty-i))
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
            else if (-tempx == tempy)
            {
                if (y == currenty + 1)
                {
                    return true;
                }
                else
                {
                    for (int i = 1; i < tempy ; i++)
                    {
                        if (!Spot.IsEmpty(currentx-i,currenty+i))
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
            else 
            {
                return false;
                //pop up display "Illegal movement"
            }
        }
    }
}