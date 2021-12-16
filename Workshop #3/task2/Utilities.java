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

public class Utilities {
	private static String[] months = {"January", "February", "March", "April", 
			"May", "June", "July", "August", 
			"Sepember", "October", "November", "December"};
	
	public void printChoices(){
		System.out.println("Enter 1 for format: MM/DD/YYYY");
		System.out.println("Enter 2 for format: Month DD, YYYY");
		System.out.println("Enter 3 for format: DDD YYYY");
		System.out.println("Enter 4 to exit");
		System.out.print("Choice: ");
	}
	
	public boolean validateDayOfMon(int mon, int day) {
		boolean isValid = false;
		if(mon == 2)
		{
			if(day >= 1 && day <= 28)
			{
				isValid = true; 
			}
		}
		else if(mon == 1 || mon == 3 || mon == 5 || mon == 7 || mon == 8 
				|| mon == 10 || mon == 12)
		{
			if(day >= 1 && day <= 31)
			{
				isValid = true; 
			}
		}
		else
		{
			if(day >= 1 && day <= 30)
			{
				isValid = true; 
			}
		}
		
		return isValid;
	}
	
	public boolean valiateMonString(String mon) {
		boolean isValid = false;
		for (String month : months)
		{
			if (mon.equals(month))
			{
				isValid = true;
			}
		}
		return isValid;
	}
	
	public static String intToString(int month) {
		return months[month - 1];
	}
	
	public static int stringToInt(String month) {
		int i = 0;
		boolean found = false;
		for (i = 0; i < 12 && found == false; i++)
		{
			if(month.equals(months[i]))
			{
				found =true;
			}
		}
		return i;
	}

}
