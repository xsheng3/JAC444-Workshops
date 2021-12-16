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


public class CalculatePartial implements Runnable{
	private double[][] a = new double[MatrixMultiplicaiton.size][MatrixMultiplicaiton.size];
	private double[][] b = new double[MatrixMultiplicaiton.size][MatrixMultiplicaiton.size];
	private double[][] res = new double[MatrixMultiplicaiton.size / MatrixMultiplicaiton.parts][MatrixMultiplicaiton.size];

	private int partNo;
	
	public CalculatePartial(double[][] a, double[][] b, double[][] res, int partNo)
	{
		this.a = a;
		this.b = b;
		this.res = res;
		this.partNo = partNo;
	}

	@Override
	public void run() {
		for(int i = 0; i < MatrixMultiplicaiton.size / MatrixMultiplicaiton.parts; i++) {
			for(int j = 0; j < MatrixMultiplicaiton.size; j++)
			{
				res[i][j] = 0;
				for(int k = 0; k < MatrixMultiplicaiton.size; k++)
				{
					res[i][j] += a[i + partNo * MatrixMultiplicaiton.size / MatrixMultiplicaiton.parts][k] * b[k][j];					
				}
				//System.out.print(res[i][j] + " ");
				
			}
			//System.out.println();
		}		
	}

}
