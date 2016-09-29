import java.util.*;
public class MinStack {

	Stack<Integer> regular  = new Stack<Integer>();
	Stack<Integer> min = new Stack<Integer>();
	
	
	public void push(int data){
		regular.push(data);
		if(min.isEmpty() || min.peek()>data)
			min.push(data);
	}
	
	public int pop(){
		if(regular.isEmpty())
			return Integer.MIN_VALUE;
		
		int result = regular.pop();
		if(min.peek()==result)
			min.pop();
		
		return result;
	}
	
	public int MinStack(){
		return min.peek();
	}
	
	public static void main(String[] args){
		
	}
}
