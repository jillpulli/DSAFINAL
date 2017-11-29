package tree;

/**
 * An Expr which is a result of subtraction
 * @author Jill
 * @version (31 October 2016)
 *
 */
public class Difference extends Expr {
	
	public Difference(Expr left, Expr right) {
		super(left, right);
	}

	@Override
	public Expr simplify() {
		left = left.simplify();
		right = right.simplify();
		
		if (right.eval()== 0) {	// x-0=x
			return left;
		}
		if (left.equals(right)) {
			return new Constant(0);
		}
		return this;
	}

	@Override
	public int eval() {
		return left.eval() - right.eval();
	}
	
	public boolean equals (Object obj) {
		if (!(obj instanceof Difference)) {
			return false;
		}
		Difference d = (Difference) obj;
		return (left.equals(d.left) && right.equals(d.right));
	}
	
	public String toString() {
		return "(" + left + "-" + right + ")";
	}

}
