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

import java.util.Scanner;

public class TestMyInteger {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		System.out.println("Test MyInteger constructor and get() method:");
		System.out.println("--------------------------------------------");	
		System.out.print("Please enter a integer: ");
	    int number = read.nextInt();	
	    System.out.println("You entered: " + number);
	    
	    //test constrctor and get() method
	    //MyInteger object myint created
        MyInteger myint = new MyInteger(number);     
        System.out.println("MyInteger object \"myint\" with value " + number + " is created.");
        System.out.println("The value of \"myint\" is: " + myint.getValue());
        System.out.println("\n");
        
        //Test isEven(), isOdd(), isPrime() methods
        System.out.println("Test isEven(), isOdd(), isPrime() methods");
        System.out.println("-----------------------------------------");	
        System.out.println("Is " + myint.getValue() + " an even number? " + myint.isEven());
        System.out.println("Is " + myint.getValue() + " an odd number? " + myint.isOdd());
        System.out.println("Is " + myint.getValue() + " an prime number? " + myint.isPrime());
        System.out.println("\n");
        
        //Test isEven(int), isOdd(int), isPrime(int) static methods
        System.out.println("Test isEven(int), isOdd(int), isPrime(int) static methods");
        System.out.println("---------------------------------------------------------");
        System.out.println("Is " + number + " an even number? " + MyInteger.isEven(number));
        System.out.println("Is " + number + " an odd number? " + MyInteger.isOdd(number));
        System.out.println("Is " + number + " an prime number? " + MyInteger.isPrime(number));
        System.out.println("\n");
        
        //Test isEven(MyInteger), isOdd(MyInteger), isPrime(MyInteger) static methods
        System.out.println("Test isEven(MyInteger), isOdd(MyInteger), isPrime(MyInteger) static methods");
        System.out.println("---------------------------------------------------------------------------");
 
        System.out.println("Is " + number + " an even number? " + MyInteger.isEven(myint));
        System.out.println("Is " + number + " an odd number? " + MyInteger.isOdd(myint));
        System.out.println("Is " + number + " an prime number? " + MyInteger.isPrime(myint));
        System.out.println("\n");
        
        //Test equals(int), equals(MyInteger) methods
        System.out.println("Test equals(int), equals(MyInteger) methods");
        System.out.println("-------------------------------------------");
        //create a new MyInteger object "myint2"
        System.out.print("Please enter a integer for \"myint2\": ");
        number = read.nextInt();
        System.out.println("You entered: " + number);
        MyInteger myint2 = new MyInteger(number);
        System.out.println("New MyInteger object \"myint2\" with value " + number + " is created.");
        
        //display two MyInteger objects
        System.out.println("The value of \"myint\" is: " + myint.getValue());
        System.out.println("The value of \"myint2\" is: " + myint2.getValue());
        
        //Test equals(MyInteger) and equals(int) methods
        System.out.println("Is \"myint\"equals \"myint2\"? " + myint.equals(myint2));
        System.out.println("Is " + number + " equals \"myint\"? " + myint.equals(number));
        System.out.println("Is " + number + " equals \"myint2\"? " + myint2.equals(number));        
        System.out.println("\n");
        
        //Test parseInt(char[]), parseInt(Sting) methods
        System.out.println("Test parseInt(char[]), parseInt(Sting) methods");
        System.out.println("----------------------------------------------");
        //create a string and a character array
        String str = "789";
        char[] charArray = {'5','6','7'};
        System.out.println("String \"789\" parses to integer is: " + MyInteger.parseInt(str));
        System.out.println("Character array {'5', '6','7'} parses to integer is: " + MyInteger.parseInt(charArray));
        
        read.close();   
    }
}

