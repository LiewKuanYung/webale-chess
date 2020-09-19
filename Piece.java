public abstract class Piece
{
	private int currentX;
    private int currentY;
    private String pieceName;
    private String pieceIcon;
    private String color; 
    private boolean captured = false; 
    
    //private MovementBehavior movement;

	public Piece(int currentX, int currentY, String color) 
	{ 
		this.currentX = currentX;
		this.currentY = currentY;
		this.color = color;
	} 
	
	public int getCurrentX()
	{
		return currentX;
	}
	
	public int getCurrentY()
	{
		return currentY;
	}
	
	public String getPieceName() 
	{ 
		return pieceName;
	}
	
	public void setPieceName(String pieceName) 
	{ 
		this.pieceName = pieceName;
	}
	
	public String getPieceIcon() 
	{ 
		return pieceIcon;
	}

	public String getColor() 
	{ 
		return color; 
	}  

	public boolean isCaptured() 
	{ 
		return this.captured == true; 
	} 

	public void setCaptured(boolean captured) 
	{ 
		this.captured = captured; 
	} 
    
    //Validate move
    public abstract boolean isValidMove(GameBoard board, GameBoardSpot start, GameBoardSpot end);
	
    //Move the piece
    //public abstract void move(GameBoard board, Spot start, Spot end);
    

}