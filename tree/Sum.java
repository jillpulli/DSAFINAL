package tree;

/**
 * The result of addition
 * @author Jill
 * @version (31 October 2016)
 *
 */
public class Sum extends Expr {

	public Sum (Expr left, Expr right) {
		super(left, right);
	}
	
	public Expr simplify() {
		left = left.simplify();
		right = right.simplify();
		
		if ((left instanceof Constant) && left.eval()== 0) {	//0 + x = x
			return right;
		}
		if ((right instanceof Constant) && right.eval()==0) {
			return left;
		}
		return this;
	}
	
	public int eval() {
		return left.eval() + right.eval();
	}
	
	public boolean equals (Object obj) {
		if (!(obj instanceof Sum)) {
			return false;
		}
		Sum s = (Sum) obj;
		return (left.equals(s.left) && right.equals(s.right)) || 
				(left.equals(s.right) && right.equals(s.left));
	}
	
	public String toString() {
		return "(" + left + "+" + right + ")";
	}
	
}
