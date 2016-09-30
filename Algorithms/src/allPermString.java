
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
	
	public static void main(String[] args){
		allPerm("","abc");
	}
}
