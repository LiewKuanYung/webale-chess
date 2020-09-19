public class Chevron extends Piece
{
    Chevron(int x, int y, String color)
    {
    	super(x,y,color);
    	String pieceName = "Chevron";
    	super.setPieceName(pieceName);
        
    }
    public boolean isValidMove(GameBoard board, GameBoardSpot start, GameBoardSpot end)//check if the clicked mouse position is an ally or not, if ally then return false else proceed to do checking for obstacles
    {
        if (super.getColor() == end.getPiece().getColor())//check if the clicked mouse position is an ally or not, if ally then return false else proceed to do checking for obstacles
        {
            return false;//if the end spot is ally then return false
        }
        else //else check movement
        {
            int tempx = end.getX() - start.getX();
            int tempy = end.getY() - start.getY();
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