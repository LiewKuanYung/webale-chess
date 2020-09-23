/**
 * @author Eugene
 */
public class Plus extends Piece
{
    
	//public constructor to initialize the position and color
    Plus(int x, int y, String color)
    {
    	super(x,y,color);
    	String pieceName = "PLS";
    	super.setPieceName(pieceName);
    	if(color == "R") {
    		super.setPieceIcon("images/Red_Plus.png");
    	} else {
    		super.setPieceIcon("images/Blue_Plus.png");
    	}
    	
    	movementType = new MovementHorizontalVertical();
    }
    
    @Override
    public boolean isValidMove(GameBoard board, GameBoardSpot start, GameBoardSpot end)
    {
    	//check if the clicked mouse position is an ally or not, if ally then return false else proceed to do checking for obstacles
    	if(end.getPiece() != null) {
	    	if (super.getColor() == end.getPiece().getColor())
	    	{
	            return false;//if the end spot is ally then return false
	        }
    	}

    	//else check for obstacle and movement
    	return movementType.checkValidMove(board, start, end, false);
    	
    }
    	
}