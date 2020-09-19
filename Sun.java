public class Sun extends Piece
{
	//public constructor to initialize the position and color
    Sun(int x, int y, String color)
    {
    	super(x,y,color);
    	String pieceName = "SUN";
    	super.setPieceName(pieceName);  
    	if(color == "R") {
    		super.setPieceIcon("images/Red_Sun.png");
    	} else {
    		super.setPieceIcon("images/Blue_Sun.png");
    	}
    }
    
    //check if the clicked mouse position is an ally or not, if ally then return false else proceed to do checking for obstacles
    public boolean isValidMove(GameBoard board, GameBoardSpot start, GameBoardSpot end)
    {
        if (super.getColor() == end.getPiece().getColor())//check if the clicked mouse position is an ally or not, if ally then return false else proceed to do checking for obstacles
        {
            return false;//if the end spot is ally then return false
        }
        else //else check movement
        {
            int tempx = java.lang.Math.abs(end.getX() - start.getX());
            int tempy = java.lang.Math.abs(end.getY() - start.getY());
            
            if (tempx <= 1 && tempy <= 1)
            {
                return true;
            }
            else //if it is not the movement rule of Sun
            {
                return false;
                //pop up display "Illegal movement"
            }
        }
    }
}