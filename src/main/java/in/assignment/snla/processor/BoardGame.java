package in.assignment.snla.processor;

import java.util.HashMap;
import java.util.Map;

public class BoardGame {
	private Map<Integer,Integer> snakeMap;
	private Map<Integer,Integer> ladderMap;
	
	public Map<Integer, Integer> getSnakeMap() {
		return snakeMap;
	}

	//initialize snake with head as key and tail as value
	private void initSnakeMap() {
		snakeMap = new HashMap<Integer,Integer>();
		snakeMap.put(97, 21);
		snakeMap.put(65, 35);
		snakeMap.put(36, 19);
		snakeMap.put(87, 32);
	}

	public Map<Integer, Integer> getLadderMap() {
		return ladderMap;
	}

	//initialize ladder's foot as key and head as value
	public void initLadderMap() {
		ladderMap = new HashMap<Integer,Integer>();
		ladderMap.put(63, 99);
		ladderMap.put(51, 72);
		ladderMap.put(37, 85);
		ladderMap.put(7, 33);
	}
	
	public BoardGame()
	{
		initSnakeMap();
		initLadderMap();
	}
	

	public boolean isValidInput(int currPosition, int diceOutcome)
	{
		boolean validFlag = true;
		
		if(currPosition < 0 || currPosition > 99)
		{
			validFlag = false;
			System.out.println("Invalid Current Postion: provide integer between 0 to 99.");
		}

		if(diceOutcome < 1 || diceOutcome > 6)
		{
			validFlag = false;
			System.out.println("Invalid dice Outcome: provide integer between 1 to 6.");
		}
		return validFlag;
	}

	public int movePiece(int currPosition, int diceOutcome)
	{
		int nextPosition = currPosition + diceOutcome;
		
		if(nextPosition == 100)
			System.out.println("Yay!! You won!!");
		//if nextPosition is greater than 100 (final cell), do not move the piece
		else 
		{
			if(nextPosition > 100)
				nextPosition = currPosition;
			//if snake head found at new position then move to tail of snake
			else if(snakeMap.containsKey(nextPosition))
				nextPosition = snakeMap.get(nextPosition);
			//if ladder's foot found at new position then move to head of ladder
			else if(ladderMap.containsKey(nextPosition))
					nextPosition = ladderMap.get(nextPosition);
			System.out.println("New position: "+nextPosition);
		}
		return nextPosition;
	}
}
