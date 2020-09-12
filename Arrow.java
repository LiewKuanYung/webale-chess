public class Arrow implements MovementBehavior
{
    public boolean move(int x,int y)
    {
        boolean facing = true;//if false reverse the function
        if (facing)
        {
            if (y == 1 && x ==0||y == 2 && x ==0)//make sure that x and y is positive
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
            else 
            {
                return false;
                //pop up display "Illegal movement"
            }
        }
        else if (!facing)
        {
            if (y == -1 && x ==0||y == -2 && x ==0)//make sure that x and y is positive
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
            else 
            {
                return false;
                //pop up display "Illegal movement"
            }
        }
    }
}