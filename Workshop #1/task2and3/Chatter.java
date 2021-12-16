/**********************************************
Workshop #01
Course: JAC444
Last Name: Sheng
First Name: Xuewei
Date: Sep 25, 2021
**********************************************/
package task2and3;

public class Chatter {
private String[] chats = {
		"Oh, you’re going for broke, huh?",
		"Aw c’mon, take a chance!",
		"You’re up big. Now’s the time to cash in your chips!",
		"Come on, you can make it!"		
};
public void generateString() {
	int idx = (int)(Math.random() * chats.length);
	System.out.print("\n" + chats[idx] + "\n\n");
}
}
