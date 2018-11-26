import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Player extends Application{
	
	public int ansCho = 0;
	public String butOne ="Button";// getAnswer(1);
	public String butTwo = "Button";// getAnswer(2);
	public String butThree ="Button"; //getAnswer(3);
	public String butFour = "Button";//getAnswer(4);
	public String question = null;
	Socket s;
	DataInputStream din;
	DataOutputStream dout;
	

	
    public Player() {
         try {
             String serverName = "10.200.147.126";
             s=new Socket(serverName,2114);
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
          String receiveMessage;           
           while((receiveMessage = read.readLine())!= null) {
        		   question = receiveMessage.substring(2);
        		   
        		   butOne = "A";
        		   butTwo = "B";
        		   butThree = "C";
        		   butFour = "D";
              /* here is where code will go that will allow
               * a user to click a button representing their
               * answer. Send message will be button click.
               */
        	   //what do do once a choice is made
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
		grid.setVgap(20);
		
		Text scenetitle = new Text("Trivia!");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.SEMI_BOLD, 30));
		grid.add(scenetitle, 0, 0, 2, 1);
		
		Label userName = new Label("Question:");
		grid.add(userName, 0, 1);
		
		Text score = new Text("Score: ");
		grid.add(score, 0, 2);
		
		Text disScore = new Text("0");
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
			   ansCho=1;
	           ask.setText(question);
	           queOne.setText(butOne);
	           queTwo.setText(butTwo);
	           queThree.setText(butThree);
	           queFour.setText(butFour);

		});	
		
		grid.add(queOne, 0, 3);
		
		
		queTwo.setOnAction(e->{
			   ansCho=2;
			   ask.setText(question);
	           queOne.setText(butOne);
	           queTwo.setText(butTwo);
	           queThree.setText(butThree);
	           queFour.setText(butFour);
		});		
		grid.add(queTwo, 1, 3);
		
		queThree.setOnAction(e->{
			   ansCho=3;
			   ask.setText(question);
	           queOne.setText(butOne);
	           queTwo.setText(butTwo);
	           queThree.setText(butThree);
	           queFour.setText(butFour);
		});			
		grid.add(queThree, 2, 3);
	
		queFour.setOnAction(e->{
			   ansCho=4;
			   ask.setText(question);
	           queOne.setText(butOne);
	           queTwo.setText(butTwo);
	           queThree.setText(butThree);
	           queFour.setText(butFour);
		});			
		grid.add(queFour, 3, 3);
		
		
		try {
			if(ansCho!=0) {
				ClientChat();
			  }
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
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