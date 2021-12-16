/**********************************************
Workshop #01
Course: JAC444
Last Name: Sheng
First Name: Xuewei
ID:061745121
Section: NFF
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature Xuewei Sheng
Date: Sep 25, 2021
**********************************************/
package task2and3;

import java.util.Scanner;


public class Wager {
	private static int bankBalance = 1000;
	private static int wager;
	
	//play a round of Craps
	public void play() {	
		//set generate random integers for diceOne and diceTwo and get the sum of them
		Craps craps = new Craps();
		craps.setDiceOne();
		craps.setDiceTwo();
		int sum = craps.getSum();
		
		//win scenario
	    if(sum == 7 || sum == 11)
		{
	    	bankBalance += wager;
	    	craps.printWin();
			System.out.print("Your Bank Balance is: " + bankBalance + "\n\n"); 			   	
		}
	    
	    //lose scenario, check every time after losing if the balance is 0, if it is, game over
	    else if(sum == 2 || sum == 3 || sum == 12)
	    {
	    	bankBalance -= wager;
	    	craps.printLose();
		   	System.out.print("Your Bank Balance is: " + bankBalance + "\n\n"); 
		   	if(bankBalance == 0)
		   	{
		   		System.out.print("Sorry. You busted!");
		   	}
	    }
	    
	    //set to point scenario
	    else
	    {
	    	//set to point and print
	    	int point = sum;
		   	System.out.print("\nYou rolled " + craps.getDiceOne() + " + " + craps.getDiceTwo() + " = " + sum + "\n");
		   	System.out.print("Point is (established) set to " + sum + "\n");
		   	
		   	//loop rolling dices until win (new sum = point) or lose (new sum = 7)
		   	do {
		   		craps.setDiceOne();
				craps.setDiceTwo();
		 	    sum = craps.getSum();
		 	    if(sum == 7)
			    {
		 	    	bankBalance -= wager;
		 	    	craps.printLose();
		 	    	System.out.print("Your Bank Balance is: " + bankBalance + "\n\n"); 
				   	if(bankBalance == 0)
				   	{
				   		System.out.print("Sorry. You busted!");
				   	}
		 		}
		 	    else if(sum == point)
		 	    {
		 	    	bankBalance += wager;
		 	    	craps.printWin();
				   	System.out.print("Your Bank Balance is: " + bankBalance + "\n\n"); 
				   	
				   	}
			 	else
			    {
			 		System.out.print("You rolled " + craps.getDiceOne() + " + " + craps.getDiceTwo() + " = " + sum + "\n");
	 		    }			 		    	
 	    	}while(sum != point && sum != 7);
		}	
	}

	
	public static void main(String[] args) {
		Chatter chat = new Chatter();
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter your wager: ");
		wager = input.nextInt();
		while(wager > bankBalance || wager < 0)
		{
			if(wager > bankBalance)
			{
				System.out.print("Your balance in insufficient, please enter again(< " + bankBalance + "): ");
				wager = input.nextInt();
			}
			else if(wager < 0)
			{
				System.out.print("Wager must be positive, please enter again: ");
				wager = input.nextInt();
			}
			
		}
		
		chat.generateString();
		
		Wager wagerobj = new Wager();
		wagerobj.play();
		
		//if not busted, prompt user if to start another round of game
		if(bankBalance > 0)
		{
			chat.generateString();
			
			System.out.print("Try again (y or n)?");
	    	char c = input.next().charAt(0);
	    	//loop to continue if user choose yes at the end of every round of game, check if busted at before starting a new round
			while (c == 'y' && bankBalance > 0)
			{
				System.out.print("Please enter your wager: ");
				wager = input.nextInt();
				while(wager > bankBalance || wager < 0)
				{
					if(wager > bankBalance)
					{
						System.out.print("Your balance in insufficient, please enter again(< " + bankBalance + "): ");
						wager = input.nextInt();
					}
					else if(wager < 0)
					{
						System.out.print("Wager must be positive, please enter again: ");
						wager = input.nextInt();
					}
					
				}
				chat.generateString();
				wagerobj.play();
				if(bankBalance > 0)
				{
					System.out.print("Try again (y or n)?");
					c = input.next().charAt(0);
				}				
			}
		}
    	
		input.close();
		
	}

}
