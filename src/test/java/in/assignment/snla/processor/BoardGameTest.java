package in.assignment.snla.processor;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class BoardGameTest {
	
	@Test
	public void testBordGameInit()
	{
		BoardGame game = new BoardGame();
		Assert.assertEquals(getExpectedSnakeMap(),game.getSnakeMap());
		Assert.assertEquals(getExpectedLadderMap(),game.getLadderMap());
	}
	
	@Test
	//test currPosition is between 1 to 99
	public void isValidInput_currPosition()
	{
		BoardGame game = new BoardGame();
		//valid currPosition
		Assert.assertTrue(game.isValidInput(0,1));
		Assert.assertTrue(game.isValidInput(1,1));
		Assert.assertTrue(game.isValidInput(99,1));

		//invalid currPosition
		Assert.assertFalse(game.isValidInput(100,1));
		Assert.assertFalse(game.isValidInput(-1,1));
	}
	
	@Test
	//test diceOutcome is between 1 to 6
	public void isValidInput_diceOutcome()
	{
		BoardGame game = new BoardGame();
		//valid diceOutcome
		Assert.assertTrue(game.isValidInput(1,1));
		Assert.assertTrue(game.isValidInput(1,6));

		//invalid diceOutcome
		Assert.assertFalse(game.isValidInput(1,0));
		Assert.assertFalse(game.isValidInput(1,8));
	}
	
	@Test
	public void testMovePiece()
	{
		BoardGame game = new BoardGame();
		//currPosition = 1,  diceOutcome = 1 then nextPosition = 2
		Assert.assertEquals(2, game.movePiece(1,1));
		//currPosition = 98,  diceOutcome = 2 then nextPosition = 100
		Assert.assertEquals(100, game.movePiece(98,2));
		//currPosition = 94,  diceOutcome = 5, snake head of 97 found, then nextPosition = 21
		Assert.assertEquals(21, game.movePiece(94,3));
		//currPosition = 59,  diceOutcome = 4, ladder's foot found at 63 then nextPosition = 99
		Assert.assertEquals(99, game.movePiece(59,4));
		//currPosition = 98,  diceOutcome = 4 then nextPosition = 98,
		//as if computed nextPosition > 100, then do not move
		Assert.assertEquals(98, game.movePiece(98,4));
	}

	private Map<Integer,Integer> getExpectedSnakeMap() {
		Map<Integer,Integer> snakeMap = new HashMap<Integer,Integer>();
		snakeMap.put(97, 21);
		snakeMap.put(65, 35);
		snakeMap.put(36, 19);
		snakeMap.put(87, 32);
		return snakeMap;
	}
	
	private Map<Integer,Integer> getExpectedLadderMap() {
		Map<Integer,Integer> ladderMap = new HashMap<Integer,Integer>();
		ladderMap.put(63, 99);
		ladderMap.put(51, 72);
		ladderMap.put(37, 85);
		ladderMap.put(7, 33);
		return ladderMap;
	}
}
