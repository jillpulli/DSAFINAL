package tree;

/**
 * An Expr which has a fixed value
 * @author Jill
 * @version (October 31 2016)
 *
 */
public class Constant extends Expr {
	int value;
	
	public Constant (int value) {
		super();
		this.value = value;
	}
	
	public Expr simplify() {
		return this;
	}
	
	public int eval() {
		return value;
	}
	
	/**
	 * @return true if this constant equals obj
	 */
	public boolean equals (Object obj) {
		if (!(obj instanceof Constant)) {
			return false;
		}
		Constant c = (Constant) obj;
		return value == c.value;
	}
	
	public String toString() {
		return ""+value;
	}
}
