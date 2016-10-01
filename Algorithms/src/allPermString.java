
public class allPermString {
	static void allPerm(String res,String orig){
		if(orig.equals("") || orig.equals(null))
			System.out.println(res);
		
		else{
			for(int i=0;i<orig.length();i++){
				char temp = orig.charAt(i);
				allPerm(res+temp, orig.substring(0, i)+orig.substring(i+1,orig.length()));
			}
		}  
	}
	
	static void allBinary(int n,int[] result){
		
		if(n<1){
			for(int i=0;i<result.length;i++){
				System.out.print(result[i]);
			}
			System.out.println();
		}
		else{
			int[] temp = result;
		temp[n-1]=0;
		allBinary(n-1,temp);
		temp[n-1]=1;
		allBinary(n-1,temp);
		}
	}
	
	public static void main(String[] args){
		int[] result = new int[2];
		allBinary(2,result);
	}
}
