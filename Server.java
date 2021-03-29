// EoinCoulter 17902302
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Server extends Thread {

	private ReentrantLock lock;
	String serverName;
	private int burgerCounter;
	private int fishCounter;
	private int totalPrepped;
	private int pizzaCounter;
	private ArrayList<String> contents;
	private ArrayList<String> contents2;

	public Server(String string, ReentrantLock lock, ArrayList<String> contents,ArrayList<String> contents2) {
		this.serverName = string;
		this.lock = lock;
		this.contents = contents;
		this.contents2 = contents2;
	}

	public void run() {
		while (contents2.size() > 0||contents.size()>0) {
			lock.lock(); // block until condition holds
			try {
				if (contents2.size() > 0) {
					String order = contents2.remove(0);
					totalPrepped++;
					if (order.contains("Pizza")) {
						pizzaCounter++;
					}
					if (order.contains("Burger")) {
						burgerCounter++;
					}
					if (order.contains("Fish")) {
						fishCounter++;
					}

					System.out.print(this.serverName + " serving " + order + "\n");
				}

			} finally {
				lock.unlock();
			}
			try {
				Server.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}System.out.print(this.serverName+ " served " + this.totalPrepped + " meals including " + 
				  this.burgerCounter + " Burgers " + this.pizzaCounter +" Pizzas and " + this.fishCounter + " Fish n Chips \n" );
	}


}
