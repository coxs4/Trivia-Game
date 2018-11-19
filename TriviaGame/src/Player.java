import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Player
{
    Socket s;
    DataInputStream din;
    DataOutputStream dout;
    public Player()
    {
         try
         {
             String serverName = "10.200.240.150";
             s=new Socket(serverName,2112);
             System.out.println(s);
             din= new DataInputStream(s.getInputStream());
             dout= new DataOutputStream(s.getOutputStream());
             ClientChat();
         }
         catch(Exception e)
         {
             System.out.println(e);
         }
     }
     public void ClientChat() throws IOException {
           BufferedReader read= new BufferedReader(new InputStreamReader(din));
           String receiveMessage, sendMessage;
           do
           {
        	   if((receiveMessage = read.readLine())!= null) {
        		   System.out.println(receiveMessage.substring(2));
        	   }
              /* here is where code will go that will allow
               * a user to click a button representing their
               * answer. Send message will be button click.
               */
        	   
        	   //what do do once a choice is made
           }
           while(!read.equals("stop"));
    }
    public static void main(String as[])
    {
        new Player(); 
    }
}

