/**********************************************
Workshop #09
Course: JAC444
Last Name: Sheng
First Name: Xuewei
ID:061745121
Section: NFF
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature Xuewei Sheng
Date: Dec 1, 2021
**********************************************/
package jac444.ws9.task2;


public class PhilosopherEat {

	public static void main(String[] args) {
		Philosopher[] phs = new Philosopher[5];
		Object[] chops = new Object[5];
		
		for(int i = 0; i < 5; i++) 
		{
			chops[i] = new Object();
		}
		
		for(int i = 0; i < 5; i++)
		{
			Object leftchop = chops[i];
			Object rightchop = chops[(i + 1) % 5];
			
			if(i == 4)
			{
				//change last philosopher pick up the left chop instead
				phs[i] = new Philosopher(leftchop, rightchop);
			}
			else
			{
				phs[i] = new Philosopher(rightchop, leftchop);
			}
			
			Thread t = new Thread(phs[i], "Philosopher " + (i + 1));
			t.start();				
		}
	}

}
