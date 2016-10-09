class evenOddPrinter{
	
	static boolean PrintOdd = true;
	
		public void printOdd(int i){
			
			synchronized (this) {
				if(PrintOdd== false){
					try{
						wait();
					}catch(Exception e){}
				}
				
				System.out.println(i);
				
				PrintOdd = false;
				
				try{
					notify();
				}catch(Exception e){}
			}
		}
		
	public void printEven(int i){
			
			synchronized (this) {
				if(PrintOdd== true){
					try{
						wait();
					}catch(Exception e){}
				}
				
				System.out.println(i);
				
				PrintOdd = true;
				
				try{
					notify();
				}catch(Exception e){}
			}
		}
	
}

class th1 extends Thread{
	private evenOddPrinter x;
	
	public th1(evenOddPrinter x){
		this.x=x;
	}
	
	public void run(){
		for(int i=1;i<=10;i+=2)
			x.printOdd(i);
	}
}

class th2 extends Thread{
	private evenOddPrinter x;
	
	public th2(evenOddPrinter x){
		this.x=x;
	}
	
	public void run(){
		for(int i=2;i<=10;i+=2)
			x.printEven(i);
	}
}



public class ThreadEvenOdd{
	
	public static void main(String[] args){
		evenOddPrinter x = new evenOddPrinter();
		th2 t2 = new th2(x);
		th1 t1 = new th1(x);
		
		t1.start();
		t2.start();
		
	}

}