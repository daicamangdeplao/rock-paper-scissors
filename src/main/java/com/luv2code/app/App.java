package com.luv2code.app;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.luv2code.entity.Action;
import com.luv2code.entity.Player;
import com.luv2code.entity.Result;

/**
 * What does super() do?
 *
 */
public class App {

	static int round = 1;
	static final int numRound = 100;
	static final String[] actions = { "paper", "rock", "scissors", "well" };

	static final List<String> rockWin = Arrays.asList("scissors");
	static final List<String> paperWin = Arrays.asList("rock", "well");
	static final List<String> scissorsWin = Arrays.asList("paper");
	static final List<String> wellWin = Arrays.asList("rock", "scissors");

	static Map<String, List<String>> lut;

	public static void main(String[] args) {
		System.out.println("Welcome to the game");
		init();

		Player playerA = new Player("A", 0, 0, 0);
		Player playerB = new Player("B", 0, 0, 0);

		Action actionA = new Action();
		Action actionB = new Action();

		while (round <= numRound) {
			System.out.println("\n#ROUND " + round);

			actionA = playerA.performAction();
			System.out.println(playerA.getName() + " plays " + actions[actionA.getType() - 1]);
			actionB = playerB.performAction();
			actionB.setType(1);
			System.out.println(playerB.getName() + " plays " + actions[actionB.getType() - 1]);

//			run1(playerA, playerB, actionA, actionB);
			run2(playerA, playerB, actionA, actionB);

			round += 1;

		}

		System.out.println("\nRESULT");

		playerA.printInfo();
		playerB.printInfo();
	}

	public static void init() {

		lut = new HashMap<>();
		lut.put("rock", Arrays.asList("scissors"));
		lut.put("paper", Arrays.asList("rock", "well"));
		lut.put("scissors", Arrays.asList("paper"));
		lut.put("well", Arrays.asList("rock", "scissors"));
	}

	public static void run2(Player playerA, Player playerB, Action actionA, Action actionB) {

		List<String> temp = lut.get(actions[actionA.getType() - 1]);
		boolean aWins = false;

		/**
		 * If actionB exists in temp 
		 * 		aWins = true; 
		 * else 
		 * 		bWins = true;
		 */

		if (actions[actionA.getType() - 1].compareTo(actions[actionB.getType() - 1]) == 0) {
			System.out.println("It is a tie round");
			playerA.updateStatus(Result.TIE.name().toLowerCase());
			playerB.updateStatus(Result.TIE.name().toLowerCase());
		} else {

			if (temp.contains(actions[actionB.getType() - 1])) {
				aWins = true;
			} else {
				aWins = false;
			}

			if (aWins) {
				System.out.println(playerA.getName() + " " + Result.WIN.name().toLowerCase());
				playerA.updateStatus(Result.WIN.name().toLowerCase());
				playerB.updateStatus(Result.LOSS.name().toLowerCase());
			} else {
				System.out.println(playerB.getName() + " " + Result.WIN.name().toLowerCase());
				playerA.updateStatus(Result.LOSS.name().toLowerCase());
				playerB.updateStatus(Result.WIN.name().toLowerCase());
			}

		}
	}

	public static void run1(Player playerA, Player playerB, Action actionA, Action actionB) {
		int ret = -1;
		// How different two actions is
		ret = actionA.compares(actionB);
		System.out.println("The difference is " + ret);

		if (!actionA.equals(actionB)) {

			if (ret == 1) {

				if (actionA.getType() > actionB.getType()) {
					playerA.updateStatus(Result.LOSS.name().toLowerCase());
					playerB.updateStatus(Result.WIN.name().toLowerCase());
					System.out.println(playerB.getName() + " " + Result.WIN.name().toLowerCase());
				} else {
					playerA.updateStatus(Result.WIN.name().toLowerCase());
					playerB.updateStatus(Result.LOSS.name().toLowerCase());
					System.out.println(playerA.getName() + " " + Result.WIN.name().toLowerCase());
				}

			} else if (ret == 2) {

				if (actionA.getType() > actionB.getType()) {
					playerA.updateStatus(Result.WIN.name().toLowerCase());
					playerB.updateStatus(Result.LOSS.name().toLowerCase());
					System.out.println(playerA.getName() + " " + Result.WIN.name().toLowerCase());
				} else {
					playerA.updateStatus(Result.LOSS.name().toLowerCase());
					playerB.updateStatus(Result.WIN.name().toLowerCase());
					System.out.println(playerB.getName() + " " + Result.WIN.name().toLowerCase());
				}

			}
		} else {
			playerA.updateStatus(Result.TIE.name().toLowerCase());
			playerB.updateStatus(Result.TIE.name().toLowerCase());
			System.out.println("It is a tie round");
		}
	}
}
