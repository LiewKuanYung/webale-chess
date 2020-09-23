/**
 * @author Eugene
 */

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
    	
    	movementType = new MovementOneBox();
    }
    
    
    //check if the clicked mouse position is an ally or not, if ally then return false else proceed to do checking for obstacles
    public boolean isValidMove(GameBoard board, GameBoardSpot start, GameBoardSpot end)
    {
    	//check if the clicked mouse position is an ally or not, if ally then return false else proceed to do checking for obstacles
    	if(end.getPiece() != null) {
	        if (start.getPiece().getColor() == end.getPiece().getColor())
	        {
	            return false;//if the end spot is ally then return false
	        }
    	}
    	
    	//else check movement
    	return movementType.checkValidMove(board, start, end, false);
    }
}