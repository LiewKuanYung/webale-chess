public class Chevron extends Piece
{
    Chevron(int x, int y, String color)
    {
    	super(x,y,color);
    	String pieceName = "CHV";
    	super.setPieceName(pieceName);
    	if(color == "R") {
    		super.setPieceIcon("images/Red_Chevron.png");
    	} else {
    		super.setPieceIcon("images/Blue_Chevron.png");
    	}
    }
    
    public boolean isValidMove(GameBoard board, GameBoardSpot start, GameBoardSpot end)//check if the clicked mouse position is an ally or not, if ally then return false else proceed to do checking for obstacles
    {
    	if(end.getPiece() != null) {
	        if (super.getColor() == end.getPiece().getColor())//check if the clicked mouse position is an ally or not, if ally then return false else proceed to do checking for obstacles
	        {
	            return false;//if the end spot is ally then return false
	        }
	    }
        
    	//else check movement
    	int tempx = end.getX() - start.getX();
    	int tempy = end.getY() - start.getY();
    	int checktempx = java.lang.Math.abs(tempx);
    	int checktempy = java.lang.Math.abs(tempy);
    	if (checktempx == 1 && checktempy == 2 || checktempx == 2 && checktempy == 1)
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