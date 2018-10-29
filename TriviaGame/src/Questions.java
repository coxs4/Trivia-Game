import java.util.Scanner;

public class Questions {
	public final int testLen = 5;
	private String questions[] = new String[testLen];
	private char answers[]= new char[testLen];
	private int points = 0;

	public Questions() {
		System.out.println("Select the subject you would like to test: "+"\r\n"+"[1] Network Programming"+"\r\n"+"[2] Something Else");
		Scanner input = new Scanner(System.in);
		System.out.print("Your Choice: ");
		int choice = input.nextInt();
		
		setQuestions(choice);
		
		for(int q = 0; q<questions.length;q++) {
			String ques = getQuestion(q);
			System.out.println(ques);
			
			System.out.print("Answer: ");
			char userAns = input.next().charAt(0);
			char ans = getAnswer(q);
			
			if(userAns == ans) {
				System.out.println("Correct!");
				points++;
			}
			else System.out.println("Not quite..");
		}
		System.out.println("Test Complete. You scored "+points+"/5");
	}
	
	public char getAnswer(int num) {
		return answers[num];
	}
	
	public String getQuestion(int num) {
		return questions[num];
	}
	
	private void setQuestions(int test) {
		if(test == 1) {
			questions[1] = "This is the question"+"\r\n"+
							"[A] this is an option"+"\r\n"+
							"[B] this is another"+"\r\n"+
							"[C] another"+"\r\n"+
							"[D] one more";
			questions[2] = "True or False: this is a question";
		
		}
	}
}
