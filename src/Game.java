import java.util.Scanner;

//driver
public class Game {

	public static void main(String[] args) {
		Color color = Color.white;
		Scanner mert = new Scanner(System.in);
		Board board = new Board();
		while (true) {
			// check if there is any possible move
			if (!board.anyPossibleMove(color)) {
				System.out.println("pat");
				System.out.println("hamle kalmadi");
				// restart();//sonradan yazilacak
			}
			System.out.println(board);
			System.out.println(color + " senin siran");
			String move = mert.nextLine();// taking commands as b1 to f4 or "give" or "restart"
			if (move.contains("restart")) {
				// restart();//sonradan yazilacak
			} else if (move.contains("give")) {
				System.out.println("oyun bitti");
				//System.out.println(color.changeColor(color) + " won");
				// restart();//sonradan yazilacak
			} else {
				// have to check after every move if King is in danger
				// for the player who is on move
//				while(board.isinDanger(color)) {
//					//tehlikde oldugunu soyle
//					System.out.println("tehlikede");
//					//hareketi yaptir
//					board.makeMove(move,color);
//					//hala tehlikedeyse geri al
//					//rollback();//sonradan yazilicak
//					// bi daha hareketi yaptir
//				}
				// perform the move
				board.makeMove(move, color);

				// change side
				//color.changeColor(color);
			}

		}

	}

	Color changeColor(Color color) {
		if (color == Color.black) {
			return Color.white;
		} else {
			return Color.black;
		}
	}

}

//nothing works and i don't know why