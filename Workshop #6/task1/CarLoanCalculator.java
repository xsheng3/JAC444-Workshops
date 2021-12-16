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
package jac444.ws6.task1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CarLoanCalculator extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage ps) throws Exception {
		GridPane gp = new GridPane();
		gp.setAlignment(Pos.CENTER);
		gp.setHgap(5);
		gp.setVgap(5);

		gp.add(new Label("Price of the Car: "), 0, 0);
		TextField price = new TextField();
		gp.add(price, 1, 0);
		gp.add(new Label("Down-payment:"), 0, 1);
		TextField dpay = new TextField();
		gp.add(dpay, 1, 1);
		gp.add(new Label("Interest Rate:"), 0, 2);
		TextField rate = new TextField();
		gp.add(rate, 1, 2);			
		
		Button btnCal = new Button("Calculate");
		Button btnReset = new Button("Reset");
		gp.add(btnCal, 0, 4); 
		gp.add( btnReset, 1, 4);
		
		btnCal.setOnAction(new EventHandler<ActionEvent>() {				
			@Override
			public void handle(ActionEvent e) {					
				double p = Double.parseDouble(price.getText());
				double d = Double.parseDouble(dpay.getText());
				double r = Double.parseDouble(rate.getText());
				
				double twoYearsPayment =(double)Math.round(((p - d) * (1 + r * 2) / 24) * 100) / 100; 
				double threeYearsPayment = (double)Math.round(((p - d) * (1 + r * 3) / 36) * 100) / 100;
				double fourYearsPayment = (double)Math.round(((p - d) * (1 + r * 4) / 48) * 100) / 100;
				double fiveYearsPayment = (double)Math.round(((p - d) * (1 + r * 5) / 60) * 100) / 100;
					
				Stage showPmt = new Stage();
				GridPane gp2 = new GridPane();
				gp2.setAlignment(Pos.CENTER);
				gp2.setHgap(5);
				gp2.setVgap(5);
									
				TextField twoyp = new TextField();
				twoyp.setText(String.valueOf(twoYearsPayment));
				TextField threeyp = new TextField();
				threeyp.setText(String.valueOf(threeYearsPayment));
				TextField fouryp = new TextField();
				fouryp.setText(String.valueOf(fourYearsPayment));
				TextField fiveyp = new TextField();
				fiveyp.setText(String.valueOf(twoYearsPayment));
					
				gp2.add(new Label("Two years: "), 0, 0);
				gp2.add(new Label("Total payments: 24"), 1, 0);					
				gp2.add(new Label("Amount per month: " + String.valueOf(twoYearsPayment)), 1, 1);
					
				gp2.add(new Label("Three years: "), 0, 2);
				gp2.add(new Label("Total payments: 36"), 1, 2);					
				gp2.add(new Label("Amount per month: " + String.valueOf(threeYearsPayment)), 1, 3);
				
				gp2.add(new Label("Four years: "), 0, 4);
				gp2.add(new Label("Total payments: 48"), 1, 4);					
				gp2.add(new Label("Amount per month: " + String.valueOf(fourYearsPayment)), 1, 5);
				
				gp2.add(new Label("Five years: "), 0, 6);
				gp2.add(new Label("Total payments: 60"), 1, 6);					
				gp2.add(new Label("Amount per month: " + String.valueOf(fiveYearsPayment)), 1, 7);
				
				Scene sc2 = new Scene(gp2, 400, 250);
				showPmt.setTitle("Payments of your loan");
				showPmt.setScene(sc2);
				showPmt.show();			
				}
			});
		
		btnReset.setOnAction(new EventHandler<ActionEvent>() {				
			@Override
			public void handle(ActionEvent e) {
				price.setText("");
				dpay.setText("");
				rate.setText("");					
			}
		});
			
		Scene sc = new Scene(gp,400,250);
		ps.setTitle("Car Loan Calculator");
		ps.setScene(sc);
		ps.show();					
	}
}
