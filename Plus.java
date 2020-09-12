public class Plus implements MovementBehavior
{
    public boolean move(int x,int y)
    {
        if (x == 0 && y > 0 )
        {
            for (int i = 1; i <= y ; i++)
                {
                    if (!Spot.IsEmpty(x,i))
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
        else if (x == 0 && y < 0)
        {
            for (int i = -1; i >= y ; i--)
                {
                    if (!Spot.IsEmpty(x,i))
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
        else if (y == 0 && x > 0)
        {
            for (int i = 1; i <= x ; i++)
                {
                    if (!Spot.IsEmpty(i,y))
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
        else if (y == 0 && x < 0)
        {
            for (int i = -1; i >= x ; i--)
                {
                    if (!Spot.IsEmpty(i,y))
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