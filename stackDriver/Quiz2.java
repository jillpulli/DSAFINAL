package stackDriver;
import stack.*;
import list.*;

/**
 * Number 2 for Quiz 2.
 * @author puliciccj5
 * @version (10.11.2016)
 * @param <E>
 * @param <E>
 * @param <E>
 *
 */
public class Quiz2 {
	
	
	
	public static void main(String[] args) {
		
		StackADT<Integer> values = new Stack<Integer>();
		splitList(values);
		
	}
	
	/**
	 * Display the positive values of the given list in the same order, 
	 * followed by all the negative values in reverse order.
	 */
	public static void splitList (StackADT<Integer> numbers) {

		numbers.push(-9);
		numbers.push(0);
		numbers.push(12);
		numbers.push(-1);
		numbers.push(-3);
		numbers.push(4);
		numbers.push(-1);
		numbers.push(13);
		
		System.out.println("List of all values:");
		System.out.println(numbers.toString());
		
		StackADT<Integer> posValues = new Stack<Integer>();
		StackADT<Integer> negValues = new Stack<Integer>();
		int currentNum;
		
		for (int i=0; i < 15; i++) {
			if (numbers.peek() != null) {
				currentNum = numbers.peek();
				if (currentNum > 0){
					posValues.push(currentNum);
				}
				if (currentNum < 0) {
					negValues.push(currentNum);
				}
			numbers.pop();
			}
		}
		
		System.out.println("\nPostive values:");
		System.out.println(posValues.toString());
		System.out.println("\nNegative values:");
		System.out.println(negValues.toString());
	}

}

