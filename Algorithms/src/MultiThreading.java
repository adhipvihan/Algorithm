import java.util.*;

class myThread extends Thread{
	public void run(){
			System.out.println(Thread.currentThread().getName());
	}
	
}

//Test
public class MultiThreading {

	public static void main(String[] args){
		myThread x = new myThread();
		x.start();
		//x.join();
		
		System.out.println(Thread.currentThread().getName());
	}
}
