import java.util.*;
public class Arrays {

	static int maxSumContag(int[] arr){
		int max_here = 0;
		int max = Integer.MIN_VALUE;
		
		for(int i=0;i<arr.length;i++){
		
			
			max_here = Math.max(max_here, max_here+arr[i]);
			if(max_here<0)
				max_here = 0;
			max = Math.max(max_here, max);
		}
		return max;
	}
	
	static int[][] transposeMatrix(int [][] m){
   
		int[][] x= new int[m.length][m[0].length];
        for (int i = 0; i < m.length; i++){
            for (int j = 0; j < m[0].length; j++){  
            	x[i][j] = m[j][i];
            }
        }       		
        	return x;
        }
	
	static void sumAs(int[] x,int k){
		HashMap<Integer,Integer> t = new HashMap<Integer,Integer>();
		
		
		for(int i=0;i<x.length;i++);
		
	}
	
	static int[][] reverseRows(int[][] x){
		int[][] temp = new int[x.length][x[0].length];
		
		for(int i=0;i<x.length;i++){
			for(int j=0;j<x[0].length;j++){
			
				temp[i][j] = x[i][x[0].length-1-j];
			}
		}
		
		return temp;
	}
	
	public static void main(String[] args){
		int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
		//System.out.println(maxSumContag(a));
		int A[][] = { 	{1, 1, 1, 1},
                		{2, 2, 2, 2},
                		{3, 3, 3, 3},
                		{4, 4, 4, 4}
                	};
	    int B[][] = transposeMatrix(A);
	    int C[][] = reverseRows(B);
	 
	   
	    for (int i = 0; i < C.length; i++)
	    {
	        for (int j = 0; j < C[0].length; j++)
	           System.out.print(C[i][j]);
	        
	       System.out.println();
	    }
	}
}
