public class Triangle extends Piece
{
    Triangle(int x, int y, String color)
    {
    	super(x,y,color);
    	String pieceName = "TRI";
    	super.setPieceName(pieceName);
    	if(color == "R") {
    		super.setPieceIcon("images/Red_Triangle.png");
    	} else {
    		super.setPieceIcon("images/Blue_Triangle.png");
    	}
    	
    	movementType = new MovementDiagonal();
        
    }
    
    public boolean isValidMove(GameBoard board, GameBoardSpot start, GameBoardSpot end)//check if the clicked mouse position is an ally or not, if ally then return false else proceed to do checking for obstacles
    {
    	if (end.getPiece() != null) {
	        if (super.getColor() == end.getPiece().getColor())//check if the clicked mouse position is an ally or not, if ally then return false else proceed to do checking for obstacles
	        {
	            return false;//if the end spot is ally then return false
	        }
    	} 
 
    	//check for obstacle
    	return movementType.checkValidMove(board, start, end, false);

    }
}