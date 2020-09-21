import java.util.ArrayList;

public class GameBoard { 
	
	//store its own instance for singleton
	public static GameBoard firstInstance = null; 
	
	//board elements
	private GameBoardSpot[][] boxes = new GameBoardSpot[8][7]; 
	private ArrayList<Piece> redPieceList = new ArrayList<>(); 
	private ArrayList<Piece> bluePieceList = new ArrayList<>(); 

	//private constructor not allow other program to instantiate this class
	private GameBoard() 
	{ 
		//this.resetBoard(); 
	} 
	
	public static GameBoard getInstance() { //Singleton: get instance being created
		if(firstInstance == null) {
			
			// Use synchronized when the first object is created
			synchronized(GameBoard.class){ 

				if(firstInstance == null) {
					
					// If the instance isn't needed it isn't created
					// This is known as lazy instantiation
					firstInstance = new GameBoard();

				}
			}
		}	
		
		return firstInstance;
	}

	//get information on particular spot
	public GameBoardSpot getSpot(int x, int y) throws Exception 
	{ 

		if (x < 0 || x > 7 || y < 0 || y > 8) { 
			throw new Exception("GameBoard Exception: Index out of bound"); 
		} 
		
		/*****For Back-end Checking Purpose *****/
		System.out.print("Result: X:" + boxes[y][x].getX() + " Y:" + boxes[y][x].getY()+"  ");
		if(!boxes[y][x].isEmpty()) { System.out.println(boxes[y][x].getPiece().getPieceInfo());}
		else if (boxes[y][x].isEmpty()) {System.out.println("Empty");}
		/*****For Back-end Checking Purpose *****/
		
		
		return boxes[y][x]; 
	} 
	
	public ArrayList<Piece> getBluePieceList() {
		return bluePieceList;
	}
	
	public ArrayList<Piece> getRedPieceList() {
		return redPieceList;
	}
	
	public void changePlusAndTriangle(int x, int y) throws Exception  {
		String color = getSpot(x, y).getPiece().getColor();
		if(getSpot(x, y).getPiece() instanceof Plus) {
			getSpot(x,y).setPiece( new Triangle(x, y, color) );
			System.out.print("Change Plus to Triangle");
		} else if (getSpot(x, y).getPiece() instanceof Triangle) {
			getSpot(x,y).setPiece( new Plus(x, y, color) );
			System.out.print("Change Plus to Triangle");
		} else {
			throw new Exception("GameBoard Exception: changePlusAndTriangle");
		}
		
	}
	
	public void resetBoard ()
	{	
		redPieceList.clear();
		bluePieceList.clear();
		
		//Fill up all boxes with null first
		for(int i = 0; i < 8; i++) //Y axis
	    {
	        for(int j = 0; j < 7; j++) //X axis
	        {
	            boxes[i][j] = new GameBoardSpot (j , i ,null);
	        } 
		} 
		int r = 7; //Red
		int b = 0; //blue
		String color1 = "R";
		String color2 = "B";
		
		//Initialize Red Player
		redPieceList.add(new Sun(3, r, color1));
		redPieceList.add(new Chevron(2, r, color1));
		redPieceList.add(new Chevron(4, r, color1));
		redPieceList.add(new Triangle(1, r, color1));
		redPieceList.add(new Triangle(5, r, color1));
		redPieceList.add(new Plus(0, r, color1));
		redPieceList.add(new Plus(6, r, color1));
        for(int i=0; i<4 ;i++)
        {
        	redPieceList.add(new Arrow(i*2, r-1, color1));
        }
		
		boxes[r][3].setPiece(redPieceList.get(0));
		boxes[r][2].setPiece(redPieceList.get(1));
		boxes[r][4].setPiece(redPieceList.get(2));
		boxes[r][1].setPiece(redPieceList.get(3));
		boxes[r][5].setPiece(redPieceList.get(4));
		boxes[r][0].setPiece(redPieceList.get(5));
		boxes[r][6].setPiece(redPieceList.get(6));
        for(int i=0; i<4 ;i++)
        {
        	boxes[r-1][i*2].setPiece(redPieceList.get(7+i));
        }
        
        //Initialize Blue Player
        bluePieceList.add(new Sun(3, b, color2));
		bluePieceList.add(new Chevron(2, b, color2));
		bluePieceList.add(new Chevron(4, b, color2));
		bluePieceList.add(new Triangle(1, b, color2));
		bluePieceList.add(new Triangle(5, b, color2));
		bluePieceList.add(new Plus(0, b, color2));
		bluePieceList.add(new Plus(6, b, color2));
        for(int i=0; i<4 ;i++)
        {
        	bluePieceList.add(new Arrow(i*2, b+1, color2));
        }
		boxes[b][3].setPiece(bluePieceList.get(0));
		boxes[b][2].setPiece(bluePieceList.get(1));
		boxes[b][4].setPiece(bluePieceList.get(2));
		boxes[b][1].setPiece(bluePieceList.get(3));
		boxes[b][5].setPiece(bluePieceList.get(4));
		boxes[b][0].setPiece(bluePieceList.get(5));
		boxes[b][6].setPiece(bluePieceList.get(6));
		boxes[b+1][0].setPiece(bluePieceList.get(7));
        for(int i=0; i<4 ;i++)
        {
        	boxes[b+1][i*2].setPiece(bluePieceList.get(7+i));
        }
	}
	
	
	public void loadBoard (ArrayList<String> loadPiecesList)
	{	
		redPieceList.clear();
		bluePieceList.clear();
		
		//Fill up all boxes with null first
		for(int i = 0; i < 8; i++) //Y axis
		{
			for(int j = 0; j < 7; j++) //X axis
			{
				boxes[i][j] = new GameBoardSpot (j , i ,null);
			} 
		} 
		
		int redCount = 0;
		int blueCount = 0;
		String red = "R";
		String blue = "B";
		System.out.println(loadPiecesList.size());
		for(int i = 0; i < loadPiecesList.size(); i++) {

			System.out.println(loadPiecesList.get(i));
			char info[] = new char[4];
			info[0] = loadPiecesList.get(i).charAt(0);
			info[1] = loadPiecesList.get(i).charAt(1);
			info[2] = loadPiecesList.get(i).charAt(2);
			info[3] = loadPiecesList.get(i).charAt(3);
			String pieceName = String.valueOf(info);
			int x = Character.getNumericValue(loadPiecesList.get(i).charAt(4));
			int y = Character.getNumericValue(loadPiecesList.get(i).charAt(5));
			System.out.println("loadBoard " + pieceName +" " + x + y);
			switch(pieceName) 
			{
			case "SUNR" :
				redPieceList.add(new Sun(x, y, red));
				boxes[y][x].setPiece(redPieceList.get(redCount));
				redCount++;
				System.out.println("***** ***** Check SUN ***** *****");
				break;
			case "PLSR" :
				redPieceList.add(new Plus(x, y, red));
				boxes[y][x].setPiece(redPieceList.get(redCount));
				redCount++;
				break;
			case "TRIR" :
				redPieceList.add(new Triangle(x, y, red));
				boxes[y][x].setPiece(redPieceList.get(redCount));
				redCount++;
				break;
			case "CHVR" :
				redPieceList.add(new Chevron(x, y, red));
				boxes[y][x].setPiece(redPieceList.get(redCount));
				redCount++;
				break;
			case "ARRR" :
				redPieceList.add(new Arrow(x, y, red));
				boxes[y][x].setPiece(redPieceList.get(redCount));
				redCount++;
				break;
			case "SUNB" :
				bluePieceList.add(new Sun(x, y, blue));
				boxes[y][x].setPiece(bluePieceList.get(blueCount));
				blueCount++;
				System.out.println("***** ***** Check SUN B ***** *****");
				break;
			case "PLSB" :
				bluePieceList.add(new Plus(x, y, blue));
				boxes[y][x].setPiece(bluePieceList.get(blueCount));
				blueCount++;
				break;
			case "TRIB" :
				bluePieceList.add(new Triangle(x, y, blue));
				boxes[y][x].setPiece(bluePieceList.get(blueCount));
				blueCount++;
				break;
			case "CHVB" :
				bluePieceList.add(new Chevron(x, y, blue));
				boxes[y][x].setPiece(bluePieceList.get(blueCount));
				blueCount++;
				break;
			case "ARRB" :
				bluePieceList.add(new Arrow(x, y, blue));
				boxes[y][x].setPiece(bluePieceList.get(blueCount));
				blueCount++;
				break;
			}	
		}	
	}

} 
