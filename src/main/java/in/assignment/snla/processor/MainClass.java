package in.assignment.snla.processor;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainClass {

	//run this method to play the game
	public static void main(String[] args) {
		//initialize starting point
		int currPosition = 0, diceOutcome = 0;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		BoardGame game = new BoardGame();
		
		do {
			//get input from command prompt for currPosition and diceOutcome
			try {
				System.out.println("Enter current Position of player and Dice outcome : ");
				String input = reader.readLine();
				String inputToken[] = input.split(",");
				if(inputToken.length != 2)
				{
					System.out.println("Invalid input : please enter valid comma seperated interger.");
					continue;
				}
				currPosition = Integer.parseInt(inputToken[0]);
				diceOutcome = Integer.parseInt(inputToken[1]);
			}
			catch(Exception e)
			{
				System.out.println("Invalid input : please enter valid comma seperated interger.");
				continue;
			}
			
			int nextPosition = 0;
			//validate input
			if(game.isValidInput(currPosition, diceOutcome))
			{
				//move the piece
				nextPosition = game.movePiece(currPosition, diceOutcome);
			}
			currPosition = nextPosition;
		}while(currPosition < 100);
		
		System.out.println("Game Complete");
	}
}
