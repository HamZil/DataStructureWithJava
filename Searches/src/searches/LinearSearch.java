package searches;

public class LinearSearch {
	
	public static int linearSearch(int A[] ,int size , int key) {
		int index = 0;
		while (index < size) {
			if(A[index]== key) 
				return index;
			index++;
		}
		return -1;
	}
	
}
