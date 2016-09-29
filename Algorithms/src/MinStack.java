import java.util.*;
public class MinStack<E> {

	Stack<E> regular  = new Stack<E>();
	Stack<E> min = new Stack<E>();
	
	
	public void push(E data){
		regular.push(data);
		
	}
}
