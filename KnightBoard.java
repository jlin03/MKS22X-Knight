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
		
		
	}
	
	
	public static void main(String[] args) {
		KnightBoard x = new KnightBoard(2,3);
		System.out.println(Arrays.deepToString(x.decisionBoard));
		
	}
}