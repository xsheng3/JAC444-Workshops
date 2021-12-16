/**********************************************
Workshop #07
Course: JAC444
Last Name: Sheng
First Name: Xuewei
ID:061745121
Section: NFF
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature Xuewei Sheng
Date: Nov 16, 2021
**********************************************/
package jac444.ws7.task2;

import java.util.ArrayList;
import java.util.Scanner;

public class TestProcessor {
	
	public static void main(String[] args) {
		System.out.print("Please Enter a list of double number(enter any letter to end): ");
		Scanner sc = new Scanner(System.in);
		ArrayList<Double> dbList = new ArrayList<>();
		double input;
		
		while(sc.hasNextDouble())
		{
			input = sc.nextDouble();
			dbList.add(input);
		}		
		
		double[] dbarr = new double[dbList.size()];
		for(int i = 0; i < dbList.size(); i++)
		{
			dbarr[i] = dbList.get(i);
		}
		
		System.out.print("\nThe numbers you entered: ");
		for(double ele:dbarr)
		{
			System.out.print(ele + ", ");
		}
		System.out.println();		
		
		System.out.println("The maximun number in the list is:" + Processors.maxValue.arrayProcess(dbarr));
		System.out.println("The minimun number in the list is:" + Processors.minValue.arrayProcess(dbarr));
		System.out.println("The sum of numbers in the list is:" + Processors.sumValue.arrayProcess(dbarr));
		System.out.printf("The avarage of numbers in the list is: %.1f%n", Processors.avrgValue.arrayProcess(dbarr));		
		
		System.out.print("\nPlease enter the number you want to find in the array: ");		
		Scanner sc2 = new Scanner(System.in);
		double findNum = sc2.nextDouble();
		System.out.println("Number \"" + findNum + "\" appears " + (int)Processors.counter(findNum).arrayProcess(dbarr) + " time(s) in the list.");
		
		sc.close();
		sc2.close();		
	}

}
