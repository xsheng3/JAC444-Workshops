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

public class Transaction implements Serializable {
	private int accNum;
	private double transAmt;
	
	public int getAccNum() {
		return accNum;
	}
	public void setAccNum(int accNum) {
		this.accNum = accNum;
	}
	public double getTransAmt() {
		return transAmt;
	}
	public void setTransAmt(double transAmt) {
		this.transAmt = transAmt;
	}
	
	public Transaction() {
		this(0,0.0);
	}
	public Transaction(int accNum, double transAmt) {
		super();
		this.accNum = accNum;
		this.transAmt = transAmt;
	}

}
