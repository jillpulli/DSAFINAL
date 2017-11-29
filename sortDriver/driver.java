package sortDriver;
import sort.*;
import list.*;


public class driver {

	public static void main(String[] args) {
		List<Character> list = new LinkedList<Character>();
		list.add('e');
		list.add('a');
		list.add('c');
		list.add('b');
		list.add('d');
		System.out.println(list);
		Sorter<Character> sorter = new BubbleSortLinked<Character>();
		sorter.sort(list);
		System.out.println(list);
		
		
	}
	
}
