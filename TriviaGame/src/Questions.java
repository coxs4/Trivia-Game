import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Questions { //this is the questions class beginning
	public final static int testLen = 5;
	private static String questions[] = new String[testLen];
	private static int answers[]= new int[testLen];
	


	@SuppressWarnings("resource")
	public static void main(String as[]) throws IOException
    {
		ServerSocket serverSocket = new ServerSocket(2134);
		Socket mySocket = serverSocket.accept(); 
		
		DataOutputStream dout = new DataOutputStream(mySocket.getOutputStream());
		BufferedWriter write = new BufferedWriter(new OutputStreamWriter(dout));

		setQuestions(1);
		setAnswers(1);
		
		
		InputStream input = mySocket.getInputStream();
		BufferedReader read  =  new BufferedReader(new InputStreamReader(input));
		
		for(int q = 0; q<questions.length;q++) {
			dout.writeUTF(questions[q]);
			dout.flush();
		}
	}
	
	public static void setQuestions(int test) {
		if(test == 1) {
			questions[0] ="3Where were the 2012 Summer Olympics Held? 	#A. Boston 	#B. Hong Kong 	#C. London 	#D. Berlin $#";
			questions[1] ="2Which of the following is NOT in Boston?		#A. Fenway   #B. Gillete Stadium 		#C. TD Garden 	#D. None of the above $#";
			questions[2] ="3Which President was from the Boston area?  	#A. Jimmy Carter 	#B. Samuel Adams 		#C.  John F. Kennedy	#D. Both B and C $#";
			questions[3] ="1What year was Wentworth founded?			#A. 1904		#B. 1902		#C. 1906		#D.1908 $#";
			questions[4] ="1Which album sold the most copies in America? #A. Thriller - Michael Jackson #B. Greatest Hits - Eagles #C. DAMN. - Kendrick Lamar #D. In Pieces - Garth Brooks$";
		}
	}
	public static void setAnswers(int test) {
		if(test == 1) {
			answers[0] = 3;
			answers[1] = 2;
			answers[2] = 4;
			answers[3] = 3;
			answers[4] = 2;
		}
	}
	
	public static int getAnswer(int num) {
		return answers[num];
	}
}
