
public class Knight extends Piece {

	Knight(Color color) {
		super(color);
	}

	@Override
	public boolean possibleMoves(Piece[][] board, int currentRow, int currentCol, int newRow, int newCol) {
		// find the length of the diagonal line
		// the lenght of the diagonal line must be equal to 5
		if ((Math.abs(newRow - currentRow) * Math.abs(newRow - currentRow) + Math.abs(newCol - currentCol) * Math.abs(newCol - currentCol)) != 5) {
			return false;
		}
		return true;
	}

	@Override
	public Color getColor() {
		return color;
	}
	
	public String toString(){
		if (color.equals(Color.black))
			return "BN";
		else 
			return "WN";
	}

}
