import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Player extends Application{
	public int score1 = 0;
	public String ansCho = "0";
	public String butOne ="A";// getAnswer(1);
	public String butTwo = "B";// getAnswer(2);
	public String butThree ="C"; //getAnswer(3);
	public String butFour = "D";//getAnswer(4);
	public static String question;
	public String[] ques = new String[5];
	public String[] answ = new String[ques.length];
	public String ans;
	public int num = 4;

	Socket s;
	DataInputStream din;
	DataOutputStream dout;
	
    int p=0;
    String[] r = new String[ques.length];
    int w = 5;

	
    public Player() {
         try {
             String serverName = "10.200.147.126";
             s=new Socket(serverName,2134);
             System.out.println(s);
             din= new DataInputStream(s.getInputStream());
             dout= new DataOutputStream(s.getOutputStream());
             ClientChat();
         }
         catch(Exception e){
             System.out.println(e);
         }
     }
     @SuppressWarnings("null")
	public void ClientChat() throws IOException{
          BufferedReader read= new BufferedReader(new InputStreamReader(din));
          
          for(int i=ques.length-1;i>0;i--) {
        	  r[i]=din.readUTF().replace('#', '\n');
          }
          question = r[4].substring(p+1).replace("$", "");
          ans = r[4].substring(p, p+1).toString();
          
          for(int n = r.length-1 ; n > 0; n--) {
        	 System.out.print("r["+n+"] is : "+r[n]); 
          } 	  
      
     }
  
	
	public void start(Stage primaryStage) throws Exception {
		/*/
		 * This is the gui and the button should update when an answer is selected  
		 * was working
		 */
		
		primaryStage.setTitle("Trivia Game");
		GridPane grid = new GridPane();
		grid.setGridLinesVisible(false);
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(75);
		grid.setVgap(5);
		
		Text scenetitle = new Text("Trivia!");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.SEMI_BOLD, 30));
		grid.add(scenetitle, 0, 0, 2, 1);
		
		Label userName = new Label("Question:");
		grid.add(userName, 0, 1);
		
		Text score = new Text("Score: ");
		grid.add(score, 0, 2);
		
		Text disScore = new Text(new Integer(score1).toString());
		grid.add(disScore, 1, 2);
		
		
		Text ask = new Text(question);
		ask.setFont(Font.font("Tahoma", FontWeight.SEMI_BOLD, 12));
		ask.setWrappingWidth(150);
		grid.add(ask, 1,1,1, 1);
		
		
		Button queOne = new Button(butOne);
		Button queTwo = new Button(butTwo);
		Button queThree = new Button(butThree);
		Button queFour = new Button(butFour);
		
		queOne.setOnAction(e->{
			   ansCho="1";
			   if(score1 == 2) {
					ask.setText("~Congrats!~ you finished!");
					ans = "2";
				}
			   if(ans.equals(ansCho)) {
				   score1++;
    			   disScore.setText(new Integer(score1).toString());
    			   num = num-1;
    			   ask.setText(r[num].substring(p+1).replace("$", ""));							//sets the next question
    			   ans = r[num-1].substring(p, p+1).toString();
        	   }else {
        		   num = num-1;
    			   ask.setText(r[num].substring(p+1).replace("$", ""));
    			   ans = r[num].substring(p, p+1).toString();
        	   }
	          

		});	
		
		grid.add(queOne, 0, 3);
		
		
		queTwo.setOnAction(e->{
			   ansCho="2";
			   if(score1 == 2) {
					ask.setText("~Congrats!~ you finished!");
					ans = "1";
				}
			   if(ans.equals(ansCho)) {
				   score1++;
    			   disScore.setText(new Integer(score1).toString());
    			   num = num-1;
    			   ask.setText(r[num].substring(p+1).replace("$", ""));						//sets the next question
    			   ans = r[num].substring(p, p+1).toString();
        	   }else {
        		   num = num-1;
    			   ask.setText(r[num].substring(p+1).replace("$", ""));
    			   ans = r[num].substring(p, p+1).toString();
        	   }
	          
	          
		});		
		grid.add(queTwo, 1, 3);
		
		queThree.setOnAction(e->{
			   ansCho="3";
			   if(score1 == 2) {
					ask.setText("~Congrats!~ you finished!");
					ans = "1";
				}
			   if(ans.equals(ansCho)) {
				   score1++;
    			   disScore.setText(new Integer(score1).toString());
    			   num = num-1;
    			   ask.setText(r[num].substring(p+1).replace("$", ""));
    			   ans = r[num].substring(p, p+1).toString();
        	   }else {
        		   num = num-1;
    			   ask.setText(r[num].substring(p+1).replace("$", ""));
    			   ans = r[num].substring(p, p+1).toString();
        	   }
	          
		});			
		grid.add(queThree, 2, 3);
	
		queFour.setOnAction(e->{
			   ansCho="4";
			   if(score1 == 2) {
					ask.setText("~Congrats!~ you finished!");
					ans = "1";
				}
			   if(ans.equals(ansCho)) {
				   score1++;
    			   disScore.setText(new Integer(score1).toString());
    			   num = num-1;
    			   ask.setText(r[num].substring(p+1).replace("$", ""));
    			   ans = r[num].substring(p, p+1).toString();
        	   }else {
        		   num = num-1;
    			   ask.setText(r[num].substring(p+1).replace("$", ""));
    			   ans = r[num].substring(p, p+1).toString();
        	   }
	          
	           
		});			
		grid.add(queFour, 3, 3);
		
		
		Scene scene = new Scene(grid);
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
		primaryStage.show();
		
	}
	
	public static void main(String args[]) {
		launch(args);
		new Player();

	}	
}