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

public class BasePlusCommissionEmployee extends CommissionEmployee {
	private double baseSalary;	
	
	public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales, double commissionRate, double baseSalary) {
		super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);
		this.setBaseSalary(baseSalary);
	}
	
	public void setBaseSalary(double baseSalary) {
		if(baseSalary <= 0)
		   {
			   throw new ArithmeticException("Base salary is not valid.");
		   }
		this.baseSalary = baseSalary;
	}
	public double getBaseSalary()
	{
		return this.baseSalary;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nBase salary: " + String.format("%.2f", this.baseSalary);
	}	
	@Override
	public double getPaymentAmount() {
		return super.getPaymentAmount() + this.baseSalary;
	}	
}
