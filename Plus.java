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
    }
    
    @Override
    public boolean isValidMove(GameBoard board, GameBoardSpot start, GameBoardSpot end)
    {
    	System.out.println("Plus Check Point 1");
    	//Check if "end" has same color with "current"
    	
    	if(end.getPiece() != null) {
	    	if (super.getColor() == end.getPiece().getColor())
	    	{
	            return false;//if the end spot is ally then return false
	        }
    	}
        
    	//else check for obstacle
    	return movementType.checkValidMove(board, start, end, false);
    	
    }
    	
}