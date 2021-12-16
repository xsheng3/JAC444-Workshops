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

package jac444.ws2.task2;

public class IncomeTax {
	private static final int SINGLE_FILER = 0;
	private static final int MARRIED_JOINTLY_OR_QUALIFYING_WIDOWER = 1;
	private static final int MARRIED_SEPARATELY = 2;
	private static final int HEAD_OF_HOUSEHOLD = 3;	
	
	private int filingStatus;
	private int[][] intervals;
	private double[] rates; 
	private double taxableIncome;
	
	public void setFilingStatus(int status) {
		this.filingStatus = status;
	}
	
	public void setTaxableIncome(double income) {
		this.taxableIncome = income;
	}
	
	public void setIntervals(int[][] intervals) {
	   this.intervals = new int[intervals.length][intervals[0].length];
	   for(int row = 0; row < intervals.length; row++) {
		   for(int col = 0; col < intervals[0].length; col++)
		   {
			   this.intervals[row][col]= intervals[row][col];
		   }
	   }
	}
	
	public void setRates(double[] rates) {
		this.rates = new double[rates.length];
		for(int i = 0; i < rates.length; i++)
		{
			this.rates[i] = rates[i];
		}		
	}
	
	public int getFilingStatus() {
		return this.filingStatus;
	}
	
	public int[][] getIntervals(){
		return this.intervals;
	}
	
	public double[] getRate() {
		return this.rates;
	}
	
	public double getTaxableIncome() {
		return this.taxableIncome;
	}

    public IncomeTax() {
    	
    }
    
    public IncomeTax(int filingStatus, int[][] intervals, double[] rates, double taxableIncome) {
    	setFilingStatus(filingStatus);
    	setIntervals(intervals);
    	setRates(rates);    	
    	setTaxableIncome(taxableIncome);
    }
    
    public double getTax() {
    	double tax = 0;
    	double taxedIncome = 0;
    	double remainedIncome = taxableIncome;

    	if(remainedIncome > intervals[this.filingStatus][0])
    	{
    		tax =+ intervals[this.filingStatus][0] * this.rates[0];
        	for(int i = rates.length - 2; i >= 0; i--)
        	{
        		if(remainedIncome > intervals[this.filingStatus][i])
        		{
        			taxedIncome = remainedIncome - intervals[this.filingStatus][i];
        			tax += taxedIncome * this.rates[i+1];
        			remainedIncome -= taxedIncome;        		
        		}
        	}
    	}
    	else
    	{
    		tax = remainedIncome * this.rates[0];
    	} 	
    	
      	return tax;    
    }
}
