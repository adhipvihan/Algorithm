

public class Heap {

	private int capacity;
	private int[] arr;
	private int type;
	private int size;
	
		public Heap(int cap){
			capacity = cap;
			arr = new int[capacity];
			size=0;
		}
		
		
		public int getMax(){
			if(size==0)
				return Integer.MAX_VALUE;
			return arr[0];
		}
		
	
		void add(int data){
			if(size==capacity)
				expand();
			
			size++;
			arr[size-1] = data;
			
			precolateUp();
		}
		
		public void ArrayToHeap(int[] arr){
			
			if(this.size == this.capacity)
				expand();
			
			for(int i=0;i<arr.length;i++){
				this.arr[i] =  arr[i];
				size++;
			}
			
		
			for(int i=(this.size-1)/2;i>=0;i--)
				precolateDown(i);
		}
		
		public void printHeap(){
			for(int i=0;i<size;i++)
				System.out.println(arr[i]);
		}
		public int getLeft(int i){
			int left = i*2+1;
			
			if(left>=size)
				return -1;
			else
				return left;
			
		}
		
		public int getRight(int i){
			int right = i*2+2;
			
			if(right>=size)
				return -1;
			else
				return right;
		}
		
		public void precolateDown(int i){

			if(i<0 || i>=size)
				throw new IllegalStateException("Recheck the value of i");
			
			int l = getLeft(i);
			int r = getRight(i);
			int max;
			
			if(l!=-1 && this.arr[l]>this.arr[i])
				max = l;
			else
				max=i;
			
			if(r!=-1 && this.arr[r]>arr[max])
				max = r;
			
			if(max!=i){
				
				arr[i]^=arr[max];
				arr[max]^=arr[i];
				arr[i]^=arr[max];
				precolateDown(max);
			}
				
		}
		
		public void precolateUp(){
		
		}
		
	public void expand(){
		int[] temp = new int[capacity*2];
		
		for(int i=0;i<this.arr.length;i++){
			temp[i] = this.arr[i];
		}
		capacity*=2;
	}
	
			public static void main(String[] args){
				int[] arr = {1,2,3,4};
				Heap x = new Heap(4);
				x.ArrayToHeap(arr);
				x.printHeap();
				//System.out.println(x.getMax());
			}
		}

