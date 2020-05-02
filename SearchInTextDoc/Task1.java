
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

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
@SuppressWarnings("unused")

public class Task1 extends Application {
	 @SuppressWarnings("resource")
	public void start(Stage primaryStage) throws IOException {
	BorderPane root = new BorderPane();
	
    GridPane grid = new GridPane();
    root.setCenter(grid);
    grid.setPadding(new Insets(10, 10, 0, 10));
    grid.setHgap(5);
    grid.setVgap(25);
    
   
    TextField year = new TextField();
    TextField gender = new TextField();
    gender.setMaxWidth(25);
    TextField name = new TextField();
    

    StringBuilder statementText = new StringBuilder("");
   
    Text statement = new Text("");
    grid.add(new Label("Enter the Year:"), 0, 0);
    grid.add(year, 1, 0);
    grid.add(new Label("Enter the Gender:"), 0, 1); 
    grid.add(gender, 1, 1);
    grid.add(new Label("Enter the Name:"), 0, 2);
    grid.add(name, 1, 2);
    grid.add(statement, 0, 3, 5, 1);    
    
    
    HBox hbox = new HBox(2);
    hbox.setPadding(new Insets(10, 10, 5, 10));
    Button btSubmit = new Button("Submit Query");   
    Button btExit= new Button("Exit"); 
   
    EventHandler<MouseEvent> btSubmitHandler = new EventHandler<MouseEvent>() {
	      @Override
	      public void handle(MouseEvent e) {
	    	  
	    	  StringBuilder file = new StringBuilder("babynamesranking");
	    	    file.append(year.getText());
	    	    file.append(".txt");
	    	    Boolean found = false, err = false;
	    	    statement.setText("");
	    	    if(!gender.getText().equals("M") && !gender.getText().equals("m")&& !gender.getText().equals("f") && !gender.getText().equals("F")) {
	    	    	statement.setText("Gender must be M/F");
	    	    	err = true;
	    	    };
	    	    if((Integer.parseInt(year.getText()) > 2010) || (Integer.parseInt(year.getText()) < 2001)){
	    	    	statement.setText("Year must be between 2001 and 2010");
	    	    	err = true;
	    	    };
	    	    try {
					BufferedReader br = new BufferedReader(new FileReader(file.toString()));
					String line;
					String[] columns;
					int rank = 0;
					while ((line = br.readLine()) != null) {
					columns = line.split("\\s+");
					if(gender.getText().equals("M") || gender.getText().equals("m")) {
						if(columns[1].equals(name.getText())) {
							rank = Integer.parseInt(columns[0]);
							statement.setText("Boy name " + name.getText() + " is ranked #" + rank+ " in " +year.getText()+ " year");
							found = true;
						}
					} 
					
					if(gender.getText().equals("F") || gender.getText().equals("f")){
						if(columns[3].equals(name.getText())) {
							rank = Integer.parseInt(columns[0]);
							statement.setText("Girl name " + name.getText() + " is ranked #" + rank+ " in " +year.getText()+ " year");
							found = true;
						}
					}
					
					}
					if(!found && !err) statement.setText("Name not found");
	    	    } catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	      }
	    };
  btSubmit.addEventFilter(MouseEvent.MOUSE_CLICKED, btSubmitHandler);
    
  EventHandler<MouseEvent> btExitHandler = new EventHandler<MouseEvent>() {
      @Override
      public void handle(MouseEvent e) {
    	  ((Stage)(((Button)e.getSource()).getScene().getWindow())).close();
      }
    };
btExit.addEventFilter(MouseEvent.MOUSE_CLICKED, btExitHandler);  
 

    btSubmit.setPrefWidth(100);
    btExit.setPrefWidth(100);
    hbox.setSpacing(50);
    hbox.getChildren().addAll(btSubmit, btExit);
    hbox.setAlignment(Pos.CENTER);
    root.setBottom(hbox);
    Scene scene = new Scene(root,400, 225);
    primaryStage.setTitle("Search Name Ranking Application"); 
    primaryStage.setScene(scene); 
    primaryStage.show(); 
    
	}
public static void main(String[] args) {
    launch(args);
  }

}

