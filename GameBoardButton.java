import javax.swing.JButton;

class GameBoardButton extends JButton {
	
	private int x; //Column // Horizontal
    private int y; //Row 	// Vertical

    public GameBoardButton(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getCol() {
        return x;
    }

    public int getRow() {
        return y;
    }
}
