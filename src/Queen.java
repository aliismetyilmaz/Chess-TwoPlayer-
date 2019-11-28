
public class Queen extends Piece {

	Queen(Color color) {
		super(color);
	}

	@Override
	public boolean possibleMoves(Piece[][] board, int currentRow, int currentCol, int newRow, int newCol) {
		// can make every move that rook or bishop does
		return new Rook(color).possibleMoves(board, currentRow, currentCol, newRow, newCol)
				|| new Bishop(color).possibleMoves(board, currentRow, currentCol, newRow, newCol);

	}

	@Override
	public Color getColor() {
		return color;
	}

	public String toString() {
		if (color.equals(Color.black))
			return "BQ";
		else 
			return "WQ";

	}

}
