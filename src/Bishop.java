
public class Bishop extends Piece {

	Bishop(Color color) {
		super(color);
	}

	@Override
	public boolean possibleMoves(Piece[][] board, int currentRow, int currentCol, int newRow, int newCol) {
		if (currentRow == newRow || currentCol == newCol) {
			System.out.println("Can move diagonally");
			return false;
		}

		if ((newRow - currentRow) != (newCol - currentCol)) {
			return false;
		}
		// checking the way
		int rowDir, colDir;
		// finding the direction
		if (currentRow < newRow) {
			rowDir = 1;
		} else {
			rowDir = -1;
		}
		if (currentCol < newCol) {
			colDir = 1;
		} else {
			colDir = -1;
		}
		// to check the move if it is diagonal
		if ((newRow - currentRow) == (newCol - currentCol)) {
			//make first move on y
			int y = currentCol + colDir;
			// continue to make move one by one in both axis
			for (int x = currentRow + rowDir; x != newRow; x += rowDir) {
				if (board[x][y] != null) {
					return false;
				}
				// on y
				y += colDir;
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
			return "BB";
		else 
			return "WB";

	}

}
