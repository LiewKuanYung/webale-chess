public abstract class Piece
{
	private int currentX;
    private int currentY;
    private String pieceName;
    private String pieceIcon;
    private String color; 
    private boolean captured = false; 
    protected MovementBehavior movementType;

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
	
	public void setCurrentXY(int newX, int newY) {
		this.currentX = newX;
		this.currentY = newY;
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
	
	public void setPieceIcon(String pieceIcon) 
	{ 
		this.pieceIcon = pieceIcon;
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
	
	public String getPieceInfo() {
		return (String.valueOf(currentX) + String.valueOf(currentY) + pieceName + color);
	}
	
	public void move(int startX, int startY, int endX, int endY) {
    	int tempx = endX - startX;
    	int tempy = endY - startY;
    	setCurrentXY((getCurrentX()+tempx), (getCurrentY()+tempy));
    }
    
	//For dynamic changes
	public void setMovementBehavior(MovementBehavior type) {
		this.movementType = type;
	}
	
    //Validate move
    public abstract boolean isValidMove(GameBoard board, GameBoardSpot start, GameBoardSpot end);   
    
}