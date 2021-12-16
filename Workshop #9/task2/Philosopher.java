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
package jac444.ws9.task2;

public class Philosopher implements Runnable {
	private Object rightChopstick;
	private Object leftChopstick;
	
	public Philosopher(Object right, Object left) {
		this.rightChopstick = right;
		this.leftChopstick = left;
	}

	@Override
	public void run() {		
		synchronized (rightChopstick) {
			System.out.println(Thread.currentThread().getName() + " picked up right chopstick...");
			try {
				Thread.sleep(((int) (Math.random() * 100)));
			} catch (InterruptedException e) {}
			synchronized (leftChopstick) {
				System.out.println(Thread.currentThread().getName() + " picked up left chopstick...");
				try {
					Thread.sleep(((int) (Math.random() * 100)));
				} catch (InterruptedException e) {}
				System.out.println(Thread.currentThread().getName() + " is eating");
				try {
					Thread.sleep(((int) (Math.random() * 2000)));;						
				}catch(InterruptedException ex) {}
					/*try {
						leftChopstick.wait();
					} catch (InterruptedException e) {}
					*/
				System.out.println(Thread.currentThread().getName() + " finish eating");
			}			
		}	
	}
}

















//not for submission

/*public void chooseStatus(String status) throws InterruptedException {
	System.out.println(Thread.currentThread().getName() + " is " + status);
	Thread.sleep(200);
}*/
/*synchronized void pickUpChops() {
	System.out.println("Going to pick up chopsticks...");
	if(!this.leftChopstick || !this.rightChopstick)
	{
		System.out.println("Chopsticks are not ready, waiting...");
		try {
			wait();
		}catch(InterruptedException ex) {}
	}
	this.leftChopstick = false;
	this.rightChopstick = false;
	System.out.println("Chopsticks are picked up, start eating");
	try {
		TimeUnit.SECONDS.sleep(3);
		
	}catch(InterruptedException ex ) {}
	System.out.println("finish eating.");	
	this.leftChopstick = true;
	this.rightChopstick = true;
	notify();
}

/*synchronized void FinishEating() {
	System.out.println("going to eat...");
	System.out.println("finish eating.");
	this.leftChopstick = true;
	this.rightChopstick = true;
	notify();
	
	
}*/

//synchronized void putDownChops() {
	
//}



/*synchronized(lock) {
System.out.println(Thread.currentThread().getName() + " is going to pick up chopsticks...");
if(!this.leftChopstick || !this.rightChopstick)
{
	System.out.println(Thread.currentThread().getName() + "'s chopsticks are not ready, waiting...");
	try {
		lock.wait();
	}catch(InterruptedException ex) {}
}
else 
{
	this.leftChopstick = false;
	this.rightChopstick = false;
	lock.notifyAll();
	System.out.println(Thread.currentThread().getName() + " picked up chopsticks, start eating");
	try {
		TimeUnit.SECONDS.sleep(15);
		
	}catch(InterruptedException ex ) {}
	System.out.println(Thread.currentThread().getName() + ": finish eating.");	
	this.leftChopstick = true;
	this.rightChopstick = true;
	lock.notifyAll();
}
}*/
