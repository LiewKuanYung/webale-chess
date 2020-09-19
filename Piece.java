public abstract class Piece
{
	private int currentX;
    private int currentY;
    private MovementBehavior mb;
    private boolean captured = false; 
	private boolean red = false; 

	public Piece(boolean red) 
	{ 
		this.setWhite(red); 
	} 

	public boolean isRed() 
	{ 
		return this.red == true; 
	} 

	public void setWhite(boolean red) 
	{ 
		this.red = red; 
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
    public abstract boolean isValidMove(GameBoard board, Spot start, Spot end);
	
    //Move the piece
    public abstract void move(GameBoard board, Spot start, Spot end);
    

}