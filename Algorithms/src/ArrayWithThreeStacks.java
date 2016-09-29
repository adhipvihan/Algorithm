
public class ArrayWithThreeStacks {

	private int[] dataArray;
	private int top1,top2,base3,top3,size;
	
	public ArrayWithThreeStacks(int size){
		if(size<3)
			throw new IllegalStateException("Size cannot be less than 3");
		this.size=size;
		dataArray = new int[size];
		top1=-1;
		top2 = size;
		base3 = size/2;
		top3 = base3;
	}
	
	public void push(int StackId,int data){
		if(StackId==1){
			if(top1+1==base3){
				if(Stack3RightShiftable()){
					Stack3RightShift();
					dataArray[++top1] = data;
				}
				else
					throw new IllegalStateException("Stack Full");
			}
			else
				dataArray[++top1] = data;
		}
		else if(StackId==2){
			if(top2-1==top3){
				if(Stack3LeftShiftable()){
					Stack3LeftShift();
					dataArray[--top2] = data;
				}
				else
					throw new IllegalStateException("Stack2 is Full. Unable to Left shift Stack 3");
			}
			else
				dataArray[--top2] = data;
		}
		
		/* Left shifting the array so that stack-3 can accept more elements in the case when the top of the stack 3 is touching
		 * the top of the stack 2. Else we can use regular operation to put it in the stack 3
		 */
		
		else if(StackId==3){
			if(top3+1==top2){
				if(Stack3LeftShiftable()){
					Stack3LeftShift();
					dataArray[++top3] = data;
				}
				else
					throw new IllegalStateException("Stack 3 is full.Stack 3 Cannot be Left Shifted");
			}
			else
				dataArray[++top3] = data;
		}
		else
			return;
	}
	
	public boolean Stack3RightShiftable(){
		if(top3+1<top2)
			return true;
		
		return false;
	}
	
	public void Stack3RightShift(){
		for(int i=top3+1;i>base3+1;i--)
			dataArray[i]=dataArray[i-1];
	}
	public boolean Stack3LeftShiftable(){
		if(top1+1<base3)
			return true;
		return false;
	}
	
	public void Stack3LeftShift(){
		for(int i=base3-1;i<top3;i++)
			dataArray[i] = dataArray[i+1];
	}
	
}
