package queens;

import list.*;

/**
 * A chess Board can have 0 or more queens in diff positions
 * @author Jill
 *
 */
public class Board {
	List<Position> queens;		//the positions on which queens have been placed
	
	public Board(){
		queens = new LinkedList<Position>();	//an empty board
	}
	
	//a copy constructor
	public Board(Board b){
		queens = new LinkedList<Position>(b.queens);
	}
	
	/**
	 * put a queen onto this Board at the given position
	 */
	public void addQueen(Position p){
		queens.add(p);
	}
	
	/**
	 * @return true only if no queens are attacking any other
	 * 	queens on this Board
	 */
	public boolean ok(){
		Position p, other;
		Iterator<Position> itty = queens.iterator(), 
							itty2;
		while (itty.hasNext()){
			p = itty.next();
			itty2 = queens.iterator();
			while (itty2.hasNext()){
				other = itty2.next();
				if (!(p.equals(other))) {				//check different positions
					if (p.isAttacking(other)){
						return false;				//board is not okay
					}
				}
			}
		}
		return true;
	}
	
	public String toString() {
		String result = queens + "\n";
		for (int row = 0; row < Game.SIZE; row++){
			for (int col = 0; col < Game.SIZE; col++){
				if (queens.contains(new Position(row, col))){
					result += "Q ";
				}
				else {
					result += ". ";		//no queen
				}
			}
			result += "\n";
		}
		return result;
	}
	
}
