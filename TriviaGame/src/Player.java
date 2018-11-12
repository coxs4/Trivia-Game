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
             String serverName = "10.200.20.218";
             s=new Socket(serverName,1236);
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
     public void ClientChat() throws IOException
     {
           BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
           String s1;
           do
           {
               s1=br.readLine();
               dout.writeUTF(s1);
               dout.flush();
               System.out.println("Server Message:"+din.readUTF());
           }
           while(!s1.equals("stop"));
    }
    public static void main(String as[])
    {
        new Player(); 
    }
}

