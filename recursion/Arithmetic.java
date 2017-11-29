package recursion;

/**
 * HW Oct 4 and number 1 for Quiz 2.
 * @author puliciccj5
 * @version (10.11.2016)
 *
 */
public class Arithmetic {

    
	public static void main(String [] args)
	{
		test (3,5);
		test (25,3);
		test (10,2);
	}
 
	private static void test (int x, int y)
	{   
		System.out.println (x + "*" + y + " = " + multiply(x,y));
		System.out.println (y + "*" + x + " = " + multiply(y,x));
		System.out.println (x + "/" + y + " = " + divide(x,y));
		System.out.println (y + "/" + x + " = " + divide(y,x));
	}
	
	/**
	 * @return the product when a is multiplied by b
	 * pre: a is not negative.
	 */
	public static int multiply(int a, int b){
		if (a==0) {
			return 0;
		}
		return b + multiply(a-1, b);
	}
	
	/**
	 * @param a
	 * @param b
	 * @return the quotient when a is dividing by b
	 * Pre: the parameters a and b are both positive.
	 */
	public static int divide(int a, int b) {
		if (a < b) {
			return 0;
		}
		return 1 + divide(a-b, b);
	}
	
	
}
