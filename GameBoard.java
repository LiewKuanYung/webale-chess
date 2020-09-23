/**
 * @author Liew Kuan Yung
 * @ID 1191301064
 */

import java.util.ArrayList;
import java.util.Arrays;

public class GameBoard { 
	
	//store its own instance for singleton
	public static GameBoard firstInstance = null; 
	
	//board elements
	private GameBoardSpot[][] boxes = new GameBoardSpot[8][7];  

	//private constructor not allow other program to instantiate this class
	private GameBoard() 
	{ 
		this.resetBoard(); 
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
		
		/*****For Back-end Checking Purpose *****
		System.out.print("Result: X:" + boxes[y][x].getX() + " Y:" + boxes[y][x].getY()+"  ");
		if(!boxes[y][x].isEmpty()) { System.out.println(boxes[y][x].getPiece().getPieceInfo());}
		else if (boxes[y][x].isEmpty()) {System.out.println("Empty");}
		/*****For Back-end Checking Purpose *****/
		
		
		return boxes[y][x]; 
	} 
	
	public GameBoardSpot[][] getEntireGameBoardSpot(){
		System.out.println("getEntireGameBoardSpot");
		for(int i = 0; i < 8; i++) { //Y axis
	        for(int j = 0; j < 7; j++) { //X axis
	        	if (boxes[i][j].getPiece() == null) {
	        		System.out.print("null   ");
	        	} else {
	        		System.out.print(boxes[i][j].getPiece().getPieceInfo() + " ");
	            }
	        } System.out.print("\n");
		} 
		return boxes;
	}
	
	
	public void changePlusAndTriangle(int x, int y) throws Exception  {
		String color = getSpot(x, y).getPiece().getColor();
		if(getSpot(x, y).getPiece() instanceof Plus) {
			getSpot(x,y).setPiece( new Triangle(x, y, color) );
			System.out.println("Change Plus to Triangle");
		} else if (getSpot(x, y).getPiece() instanceof Triangle) {
			getSpot(x,y).setPiece( new Plus(x, y, color) );
			System.out.println("Change Triangle to Plus");
		} else {
			throw new Exception("GameBoard Exception: changePlusAndTriangle");
		}
	}
	
	
	/**
	 * x size = 7
	 * y size = 8
	 * 
	 * Coordinate of the boxes
	 * XY XY XY . . XY
	 * 00 10 20 . . 60
	 * 01 11
	 * 02	  .
	 * .        .
	 * .		  .
	 * 07			67
	 */
	public void resetBoard ()
	{	
		//Clear Array fill up all boxes with null 
		for(int i = 0; i < 8; i++) //Y axis
	    {
	        for(int j = 0; j < 7; j++) //X axis
	        {
	            boxes[i][j] = new GameBoardSpot (j , i ,null);
	        } 
		} 
		int r = 7; //Red at bottom
		int b = 0; //blue at top
		String color1 = "R";
		String color2 = "B";
		
		//Initialize Red Player
		boxes[r][3].setPiece(new Sun(3, r, color1));
		boxes[r][2].setPiece(new Chevron(2, r, color1));
		boxes[r][4].setPiece(new Chevron(4, r, color1));
		boxes[r][1].setPiece(new Triangle(1, r, color1));
		boxes[r][5].setPiece(new Triangle(5, r, color1));
		boxes[r][0].setPiece(new Plus(0, r, color1));
		boxes[r][6].setPiece(new Plus(6, r, color1));
        for(int i=0; i<4 ;i++)
        {
        	boxes[r-1][i*2].setPiece(new Arrow(i*2, r-1, color1));
        }
        
        //Initialize Blue Player
		boxes[b][3].setPiece(new Sun(3, b, color2));
		boxes[b][2].setPiece(new Chevron(2, b, color2));
		boxes[b][4].setPiece(new Chevron(4, b, color2));
		boxes[b][1].setPiece(new Triangle(1, b, color2));
		boxes[b][5].setPiece(new Triangle(5, b, color2));
		boxes[b][0].setPiece(new Plus(0, b, color2));
		boxes[b][6].setPiece(new Plus(6, b, color2));
        for(int i=0; i<4 ;i++)
        {
        	boxes[b+1][i*2].setPiece(new Arrow(i*2, b+1, color2));
        }
	}
	
	
	public void loadBoard (ArrayList<String> loadPiecesList)
	{
		//Fill up all boxes with null first
		for(int i = 0; i < 8; i++) //Y axis
		{
			for(int j = 0; j < 7; j++) //X axis
			{
				boxes[i][j] = new GameBoardSpot (j , i ,null);
			} 
		} 

		System.out.println("Total pieces: "+loadPiecesList.size());
		
		for(int i = 0; i < loadPiecesList.size(); i++) {

			System.out.println(loadPiecesList.get(i));
			char info[] = new char[3];
			info[0] = loadPiecesList.get(i).charAt(0);
			info[1] = loadPiecesList.get(i).charAt(1);
			info[2] = loadPiecesList.get(i).charAt(2);
			String pieceName = String.valueOf(info);
			String color;
			if('R' == loadPiecesList.get(i).charAt(3)) {
				color = "R";
			} else {
				color = "B";
			}
			int x = Character.getNumericValue(loadPiecesList.get(i).charAt(4));
			int y = Character.getNumericValue(loadPiecesList.get(i).charAt(5));
			System.out.println("loadBoard " + pieceName + color + " " + x + y);
			switch(pieceName) 
			{
			case "SUN" :
				boxes[y][x].setPiece(new Sun(x, y, color));
				break;
			case "PLS" :
				boxes[y][x].setPiece(new Plus(x, y, color));
				break;
			case "TRI" :
				boxes[y][x].setPiece(new Triangle(x, y, color));
				break;
			case "CHV" :
				boxes[y][x].setPiece(new Chevron(x, y, color));
				break;
			case "ARR" :
				boxes[y][x].setPiece(new Arrow(x, y, color));
				break;
			default :
				System.out.print("\n\n\n\n ***************\n" 
							   + "ERROR INVALID PIECES"
							   + "PLEASE CHECK LOAD FILE"
						       + "\n ***************\n\n\n");
			}
		}	
	}
} 
