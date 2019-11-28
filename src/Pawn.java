
public class Pawn extends Piece {
	boolean hasMoved;

	Pawn(Color color) {
		super(color);
		hasMoved = false;
	}

	@Override
	public boolean possibleMoves(Piece[][] board, int currentRow, int currentCol, int newRow, int newCol) {

		if (color.equals(Color.white)) {

			if (currentRow < newRow) {

				return false;
			}
		} else {

			if (newRow > currentRow) {

				return false;
			}
		}
		return true;
	}

	@Override
	public Color getColor() {
		return color;
	}

	public String toString() {
		if (color.equals(Color.black))
			return "BP";
		else
			return "WP";

	}
}
