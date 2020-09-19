public class GameBoard { 
	
	GameBoardSpot[][] boxes = new GameBoardSpot[8][7]; 

	public GameBoard() 
	{ 
		this.resetBoard(); 
	} 

	//get information on particular spot
	public GameBoardSpot getSpot(int x, int y) throws Exception 
	{ 

		if (x < 0 || x > 7 || y < 0 || y > 8) { 
			throw new Exception("GameBoard Exception: Index out of bound"); 
		} 
		
		System.out.println("Result: X = " + boxes[x][y].getX() + " Y = " + boxes[x][y].getY());
		
		if(!boxes[x][y].isEmpty()) {
			System.out.println(boxes[x][y].getPiece().getPieceName());
		}
		
		return boxes[x][y]; 
	} 

	
	public void resetBoard ()
	{
		/*
	    for (int i=0; i<player.getChess().size(); i++ )
	    {
	        boxes[player.getChess.get(i).getX()] [player.getChess.get(i).getY()] = player.getChess.get(i);
	    }
	    
	    for(int i = 2; i < 6; i++)
	    {
	        for(int j = 0; j < 8; j++)
	        {
	            boxes[i][j] = new Spot (i , j ,null);
	        } 
		} 
		*/
		
		for(int i = 0; i < 8; i++)
	    {
	        for(int j = 0; j < 7; j++)
	        {
	            boxes[i][j] = new GameBoardSpot (i , j ,null);
	        } 
		} 
		
		boxes[7][0].setPiece(new Sun(0,7,"Red"));
	} 
} 
