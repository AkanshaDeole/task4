package codsoft.com;

import java.util.Scanner;
import java.util.Timer;
import java.util.List;
import java.util.ArrayList;
import java.util.TimerTask;


 class Quiz {
	
	private String question;
	private List<String> options;
	private int correctop;
	
	public Quiz(String question,List<String> options,int correctop)
	{
		this.question = question;
		this.options = options;
		this.correctop = correctop;
	}
	
	public String getQuestion()
	{
		return question;
	}
	
	public List<String> getOptions()
	{
		return options;
	}
	
	public int getCorrectOption() 
	{
		return correctop;
	}
}

public class QuizGame{
	private List<Quiz> questions;
	private int currentQuestion;
	private int score;
	private Timer timer;
	
	public QuizGame() {
		questions =new ArrayList<>();
		currentQuestion = 0;
		score =0;
		timer = new Timer();	
	}
	
	Scanner sc = new Scanner(System.in);
	
	public void addQuestion(Quiz question) 
	{
		questions.add(question);
	}
	
	public void StartQuiz() {
	System.out.println("Welcome To The Quiz-Game!");
	timer.schedule(new TimerTask1(), 3, 7000000);
	
	
	while(currentQuestion< questions.size()) {
		 Quiz currentQuestionNew = questions.get(currentQuestion);
		display(currentQuestionNew);
		
		int choice = getChoice();
		if (choice == currentQuestionNew.getCorrectOption()) {
			System.out.println("Correct Answer..");
			score++;
		}
		else {
			System.out.println("Incorrect Answer..");
		}
		
		currentQuestion++;	
	}
	displayResult();
	}
	
	private void display(Quiz question) {
		System.out.println(question.getQuestion());
		List<String> options = question.getOptions();
		for (int i = 0;i< options.size(); i++) {
			System.out.println((i+1)+"."+ options.get(i));
		}
	}
	
	private int getChoice() {
		System.out.print("Enter your Choice : 1-"+ questions.get(currentQuestion).getOptions().size()+" ):");
		return sc.nextInt();
		}
	
	private void displayResult() {
		System.out.println("Quiz Game is completed.");	
		System.out.println("Your Score is"+score);
			
	}
	
	
	private class TimerTask1 extends TimerTask{
		private int time = 10 ;
		
		
		public void run() {
			if (time > 0) {
				System.out.println("Time left"+ time +"sec");
				time--;
			}
			else {
				System.out.println("Time's Up");
				currentQuestion++;
				}
			}
		}
	
public static void main(String[] args) {
	
	    
		QuizGame Q1 = new QuizGame();
		Q1.addQuestion(new Quiz("1. Which is the biggest island in the world?",List.of("GreenLand","Japan","SriLanka","France"),1));
		Q1.addQuestion(new Quiz("2. Which city is called the city of temple of India?",List.of("Arunachal Pradesd","Gujrat","Bhubaneswar","Jaipur"),3));
		Q1.addQuestion(new Quiz("3. What is the Computer Brain?",List.of("RAM","ROM","Memory","CPU"),4));
		Q1.addQuestion(new Quiz("4. Which is the third highest civilian award in India?",List.of("Bharat Ratna","Padma Bhushan","Padma Shri","Padma Vibhushan"),2));
		Q1.addQuestion(new Quiz("5. Which is the Lower House of the Parliament of India?",List.of("LokShabha","RajyaSabha","Vidhansabha","None of these"),3));
		Q1.addQuestion(new Quiz("6. What is the national Song of india",List.of("Jana Gana Mana","Mere desh ki dharti","Sare Jahan Se Accha","Vande Mataram"),4));
		Q1.addQuestion(new Quiz("7. Which was the first Satellite of India?",List.of("Bhaskara","Aryabhata","Rohini","Kalpana"),2));
		Q1.addQuestion(new Quiz("8. What is the retirement age of Cheif Justice of India?",List.of("55 years","60 years","65 years", "70 years"),3));
		Q1.addQuestion(new Quiz("9. When is National Voter's Day celebrated in India?",List.of("5 January","5 December","25 January","25 December"),3));
		Q1.addQuestion(new Quiz("10. Which is the longest river flowing in India?",List.of("Indus","Godavari","Kaveri","Ganga"),4));
		Q1.StartQuiz();
	}

}
