/**********************************************
Workshop #07
Course: JAC444
Last Name: Sheng
First Name: Xuewei
ID:061745121
Section: NFF
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature Xuewei Sheng
Date: Nov 16, 2021
**********************************************/
package jac444.ws7.task2;

public class Processors {
	public static final ArrayProcessor maxValue = arr ->{
		double max = arr[0];
		for(double ele: arr)
		{
			max = ele > max ? ele : max;
		}
		return max;
	};
	
	public static final ArrayProcessor minValue = arr ->{
		double min = arr[0];
		for(double ele:arr)
		{
			min = ele < min ? ele : min;
		}
		return min;
	};
	
	public static final ArrayProcessor sumValue = arr ->{
		double sum = 0.0;
		for(double ele: arr)
		{
			sum += ele;
		}
		return sum;
	};
	
	public static final ArrayProcessor avrgValue = arr ->{
		double sum = 0.0;
		for(double ele: arr)
		{
			sum += ele;
		}
		return sum / arr.length;
	};
	
	public static ArrayProcessor counter(double value ) {
		return arr -> {
			int count = 0;
			for(double ele:arr) 
			{
				if(ele == value)
				{
					count++;
				}
			}
			return count;
		};
	}

}
