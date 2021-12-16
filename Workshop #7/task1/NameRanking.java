package jac444.ws7.task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class NameRanking extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage ps) throws Exception {
		//set layout for Senen one
		GridPane gp1 = new GridPane();
		gp1.setAlignment(Pos.CENTER);
		gp1.setHgap(10);
		gp1.setVgap(10);
		
		BorderPane bp = new BorderPane();
		Label lbYear = new Label("Enter the Year: ");
		Label lbGender = new Label("Choose the Gender: ");
		Label lbName = new Label("Enter the Name: ");
		
		TextField yr = new TextField();
		ChoiceBox<String> gd = new ChoiceBox<String>(FXCollections.observableArrayList(
			    "M", "F"));
		TextField nm = new TextField();
		
		gp1.addRow(0, lbYear, yr);
		gp1.addRow(1, lbGender, gd);
		gp1.addRow(2, lbName, nm);
		
		HBox hb = new HBox(50);
		Button sbmtBtn = new Button("Submit Query");
		Button exitBtn = new Button("Exit");
		exitBtn.setMinWidth(100);
		hb.getChildren().addAll(sbmtBtn, exitBtn);
		
		hb.setAlignment(Pos.TOP_CENTER);
		hb.setPadding(new Insets(0,5,30,5));
	
		bp.setCenter(gp1);
		bp.setBottom(hb);
		Scene sc = new Scene(bp, 400, 200);
		
		//set layout for Scene two
		GridPane gp2 = new GridPane();
		gp2.setAlignment(Pos.CENTER);
		gp2.setHgap(10);
		gp2.setVgap(40);
		Label l1 = new Label();
		gp2.addRow(0,l1);
		gp2.addRow(1,new Label("Do you want to Search for another Name: "));
		
		
		Button btnYes = new Button("Yes");
		Button btnNo = new Button("No");
		btnYes.setMinWidth(100);
		btnNo.setMinWidth(100);
		//btnYes.setPadding(new Insets(5,0,5,0));
		//btnNo.setPadding(new Insets(5,0,5,0));
		HBox btns = new HBox(btnYes, btnNo);
		btns.setAlignment(Pos.TOP_CENTER);
		btns.setPadding(new Insets(0,0,50,0));
		btns.setSpacing(30);
		
		BorderPane bp2 = new BorderPane();
		bp2.setCenter(gp2);
		bp2.setBottom(btns);
		Scene sc2 = new Scene(bp2, 400, 200);		
		
		//submit Button handler
		sbmtBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {		
				//read data from file
				String fileName = "babynamesranking" + yr.getText() + ".txt";				
				try {
					BufferedReader bfr = new BufferedReader(new FileReader(fileName));
					String ln;
					boolean found = false;
					while ((ln=bfr.readLine()) != null) 
					{
					    String rk = ln.substring(0, ln.indexOf("\t"));
					    ln = ln.substring(ln.indexOf("\t") + 1);
					    String nameBoy = ln.substring(0, ln.indexOf("\t"));
					    ln = ln.substring(ln.indexOf("\t") + 1);
					    ln = ln.substring(ln.indexOf("\t") + 1);
					    String nameGirl = ln.substring(0, ln.indexOf(" "));
					    ln = ln.substring(ln.indexOf("\t") + 1);
					    
					    if (gd.getValue().toString() == "M")
						{							
					    	if(nameBoy.equals(nm.getText()))
							{
								l1.setText("Boy name " + nameBoy + " is ranked #" + rk + " in " + yr.getText());
								found = true;
								break;
							}					    	
						}
					    else 
					    {
					    	if(nameGirl.equals(nm.getText()))
							{
					    		l1.setText("Girl name " + nameGirl + " is ranked #" + rk + " in " + yr.getText());  
					    		found = true;					    		
								break;
							}
					    }
					}
					bfr.close();
					if (!found)
					{
						l1.setText("The Name is Not Found!");
					}
				}catch(IOException ex) {
					System.out.println("Error opening file!");
					l1.setText("Error Opening File!");
				}								
				
				ps.setScene(sc2);
				ps.show();				
			}
		});
		
		//exit button handler
		exitBtn.setOnAction(e -> ps.close());
		
		//yes button handler
		btnYes.setOnAction(e -> {
			yr.setText("");
			nm.setText("");
			ps.setScene(sc); 
			ps.show();
			});
		
		//no button handler
		btnNo.setOnAction(e -> ps.close());		
		
		ps.setTitle("Serch Name Ranking Application");
		ps.setScene(sc);
		ps.show();		
	}
	

}
