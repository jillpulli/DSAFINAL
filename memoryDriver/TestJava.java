package memoryDriver;

import list.*;

/**
 * Test the memory limitations of the Java runtime system
 * @author Jill
 *
 */
public class TestJava {

	static final int MAX = (int)1e5;
	
	public static void main (String[] args){
		char[] buffer;
		int size = 2;
		for(int i=0; i <100; i++) {
			System.out.println(size);
			buffer = new char[size];
			size = size*2;
		}
	}
	
	public static void testMemory() {
		List <char[]> list = new ArrayList<char[]>();
		for (int i = 0; i <1000; i++){
			System.out.println(i);
			list.add (new char[MAX]);
		}
		char[] buffer = new char[MAX*10];
	}
	
}
