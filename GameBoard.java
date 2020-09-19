public class GameBoard { 
	
	Spot[][] boxes; 

	public GameBoard() 
	{ 
		this.resetBoard(); 
	} 

	//get information on particular spot
	public Spot getSpot(int x, int y) throws Exception 
	{ 

		if (x < 0 || x > 8 || y < 0 || y > 7) { 
			throw new Exception("Index out of bound"); 
		} 
		
		System.out.println("Result: X = " + boxes[x][y].getX() + " Y = " + boxes[x][y].getY());
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
	} 
} 
