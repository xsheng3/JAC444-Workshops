/**********************************************
Workshop #09
Course: JAC444
Last Name: Sheng
First Name: Xuewei
ID:061745121
Section: NFF
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature Xuewei Sheng
Date: Dec 1, 2021
**********************************************/
package jac444.ws9.task1;


public class MatrixMultiplicaiton {
	public static final int size = 2000;
	public static final int parts = 4;
	
	public static void main(String[] args) throws InterruptedException {
		
		double [][] x = new double[size][size];
		double [][] y = new double[size][size];
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
			{
				x[i][j] = 2; //(int)Math.random() * 5;
				y[i][j] = 2; //(int)Math.random() * 5;				
			}
		}
		long time = System.currentTimeMillis();
		sequentialMultiplyMatrix(x,y);
		System.out.println("Run time of  sequential multiply matrix: " + (System.currentTimeMillis() - time));
		time = System.currentTimeMillis();
		parallelMultiplyMatrix(x,y);
		System.out.println("Run time of  parallel multiply matrix: " + (System.currentTimeMillis() - time));
		
	}
	
	public static double[][] sequentialMultiplyMatrix(double[][] c, double[][] d){
		double temp[][] = new double[size][size];		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++)
			{
				temp[i][j] = 0;
				for(int k = 0; k < size; k++)
				{
					temp[i][j] += c[i][k] * d[k][j];
				}
				//System.out.print(temp[i][j] + " ");
			}
			//System.out.println();
		}
		return temp;
	}
	
	public static double[][] parallelMultiplyMatrix(double[][] a, double[][] b) throws InterruptedException{
		//divide the array into 4 parts, 
		double res1[][] = new double[size/parts][size];
		double res2[][] = new double[size/parts][size];
		double res3[][] = new double[size/parts][size];
		double res4[][] = new double[size/parts][size];
		double result[][] = new double[size][size];
		//create 4 threads
	    Runnable partOne = new CalculatePartial(a, b, res1, 0);
	    Runnable partTwo = new CalculatePartial(a, b, res2, 1);
	    Runnable partThree = new CalculatePartial(a, b, res3, 2);
	    Runnable partFour = new CalculatePartial(a, b, res4, 3);
	    
	    Thread t1 = new Thread(partOne);
	    Thread t2 = new Thread(partTwo);
	    Thread t3 = new Thread(partThree);
	    Thread t4 = new Thread(partFour);
	    
	    //run the thread, after finishing join each of the threads
	    t1.start();
	    t2.start();
	    t3.start();
	    t4.start();
	    t1.join();
	    t2.join();
	    t3.join();
	    t4.join(); 	 
	    
	   //add for part together to get 2-D array result of matrix multiplication
	    
	    for(int i = 0; i < size / parts; i++)
	    {
	    	for(int j = 0; j < size; j++)
	    	{
	    		result[i][j] = res1[i][j];
	    	}
	    }
	    for(int i = size / parts; i < size / parts * 2; i++)
	    {
	    	for(int j = 0; j < size; j++)
	    	{
	    		result[i][j] = res2[i - size / parts][j];
	    	}
	    }
	    for(int i = size / parts * 2; i < size / parts * 3; i++)
	    {
	    	for(int j = 0; j < size; j++)
	    	{
	    		result[i][j] = res3[i - size / parts * 2][j];
	    	}
	    }
	    for(int i = size / parts * 3; i < size / parts * 4; i++)
	    {
	    	for(int j = 0; j < size; j++)
	    	{
	    		result[i][j] = res4[i - size / parts * 3][j];
	    	}
	    }
	    
	    //test the result array
	    /*for(int i = 0; i < size; i++)
	    {
	    	for(int j = 0; j< size; j++)
	    	{
	    		System.out.print(result[i][j] + " ");
	    	}
	    	System.out.println();
	    }*/	    
		return result;
	}
	
	

}
