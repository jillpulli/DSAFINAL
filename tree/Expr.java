package tree;

/**
 * An Arithmetic Expression involving ints
 * @author Jill
 *
 */
public abstract class Expr {
	
	Expr left, right;
	
	public Expr(Expr left, Expr right) {
		this.left = left;
		this.right = right;
	}
	
	public Expr() {}
	
	/**
	 * @return a simplified version of this Expres
	 */
	public abstract Expr simplify();
	
	/**
	 * @return the value of this Expr.
	 * @throws IllegalArgumentException if this expression cannot be evaluated.
	 */
	public abstract int eval();
	
}
