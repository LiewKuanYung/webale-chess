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
            return false;//if the end spot is ally then return false
        }
        else //else check for obstacle
        {
            int tempx = x - currentx;
            int tempy = y - currenty;
            if (tempx == tempy)
            {
                if (tempx > 0)//meaning the top right
                {
                    if (x == currentx + 1)
                    {
                        return true; //making 1 tile step so no need check for obstacle
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
                            else if (i == tempx - 1) //if the end of the loop means no obstacle so return true
                            {
                                return true;
                            }
                        }
                    }
                }
                else if (tempx < 0)//meaning the bottom left
                {
                    if (y == currenty - 1)
                    {
                        return true; //making 1 tile step so no need check for obstacle
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
                if (x == currentx + 1)
                {
                    return true; //making 1 tile step so no need check for obstacle
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
                        else if (i == tempx - 1) //if the end of the loop means no obstacle so return true
                        {
                            return true;
                        }
                    }
                }
            }
            else if (-tempx == tempy) //meaning the top left
            {
                if (y == currenty + 1)
                {
                    return true; //making 1 tile step so no need check for obstacle
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