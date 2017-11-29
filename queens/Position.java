package queens;

/**
 * A Position stores a row number and a column number
 * @author Jill
 *
 */
public class Position {
	int row, col;
	
	public Position(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	public String toString() {
		return "(" + row + ", " + col + ")";
	}
	
	/**
	 * @return true only if a queen in this position is attacking
	 * a queen in another position
	 */
	public boolean isAttacking(Position other) {
		return row == other.row ||		//same row?
				col == other.col || //same col?
				row+col == other.row+ other.col ||	//same major diagonal
				row-col == other.row- other.col; 	//same minor diagonal
	}
	
	/**
	 * @return true only if object is a Position, 
	 * and this Position has same row and col as the other Position
	 */
	public boolean equals(Object obj){
		if (! (obj instanceof Position)){
			return false;
		}
		Position other = (Position) obj;
		return row == other.row && col == other.col;
	}

}
