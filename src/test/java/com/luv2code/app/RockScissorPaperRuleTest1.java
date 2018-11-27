package com.luv2code.app;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.luv2code.entity.Action;
import com.luv2code.entity.Player;

public class RockScissorPaperRuleTest1 {

	private Player playerA;
	private Player playerB;
	private Action actionA;
	private Action actionB;

	@Before
	public void init() {
		playerA = new Player("A", 0, 0, 0);
		playerB = new Player("B", 0, 0, 0);
		actionA = new Action();
		actionB = new Action();
	}

	@Test
	public void tie() {
		
		// given
		actionA.setType(1);
		actionB.setType(1);

		// when
		App.run1(playerA, playerB, actionA, actionB);

		// then
		assertEquals(playerA.getLoss(), 0);
		assertEquals(playerA.getWin(), 0);
		assertEquals(playerA.getTie(), 1);

		assertEquals(playerB.getLoss(), 0);
		assertEquals(playerB.getWin(), 0);
		assertEquals(playerB.getTie(), 1);
	}

	@Test
	public void playerAWins() {
		
		// given
		actionA.setType(1);
		actionB.setType(2);

		// when
		App.run1(playerA, playerB, actionA, actionB);

		// then
		assertEquals(playerA.getLoss(), 0);
		assertEquals(playerA.getWin(), 1);
		assertEquals(playerA.getTie(), 0);

		assertEquals(playerB.getLoss(), 1);
		assertEquals(playerB.getWin(), 0);
		assertEquals(playerB.getTie(), 0);
	}

	@Test
	public void playerBWins() {

		// given
		actionA.setType(2);
		actionB.setType(1);

		// when
		App.run1(playerA, playerB, actionA, actionB);

		// then
		assertEquals(playerA.getLoss(), 1);
		assertEquals(playerA.getWin(), 0);
		assertEquals(playerA.getTie(), 0);

		assertEquals(playerB.getLoss(), 0);
		assertEquals(playerB.getWin(), 1);
		assertEquals(playerB.getTie(), 0);
	}

}
