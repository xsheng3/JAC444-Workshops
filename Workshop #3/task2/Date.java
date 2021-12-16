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

public class Date {
	private int year;
	private int month;
	private int day;
	
	//three overload constructors with different types of arguments
	public Date(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public Date(int year, String month, int day) {
		this.year = year;
		this.month = Utilities.stringToInt(month);
		this.day = day;
	}
	
	public Date(int year, int day) {
		this.year = year;
		this.setMonDay(day);
	}	

	//convert the day of the year to the month and the day of the month
	//then set the month and day to this object
	public void setMonDay(int dayOfYear) {
		if(dayOfYear > 334)
		{
			this.month = 12;
			this.day = dayOfYear - 334;
		}
		else if(dayOfYear <= 334 && dayOfYear > 304)
		{
			this.month = 11;
			this.day = dayOfYear -304;
		}
		else if(dayOfYear <= 304 && dayOfYear > 273)
		{
			this.month = 10;
			this.day = dayOfYear - 273;
		}
		else if(dayOfYear <= 273 && dayOfYear > 243)
		{
			this.month = 9;
			this.day = dayOfYear - 243;
		}
		else if(dayOfYear <= 243 && dayOfYear > 212)
		{
			this.month = 8;
			this.day = dayOfYear - 212;
		}
		else if(dayOfYear <= 212 && dayOfYear > 181)
		{
			this.month = 7;
			this.day = dayOfYear - 181;
		}
		else if(dayOfYear <= 181 && dayOfYear > 151)
		{
			this.month = 6;
			this.day = dayOfYear - 151;
		}
		else if(dayOfYear <= 151 && dayOfYear > 120)
		{
			this.month = 5;
			this.day = dayOfYear - 120;
		}
		else if(dayOfYear <= 120 && dayOfYear > 90)
		{
			this.month = 4;
			this.day = dayOfYear - 90;
		}
		else if(dayOfYear <= 90 && dayOfYear > 59)
		{
			this.month = 3;
			this.day = dayOfYear - 59;
		}
		else if(dayOfYear <= 59 && dayOfYear > 31)
		{
			this.month = 2;
			this.day = dayOfYear - 31;
		}
		else 
		{
			this.month = 1;
			this.day = dayOfYear;
		}
	}	
	
	//calculate the day of the year
	public int calDayOfYear() {
		int dayOfYear = 0;
		switch(this.month) 
		{
		case 1: 
			dayOfYear = this.day;
			break;
		case 2:
			dayOfYear = this.day + 31;
	        break;
		case 3:
			dayOfYear = this.day + 59;
		    break;
		case 4:
			dayOfYear = this.day + 90;
		    break;
		case 5:
			dayOfYear = this.day + 120;
		    break;
		case 6:
			dayOfYear = this.day + 151;
		    break;
		case 7:
			dayOfYear = this.day + 181;
		    break;
		case 8:
			dayOfYear = this.day + 212;
		    break;
		case 9:
			dayOfYear = this.day + 243;
		    break;
		case 10:
			dayOfYear = this.day + 273;
		    break;
		case 11:
			dayOfYear = this.day + 304;
		    break;
		case 12:
			dayOfYear = this.day + 334;
		    break;		
		}
		return dayOfYear;
	}
	
	//print an object
	public void print()
	{		
		System.out.print("\n");System.out.println("MM/DD/YYYY: " + this.month + "/" + this.day + "/" + this.year);
		System.out.println("Month DD, YYYY: " + Utilities.intToString(this.month) + " " + this.day + ", " + this.year);
		System.out.println("DDD YYYY: " + this.calDayOfYear() + " " + this.year);
		System.out.print("\n");
	}
	
	//anohter way to print the object
	public String toString() {
		return "\n"
	           + "MM/DD/YYYY: " + this.month + "/" + this.day + "/" + this.year + "\n"
	           + "Month DD, YYYY: " + Utilities.intToString(this.month) + " " + this.day + ", " + this.year + "\n"
	           + "DDD YYYY: " + this.calDayOfYear() + " " + this.year
	           + "\n";
	}
}
