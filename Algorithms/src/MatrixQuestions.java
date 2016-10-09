
public class MatrixQuestions {

	static boolean RowColSortedSearch(int[][] mat, int element){
		int r = 0;
		int c = mat.length-1;
		
		while(r<mat.length && c>=0){
			if(mat[r][c]==element)
				return true;
			else if(mat[r][c]>element)
				c--;
			else
				r++;
		}
		
		return false;
	}
	
	static void SpiralMatrix(int[][] mat){
		int k=0;
		int m=mat.length-1;
		int l=0;
		int n=mat.length-1;
		
		while(k<m && l<n){
			
			for(int i=l;i<=n;i++){
				System.out.println(mat[k][i]);
			}
			k++;
			
			for(int i=k;i<=m;i++){
				System.out.println(mat[i][n]);
			}
			n--;
			
			for(int i=n;i>=l;i--){
				System.out.println(mat[m][i]);
			}
			m--;
			
			for(int i=m;i>=k;i--){
				System.out.println(mat[i][l]);
			}
			l++;
		}
	
	}
	
	public static void main(String[] args) {
		int[][] mat = { {10, 20, 30, 40},
                		{15, 25, 35, 45},
                		{27, 29, 37, 48},
                		{32, 33, 39, 50},
              		};
		//System.out.println(RowColSortedSearch(mat, 21));
		SpiralMatrix(mat);

	}

}
