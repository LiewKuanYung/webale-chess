public class Triangle implements MovementBehavior
{
    public boolean move(int x,int y)
    {
        if (x == y)//make sure that x and y has absolute value
        {
            for (int i = 1; i <= x ; i++)
                {
                    if (!Spot.IsEmpty(i,i))
                    {
                        i = 0;//stop the loop when it detects the first obstacle
                        return false;
                    }
                    else
                    {
                        return true;
                    }
                }
        }
        else if (x == -y)
        {
            for (int i = 1; i <= x ; i++)
                {
                    if (!Spot.IsEmpty(i,-i))
                    {
                        i = 0;//stop the loop when it detects the first obstacle
                        return false;
                    }
                    else
                    {
                        return true;
                    }
                }
        }
        else if (-x == y)
        {
            for (int i = 1; i <= x ; i++)
                {
                    if (!Spot.IsEmpty(-i,i))
                    {
                        i = 0;//stop the loop when it detects the first obstacle
                        return false;
                    }
                    else
                    {
                        return true;
                    }
                }
        }
        else if (-x == -y)
        {
            for (int i = 1; i <= x ; i++)
                {
                    if (!Spot.IsEmpty(-i,-i))
                    {
                        i = 0;//stop the loop when it detects the first obstacle
                        return false;
                    }
                    else
                    {
                        return true;
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