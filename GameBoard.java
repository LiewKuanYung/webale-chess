import java.util.ArrayList;

public class GameBoard { 
	
	GameBoardSpot[][] boxes = new GameBoardSpot[8][7]; 
	ArrayList<Piece> redPieceList = new ArrayList<>(); 
	ArrayList<Piece> bluePieceList = new ArrayList<>(); 

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
		
		/*****For Back-end Checking Purpose *****/
		System.out.println("Result: X:" + boxes[y][x].getX() + " Y:" + boxes[y][x].getY());
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
	
	public void changePlusAndTriangle(Piece...pieces) {
		for(int i = 0; i<pieces.length; i++) {
			if(pieces[i] instanceof Plus) {
				System.out.print(pieces[i].getPieceInfo() + pieces[i].getCurrentX() 
						+ pieces[i].getCurrentY()+ "Is Instance Of Plus");
			} else if (pieces[i] instanceof Triangle) {
				System.out.print(pieces[i].getPieceInfo() + pieces[i].getCurrentX() 
						+ pieces[i].getCurrentY()+ "Is Instance Of Triange");
			}
		}
		
	}


	
	public void resetBoard ()
	{	
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
} 
