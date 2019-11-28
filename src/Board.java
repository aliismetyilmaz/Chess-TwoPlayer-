
public class Board {
	Piece[][] board = new Piece[8][8];

	// constructor
	public Board() {
		createBoard();
	}

	public void createBoard() {
		// create empty board
		for (int x = 0; x < board.length; x++) {
			for (int y = 0; y < board[0].length; y++) {
				board[x][y] = null;
			}
		}
		// placing the black pieces
		board[0][0] = new Rook(Color.black);
		board[0][1] = new Knight(Color.black);
		board[0][2] = new Bishop(Color.black);
		board[0][3] = new Queen(Color.black);
		board[0][4] = new King(Color.black);
		board[0][5] = new Bishop(Color.black);
		board[0][6] = new Knight(Color.black);
		board[0][7] = new Rook(Color.black);
		// placing the black pawns
		for (int i = 0; i < 8; i++) {
			board[1][i] = new Pawn(Color.black);
		}
		// placing the white pieces
		board[7][0] = new Rook(Color.white);
		board[7][1] = new Knight(Color.white);
		board[7][2] = new Bishop(Color.white);
		board[7][3] = new Queen(Color.white);
		board[7][4] = new King(Color.white);
		board[7][5] = new Bishop(Color.white);
		board[7][6] = new Knight(Color.white);
		board[7][7] = new Rook(Color.white);
		// placing the white pawns
		for (int i = 0; i < 8; i++) {
			board[6][i] = new Pawn(Color.white);
		}
	}

	// performing move
	public void makeMove(String move, Color boardcolor) {/// move --> b1 to f5
		String[] moves = move.split(" to ");
		int oldRow = StringToInt(moves[0].substring(0, 1));
		int oldColumn = Integer.parseInt(moves[0].substring(1, 2)) - 1;
		int newRow = StringToInt(moves[1].substring(0, 1));
		int newColumn = Integer.parseInt(moves[1].substring(1, 2)) - 1;

		// check for the performing move for the correct side
		if (board[oldColumn][oldRow].getColor().equals(boardcolor)) {
			// check for the possibility of the requested move
			if (board[oldColumn][oldRow].possibleMoves(board, oldRow, oldColumn, newRow, newColumn)) {
				// check for the kings condition of the requested move
				if (board[oldColumn][oldRow].equals(new King(boardcolor))) {
					for (int x = 0; x < board.length; x++) {
						for (int y = 0; y < board[0].length; y++) {
							if (board[x][y].possibleMoves(board, x, y, newRow, newColumn)) {
								System.out.println("sahi orda yerler yani oyun  iter");
							} else {// performing move
								board[newColumn][newRow] = board[oldColumn][oldRow];
								// empty the old array of the moved piece
								board[oldColumn][oldRow] = null;
							}

						}
					}
				} else {// performing move
					board[newColumn][newRow] = board[oldColumn][oldRow];
					// empty the old array of the moved piece
					board[oldColumn][oldRow] = null;

				}

			}
		} else {
			System.out.println("senin olmayan tasi oynatamazsin tatli cocuk");
		}

	}

	public int StringToInt(String letter) {
		switch (letter) {
		case "a":
			return 0;
		case "b":
			return 1;
		case "c":
			return 2;
		case "d":
			return 3;
		case "e":
			return 4;
		case "f":
			return 5;
		case "g":
			return 6;
		case "h":
			return 7;
		default:
			return 8;
		}
	}

	// to check the condition of the king if it is in danger
	// focused on only King piece for the selected side
	public boolean isinDanger(Color boardcolor) {
		// need to find King's position first
		int[] kingPosition = getKingPosition(boardcolor);
		// scan the entire board by using possibleMoves method for each opponent pieces
		for (int x = 0; x < board.length; x++) {
			for (int y = 0; y < board[0].length; y++) {
				if (board[x][y] != null && board[x][y].getColor() != boardcolor) {
					if (board[x][y].possibleMoves(board, x, y, kingPosition[0], kingPosition[1])) {
						return true;// means King is in danger
					}
				}
			}
		}
		return false;// means King is NOT in danger
	}

	public int[] getKingPosition(Color boardcolor) {
		int row = 0;
		int column = 0;
		// scan the all board to find King's position
		for (int x = 0; x < board.length; x++) {
			for (int y = 0; y < board[0].length; y++) {
				if (board[x][y].equals(new King(boardcolor))) {
					row = x;
					column = y;

				}
			}
		}
		// moving out by using array
		int[] outing = new int[2];
		outing[0] = row;
		outing[1] = column;
		return outing;
	}

	public boolean anyPossibleMove(Color boardcolor) {
		// need to check all possible move of the all left pieces
		// for the side who is on move (hamle sirasi kimdeyse)
		for (int x = 0; x < board.length; x++) {
			for (int y = 0; y < board[0].length; y++) {
				for (int w = 0; w < board.length; w++) {
					for (int z = 0; z < board[0].length; z++) {/// cok complex oldu
						if (board[x][y] != null)
							if (board[x][y].getColor() == (boardcolor)
									&& board[x][y].possibleMoves(board, x, y, w, z)) {
								return true;// means there is at least one possible move
							}
					}

				}
			}
		}
		return false; // means there is no possible move
	}

	public String toString() {
		String string = "";
		int rowCounter = 0;
		for (Piece[] pieces : board) {
			int columnCounter = 0;
			for (Piece piece : pieces) {
				if (piece == null) {
					if (rowCounter % 2 == 0) {
						if (columnCounter % 2 == 0) {
							string += "##";// blacks
						} else {
							string += "  ";// whites
						}
					} else {
						if (columnCounter % 2 == 0) {
							string += "  ";
						} else {
							string += "##";
						}
					}
				} else {
					string += piece;
				}
				string += " ";
				columnCounter++;
			}
			rowCounter++;
			string += "\n";
		}

		String reverseString = "";

		reverseString += "~ a  b  c  d  e  f  g  h \n";
		String[] stringSplit = string.split("\n");
		for (int x = stringSplit.length - 1; x >= 0; x--) {
			reverseString += x + 1 + " " + stringSplit[x] + "\n";
		}
		reverseString += "";

		return reverseString;
	}
// bu methdou bu classta olabildigince kullanmamaya calisacaz
//	public Color changeColor(Color color) {
//		if (color == Color.black) {
//			return Color.white;
//		} else {
//			return Color.black;
//		}
//	}
}
