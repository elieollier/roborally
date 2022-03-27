
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {

	
	
	public static void main(String[] args)  throws IOException {
		
		Socket client  = new Socket ("localhost",5056);
		
		ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
		ObjectInputStream in = new ObjectInputStream(client.getInputStream());
		
		while(true) {
		

		
		
		}
		
}
}
