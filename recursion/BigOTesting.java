package recursion;

public class BigOTesting {

	public static void main(String[] args) {
		//methodA(5);
		methodB(8);
	}
	
	 static void methodA(int n) 
     {  for (int i=0; i < n; i++)
               System.out. println (i*i); 
        for (int j=0; j < n; j++)
                System.out. println (j*j); 
     }
	 
	 static void methodB(int n) 
     {  for (int i=0; i <n; i++)
             for (int j=i; j<n; j++)  
                System.out. println (j*j);
   } 
}
