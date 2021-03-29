// EoinCoulter 17902302
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

public class Restaurant {

	static ArrayList<String> contents = new ArrayList<String>();
	static ArrayList<String> contents2 = new ArrayList<String>();

	

	File file = new File("C:\\Users\\Eoin Coulter\\Documents\\orderList.txt");
	

	public Restaurant() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(file));

		String st;
		while ((st = br.readLine()) != null)
			contents.add(st);

	}

	public static void main(String args[]) throws Exception {
		Restaurant res = new Restaurant();
		
		
		ReentrantLock lock = new ReentrantLock();
		
		

		Chef chef1 = new Chef("John",lock,contents,contents2);
		Chef chef2 = new Chef("Mark",lock,contents,contents2);
		Server server1 = new Server("Katie",lock,contents,contents2);
		Server server2 = new Server("Andrew",lock,contents,contents2);
		Server server3 = new Server("Emily",lock,contents,contents2);
		
		
		chef1.start();
		chef2.start();
		
		server2.start();
		server1.start();
		server3.start();

		
		  
		
		  }
				  

	}

	

	
