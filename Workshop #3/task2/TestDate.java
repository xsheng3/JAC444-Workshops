/**********************************************
Workshop #03
Course: JAC444
Last Name: Sheng
First Name: Xuewei
ID:061745121
Section: NFF
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature Xuewei Sheng
Date: Oct 8, 2021
**********************************************/
package jac444.ws3.task2;

import java.util.Scanner;

public class TestDate {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		Utilities uti = new Utilities();
		int choice;
		do
		{
			uti.printChoices();
			choice = Integer.parseInt(read.nextLine());
			while(choice < 1 || choice > 4)
			{
				System.out.println("Invalid input, please enter again!\n");
				uti.printChoices();
				choice = Integer.parseInt(read.nextLine());
			}
			
			if (choice == 1)
			{
				System.out.print("Enter Month (1-12): ");
				int mon = Integer.parseInt(read.nextLine());
				while(mon < 1 || mon > 12)
				{
					System.out.print("Invalid month, please enter again (1-12): ");
					mon = Integer.parseInt(read.nextLine());
				}
				
				System.out.print("Enter Day of Month: ");
				int day = Integer.parseInt(read.nextLine());
				while(!uti.validateDayOfMon(mon, day))
				{
					System.out.print("Invalid day of month, please enter again: ");
					day = Integer.parseInt(read.nextLine());
				}
				System.out.print("Enter Year: ");
				int year = Integer.parseInt(read.nextLine());
				while(year < 0)
				{
					System.out.print("Invalid year, please enter again (year > 0): ");
					year = Integer.parseInt(read.nextLine());
				}
				
				Date date1 = new Date(year, mon, day);
				//date1.print();
				System.out.println(date1.toString());;
				
			}
			

			
			if(choice == 2)
			{
				System.out.print("Enter Month (January to December): ");
				String mon = read.nextLine();
				while(!uti.valiateMonString(mon))
				{
					System.out.print("Invalid month, please enter again (January to December): ");
					mon = read.nextLine();
				}
				int month = Utilities.stringToInt(mon);
				System.out.print("Enter Day of Month: ");
				int day = Integer.parseInt(read.nextLine());
				while(!uti.validateDayOfMon(month, day))
				{
					System.out.print("Invalid day of month, please enter again: ");
					day = Integer.parseInt(read.nextLine());
				}
				System.out.print("Enter Year: ");
				int year = Integer.parseInt(read.nextLine());
				while(year < 0)
				{
					System.out.print("Invalid year, please enter again (year > 0): ");
					year = Integer.parseInt(read.nextLine());
				}
				
				Date date2 = new Date(year, mon, day);
				date2.print();				
			}
			
			if(choice == 3)
			{
				System.out.print("Enter day of the year (1-365): ");
				int day = Integer.parseInt(read.nextLine());
				while(day < 1 || day > 365)
				{
					System.out.print("Invalid day of year, please enter again (1-365): ");
					day = Integer.parseInt(read.nextLine());
				}
				
				System.out.print("Enter Year: ");
				int year = Integer.parseInt(read.nextLine());
				while(year < 0)
				{
					System.out.print("Invalid year, please enter again (year > 0): ");
					year = Integer.parseInt(read.nextLine());
				}
				
				Date date3 = new Date(year, day);
				date3.print();			
			}
		}while(choice != 4);
				
		read.close();
	}

}
