import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;

import javafx.beans.binding.Binding;
import javafx.beans.binding.Bindings;
import java.util.Random;
import java.util.Set;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;
import javafx.scene.text.TextAlignment;
@SuppressWarnings("unused")

public class Task1 extends Application {
	 @SuppressWarnings("resource")
	public void start(Stage primaryStage) {
	StringBuilder msg = new StringBuilder();
	Random rand = new Random();
	BorderPane  root = new BorderPane ();
	GridPane grid = new GridPane();
	Set<Integer> answers1 = new HashSet<Integer>();
	Set<Integer> answers2 = new HashSet<Integer>();
	Set<Integer> answers3 = new HashSet<Integer>();
	Set<Double> answers4 = new HashSet<Double>();
	root.setCenter(grid);
	grid.setAlignment(Pos.TOP_CENTER);
	grid.setVgap(10); 
    grid.setHgap(5);     
    grid.setPadding(new Insets(20, 10, 14, 10));
    
	TextField a1 = new TextField();
    TextField a2 = new TextField();
    TextField a3 = new TextField();
    TextField a4 = new TextField();
    int num1 = rand.nextInt(1001), num2 = rand.nextInt(1001);
    
    Label q1 = new Label("What is addition of "+ num1 +" and " + num2 + ": ");
    Label q2 = new Label("What is subtraction of "+ num1 +" and " + num2+ ": ");
    Label q3 = new Label("What is multiplication of "+ num1 +" and " + num2+ ": ");
    Label q4 = new Label("What is division of "+ num1 +" and " + num2+ ": \n(round to 3 decimal position)");
  
    Label right = new Label("");
    Label wrong = new Label("");
    Label state = new Label("");
    
    Button btnAgain = new Button("Again");
    Button btnSubmit = new Button("Submit");
    
   
    grid.add(new Label("Two randomly generated numbers are: "+ num1 +" and " + num2), 0, 0,2,1);
    grid.add(q1, 0, 1); 
    grid.add(a1, 1, 1);
    grid.add(q2, 0, 2);
    grid.add(a2, 1, 2);
    grid.add(q3, 0, 3);
    grid.add(a3, 1, 3);
    grid.add(q4, 0, 4);
    grid.add(a4, 1, 4);
    grid.add(right, 0, 6);
    grid.add(wrong, 0, 7);
    grid.add(state, 0, 8, 2, 1);
    btnSubmit.setOnAction(e-> {
    	state.setText("");
    	//check all numbers
    	Boolean err = false;
    	Boolean check = false;
    	int counterR =0;
    	int counterW =0;
    	msg.setLength(0);
    	
    	if(!a1.getText().matches("[0-9]+") ||  a1.getText().length() < 1) {
    		state.setText("***Error! Answer field #1 should be number");
    		err = true;
    	}
    	
    	if((!a2.getText().matches("[0-9\\-]+") ||  a2.getText().length() < 1) && !err) {
    		state.setText("***Error! Answer field #2 should be number");
    		err = true;
    	}
    	
    	if((!a3.getText().matches("[0-9]+") ||  a3.getText().length() < 1) && !err) {
    		state.setText("***Error! Answer field #3 should be number");
    		err = true;
    	}
    	
    	if((!a4.getText().matches("[0-9\\.]+") ||  a4.getText().length() < 1) && !err) {
    		state.setText("***Error! Answer field #4 should be number");
    		err = true;
    	}
    	msg.append("You already answer this on field");
    	if(!err) {
    		BigDecimal bd = new BigDecimal((double)num1 / num2);
        	bd = bd.setScale(3, RoundingMode.HALF_UP);
    		
    		if(answers1.contains(Integer.valueOf(a1.getText())) && Integer.valueOf(a1.getText()) != (num1 + num2)) {
    		msg.append(" #1 ");
    		check = true;
    		}else{ answers1.add(Integer.valueOf(a1.getText()));};
 
    		if(answers2.contains(Integer.valueOf(a2.getText())) && Integer.valueOf(a2.getText()) != (num1 - num2) ) {
        		msg.append(" #2 ");
        		check = true;
    		}else{ answers2.add(Integer.valueOf(a2.getText()));};
    		
    		if(answers3.contains(Integer.valueOf(a3.getText())) && Integer.valueOf(a3.getText()) != (num1 * num2) ) {
        		msg.append(" #3 ");
        		check = true;
    		}else{ answers3.add(Integer.valueOf(a3.getText()));};
    		
    		if(answers4.contains(Double.valueOf(a4.getText())) && Double.valueOf(a4.getText()) != bd.doubleValue() ) {
        		msg.append(" #4 ");
        		check = true;
	 		}else{ answers4.add(bd.doubleValue());};
	 	
		 	if(check) {
	        msg.append("\nTry a different answer");
	        state.setText(msg.toString());}
    	
    		System.out.print(bd.doubleValue());
    		if(Integer.valueOf(a1.getText()) == (num1 + num2)) 
    			counterR++;
    		 else counterW++;
    		if(Integer.valueOf(a2.getText()) == (num1 - num2)) 
    			counterR++;
    		 else counterW++;
    		 if(Integer.valueOf(a3.getText()) == (num1 * num2)) 
     			counterR++;
     		 else counterW++;
     		if(Double.valueOf(a4.getText()) == bd.doubleValue()) 
    			counterR++;
    		 else counterW++;
     		
     		right.setText("Number of Correct Answers: " + counterR);
     		wrong.setText("Number of Wrong Answers: "+ counterW);
     		if(counterR == 4)state.setText("If you want to try different numbers press the Again button");
    	}
    	
    }
    );
    btnAgain.setOnAction(e-> {
    	start(primaryStage);
    });
        
    //Bottom
    
    HBox buttons = new HBox(10);
    buttons.setPadding(new Insets(20, 10, 14, 10));
    root.setBottom(buttons);
    buttons.setAlignment(Pos.CENTER);
    buttons.getChildren().addAll(btnSubmit,btnAgain);
    
    Scene scene = new Scene(root,450, 500);
    primaryStage.setTitle("Quiz Application"); 
    primaryStage.setScene(scene); 
    primaryStage.show(); 
    
	}
public static void main(String[] args) {
    launch(args);
  }

}

