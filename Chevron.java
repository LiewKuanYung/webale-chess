/**
 * @author Eugene 
 */
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
    	movementType = new MovementLShape();
    }
    
    public boolean isValidMove(GameBoard board, GameBoardSpot start, GameBoardSpot end)//check if the clicked mouse position is an ally or not, if ally then return false else proceed to do checking for obstacles
    {
    	//check if the clicked mouse position is an ally or not, if ally then return false else proceed to do checking for obstacles
    	if(end.getPiece() != null) {
	        if (super.getColor() == end.getPiece().getColor())
	        {
	            return false;//if the end spot is ally then return false
	        }
	    }
        
    	//else check movement
    	return movementType.checkValidMove(board, start, end, false);
    }
}