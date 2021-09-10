package sorting;

public class Sortings {
	
	public void display(int A[], int size) {
		for (int i= 0; i<size;i++) {
			System.out.print(A[i] + " ");
		}	
		
	}
	
	public void insertion(int arr[], int size) {
		for(int i = 1 ;i < size; i ++) {
			int temp = arr[i];
			int position = i;
			while (position > 0 && arr[position-1]>temp) {
				arr[position]= arr[position-1];
				position = position -1;
				
			}
			arr[position] = temp;
		}
	}
		
	public void selectionSort(int A[],int size) {
		for(int i =0 ; i<size-1;i++) {
			int position = i;
			for(int j = i+1 ; j<size;j++) {
				if(A[j]<A[position]) {
					position = j;
					
				}	
			}
			int tem = A[i];
			A[i]= A[position];
			A[position] = tem;
		}
		
	}
	
	public void bubbleSort (int arr[], int size) {
		for(int pass = size-1 ; pass >= 0 ; pass -- ) {
			for(int i = 0; i<pass ; i++) {
				if(arr[i]> arr[i+1]) {
					int temp = arr[i];
					arr[i]= arr[i+1];
					arr[i+1] = temp;
				}
				
			}
			
		}
	}
	
	public void shellSort (int arr[], int size) {
		for(int gap = size/2 ; gap>0 ;gap= gap/2) {
			System.out.println( "gap =  " + gap);
			for(int i = gap ; i < size; i++) {
				int temp = arr[i];
				int jump = i-gap;
				System.out.println("for i = " + i +" temp = " + temp + " jump = "+ jump );
				while (jump >= 0 && arr[jump]> temp) {
					arr[jump + gap] = arr[jump];
					System.out.println("while loop " + " arr[jump + gap] =  " + arr[jump + gap]);
					jump = jump-gap;
					System.out.println( "jump =  " + jump);	
				}
				System.out.println( "out of the while with 2 condition  ");
				System.out.println( "arr[jump + gap] =  " + arr[jump + gap]);
				
			arr[jump + gap] = temp;
				
			}
			System.out.println( "out of the for 2nd loop   ");
		}
	}

	public void mergeSort(int arr[] ,int left ,int right) {
		
		if(left < right) {
			int mid = (left + right) /2 ;
			
			mergeSort(arr,left , mid);
			mergeSort(arr,mid+1,right);
			System.out.println( "Inning ");
			merge(arr,left ,mid , right);
			System.out.println( "outing ");
			
		}
		
	}
	
	private void merge(int[] arr, int left, int mid, int right) {
		
		int i = left , j = mid + 1, k = left;
		int B[] = new int[right+1];
		
		while (i <= mid && j <= right) {
			if(arr[i]< arr[j]) {
				B[k] = arr[i];
				i++ ;	
			}else {
				B[k] = arr[j];
				j++;
			}
			k++;
		}
		while (i <= mid) {
			B[k] = arr[i];
			i++; k++;
			
		}
		while(j <= right) {
			B[k] = arr[j];
			j++; k++;
		}
		
		for(int index = left  ; index < right+1 ; index++) { //iterate to last index of arry right +1 or <= right
			System.out.println(index + "  compare "+arr[index] + "  "+ B[index]+ " right "+ right);
			arr[index] = B[index];
			
		}
	}


	public void QuickSort(int[] arr,int low,int high) {
		if(low<high) {
			int pi = partition(arr , low , high);
			QuickSort(arr ,low ,pi);
			QuickSort(arr , pi+1,high);
		}
		
	}
	
	private int partition(int[] arr, int low, int high) {
		// TODO Auto-generated method stub
		int pivot = arr[low],i =low,j=high;
		do {
			i++;
			while(i<=j && arr[i]<=arr[pivot]) {
				i++;
			}
			while(i<=j && arr[j]> arr[pivot]) {
				j--;
			}
			if(i <= j) {
				swap(arr,i,j);
			}
			
		}while(i<j);
		swap(arr,low,j);
		
		
		return j;
	}

	private void swap(int[] arr, int low, int j) {
		// TODO Auto-generated method stub
		int temp = arr[j];
		arr[j] = arr[low];
		arr[low] = temp;
		
		
		
	}

	
	public static void main (String Args[]) {
		
		int A [] = {45,23,54,23,5,67,33,2};
		
		Sortings sort = new Sortings();
		System.out.println( "Orignal Array ");
		System.out.println( );
		sort.display(A, A.length);
		System.out.println( );
		System.out.println( "Sorted Array ");
		sort.QuickSort(A,0 ,A.length-1);
		sort.display(A, A.length);
	}

}
