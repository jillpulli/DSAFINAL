package queens;

/**
 * Solve the n Queens problem
 * @author Jill
 *
 */
public class Game {
	static final int SIZE = 12;		//size of board, also # of queens
	
	public static void main(String[] args){
		Game game = new Game();
		System.out.println(game.placeQueens(0, new Board()));	//place queens on an empty board
	}
	
	/**
	 * @param b A Board on which queens have been safely placed
	 * in cols 0...col-1
	 * 
	 * @return a Board on which queens have been safely placed in all columns,
	 * or null if not possible.
	 */
	private Board placeQueens(int col, Board b){
		Position p;
		Board result;
		
		for (int row = 0; row < SIZE; row++){
			p = new Position(row, col);
			result = new Board(b);			//copy of given Board
											//dont clobber b
			result.addQueen(p);
			if (result.ok()){
				if (col < SIZE-1){			//last column?
					result = placeQueens(col+1, result);
					if (result != null){
						return result;		//success
					}
					
				}
				else{
					return result;		//base case
				}
			}
		}
		return null;
	}
	
}
