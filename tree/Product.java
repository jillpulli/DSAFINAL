package tree;

/**
 * An Expr which is the result of multiplication
 * @author Jill
 * @version (31 October 2016)
 *
 */
public class Product extends Expr{

	public Product(Expr left, Expr right) {
		super(left, right);
	}
	
	public Expr simplify() {
		left = left.simplify();
		right = right.simplify();
		if (left.eval()==0) {		//0 * x = 0
			return new Constant(0);
		}
		if (right.eval()==0) {
			return new Constant(0);
		}
		if (left.eval()==1) {
			return right;
		}
		if (right.eval()==1) {
			return left;
		}
		return this;
	}
	
	public boolean equals (Object obj) {
		if (!(obj instanceof Product)) {
			return false;
		}
		Product p = (Product) obj;
		return (left.equals(p.left) && right.equals(p.right)) || (left.equals(p.right) && right.equals(p.left));
	}

	@Override
	public int eval() {
		return left.eval()*right.eval();
	}
	
	public String toString(){
		return "(" + left + "*" + right + ")";
	}
}
