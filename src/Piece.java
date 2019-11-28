
public abstract class Piece {
	Color color;

	Piece(Color color) {
		this.color = color;
	}

	public abstract Color getColor();

	public abstract boolean possibleMoves(Piece[][]board, int currentRow, int currentCol, int newRow, int newCol);
	//hareketleri tahtaya gore ayarlama taslara ozellik olarak ver

}
 