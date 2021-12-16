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

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class FileMatch {
	private static ObjectInputStream input;
	private static ObjectOutputStream output;
	
	public static Account[] acctList = { new Account(100, "Alan Jones", 348.17), 
			new Account(300, "Mary Smith", 27.19), 
			new Account(500, "Sam Sharp", 0.00),
			new Account(700, "Suzy Green", -14.22)};
	public static Transaction[] transList = { new Transaction(100, 27.14), 
				new Transaction(300, 62.11),
				new Transaction(300, 83.89),
				new Transaction(400, 100.46),
				new Transaction(700, 80.87),
				new Transaction(700, 1.53),
				new Transaction(900, 82.17)};
	
	public static void main(String[] args) {
		CreateData.createFiles();
		
		//read old master file data		
		readMaster("oldmast.txt", false);	
		
		//read transaction file data
		readTrans("trans.txt");		
		
		//combine transaction data to old master data
		combineTransactions();
		
		//create new master file, write data into file and read data to system out 
		createNewMaster();		
		readMaster("newmast.txt", true);
		
		//create log file, write the data in and read data to system out
		createLogFile();
	}
	
	//open file for input stream
	private static void openFile(String fileName) {
		try {
			input = new ObjectInputStream(new FileInputStream(fileName));
		}catch(IOException ex)
		{
			System.err.println("Error opening the file.");
		}
		
	}
	
	private static void closeFile() {
		try{
			input.close();
		}catch (IOException ex)
		{
			System.out.println("Error closing file.");
		}
	}
	
    //read the data from the master file(new or old)
	//store each record of data into an Account object
	//print out the object record
	private static void readMaster(String fileName, boolean isNew) {
		openFile(fileName);
		if(isNew)
		{
			System.out.println("New master file");
		}
		else
		{
			System.out.println("Old master file");
		}
		
		System.out.printf("%-18s%-20s%7s%n", "Account number", "Name", "Balance");
		try {
			while(true)
			{				
				Account record= (Account)input.readObject();
				System.out.printf("%-18d%-20s%-12.2f%n",record.getAccNum(),
														record.getName(),
														record.getBalance());
				if(!isNew)
				{
					
				}							
			}
		}catch(EOFException eox) {
			System.out.println("No more records\n");
		}
		catch(ClassNotFoundException cnfe)
		{
			System.err.println("Invalid object type.");
			
		}
		catch(IOException ex)
		{
			System.err.println("Error reading master file.");
		}
		closeFile();
	}
	
	
    //read the data from the transaction file
	//store each record of data into a Transaction object
	//print out the object record
	private static void readTrans(String fileName) {
		openFile(fileName);
		System.out.println("Transaction file");
		System.out.printf("%-18s%-20s%n", "Account number","Transaction amount");
		try {
			while(true)
			{
				Transaction record= (Transaction)input.readObject();
				System.out.printf("%-18d%-12.2f%n",record.getAccNum(),record.getTransAmt());
			}
		}catch(EOFException eox) {
			System.out.println("No more records\n");
		}
		catch(ClassNotFoundException cnfe)
		{
			System.err.println("Invalid object type.");
			
		}
		catch(IOException ex)
		{
			System.err.println("Error reading transaction record file.");
		}
		closeFile();
	}
	
	//find the matched transaction records for each account
	//update the account amount if match found
	private static void combineTransactions() {
		for(int i = 0; i < transList.length; i++)
		{
			for(int j = 0; j < acctList.length; j++)
			{
				if(transList[i].getAccNum() == acctList[j].getAccNum())
				{
					acctList[j].combine(transList[i]);
				}
			}			
		}	
	}
	
	//create a new master file, write the updated Account objects into the new file
	private static void createNewMaster() {
		try {
			output = new ObjectOutputStream(new FileOutputStream("newmast.txt"));
		}catch(IOException ex)
		{
			System.err.println("Error opening new master file.");
		}
		
		for(int i = 0; i < acctList.length; i++)
		{
			try {
				Account record= new Account(acctList[i].getAccNum(),
						acctList[i].getName(),
						acctList[i].getBalance());
				output.writeObject(record);
			}catch(IOException ex)
			{
				System.err.println("Error writting to new master file.");
				break;
			}
		}
		try{
			output.close();
		}catch (IOException ex)
		{
			System.out.println("Error closing new master file.");
		}
	}
	
	//create a log file, 
	//find out the unmatched transactions and write their account number into the log file
	//read the 
	private static void createLogFile() {
		File file = new File("log.txt");
		try(FileWriter fw = new FileWriter(file);
				FileReader fr = new FileReader(file))	
		{
			//if this transaction is not matched any of the accounts, record the account number
			//into a integer array
			ArrayList<Integer> log = new ArrayList<>();
			boolean isFound;
			for(int i = 0; i < transList.length; i++)
			{
				isFound = false;
				for(int j = 0; j < acctList.length; j++)
				{
					if (transList[i].getAccNum() == acctList[j].getAccNum())
					{
						isFound = true;
						break;
					}					
				}if(!isFound)
				{
					log.add(transList[i].getAccNum());
				}
			}	
			int[] acctsNo = new int[log.size()];
			for(int i = 0; i < acctsNo.length; i++)
			{
				acctsNo[i] = log.get(i);
			}
		    
			//write the string and the account number array into the log file
			//before writing, convert the integer array into a string first to use the FileRead and FileWrite stream
			String s = Arrays.toString(acctsNo).replaceAll("\\[|\\]", "");
			fw.write("Unmatched transaction record for account number: " );
			fw.write(s);
			fw.close();
			
			//read the text data from the log, and print it out
			int c;
			while((c = fr.read()) != -1) {
				System.out.print((char)c);
			}	
			System.out.print("\n");
			fr.close();
			
		}catch(IOException ex)
		{
			System.out.println("Error creating log file");
		}		
	}
}
