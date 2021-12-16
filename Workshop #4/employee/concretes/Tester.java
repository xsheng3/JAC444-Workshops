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

import jac444.ws4.interfaces.Payable;
import jac444.ws4.invoice.Invoice;

public class Tester {
	public static void main(String[] args) {		
		System.out.println("************************************");
		System.out.println("*      Payroll System Test         *");
		System.out.println("************************************");
		
		try
		{
			Payable[] payableObjs = {new Invoice("001", "Outdoor Furniture", 30, 499.99), 
					new Invoice("002", "Gardening", 20, 34.99),
					new SalariedEmployee("Jean", "Zhang", "111111111", 1000),
					new HourlyEmployee("Vincent", "Saccucci", "222222222", 35, 40),
					new CommissionEmployee("Rebeca", "Fang", "333333333", 300200, 0.2),
					new BasePlusCommissionEmployee("John", "Lane", "444444444", 402000, 0.1, 30000 )
					};
			for(int i = 0; i < payableObjs.length; i ++)
			{
				if(payableObjs[i] instanceof BasePlusCommissionEmployee)
				{
					((BasePlusCommissionEmployee)payableObjs[i])
					  .setBaseSalary(((BasePlusCommissionEmployee)payableObjs[i]).getBaseSalary()*1.1);
					System.out.println("Note: Base Salary Of This Employee Is Increased By 10% ");
				}
				System.out.println(payableObjs[i].toString());
			    System.out.println("Total payment amount: " +String.format("%.2f", payableObjs[i].getPaymentAmount()) + "\n");		
			}	
		}catch(ArithmeticException ex)
		{
			System.out.println(ex);
		}
	}

}
