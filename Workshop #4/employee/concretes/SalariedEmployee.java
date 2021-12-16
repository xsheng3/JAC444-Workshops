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

public class SalariedEmployee extends Employee{
	private double weeklySalary;
	
	public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber, double salary) {
		super(firstName, lastName, socialSecurityNumber);
	    this.setWeeklySalary(salary);
	}
	public void setWeeklySalary(double salary) {
		if(salary <= 0)
		   {
			   throw new ArithmeticException("Weekly Salary is not valid.");
		   }
		this.weeklySalary = salary;
	}
	public double getWeeklySalary() {
		return this.weeklySalary;
	}
	
	@Override
	public String toString() {
		return super.toString() + "Weekly salary: " 
	           + String.format("%.2f",this.getWeeklySalary());
	}
	@Override
	public double getPaymentAmount() {
		return this.getWeeklySalary() * 52;
	}
}
