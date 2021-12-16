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
package jac444.ws4.employee.abstracts;

import jac444.ws4.interfaces.Payable;

public abstract class Employee implements Payable{
	private String firstName;
	private String lastName;
	private String socialSecurityNumber;
	
	public Employee(String firstName, String lastName, String socialSecurityNumber) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setSocialSecurityNumber(socialSecurityNumber);
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setSocialSecurityNumber(String sin) {
		this.socialSecurityNumber = sin;
	}
	public String getFirstName() {
		return this.firstName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public String getSocialSecurityNumber() {
		return this.socialSecurityNumber;
	}
	
	@Override
	public String toString() {
		return "Employee name: " + this.getFirstName() + " " + this.getLastName() 
		+ "\nSocial security number: " + this.getSocialSecurityNumber() + "\n";
	}
}
