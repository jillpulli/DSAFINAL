package tree;

public class Mod extends Expr {

	public Mod(Expr left, Expr right) {
		super(left, right);
	}
	
	@Override
	public Expr simplify() {
		left = left.simplify();
		right = right.simplify();
		
		if ((left instanceof Constant) && left.eval()==0){
			return left;
		}
		if ((left instanceof Constant) && left.eval()==1){
			return left;
		}
		if (right.eval()==1){
			return new Constant(0);
		}
		if (left.equals(right)) {
			return new Constant(0);
		}
		return this;
		
	}

	@Override
	public int eval() {
		return left.eval() % right.eval();
	}
	
	public boolean equals(Object obj) {
		if (!(obj instanceof Mod)) {
			return false;
		}
		Mod m = (Mod) obj;
		return (left.equals(m.left) && right.equals(m.right));
	}

	public String toString() {
		return "(" + left + "%" + right + ")";
	}
}
