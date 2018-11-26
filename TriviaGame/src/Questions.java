import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Questions { //this is the questions class beginning
	public final static int testLen = 5;
	private static String questions[] = new String[testLen];
	private static int answers[]= new int[testLen];
	private static String options[] = new String[4];
	private static int points = 0;

	@SuppressWarnings("resource")
	public static void main(String as[]) throws IOException
    {
		ServerSocket serverSocket = new ServerSocket(2114);
		//wait and accept a connection
		Socket mySocket = serverSocket.accept(); 

		setQuestions(1);
		
		//feed the questions, wait for an answer, and determine whether they answered correctly or not.
	    //DataInputStream din= new DataInputStream(mySocket.getInputStream());
		DataOutputStream dout = new DataOutputStream(mySocket.getOutputStream());
		//int receiveMessage;
		
		for(int q = 0; q<questions.length;q++) {
			dout.writeUTF(getQuestion(q));
			dout.flush();
			break;
		}
		//return score when the test concludes.
	}
	
	public static int getAnswer(int num) {
		return answers[num];
	}
	
	public static String getQuestion(int num) {
		return questions[num];
	}
	
	public static void setQuestions(int test) {
		if(test == 1) {
			questions[0] ="Where were the 2012 Summer Olympics Held? [A. Boston B. Hong Kong C. London D. Berlin] \n";
			questions[1] ="Which of the following is NOT in Boston? \n A. Fenway Park \n B. Gillete Stadium \n C. TD Garden \n D. None of the above. \n";
			questions[2] ="Which U.S. President was from the Boston area? \n A. Jimmy Carter \n B. John F. Kennedy \n C. Samuel Adams \n D. Both B and C \n";
			questions[3] ="A string";
			questions[4] ="A string";
		}
	}
}
