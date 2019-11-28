
public class King extends Piece {
	// rok yapamiyor suan buyuyunce yapicak
	King(Color color) {
		super(color);
	}

	@Override
	public boolean possibleMoves(Piece[][] boad, int currentRow, int currentCol, int newRow, int newCol) {
		if (Math.abs(newRow - currentRow) > 1 || Math.abs(newCol - currentCol) > 1) {
			System.out.println("Cannot move more than one tile each time");
			return false;
		}
		return true;
	}

	@Override
	public Color getColor() {
		return color;
	}

	public String toString() {
		if (color.equals(Color.black))
			return "BK";
		else 
			return "WK";
	}
}
