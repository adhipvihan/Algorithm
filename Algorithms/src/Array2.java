
public class Array2 {

	
	static void Merger(int[] arr,int low,int mid,int high){
		int[] left = new int[mid-low+1];
		int[] right = new int[high-mid];
		
		for(int i=0;i<left.length;i++)
			left[i] = arr[low+i];
		for(int k =0;k<right.length;k++)
			right[k] = arr[mid+1+k];
		
		int i=0;int k=0;
		int m=low;
		while(i<left.length && k<right.length){
			if(left[i]<=right[k]){
				arr[m] = left[i];
				i++;
			}
			else{
				arr[m] = right[k];
				k++;
			}
			
			m++;
		}
		
		while (i < left.length)
        {
            arr[m] = left[i];
            i++;
            m++;
        }
 
        while (k < right.length)
        {
            arr[m] = right[k];
            k++;
            m++;
        }
        
	}
	
	static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
	
	static void sortArr(int[] arr,int low,int high){
	
		if(low<high){
		int mid = (high+low)/2;
		sortArr(arr, low, mid);
		sortArr(arr, mid+1, high);
		
		Merger(arr, low, mid, high);
		}
	}
	
	public static void main(String[] args) {
		int arr[] = {12, 11, 13, 5, 6, 7};
		 
        System.out.println("Given Array");
        printArray(arr);

        sortArr(arr, 0, arr.length-1);
 
        System.out.println("\nSorted array");
        printArray(arr);
	}
}
