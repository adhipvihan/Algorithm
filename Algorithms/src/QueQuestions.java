import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class QueQuestions {

	static int[] SlidingWindowMax(int[] arr,int k){
		int[] B = new int[(arr.length-k)+1];
		ArrayDeque<Integer> ns = new ArrayDeque<Integer>();
		Stack<Integer> s = new Stack<Integer>();
		int i=0;
		
		for(;i<k;i++){
			while(!ns.isEmpty() && arr[i]>=arr[ns.getLast()])
				ns.removeLast();
			ns.addLast(i);
		}
		
		for(;i<arr.length;i++){
			
			B[i-k] = arr[ns.getFirst()];
			while(!ns.isEmpty() && ns.getFirst()<=i-k)
				ns.removeFirst();
			
			while(!ns.isEmpty() && arr[i]>=arr[ns.getLast()])
				ns.removeLast();
			ns.addLast(i);
		}
		
		B[i-k] = arr[ns.getFirst()];
		return B;
	}
	public static void main(String[] args){
		int[] x = {1,3,-1,-3,5,3,6,7};
		int[] ans= new int[(x.length-3)+1];
		ans = SlidingWindowMax(x, 3);
		for(int i=0;i<ans.length;i++)
			System.out.println(ans[i]);
	}
}
