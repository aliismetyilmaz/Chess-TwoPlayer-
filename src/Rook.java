//rok eklememiz lazim buna
public class Rook extends Piece {

	Rook(Color color) {
		super(color);

	}

	@Override
	public boolean possibleMoves(Piece[][] board, int currentRow, int currentCol, int newRow, int newCol) {

		if (currentRow != newRow && currentCol != newCol) {
			System.out.println("Can move duz gider sadece");
			return false;
		}

		// need to hava a direction
		int direction;
		// if it goes by row
		if (currentRow != newRow) {
			// finding the direction
			if (currentRow < newRow) {
				direction = 1;
			} else {
				direction = -1;
			}
			// checking the way
			for (int x = currentRow + direction; x != newRow; x += direction) {
				if (board[x][currentCol] != null) {
					System.out.println("yol veya gidecegin yer dolu");
					return false;
				}
			}
		}

		// if it goes by column
		if (currentCol != newCol) {
			// finding the direction
			if (currentCol < newCol) {
				direction = 1;
			} else {
				direction = -1;
			}
			// checking the way
			for (int x = currentCol + direction; x != newCol; x += direction) {// yol kontrolu
				if (board[currentRow][x] != null) {
					System.out.println("yol veya gidecegin yer dolu");
					return false;
				}
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
			return "BR";
		else
			return "WR";

	}

}
