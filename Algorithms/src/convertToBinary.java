

public class convertToBinary {

	static String convert2Binary(int num){
		StringBuilder result=new StringBuilder();
		while(num>0){
			int temp = num%2;
			result.append(String.valueOf(temp));
			num=num/2;
		}
		
		return result.toString();
	}
	
	public static void main(String[] args){
		System.out.println(convert2Binary(5));
	}
}
