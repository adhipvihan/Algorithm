import java.util.*;

class t1 implements Runnable{
	static Thread mt;
	public void run(){
		try{
			mt.join();
		}catch(Exception e){}
		System.out.println(Thread.currentThread().getName());
	}
}

class t2 implements Runnable{
	public void run(){
		System.out.println(Thread.currentThread().getName());
	}
}


public class MultiThreading {

	public static void main(String[] args){
		t1 ob = new t1();
		t2 ob2 = new t2();
		Thread x = new Thread(ob);
		Thread y = new Thread(ob2);
		t1.mt = y;
		y.start();
		x.start();
		try{
			x.join();
		}catch(Exception e){}
		
		
		System.out.println(Thread.currentThread().getName());
	}
}
