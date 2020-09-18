public class Arrow implements MovementBehavior
{
    int currentx;
    int currenty;
    String currentcolor;
    Arrow(int x,int y,String color)//public constructor to initialize the position and color
    {
        currentx = x;
        currenty = y;
        currentcolor = color;
    }
    public boolean move(int x,int y ,String color)//the input from click mouse position
    {
        boolean facing = true;//if false reverse the function
        if (currentcolor == color)//check if the clicked mouse position is an ally or not, if ally then return false else proceed to do checking for obstacles
        {
            return false;
        }
        else
        {
            int tempx = x - currentx;
            int tempy = y - currenty;
            if (facing)
            {
                if (tempy == 1 && tempx ==0)
                {
                    return true;
                }
                else if (tempy == 2 && tempx ==0)
                {
                    if (!Spot.IsEmpty(x,y-1))
                    {
                        return false;
                    }
                    else
                    {
                        return true;
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
                if (tempy == -1 && tempx ==0)
                {
                    return true;
                }
                else if (tempy == -2 && tempx ==0)
                {
                    if (!Spot.IsEmpty(x,y+1))
                    {
                        return false;
                    }
                    else
                    {
                        return true;
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
}