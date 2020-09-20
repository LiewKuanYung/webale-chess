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
    	System.out.println("Sun Check Point 1");

    	if(end.getPiece() != null) {
	        if (start.getPiece().getColor() == end.getPiece().getColor())//check if the clicked mouse position is an ally or not, if ally then return false else proceed to do checking for obstacles
	        {
	        	System.out.println("Plus Check Point 1.2");
	            return false;//if the end spot is ally then return false
	        }
    	}
    	
    	System.out.println("Plus Check Point 2");
    	int tempx = end.getX() - start.getX();
    	int tempy = end.getY() - start.getY();

    	if (java.lang.Math.abs(tempx) <= 1 && java.lang.Math.abs(tempy) <= 1)
    	{
    		super.setCurrentXY((super.getCurrentX()+tempx), (super.getCurrentY()+tempy));
    		return true;
    	}
    	else //if it is not the movement rule of Sun
    	{
    		return false;
    		//pop up display "Illegal movement"
    	}
    }
}