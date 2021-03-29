// EoinCoulter 17902302
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

public class Chef extends Thread{
	
	private ReentrantLock lock;
	
	private  int pizzaCounter; 
	private String Chefname;
	private  int burgerCounter;
	private  int fishCounter;
	private int totalPrepped;
	private ArrayList<String> contents;
	private ArrayList<String> contents2;

	  

	public Chef(String string, ReentrantLock lock,ArrayList<String> contents,ArrayList<String> contents2) {
		this.Chefname = string;
		this.lock = lock;
		this.contents = contents;
		this.contents2 = contents2;
		
	}

	public void run ( ) {
	while (contents.size()>0)	{lock.lock();  // block until condition holds  
	    try {
	    	
	    	
	   String order =	contents.remove(0);
	   totalPrepped++;
	   if (order.contains("Pizza")) {pizzaCounter++;}
	   if (order.contains("Burger")) {burgerCounter++;}
	   if (order.contains("Fish")) {fishCounter++;}

	    	System.out.print(this.Chefname+ " is preparing " + order + "\n" );
	    	contents2.add(order);
	    
	    	
	   
		} finally {
	       lock.unlock();
	       
	     }
	    try {
			Chef.sleep((long) (10));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   } System.out.print(this.Chefname+ " made " + this.totalPrepped + " meals including " + 
				  this.burgerCounter + " Burgers " + this.pizzaCounter +" Pizzas and " + this.fishCounter + " Fish n Chips \n" );
	}

	
	
	

	
	
	}
