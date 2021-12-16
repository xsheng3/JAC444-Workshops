/**********************************************
Workshop #04
Course: JAC444
Last Name: Sheng
First Name: Xuewei
ID:061745121
Section: NFF
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature Xuewei Sheng
Date: Oct 14, 2021
**********************************************/
package jac444.ws4.invoice;

import jac444.ws4.interfaces.Payable;

public class Invoice implements Payable{
	private String partNumber;
	private String partDescription;
	private int quantity;
	private double pricePerItem;
	
	public Invoice(String partNo, String partDesc, int quantity, double price) {
		setPartNumber(partNo);
		setPartDescription(partDesc);
		setQuantity(quantity);
		setPricePerItem(price);
	}
	
	public void setPartNumber(String partNo) {
		this.partNumber = partNo;
	}
	
	public void setPartDescription(String partDesc) {
		this.partDescription = partDesc;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void setPricePerItem(double price) {
		this.pricePerItem = price;
	}
	
	public String getPartNumber() {
		return this.partNumber;
	}
	
	public String getPartDescription() {
		return this.partDescription;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	public double getPricePerItem() {
		return this.pricePerItem;
	}
	
	@Override
	public String toString() {
		return "Invoice\n" + "Part number: " + this.getPartNumber() + "\nPart description: " + this.getPartDescription()
				+ "\nQuantity: " + this.getQuantity() + "\nPrice for each item: " + this.getPricePerItem();
	}	
	
	public double getPaymentAmount(){
		return this.getPricePerItem() * this.getQuantity();
	}
	
}
