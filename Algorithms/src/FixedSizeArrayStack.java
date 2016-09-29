import java.util.*;

public class FixedSizeArrayStack  {

	protected int capacity;
	protected int top =-1;
	protected int[] data = new int[capacity];
	// Just implementing the shrink() function
	
	public void shrink(){
		if(!needShrink())
			return;
		
		int[] temp = new int[capacity>>2];
		System.arraycopy(data, 0, temp, 0, data.length-1);
		//capacity=capacity>>2;
		
	}
	
	public boolean needShrink(){
		int length = top+1;
		int cap = capacity<<2;
		
		if(length>=cap)
			return false;
		else
			return true;
	}
	
	static int[] reverseArray(int[] x,int start,int end){
		int left = start;
		int right = end;
		
		while(left<right){
			x[left]^=x[right];
			x[right]^= x[left];
			x[left]^=x[right];
			
			left++;
			right--;
		}
		
		return x;
	}
	static int[] rotateArray(int[] arr,int k){
		if(arr.length==0 || k<0 || arr==null)
			return null;
		
		if(k>arr.length)
			k%=arr.length;
		
		arr = reverseArray(arr, 0, k-1);
		arr = reverseArray(arr, k, arr.length-1);
		arr = reverseArray(arr, 0, arr.length-1);
		
		return arr;
	}
	
	static int OperatorPrecedence(char c){
		if(c=='-' || c=='+' )
			return 1;
			
		if( c=='/' || c=='*' || c=='%')
			return 2;
			
		return 0;
	}
	static String infixToPostfix(String txt){
		if(txt==null)
			return null;
		StringBuilder rs  = new StringBuilder();
		Stack<Character> s = new Stack<Character>();
		String result = "";
		
		for(int i=0;i<txt.length();i++){
			char c = txt.charAt(i);
			if(Character.isLetter(c))
				result+=c;
				
			else if(c=='('){
				s.push(c);
			}
			else if(c==')'){
				
				while(s.peek()!=')')
					result+=s.pop();
				s.pop();
			}
			else{
				while(!s.empty() && s.peek()!='(' && OperatorPrecedence(s.peek()) >= OperatorPrecedence(c)){
					result+=s.pop();
				}
				
				s.push(c);
			}
		}
		while(!s.isEmpty())
			result+=s.pop();
		
		return result;
	}
	
	static void sortStack(Stack<Integer> s){
		
		int temp;
		if(s.empty())
			return;
		else
			temp = s.pop();
			sortStack(s);
			stackHelp(s,temp);
			
	}
	
	static void stackHelp(Stack<Integer> s,int data){
	
		if(s.isEmpty() || s.peek()<data)
			s.push(data);
		
		int temp = s.pop();
		stackHelp(s, data);
		s.push(temp);
	}
	
	static int[] StockSpan(int[] arr){
		if(arr.length==0)
			return null;
		int[] result = new int[arr.length];
		
		result[0]= 1;
		Stack<Integer> s = new Stack<Integer>();
		s.push(0);
		for(int i=1;i<result.length;i++){
			
			while(!s.isEmpty() && arr[s.peek()] <= arr[i])
				s.pop();
			
			result[i] = s.isEmpty()?i+1:(i-s.peek());
			
			s.push(i);
		}
		return result;
	}
	
	public static void main(String[] args){
		String xy = "A+B*C";
		System.out.println(infixToPostfix(xy));
	}
}
