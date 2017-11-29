package tree;

/**
 * The result of division.
 * 
 * @author puliciccj5
 * @version (15 Nov 2016)
 *
 */
public class Quotient extends Expr{

	public Quotient(Expr left, Expr right) {
		super(left, right);
	}
	
	@Override
	public Expr simplify() {
		left = left.simplify();
		right = right.simplify();
		
		int leftEval = left.eval();
		int rightEval = right.eval();
		
		if (leftEval ==0) {
			return left;
		}
		if (left.equals(right)) {
			return new Constant(1);
		}
		if (left.equals(right.eval() * -1)) {
			return new Constant(-1);
		}
		if (leftEval == rightEval*-1) {
			return new Constant(-1);
		}
		if (right.equals(left.eval() *-1)){
			return new Constant(-1);
		}
		if (rightEval == leftEval*-1){
			return new Constant(-1);
		}
		return this;
	}

	@Override
	public int eval() {
		return left.eval() / right.eval();
	} 
	
	public boolean equals(Object obj) {
		if (!(obj instanceof Quotient)) {
			return false;
		}
		Quotient q = (Quotient) obj;
		return (left.equals(q.left) && right.equals(q.right));
	}
	
	public String toString() {
		return "(" + left + "/" + right + ")";
	}

}
