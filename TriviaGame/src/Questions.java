import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Questions { //this is the questions class beginning
	public final static int testLen = 5;
	private static String questions[] = new String[testLen];
	private static int answers[]= new int[testLen];
	private static int points = 0;

	@SuppressWarnings("resource")
	public static void main(String as[]) throws IOException
    {
		ServerSocket serverSocket = new ServerSocket(2112);
		//wait and accept a connection
		Socket mySocket = serverSocket.accept(); 

		setQuestions(1);
		setAnswers(1);
		
		//feed the questions, wait for an answer, and determine whether they answered correctly or not.
		//OutputStream output = mySocket.getOutputStream();
		//PrintWriter write = new PrintWriter(output,true);
	    DataInputStream din;
        din= new DataInputStream(mySocket.getInputStream());
		BufferedReader read= new BufferedReader(new InputStreamReader(din));
		
		DataOutputStream dout;
		dout = new DataOutputStream(mySocket.getOutputStream());

		int receiveMessage;
		for(int q = 0; q<questions.length;q++) {
			String ques = getQuestion(q);
				
			dout.writeUTF(ques);
			dout.flush();
				
			/*int ans = getAnswer(q);
			if((receiveMessage = read.readLine())!= 0) {
      		   System.out.println(receiveMessage);
      	    }
			if(receiveMessage == ans) {
				System.out.println("Correct!");	//calculate the correct answers
				points++;
			}	
			else System.out.println("Not quite..");*/
						
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
			questions[0] ="Where were the 2012 Summer Olympics Held?"+"\r\n";
			questions[1] ="Which of the following is NOT in Boston?"+"\r\n";
			questions[2] ="Which U.S. President was from the Boston area?"+"\r\n";
			questions[3] ="A string";
			questions[4] ="A string";
		}
	}

	public static void setAnswers(int num) {
		if(num == 1) {
			answers[0] = 2;
			answers[1] = 1;
			answers[3] = 1;
			answers[4] = 1;
		}	
	}	
}
