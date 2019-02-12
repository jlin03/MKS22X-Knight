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
	
	
	
	
	public int[][] sort(int[][] ary) {
		return null;
	}
	
	public int[][] sH(int[][] ary,int m) {
		return null;
	}
	
	public int[][] merge(int[][] ary1,int[][] ary2) {
		int[][] out = new int[ary1.length+ary2.length][3];
		int o = 0;
		int t = 0;
		int n = 0;
		for(;n < out.length; n++) {
			if(o == ary1.length) {
				for(int i = n; i < out.length; i++) {
					out[i] = ary2[t];
					t++;
				}
				return out;
			}
			if(t == ary2.length) {
				for(int i = n; i < out.length; i++) {
					out[i] = ary1[o];
					o++;
				}
				return out;
			}
			if(ary1[o][0] >= ary2[t][0]) {
				out[n] = ary2[t];
				t++;
			}
			else {
				if(ary1[o][0] < ary2[t][0]) {
					out[n] = ary1[o];
					o++;
				}
			}
		}
		return out;
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
		int[][] test = {{1,2,3},{7,2,1},{10,1,2}};
		int[][] test2 = {{4,2,3},{6,2,1},{8,1,2}};
		System.out.println(Arrays.deepToString(x.merge(test,test2)));
		
	}
}