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

public class TestSales {
	private static final int SALESPERSONNO = 4;
	private static final int PRODUCTNO = 5;
	private static final int SALESLIPSNO = 200;
	
	private double [][] sales = new double[PRODUCTNO][SALESPERSONNO]; 
	private double[] personTt = new double[SALESPERSONNO];
	private double[] prdTt = new double[PRODUCTNO]; 
	
	public void createSaleSlips() {
		//randomly create saleSlips records and assign to correct person and product
		
		SaleSlip [] saleSlips = new SaleSlip[SALESLIPSNO];
		int row, col;
		for(int i = 0; i < saleSlips.length; i++)
		{			
			saleSlips[i] = new SaleSlip((int)(Math.random() * SALESPERSONNO) + 1, (int)(Math.random() * PRODUCTNO) + 1, Math.random() * 100 + 1);
		}
		
		for(row = 0; row < sales.length; row++)
		{
			for(col= 0; col < sales[row].length; col++)
			{
				for(int i = 0; i < saleSlips.length; i++)
				{
					if((saleSlips[i].getPerson() == col + 1) && (saleSlips[i].getProduct() == row + 1))
						   {
					           sales[row][col] += saleSlips[i].getValue();
						   }
				}
			}
		}
	}
	
	//calculate the total sales amount for each type of product, store the value in a double tpye array 
	public void setPrdTotal() {
		for(int row = 0; row < this.sales.length; row++)
		{
			for(int col = 0; col < this.sales[0].length; col++)
			{
				this.prdTt[row] += this.sales[row][col];
			}
		}
	}
	
	//calculate the total sales amount for each salesperson, store the value in a double tpye array 
	public void setPersonTotal() {
		for(int row = 0; row < this.sales.length; row++)
		{
			for(int col = 0; col < this.sales[0].length; col++)
			{
				this.personTt[col] += this.sales[row][col];
			}
		}
	}
	
	
	public static void main(String[] args) {
	    TestSales ts = new TestSales();
	    //randomly create a set of sale slips
	    //the number of the slips is defined as a constant int, and can be changed if needed
		ts.createSaleSlips(); 
		//evoke methods to calculate totals
		ts.setPersonTotal();
		ts.setPrdTotal();
		
		
		//formatted print out the sales 2-dimension array
		System.out.print("Prod/Person      ");
		for(int col = 0; col < ts.sales[0].length; col++)
		{
		    System.out.printf("%-8d", col+1);
		}
		System.out.print("Total\n");
		for(int row = 0; row < ts.sales.length; row++)
		{
			System.out.print("        ");
			System.out.printf("%-9d", row + 1);
			for(int col = 0; col < ts.sales[row].length; col++)
			{
				System.out.printf("%-8.2f",ts.sales[row][col]);		
			}
			System.out.printf("%-8.2f",ts.prdTt[row]);
			System.out.print("\n");			
		}
		System.out.print("        Total    ");
		for(int col = 0; col < ts.sales[0].length; col++)
		{
		    System.out.printf("%-8.2f", ts.personTt[col]);
		}				
	}
}
