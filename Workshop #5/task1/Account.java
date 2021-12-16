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

import java.io.Serializable;

public class Account implements Serializable {
	private int accNum;
	private String name;
	private double balance;
	
	public int getAccNum() {
		return accNum;
	}
	public void setAccNum(int accNum) {
		this.accNum = accNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public  double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public Account() {
		this(0, "" , 0.0);
	}
	public Account(int accNum, String name, double balance) {
		super();
		this.accNum = accNum;
		this.name = name;
		this.balance = balance;
	}

	public void combine(Transaction transRecd) {
		if(transRecd.getAccNum() == this.getAccNum()) 
		{
			this.balance += transRecd.getTransAmt(); 
		}
	}
}
