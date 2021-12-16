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

public class CommissionEmployee extends Employee{
   private double grossSales;
   private double commissionRate;
   
   public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales, double commissionRate) {
	   super(firstName, lastName, socialSecurityNumber);
	   this.setGrossSales(grossSales);
	   this.setCommissionRate(commissionRate);	   
   }
   
   public void setGrossSales(double grossSales) {
	   if(grossSales <= 0)
	   {
		   throw new ArithmeticException("GrossSales is not valid.");
	   }
		   this.grossSales = grossSales; 	   
   }
   public void setCommissionRate(double commissionRate) {
	   if(commissionRate < 0 || commissionRate > 1)
	   {
		   throw new ArithmeticException("CommissionRate is not valid.");
	   }
	   this.commissionRate = commissionRate;
   }
   public double getGrossSales() {
	   return this.grossSales;
   }
   public double getCommissionRate() {
	   return this.commissionRate;
   }
   
   @Override
   public String toString() {
	   return super.toString() + "Gross sales: " + String.format("%.2f",this.getGrossSales()) 
	           + "\nCommission rate: " + this.getCommissionRate();
   }
   
   @Override
   public double getPaymentAmount() {
	   return this.getGrossSales() * this.getCommissionRate();
   }
   
}
