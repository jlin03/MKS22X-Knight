import java.util.Arrays;
public class KnightBoard {
	private int[][] board;
	public int[][] decisionBoard;
	public int[][] possibleMoves = {{1,2},{1,-2},{2,1},{2,-1},{-1,2},{-1,-2},{-2,1},{-2,-1}};
	
	public KnightBoard(int startingRows,int startingCols) {
		board = new int[startingRows][startingCols];
		decisionBoard = new int[startingRows][startingCols];
		generateWeights();
	}
	
	public void generateWeights() {
		for(int r = 0; r < decisionBoard.length; r++) {				//for every row
			for(int c = 0; c < decisionBoard[r].length; c++) {		//for every col
				for(int n = 0; n < possibleMoves.length; n++) {		// loop through possible moves and ++ at the point r,c if it is valid
					if(r+possibleMoves[n][0] >= 0 && r+possibleMoves[n][0] < decisionBoard.length && c+possibleMoves[n][1] >= 0 && c+possibleMoves[n][1] < decisionBoard[0].length) {
						decisionBoard[r][c]++;
					}
				}
			}
		}
	}
	
	
	
	public String toString() {
		String out = "";
		for(int r = 0; r < decisionBoard.length; r++) {
			for(int c = 0; c < decisionBoard[r].length; c++) {
				if(decisionBoard.length * decisionBoard[r].length >= 10 && board[r][c] < 10) {
				out += " " + board[r][c] + " ";
				}
				else {
					out += board[r][c] + " ";
				}
			}
			out += "\n";
		}
		return out;
	}
	
	public static void main(String[] args) {
		KnightBoard x = new KnightBoard(5,5);
		System.out.println(x);
	}
}