package com.luv2code.entity;

import java.util.concurrent.ThreadLocalRandom;

public class Player {

	private String name;
	private int win;
	private int loss;
	private int tie;

	public Player() {
		this.name = "A";
		this.win = 0;
		this.loss = 0;
		this.loss = 0;
	}

	public Player(String name, int win, int loss, int tie) {
		this.name = name;
		this.win = win;
		this.loss = loss;
		this.tie = tie;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getLoss() {
		return loss;
	}

	public void setLoss(int loss) {
		this.loss = loss;
	}

	public int getTie() {
		return tie;
	}

	public void setTie(int tie) {
		this.tie = tie;
	}

	public Action performAction() {

		// Return a random integer number from 1 - 3
		int type = ThreadLocalRandom.current().nextInt(1, 4);

		// Create a corresponding action for the random number
		Action action = new Action(type);

		// Return the action
		return action;
	}

	public void updateStatus(String status) {

		if (status.equals("win")) {
			this.win++;

		} else if (status.equals("loss")) {
			this.loss++;

		} else if (status.equals("tie"))
			this.tie++;
	}
	
	public void printInfo() {
		
		System.out.println("Information of player " + this.name);
		System.out.println("\t#win: " + this.win);
		System.out.println("\t#loss: " + this.loss);
		System.out.println("\t#tie: " + this.tie);
	}

}
