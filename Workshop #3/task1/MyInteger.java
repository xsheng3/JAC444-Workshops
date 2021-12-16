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
package jac444.ws3.task1;

public class MyInteger {
	private int value;
	
	
	public MyInteger(int value) {
		this.value = value; 
	}
	
	public int getValue() {
		return this.value;
	}
	
	public boolean isEven()
	{
		return this.value % 2 == 0;
	}
	
	public boolean isOdd() {
		return this.value % 2 == 1;
	}
	
	public boolean isPrime() {
		if(this.value < 2)
		{
			return false;
		}
		else if(this.value == 2 || this.value ==3)
		{
			return true;
		}
		else
		{
			int sqrt = (int) Math.sqrt(this.value) + 1;
			for( int i = 2; i < sqrt; i ++)
			{
				if(this.value % i == 0)
				{
					return false;
				}
			}
			return true;
		}
	}
	
	public static boolean isEven(int number)
	{
		return number % 2 == 0;
	}
	
	public static boolean isOdd(int number) {
		return number % 2 == 1;
	}
	
	public static boolean isPrime(int number) {
		if(number < 2)
		{
			return false;
		}
		else if(number == 2 || number ==3)
		{
			return true;
		}
		else
		{
			int sqrt = (int) Math.sqrt(number) + 1;
			for( int i = 2; i < sqrt; i ++)
			{
				if(number % i == 0)
				{
					return false;
				}
			}
			return true;
		}
	}
	
	public static boolean isEven(MyInteger mynum)
	{
		return mynum.value % 2 == 0;
	}
	
	public static boolean isOdd(MyInteger mynum)
	{
		return mynum.value % 2 == 1;
	}
	
	public static boolean isPrime(MyInteger mynum) {
		if(mynum.value < 2)
		{
			return false;
		}
		else if(mynum.value == 2 || mynum.value ==3)
		{
			return true;
		}
		else
		{
			int sqrt = (int) Math.sqrt(mynum.value) + 1;
			for( int i = 2; i < sqrt; i ++)
			{
				if(mynum.value % i == 0)
				{
					return false;
				}
			}
			return true;
		}
	}
	
	
	public boolean equals(int number) {
		return this.value == number;
	}
	
	public boolean equals(MyInteger mynum) {
		return this.value == mynum.value;
	}
	
	public static int parseInt(char[] chars) {
		String s = new String(chars);
		return Integer.parseInt(s);		
	}
	
	public static int parseInt(String str) {
		return Integer.parseInt(str);
	}
	
}

