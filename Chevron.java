public class Chevron implements MovementBehavior
{
    public boolean move(int x,int y)
    {
        int tempx = x;
        int tempy = y;
        if (tempx < 0)
        {
            tempx *= -1;
        }
        if (tempy < 0)
        {
            tempy *= -1;
        }
        if (tempx == 1 && tempy == 2 || tempx == 2 && tempy == 1)//make sure that x and y is positive
        {
            if (Spot.IsEmpty(x,y))//if it is enemy then delete the piece, if it is team then display illegal movement
            {
                return true;
            }
            else 
            {
                return false;
                //pop up display "Illegal movement"
            }
            
        }
        else 
        {
            return false;
            //pop up display "Illegal movement"
        }
    }
}