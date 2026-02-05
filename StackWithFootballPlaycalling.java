package stack;

import java.util.Scanner;
import java.util.Stack;

public class StackWithFootballPlaycalling {
	public static void main(String[] args) 
	{
		
		// Create Scanner
	Scanner input = new Scanner(System.in);
	
		// Create Stack
		Stack<String> playCall = new Stack<String>();
		
		System.out.println("Scenario: You are an Offensive Coordinator for your football team\nYou are down 28-24, there is 1:20 left on the game clock.\nEach play cost 10 secs.");
		
		
		// Ready Check Loop
		
		boolean start = false;
		
		while (!start) {
			System.out.println("Can you win the game? (Y/N):");
		
		String response = input.nextLine().trim().toLowerCase();
	
		
		
		
		//Switch Method
		
		switch (response) {
		case "y":
		case "yes":
			start = true;
			System.out.println("Game Clock: 1:20");
			System.out.println("1st and 10, ball on your own 20 yard line");
			break;
			
		case "no":
		case "n":
			System.out.println("Game over, Coach was not ready");
			return;
			
		default:
			System.out.println("Invalid input. Please Enter Y or N.");
				}
			}
		
	// create time variables
		int startTime = 80;
		int timeRemain = startTime;
		int runOff = 10;
		boolean running = true;
		
		while (running) {
			int minutes = timeRemain / 60;
			int seconds = timeRemain % 60;
			
			System.out.printf("\nTime Remaining: %d:%02d\n", minutes, seconds);

			System.out.println("1. Call a play (-10s)");
			System.out.println("2. Undo last play (+10s)");
			System.out.println("3. Show current play");
			System.out.println("4. Show Play history");
			System.out.println("5. Exit Drive");
			System.out.println("Choose an option:");
			
			if (!input.hasNextInt()) {
				System.out.println("Enter Number 1-5.");
				input.nextLine();
				continue;
			}
			
			int choice = input.nextInt();
			input.nextLine();
			
			switch (choice) {
			case 1: //push
				if (timeRemain < runOff) {
					System.out.println("Not Enough time left to run another play\n");
					break;
				}
					System.out.println("Enter Play Call: ");
					String play = input.nextLine();
					
					playCall.push(play);
					timeRemain -= runOff;
					
					System.out.println("Called: " + play + "\n");
			
				break;
				
			
			case 2: //pop
				if (playCall.isEmpty()) {
					System.out.println("No plays to undo.\n");
					break;
				}
				
				String remove = playCall.pop();
				timeRemain = Math.min(startTime,  timeRemain + runOff);
				System.out.print("Removed: " + remove + "\n");
				break;
				
			case 3: //Peak
				if (playCall.isEmpty()) {
					System.out.println("Play sheet is empty.\n");
				} else {
					System.out.print("Current play:" + playCall.peek() + "\n");
				}
				break;
				
			case 4: // Print Stack
				if (playCall.isEmpty()) {
					System.out.println("Play sheet is empty, call a play!\n");
				} else {
						System.out.println("PlaySheet\n");
						
					for (int i = 0; i < playCall.size(); i++) {
						System.out.println((i + 1) + ". " + playCall.get(i));
					}
					
				}
				break;
				
				
				
			case 5:
				
				System.out.println("Drive ended.");
				input.close();
			    running = false;
			    break;
				
			default:
				System.out.println("Invalid Choice!\n");
				break;
			}
		}
	}
	
}
