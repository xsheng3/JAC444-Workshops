/**********************************************
Workshop #08
Course: JAC444
Last Name: Sheng
First Name: Xuewei
ID:061745121
Section: NFF
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature Xuewei Sheng
Date: Nov 23, 2021
**********************************************/
package jac444.ws8.task1;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class IntArray {

	public static void main(String[] args) {
		List<Integer> list = new LinkedList<>();
		for(int i = 0; i < 25; i++)
		{
			int ele = (int)(Math.random()*100);
			list.add(ele);
		}
		System.out.println("Elements in the integer list: " + list);
		Collections.sort(list);
		System.out.println("Sorted elements in the integer list: " + list);
		int sum = 0;		
		for(int ele : list)
		{
			sum += ele;
		}
		float avrg = (float)sum / list.size();
		System.out.println("The sum of integer list: " + sum);
		System.out.printf("The average of integer list: %.2f", avrg);
	}

}
