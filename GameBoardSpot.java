public class GameBoardSpot { 
	
	private Piece piece; 
	private int x; 
	private int y; 

	public GameBoardSpot(int x, int y, Piece piece) 
	{ 
		this.setPiece(piece); 
		this.setX(x); 
		this.setY(y); 
	} 

	public Piece getPiece() 
	{ 
		return this.piece; 
	} 

	public void setPiece(Piece p) 
	{ 
		this.piece = p; 
	} 
	
	public boolean isEmpty() 
	{
		if(this.piece == null) {
			return true;
		} 
		else {
			return false;
		}
	}

	public int getX() 
	{ 
		return this.x; 
	} 

	public void setX(int x) 
	{ 
		this.x = x; 
	} 

	public int getY() 
	{ 
		return this.y; 
	} 

	public void setY(int y) 
	{ 
		this.y = y; 
	} 
} 
