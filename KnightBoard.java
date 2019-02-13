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
		decisionBoard = new int[board.length][board[0].length];
		for(int r = 0; r < decisionBoard.length; r++) {				//for every row
			for(int c = 0; c < decisionBoard[r].length; c++) {		//for every col
				for(int n = 0; n < possibleMoves.length; n++) {		// loop through possible moves and ++ at the point r,c if it is valid
					if(r+possibleMoves[n][0] >= 0 && r+possibleMoves[n][0] < decisionBoard.length && c+possibleMoves[n][1] >= 0 && c+possibleMoves[n][1] < decisionBoard[0].length && board[r+possibleMoves[n][0]][c+possibleMoves[n][1]] == 0) {
						decisionBoard[r][c]++;
					}
				}
			}
		}
	}

	public boolean solve(int startRow, int startCol) {
		return solveH(startRow,startCol,1);
	}

	public boolean solveH(int r, int c, int pos) {
		if(pos == 25) {
			board[r][c] = pos;
			return true;
		}
		int[][] moves = getMoves(r,c);
		board[r][c] = pos;
		System.out.println(moves.length);
		System.out.println(this);
		for(int i = 0; i < moves.length; i++) {
			if(solveH(moves[i][1],moves[i][2],pos+1)) {
				return true;
			}
		}
		board[r][c] = 0;
		return false;
	}
	
	public int countSolutions(int startRow, int startCol) {
		return cSH(startRow,startCol,1,0);
	}
	
	public int cSH(int r, int c, int pos, int sol) {
		if(pos == 25) {
			sol++;
		}
		int[][] moves = getMoves(r,c);
		board[r][c] = pos;
		System.out.println(moves.length);
		System.out.println(this);
		for(int i = 0; i < moves.length; i++) {
			solveH(moves[i][1],moves[i][2],pos+1);
		}
		board[r][c] = 0;
		return sol;
	}

	public int[][] getMoves(int r, int c) {
		generateWeights();
		int[][] moves = new int[decisionBoard[r][c]][3];
		int i = 0;
		if(decisionBoard[r][c] > 0) {
			for(int n = 0; n < possibleMoves.length; n++) {
				if(r+possibleMoves[n][0] >= 0 && r+possibleMoves[n][0] < decisionBoard.length && c+possibleMoves[n][1] >= 0 && c+possibleMoves[n][1] < decisionBoard[0].length && board[r+possibleMoves[n][0]][c+possibleMoves[n][1]] == 0) {
					moves[i][0] = decisionBoard[r+possibleMoves[n][0]][c+possibleMoves[n][1]];
					moves[i][1] = r+possibleMoves[n][0];
					moves[i][2] = c+possibleMoves[n][1];
					i++;
				}
			}
			return sort(moves);
		}
		return moves;
	}




	public int[][] sort(int[][] ary) {
		if(ary.length == 1) {
			return ary;
		}
		else {
			int n = 0;
			int m = ary.length/2;
			int[][] temp1 = new int[m][3];
			int[][] temp2 = new int[ary.length-m][3];
			for(int i = 0; i < temp1.length; i++) {
				temp1[i] = ary[n];
				n++;
			}
			for(int i = 0; i < temp2.length; i++) {
				temp2[i] = ary[n];
				n++;
			}
			return merge(sort(temp1),sort(temp2));
		}
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
		for(int r = 0; r < board.length; r++) {
			for(int c = 0; c < board[r].length; c++) {
				if(board[r][c] < 10) {
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
		System.out.println(x.solve(0,0));
		System.out.println(x);


	}
}
