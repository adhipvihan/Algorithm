public class twoNonRepeatingInArray {


	static void func(int[] arr){
		int xorResult=0;
		int x=0;
		int y=0;
		int set_bit=0;
		
		for(int i=0;i<arr.length;i++){
			xorResult^=arr[i];
		}
		
		// Now find the Rightmost set-bit in the result
		set_bit = xorResult & ~(xorResult-1);
		
		for(int i=0;i<arr.length;i++){
			if((set_bit & arr[i]) ==1){
				x^=arr[i];
			}
			else
				y^=arr[i];
		}
		System.out.println(x);
		System.out.println(y);
	}
	
	public static void main(String[] args){
		int[] arr = {1,2,3,1,2,3,4,5};
		func(arr);
	}
}
