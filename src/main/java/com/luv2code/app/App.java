package com.luv2code.app;

import com.luv2code.entity.Action;
import com.luv2code.entity.Player;

/**
 * What does super() do?
 *
 */
public class App {

	static int round = 1;
	static final int numRound = 100;
	final static String[] actions = { "Paper", "Rock", "Scissors" };

	public static void main(String[] args) {
		System.out.println("Welcome to the game Rock–Paper–Scissors");

		Player playerA = new Player("John", 0, 0, 0);
		Player playerB = new Player("Dave", 0, 0, 0);

		Action actionA = new Action();
		Action actionB = new Action();
		int ret = -1;

		while (round <= numRound) {
			System.out.println("\n#ROUND " + round);

			actionA = playerA.performAction();
			System.out.println(playerA.getName() + " plays " + actions[actionA.getType() - 1]);
			actionB = playerB.performAction();
			System.out.println(playerB.getName() + " plays " + actions[actionB.getType() - 1]);

			// How different two actions is
			ret = actionA.compares(actionB);
			System.out.println("The difference is " + ret);

			if (!actionA.equals(actionB)) {

				if (ret == 1) {

					if (actionA.getType() > actionB.getType()) {
						playerA.updateStatus("loss");
						playerB.updateStatus("win");
						System.out.println(playerB.getName() + " wins");
					} else {
						playerA.updateStatus("win");
						playerB.updateStatus("loss");						
						System.out.println(playerA.getName() + " wins");
					}

				} else if (ret == 2) {

					if (actionA.getType() > actionB.getType()) {
						playerA.updateStatus("win");
						playerB.updateStatus("loss");
						System.out.println(playerA.getName() + " wins");
					} else {
						playerA.updateStatus("loss");
						playerB.updateStatus("win");						
						System.out.println(playerB.getName() + " wins");
					}

				}
			} else {
				playerA.updateStatus("tie");
				playerB.updateStatus("tie");
				System.out.println("It is a tie round");
			}

			round += 1;

		}

		System.out.println("\nRESULT");

		playerA.printInfo();
		playerB.printInfo();
	}
}
