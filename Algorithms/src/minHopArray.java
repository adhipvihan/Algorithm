
public class minHopArray {

	static int minHop(int[] arr){
		int[] rs = new int[arr.length];
		
		if(arr[0]==0)
			return Integer.MAX_VALUE;
		
		rs[0] = 0;
		
		for(int i=1;i<arr.length;i++){
			rs[i] = Integer.MAX_VALUE;
			for(int j=0;j<i;j++){
				if(j+arr[j]>=i)
					rs[i] = Math.min(rs[i], rs[j]+1);
			}
		}
		
		return rs[rs.length-1];
	}
	
	public static void main(String[] args){
		int arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		System.out.println(minHop(arr));
	}
}
