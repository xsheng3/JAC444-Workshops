/**********************************************
Workshop #05
Course: JAC444
Last Name: Sheng
First Name: Xuewei
ID:061745121
Section: NFF
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature Xuewei Sheng
Date: Oct 25, 2021
**********************************************/

package jac444.ws5.task1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CreateData{
	private static ObjectOutputStream output;
	
	public static void createFiles() {
		writeAccountData("oldmast.txt", FileMatch.acctList);
		writeTransactionData("trans.txt", FileMatch.transList);		
	}    
	
	//open file for output stream
	private static void openFile(String fileName) {
			try {
				output = new ObjectOutputStream(new FileOutputStream(fileName));
			}catch(IOException ex)
			{
				System.err.println("Error opening the file.");
			}		
		}
	
	//close output file
	private static void closeFile() {
		try{
			output.close();		
		}catch(IOException ex)
		{
			System.out.println("Error closing file.");
		}
	}
	
    //account data serialization
	public static void writeAccountData(String fileName, Account[] accts) {
		openFile(fileName);
		try {
			for(int i = 0; i < accts.length; i++)
			{
				output.writeObject(accts[i]);
			}
			
		}catch(IOException ex)
		{
			System.err.println("Error writting to transaction file.");
		}
		
		closeFile();		
	}
	
	//transaction data serialization
	private static void writeTransactionData(String fileName, Transaction[] trans) {
		openFile(fileName);
		try {
			for(int i = 0; i < trans.length; i++)
			{
				output.writeObject(trans[i]);
			}	
		}catch(IOException ex)
		{
			System.err.println("Error writting to transaction file.");			
		}
		closeFile();
	}	
}
