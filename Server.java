import java.io.*; 
import java.net.*; 
import java.util.*;

public class Server
{

  public static void main(String[] args)
    { 
      ServerSocket welcomeSocket; 
      Thread t = null;
      try
      {
		welcomeSocket = new ServerSocket(5000);
		System.out.println("Server running on port 5000");
        while(true) 
        { 
			Socket connect1 = welcomeSocket.accept();
			System.out.println("Player 1 Added. Waiting for Player 2...");
			Socket connect2 = welcomeSocket.accept();
			System.out.println("Player 2 Added. Starting game...");
			
			//create thread to service new connection
			RunGame g= new RunGame(connect1, connect2);
			t = new Thread(g);
			t.start(); 
        } 
      } 
      catch(Exception e)
      {
    	  System.out.println("server socket creation error");
      }
    } 
}