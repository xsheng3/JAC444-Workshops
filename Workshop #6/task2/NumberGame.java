/**********************************************
Workshop #06
Course: JAC444
Last Name: Sheng
First Name: Xuewei
ID:061745121
Section: NFF
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature Xuewei Sheng
Date: Nov 9, 2021
**********************************************/
package jac444.ws6.task2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class NumberGame extends Application{
	static int sys = (int)(Math.random() * 1000 + 1);

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage ps) throws Exception {
		//create gridpane and basic setting
		GridPane gp = new GridPane();
		gp.setAlignment(Pos.CENTER);
		gp.setHgap(10);
		gp.setVgap(10);
		gp.setStyle("-fx-font-weight: 600; -fx-font-size: 14px;");
		
		//add labels to gp
		Label lb = new Label("Please enter your first guess.");		
		gp.add(new Label("I have a number between 1 and 1000. Can you guess my number?"), 0, 0);
		gp.add(lb, 0, 1);
		
		//add number input and button to gp
		HBox hBox = new HBox();
		TextField nb = new TextField();
		nb.setMaxWidth(60);
		Button playButton = new Button("Try");
		hBox.getChildren().addAll(nb, playButton);		
		gp.add(hBox, 0, 2);
		
		Button paButton = new Button("Play Again?");
		
		//eventHandler for play button
		playButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				System.out.println(sys);
				
				int numIn = Integer.parseInt(nb.getText());				
				if(numIn > sys)
				{
					gp.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
					lb.setText("Too High! Try Again.");
					nb.setText("");
					playButton.setText("Try again");
				}
				else if(numIn < sys)
				{
					gp.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));
					lb.setText("Too Low! Try Again.");
					nb.setText("");
					playButton.setText("Try again");
				}
				else 
				{
					gp.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
					lb.setText("Correct!");
					nb.setDisable(true);
					playButton.setDisable(true);
					gp.add(paButton, 0, 3);
				}				
			}
		});
		
		//eventHandler for play again button
		paButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				sys = (int)(Math.random() * 1000 + 1);
				lb.setText("Please enter your first guess.");
				nb.setDisable(false);
				nb.setText("");
				playButton.setDisable(false);	
				playButton.setText("Try again");
				gp.getChildren().remove(3);
			}
		});		
		
		Scene sc = new Scene(gp, 450, 400);
		ps.setTitle("Number Guess");
		ps.setScene(sc);
		ps.show();		
	}
}
