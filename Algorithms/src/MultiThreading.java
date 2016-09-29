
class myThread extends Thread{
	public void run(){
		System.out.println(Thread.currentThread().getName());
	}
	
}
public class MultiThreading {

	public static void main(String[] args){
		myThread x = new myThread();
		x.start();
		System.out.println(Thread.currentThread().getName());
	}
}
