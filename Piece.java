public class Piece
{
    public MovementBehavior mb;
    
 
    public void move(int x, int y)//the difference of x&y position of the current position of the chess piece and the mouse clicked position
    {
        mb.move(x,y);
    }
}