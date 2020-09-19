import java.util.*;

public class Player
{
    public boolean player1;
    public boolean player2;
    int a = 0;
    int b = 7;
    private ArrayList<Piece> chess = new ArrayList<>(); 

    public Player(boolean isPlayer1)
    {
        this.player1 = isPlayer1;
        this.player2 = (!isPlayer1);
        //addchess();
    }

    public ArrayList<Piece> getChess()
    {
        return chess;
    }

    //Initialize the chess piece according to the player's color
    /*
    public void addchess()
    {
        if(player1 == true)
        {
            chess.add(new Sun(3, a, red));
            chess.add(new Chevron(2, a, red));
            chess.add(new Chevron(4, a, red));
            chess.add(new Triangle(1, a, red));
            chess.add(new Triangle(5, a, red));
            chess.add(new Plus(0, a, red));
            chess.add(new Plus(6, a, red));
            for(int i=0; i<4 ;i++)
            {
                chess.add(new Arrow(i*2, a+1, red));
            }
        }
        else
        {
            chess.add(new Sun(3, b, red));
            chess.add(new Chevron(2, b, red));
            chess.add(new Chevron(4, b, red));
            chess.add(new Triangle(1, b, red));
            chess.add(new Triangle(5, b, red));
            chess.add(new Plus(0, b, red));
            chess.add(new Plus(6, b, red));
            for(int i=0; i<4 ;i++)
            {
                chess.add(new Arrow(i*2, b-1, red));
            }
        }

        if(player2 == true)
        {
            chess.add(new Sun(3, b, blue));
            chess.add(new Chevron(2, b, blue));
            chess.add(new Chevron(4, b, blue));
            chess.add(new Triangle(1, b, blue));
            chess.add(new Triangle(5, b, blue));
            chess.add(new Plus(0, b, blue));
            chess.add(new Plus(6, b, blue));
            for(int i=0; i<4 ;i++)
            {
                chess.add(new Arrow(i*2, b-1, blue));
            }
        }
        else
        {
            chess.add(new Sun(3, a, blue));
            chess.add(new Chevron(2, a, blue));
            chess.add(new Chevron(4, a, blue));
            chess.add(new Triangle(1, a, blue));
            chess.add(new Triangle(5, a, blue));
            chess.add(new Plus(0, a, blue));
            chess.add(new Plus(6, a, blue));
            for(int i=0; i<4 ;i++)
            {
                chess.add(new Arrow(i*2, a+1, blue));
            }
        }
        
    }/**/
}