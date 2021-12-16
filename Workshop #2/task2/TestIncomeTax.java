/**********************************************
Workshop #02
Course: JAC444
Last Name: Sheng
First Name: Xuewei
ID:061745121
Section: NFF
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature Xuewei Sheng
Date: Sep 30, 2021
**********************************************/

package jac444.ws2.task2;

import java.util.Scanner;

public class TestIncomeTax {	
	public static void printHeader() {
		System.out.println("--------------------------------------------------------------");
		System.out.println("Taxable     Single     Married Joint   Married       Head of");
		System.out.println("Income                 or Qualifying   Separate      a House");
		System.out.println("                       Widow(er)");
		System.out.println("--------------------------------------------------------------");
	}
	
	//get tax for each element in the table and print
	public static void printTable(int[][] intervals, double[] rates, int amtFrom, int amtTo) {
		for(int row = 0; row < ((amtTo - amtFrom) / 1000 + 1); row++)
		{
			System.out.print(amtFrom + 1000 * row);
			for(int col = 0; col < 4; col++)
			{
				IncomeTax it = new IncomeTax(col, intervals, rates, amtFrom + 1000 * row);
				double tax = it.getTax();
				System.out.printf("%14.2f",tax);
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}

	public static void main(String[] args) {
		int[][] intervalsFor2001 = {
				{27050, 65550, 136750, 297350}, //single
				{45200, 109250, 166500, 297350}, //married_jontly or widow
				{22600, 54625, 83250, 148675}, // married separately
				{36250, 93650, 151650, 297350} //head of household
		};
		int[][] intervalsFor2009 = {
				{8350, 33950, 82250, 171550, 372950}, //single
				{16700, 67900, 137050, 208850, 273950}, //married_jontly or widow
				{8350, 33950, 68525, 104425, 186475}, // married separately
				{11950, 45500, 117450, 190200, 372950} //head of household
		};
		double[] ratesFor2001 = {0.15, 0.275, 0.305, 0.355, 0.391};
		double[] ratesFor2009 = {0.1, 0.15, 0.25, 0.28, 0.33, 0.35};
		
		int choice = -1;
		Scanner scan = new Scanner(System.in);
		do {
			System.out.print("Please enter the choice(1 for Tax Calculate, 2 for Tax Tables, -1 to quit): ");
			
			
			choice = scan.nextInt();
			while(choice != 1 && choice != 2 && choice != -1)
			{
				System.out.print("Invalid chioce, please enter agian(1 for Tax Calculate, 2 for Tax Tables, -1 to quit): ");
				choice = scan.nextInt();
			}
			
			//if user choose 1, prompt to enter filing status and taxable income, calculate the tax and print
			if(choice == 1)
			{
				System.out.println("0 - single filer");
				System.out.println("1 - married jointly or qualifying widow(er)");
				System.out.println("2 - married separately");
				System.out.println("3 - head of household)");
				System.out.print("Enter the filing status: ");
				int filing = scan.nextInt();
				while(filing >3 || choice < 0)
				{
					System.out.print("Invalid chioce, please enter agian(0 to 3): ");
					filing = scan.nextInt();
				}
				System.out.print("Enter the Taxable Income: ");
				int income = scan.nextInt();
				IncomeTax intax = new IncomeTax(filing, intervalsFor2009, ratesFor2009, income);
				System.out.printf("Tax is: %.2f \n\n", intax.getTax());			
			}
			
			//if user chose 2, prompt to enter taxable income range 
			if(choice == 2)
			{
				System.out.print("Enter the amount From: ");
				int amtFrom = scan.nextInt();
				System.out.print("Enter the amount To: ");
				int amtTo = scan.nextInt();
				System.out.println("2001 tax tables for taxable income from $" + amtFrom + " to $" + amtTo);
				printHeader();
				//based on the tax rates of 2001
				//calculate taxes for each filing status and amount (for increasing by $1000 for each row)			
				//print the taxes in a table
			    printTable(intervalsFor2001, ratesFor2001, amtFrom, amtTo);
				
			    //print the same content for the tax rates of 2009
			    System.out.println("2009 tax tables for taxable income from $" + amtFrom + " to $" + amtTo);
				printHeader();
			    printTable(intervalsFor2009, ratesFor2009, amtFrom, amtTo);
			    System.out.print("\n");
		}		
		}while(choice != -1);
		scan.close();
	}

}
