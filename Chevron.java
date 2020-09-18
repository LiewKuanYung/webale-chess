public class Chevron implements MovementBehavior
{
    int currentx;
    int currenty;
    String currentcolor;
    Chevron(int x,int y,String color)//public constructor to initialize the position and color
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
        else //else check movement
        {
            int tempx = x - currentx;
            int tempy = y - currenty;
            if (tempx < 0)
            {
                tempx *= -1;
            }
            if (tempy < 0)
            {
                tempy *= -1;
            }
            if (tempx == 1 && tempy == 2 || tempx == 2 && tempy == 1)
            {
                return true;
            }
            else //if it is not the movement rule of Chevron
            {
                return false;
                //pop up display "Illegal movement"
            }
        }
    }
}