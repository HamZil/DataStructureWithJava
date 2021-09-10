package searches;

public class BinarySearch {
	public static int binarySearch(int A[] , int size ,int key) {
		int L = 0;
		int R = size -1;
		while (L <= R) {
			int mid = (L+R) / 2 ;
			if(A[mid] == key) {
				return mid ;
			}else if(A[mid]<key) {
				L =mid+1;
			}else if(A[mid]>key) {
				R = mid - 1;
			}
		}
		
		return -1;
	}
	
	public static int binaryRecursive(int A[],int key,int L,int R) {
		if(L>R) {
			return -1;
		}else {
			int mid = (L+R) / 2;
			if(key == A[mid]) {
				return mid;
			}else if (key >A[mid]) {
				return binaryRecursive(A,key,mid+1,R);
			}else if(key < A[mid] ){
				return binaryRecursive(A,key,L,mid-1);
					
			}
		}
		
		return -1;
	}
	
public static void main (String Args[]) {
		
		int A [] = {23,45,53,73,95};
	
		int Result;
			Result = BinarySearch.binaryRecursive(A, 45, 0,A.length-1);
		
		
		System.out.print("Index :"+ Result);
	}

}
