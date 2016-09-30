
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
		int len = this.size;
		int[] temp = new int[len<<1];
		
		for(int i=front;i<=rear;i++)
			temp[i-front] = temp[i%capacity];
        dataArray = temp;
        front = 0;
        rear = size-1;
		capacity<<=1;
	
	}
	
	public int Deque(){
		if(size==0)
			throw new IllegalStateException("Que Empty");
		int result = dataArray[front];
		front = (front+1)%this.capacity;
		shrink();
		return result;
	}
	
	public void shrink(){
		int min = capacity>>2;

		
		if(size<capacity && size<=min){
			int[] temp = new int[this.capacity>>1];
			for(int i=front;i<=rear;i++)
				temp[i-front] = temp[i%capacity];
	        dataArray = temp;
	        front = 0;
	        rear = size-1;
			capacity>>=1;
		}
			
	}
	
	public static void main(String[] args){
		
	}
}
