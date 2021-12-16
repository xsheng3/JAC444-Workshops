/**********************************************
Workshop #01
Course: JAC444
Last Name: Sheng
First Name: Xuewei
Date: Sep 25, 2021
**********************************************/
package task1;

import java.util.Scanner;

public class Encrypt {
		
	public int coding (int source){
		//store the source 4 digit integer into a 4 elements array
		int[] digits = new int[4];
		digits[0]= source / 1000;
		digits[1] = source % 1000 / 100;
		digits[2] = source % 100 / 10;
		digits[3] = source % 10;
		
		//treat each digit
		for(int i = 0; i < digits.length; i++)
		{
			digits[i] = (digits[i] + 7) % 10;
		}
		
		//swap first and third digit
		int temp = digits[0];
		digits[0] = digits[2];
		digits[2] = temp;
		//swap second and fourth digit
		temp = digits[1];
		digits[1] = digits[3];
		digits[3] = temp;
		
		return digits[0] * 1000 + digits[1] * 100 + digits[2] * 10 +digits[3];
	}

	public int decoding(int encryped) {
		//store the source 4 digit integer into a 4 elements array
		int[] digits = new int[4];
		digits[0]= encryped / 1000;
		digits[1] = encryped % 1000 / 100;
		digits[2] = encryped % 100 / 10;
		digits[3] = encryped % 10;
		
		//swap first and third digit back
		int temp = digits[0];
		digits[0] = digits[2];
		digits[2] = temp;
		//swap second and fourth digit back
		temp = digits[1];
		digits[1] = digits[3];
		digits[3] = temp;
		
		
		for(int i = 0; i < digits.length; i++)
		{
			digits[i] = (digits[i] + 3) % 10;
		}
		
		 return digits[0] * 1000 + digits[1] * 100 + digits[2] * 10 +digits[3];
	}
	
	
	public static void main(String[] args) {
		int source;
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter four-digit integer: ");
		source = scan.nextInt();
		while(source < 1000 || source > 9999)
		{
			System.out.print("Out of range, please enter four digit integer again: ");
			source = scan.nextInt();
		}
		scan.close();
		
		Encrypt enc = new Encrypt();
		int encrypted = enc.coding(source);
		int decrypted = enc.decoding(encrypted);
		
		System.out.print("Source integer is: " + source + "\n");
		System.out.print("Encrypted Integer is: " + encrypted + "\n");
		System.out.print("Decrypted Integer is: " + decrypted + "\n");
	}

}



