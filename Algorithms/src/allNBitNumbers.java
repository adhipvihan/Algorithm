
public class allNBitNumbers {

	static void allNumbers(int n,int[] A){
		if(n<1)
		{
			System.out.println("\n");
			for(int i=0;i<A.length;i++){
				System.out.print(A[i]);
			}
		}
		else{
			A[n-1]=0;
			allNumbers(n-1, A);
			A[n-1] = 1;
			allNumbers(n-1, A);
		}
	}
	
	public static void main(String[] args){
		int[] A = new int[2];
		allNumbers(2,A);
	}
}
