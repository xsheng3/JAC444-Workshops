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
package jac444.ws8.task3;

import java.util.HashMap;
import java.util.Map;



import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class GettingCapital extends Application{
	private static String[][] data= {
			{"Afghanistan", "Kabul"},
			{"Australia", "Canberra"},
			{"Bahamas", "Nassau"},
			{"Canada", "Ottawa"},
			{"China", "Beijing"},
			{"Denmark", "Copenhagen"},			
			{"East Timor", "Dili"},
			{"Finland", "Helsinki"},
			{"France", "Paris"},
			{"Germany", "Berlin"},
			{"Greece", "Athens"},
			{"India", "New Delhi"},			
			{"Japan", "Tokyo"},			
			{"Kenya", "Nairobi"},
			{"Libya", "Tripoli"},
			{"Mexico", "Mexico City"},
			{"New Zealand", "Wellingon"},			
			{"Peru", "Lima"},			
			{"Russia", "Moscow"},
			{"Spain", "Madrid"},
			{"Switzerland", "Bern"},
			{"Turkey", "Ankara"},			
			{"United States", "Washington D.C."},			
			{"Vietnam", "Hanoi"},
			{"Zambia", "Lusaka"}
			};
	
	public static Map<String, String> countryCityMapping(){
		Map<String, String> tempMap = new HashMap<>();
		for(int i = 0; i < data.length; i++)
		{
			tempMap.put(data[i][0], data[i][1]);
		}
		return tempMap;
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage ps) throws Exception {
		GridPane gp1 = new GridPane();
		gp1.setAlignment(Pos.CENTER);
		gp1.setHgap(10);
		gp1.setVgap(10);
		
		Label prmp = new Label("Please enter the coutry name: ");
		TextField country = new TextField();
		gp1.addRow(0, prmp);
		gp1.addRow(1, country);
		
		Button searBtn = new Button("Search");
		Button exitBtn = new Button("Exit");
		HBox btns = new HBox(searBtn, exitBtn);
		searBtn.setMinWidth(50);
		exitBtn.setMinWidth(50);
		btns.setAlignment(Pos.TOP_CENTER);
		btns.setSpacing(20);
		gp1.addRow(3, btns);
		
		Scene sc1 = new Scene(gp1, 300, 200);
		
		GridPane gp2 = new GridPane();
		gp2.setAlignment(Pos.CENTER);
		gp2.setHgap(10);
		gp2.setVgap(10);

		Label ctryLabel = new Label();
		Label cityLabel = new Label();
		gp2.addRow(0, ctryLabel);
		gp2.addRow(1, cityLabel);
		gp2.addRow(4, new Label("Do you want to find another capital city?"));	
		
		
		Button yesButton = new Button("Yes");
		Button noButton = new Button("No");
		HBox btns2 = new HBox(yesButton, noButton);
		btns2.setAlignment(Pos.TOP_CENTER);
		btns2.setPadding(new Insets(0,0,50,0));
		btns2.setSpacing(30);
		
		BorderPane bp2 = new BorderPane();
		bp2.setCenter(gp2);
		bp2.setBottom(btns2);
		Scene sc2 = new Scene(bp2, 300, 200);
		
		searBtn.setOnAction( e -> {
			
			String countryString = "Country: " + country.getText();
			String cityString = "Capital City: " + GettingCapital.countryCityMapping().get(country.getText());		
			ctryLabel.setText(countryString);
			if(GettingCapital.countryCityMapping().get(country.getText()) != null)
			{
				cityLabel.setText(cityString);
				cityLabel.setTextFill(javafx.scene.paint.Color.BLACK);
			}
			else
			{
				cityLabel.setText("Country name is not in the list");
				cityLabel.setTextFill(javafx.scene.paint.Color.RED);
			}			
			ps.setScene(sc2);
			ps.show();
			});
		
		exitBtn.setOnAction(e -> ps.close());
		
		yesButton.setOnAction(e -> {
			country.setText("");
			ps.setScene(sc1);
			});
		
		noButton.setOnAction(e -> ps.close());	
		
		ps.setTitle("Search the Capital City");
		ps.setScene(sc1);
		ps.show();
	}

}
