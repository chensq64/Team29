import java.io.*;
import java.util.*;

public class Test {
	//main method is for prompt the quetion file name
	 public static void main(String[]args) {
		 Scanner console = new Scanner(System.in);
		 System.out.println("This is a real test given by the Human Relations Dept at many of the major corporations today. \n"
		 		+ "It helps them get a better insight concerning their employees and prospective employees.");
		 System.out.println("Are you ready to take the test? (yes or no):");
		 String reply = console.nextLine();
		 if(reply=="no") {
			 System.exit(0);
		 }
		 String fileName = null;
		 System.out.println("Input file Name is: ");
		 fileName = console.next();
		 File input = new File(fileName);
		 while(!input.exists()){            
				System.out.print("File not found. Try again: ");
				fileName= console.next();
				input = new File(fileName);
		 } 
		 try {
				read(input);
		 } catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}  
	 }
	 //read the file and get user's answers
	public static void read(File input) throws FileNotFoundException { 
		String result="";
		String choice=null;
		Scanner console = new Scanner(System.in);
		Scanner ttt = new Scanner(input);
		int count=0;
		while(count<10) {
		  while(ttt.hasNextLine()) {
			if(ttt.hasNextInt()) {
				int index =ttt.nextInt();
				if(index!=1) {
					break;
				}else {
					continue;
				}	
			}else {
				String line = ttt.nextLine();
				System.out.println(line);	
			}
		}
			System.out.println("Please give me your choice: ");
			choice = console.nextLine();
			result+=choice;
			count++;
		}
		System.out.println("Your answers are: "+result);
		//generate a 2d array to store the score evaluation standard
		int [][]scoreStandard={{2,4,6,0,0,0,0},{6,4,7,2,1,0,0},{4,2,5,7,6,0,0},{4,6,2,1,0,0,0},
					{6,4,3,5,2,0,0},{6,4,2,0,0,0,0},{6,2,4,0,0,0,0},{6,7,5,4,3,2,1},{7,6,4,2,1,0,0},{4,2,3,5,6,1,0}};
			
		calculaion(result,scoreStandard);
		
	}
	//calculate which type of personality you are based on the total score
	public static void calculaion(String result, int[][] storingScore) {
		int totalScore = 0;
		for(int i=0;i<10;i++) {
				totalScore+=storingScore[i]["abcdefg".indexOf(result.substring(i, i+1))];
		}
		System.out.println("Your total score is: " +totalScore);
		printResult(totalScore);
	} 
	public static void printResult(int totalScore) {
		System.out.println("Here is your personality test result:");
		
		if(totalScore>60){
		    System.out.println("Vain, self-centered, extremely donminant");
		    System.out.println("Others may admire you, but may hesitate to be close to you.");
		}else if(totalScore>=51&&totalScore<=60){
		    System.out.println("Exciting, highly volatile, rather impulsive");
		    System.out.println("Others think you are a natural leader who enjoys adventure. They enjoy being with you because of your excitement.");
		}else if(totalScore>=41&&totalScore<=50){
		    System.out.println("Lively, charming, always interesting");
		    System.out.println("Others think you are the center of attention, considerate and always willing to help others.");
		}else if(totalScore>=31&&totalScore<=40){
		    System.out.println("Sensible, cautious, practical");
		    System.out.println("Others see you as clever, talented, but modest. You are not a person who makes friends too quickly, but you are extremely loyal to friends.");
		}else if(totalScore>=21&&totalScore<=30){
		    System.out.println("Sensible, cautious, practical");
		    System.out.println("Others see you as clever, talented, but modest. You are not a person who makes friends too quickly, but you are extremely loyal to friends.");
		}else if(totalScore>=11&&totalScore<=20){
		    System.out.println("Hardworking, fussy");
		    System.out.println("Others see you as extremely careful and a steady plodder who can examine anything from every angle.");
		}else{
		    System.out.println("Shy, nervous, indecisive");
		    System.out.println("Others see you as a worrier who can see problems that don't exist and usually needs looking after.");
		}	
	}
}

