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
package jac444.ws4.employee.concretes;

import jac444.ws4.employee.abstracts.Employee;

public class HourlyEmployee extends Employee {
	private double wage;
	private double hours;
	
	public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, double wage, double hours) {
		super(firstName, lastName, socialSecurityNumber);
		this.setWage(wage);
		this.setHours(hours);
	}
	public void setWage(double wage) {
		 if(wage <= 0)
		   {
			   throw new ArithmeticException("Wage is not valid.");
		   }
		this.wage = wage;
	}
	public void setHours(double hours) {
		if(hours < 0 || hours > 168)
		   {
			   throw new ArithmeticException("Hours is not valid.");
		   }
		this.hours = hours;
	}
	public double getWage() {
		return this.wage;
	}
	public double getHours() {
		return this.hours;
	}
	
	@Override
	public String toString() {
		return super.toString() + "Wage: " 
	            + String.format("%.2f",this.getWage()) + "\nHours: " + this.getHours();
	}	
	@Override
	public double getPaymentAmount() {
		return this.getWage() * this.getHours() * 52;
	}

}
