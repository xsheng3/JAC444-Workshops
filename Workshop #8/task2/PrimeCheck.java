/**********************************************
Workshop #08
Course: JAC444
Last Name: Sheng
First Name: Xuewei
ID:061745121
Section: NFF
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature Xuewei Sheng
Date: Nov 23, 2021
**********************************************/
package jac444.ws8.task2;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class PrimeCheck {

	public static void main(String[] args) {		
		Set<PrimeFactor> factors = new LinkedHashSet<>();		
		Scanner scan= new Scanner(System.in);
		System.out.print("Enter an positive integer number(-1 to exit): ");
		int input = scan.nextInt();
		while (input != -1)
		{   //check if the input integer is a prime number
			//if it is, find out all the prime factors from 2, and store it in the linked set
			boolean isPrime = true;
			int i = 2;
			int index = 0;
			int temp = input;
			while(i <= input / 2)
			{
				if(temp % i == 0)
				{
					factors.add(new PrimeFactor(index, i));
					temp /= i;
					index++;
					isPrime = false;
				}
				else
				{
					i++;
				}
			}
			
			
			//print
			if(isPrime)
			{
				System.out.println("Number " + input + " is a prime number.");
			}
			
			else
			{
				System.out.println("Number " + input + " is not a prime number.");
				System.out.print("It's prime factors: ");
				for(PrimeFactor ele : factors)
				{
					System.out.print(ele.getValue() + " ");
				}		
				System.out.println();
			}	
			
			factors.clear();
			System.out.println();			
			System.out.print("Enter an positive integer number(-1 to exit): ");
			input = scan.nextInt();			
		}			
		scan.close();
	}

}
