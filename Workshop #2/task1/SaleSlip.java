/**********************************************
Workshop #02
Course: JAC444
Last Name: Sheng
First Name: Xuewei
ID:061745121
Section: NFF
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature Xuewei Sheng
Date: Sep 30, 2021
**********************************************/

package jac444.ws2.task1;

public class SaleSlip {
	private int salespersonNo;
	private int productNo;
	private double value;
	
	public SaleSlip(int salespersonNo, int productNo, double value) {
		this.salespersonNo = salespersonNo;
	    this.productNo = productNo;
	    this.value = value;
	}
	
	public int getPerson() {
		return this.salespersonNo;
	}
	
	public int getProduct() {
		return this.productNo;
	}
	
	public double getValue() {
		return this.value;
	}
}
