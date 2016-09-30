
public class DynamicArrayQueue {

	private int[] dataArray;
	private int capacity,size,front,rear;
	
	public DynamicArrayQueue(int capacity){
		this.capacity=capacity;
		this.dataArray = new int[capacity];
		this.size=0;
		this.front=this.rear=0;
	}
	
	public void Enque(int data){
		if(size==capacity)
			expand();
		dataArray[rear] = data;
		rear = (rear+1)%this.capacity;
		size++;
	}
	
	public void expand(){
		//
	}
}
