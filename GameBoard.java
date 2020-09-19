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
		
		/*****For Checking Purpose *****/
		System.out.println("Result: X = " + boxes[x][y].getX() + " Y = " + boxes[x][y].getY());
		if(!boxes[x][y].isEmpty()) { System.out.println(boxes[x][y].getPiece().getPieceInfo());}
		else if (boxes[x][y].isEmpty()) {System.out.println("Empty");}
		/*****For Checking Purpose *****/
		
		
		return boxes[x][y]; 
	} 

	
	public void resetBoard ()
	{
		/*
	    for (int i=0; i<player.getChess().size(); i++ )
	    {
	        boxes[player.getChess.get(i).getX()] [player.getChess.get(i).getY()] = player.getChess.get(i);
	    }
		*/
		
		for(int i = 0; i < 8; i++)
	    {
	        for(int j = 0; j < 7; j++)
	        {
	            boxes[i][j] = new GameBoardSpot (i , j ,null);
	        } 
		} 
		int a = 0;
		int b = 7;
		String color1 = "R";
		String color2 = "R";
		
		boxes[a][3].setPiece(new Sun(3, a, color1));
		boxes[a][2].setPiece(new Chevron(2, a, color1));
		boxes[a][4].setPiece(new Chevron(4, a, color1));
		boxes[a][1].setPiece(new Triangle(1, a, color1));
		boxes[a][5].setPiece(new Triangle(5, a, color1));
		boxes[a][0].setPiece(new Plus(0, a, color1));
		boxes[a][6].setPiece(new Plus(6, a, color1));
        for(int i=0; i<4 ;i++)
        {
        	boxes[a+1][i*2].setPiece(new Arrow(i*2, a+1, color1));
        }
        
        boxes[b][3].setPiece(new Sun(3, b, color2));
		boxes[b][2].setPiece(new Chevron(2, b, color2));
		boxes[b][4].setPiece(new Chevron(4, b, color2));
		boxes[b][1].setPiece(new Triangle(1, b, color2));
		boxes[b][5].setPiece(new Triangle(5, b, color2));
		boxes[b][0].setPiece(new Plus(0, b, color2));
		boxes[b][6].setPiece(new Plus(6, b, color2));
        for(int i=0; i<4 ;i++)
        {
        	boxes[b-1][i*2].setPiece(new Arrow(i*2, a+1, color2));
        }
	} 
} 
