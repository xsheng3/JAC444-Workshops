/**********************************************
Workshop #01
Course: JAC444
Last Name: Sheng
First Name: Xuewei
Date: Sep 25, 2021
**********************************************/package task2and3;

public class Craps {
	private int diceOne;
	private int diceTwo;
	
	public Craps() {

    }
	
	public Craps(int diceOne, int diceTwo) {
		this.diceOne = diceOne;
		this.diceTwo = diceTwo;
	}
	
	public int getDiceOne() {
		return this.diceOne;
	}
	public int getDiceTwo() {
		return this.diceTwo;
	}
	public void setDiceOne() {
		this.diceOne = (int)(Math.random() * 6) + 1;
	}
	public void setDiceTwo() {
		this.diceTwo = (int)(Math.random() * 6) + 1;
	}
	
	public int getSum() {
		return this.diceOne + this.diceTwo;
	}
	
	public void printWin() {
		System.out.print("You rolled " + this.diceOne + " + " + this.diceTwo + " = " + (this.diceOne + this.diceTwo) + "\n");
	   	System.out.print("Congratulations, You win\n");
	}
	
	public void printLose() {
		System.out.print("You rolled " + this.diceOne + " + " + this.diceTwo + " = " + (this.diceOne + this.diceTwo) + "\n");
	   	System.out.print("Craps, Better Luck Next Time, You lose\n");
	}
}	
	
