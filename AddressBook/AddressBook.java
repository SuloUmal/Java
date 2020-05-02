
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;
public class AddressBook extends Application {

	public void start(Stage primaryStage) throws IOException {
	BorderPane root = new BorderPane();
	
    GridPane grid = new GridPane();
    root.setCenter(grid);
    @SuppressWarnings("resource")
	RandomAccessFile raf = new RandomAccessFile("addressBook.txt", "rw");
    raf.seek(0);
    byte[] bytes = new byte[10];
    raf.read(bytes);
    grid.setPadding(new Insets(10, 10, 0, 10));
    grid.setHgap(5);
    grid.setVgap(25);
    
    ComboBox<String> comboBox = new ComboBox<String>();
    comboBox.getItems().add("Ontario");
    TextField fName = new TextField();
    TextField lName = new TextField();
    TextField city = new TextField();
    TextField postal = new TextField();
    
    grid.add(new Label("First Name:"), 0, 0);
    grid.add(fName, 1, 0, 5, 1);
    grid.add(new Label("Last Name:"), 0, 1); 
    grid.add(lName, 1, 1, 5, 1);
    grid.add(new Label("City:"), 0, 2);
    grid.add(city, 1, 2);
    grid.add(new Label("Province:"), 2, 2);
    grid.add(comboBox, 3, 2);
    grid.add(new Label("Postal Code:"), 4, 2);
    grid.add(postal, 5, 2);
    
    
    
    
    HBox hbox = new HBox(5);
    hbox.setPadding(new Insets(10, 10, 5, 10));
    Button btAdd = new Button("Add");   
    Button btFirst= new Button("First"); 
    Button btNext = new Button("Next");
    Button btPrevious = new Button("Previous");    
    Button btLast = new Button("Last");
    Button btUpdate = new Button("Update");
    btAdd.setPrefWidth(100);
    btFirst.setPrefWidth(100);
    btNext.setPrefWidth(100);
    btPrevious.setPrefWidth(100);
    btLast.setPrefWidth(100);
    btUpdate.setPrefWidth(100);
    
    
    hbox.getChildren().addAll(btAdd, btFirst, 
    		btNext, btPrevious, btLast, btUpdate);
    hbox.setAlignment(Pos.CENTER);
    root.setBottom(hbox);
    Scene scene = new Scene(root, 650, 200);
    primaryStage.setTitle("Address Book"); 
    primaryStage.setScene(scene); 
    primaryStage.show(); 
  
  
	EventHandler<MouseEvent> btAddHandler = new EventHandler<MouseEvent>() {
	      @Override
	      public void handle(MouseEvent e) {

	        try {
	          long curPosition = raf.length();
	          raf.seek(curPosition);
	          raf.write('\n');
	          raf.write(String.format("%-" + 10 + "s", fName.getText()).getBytes());
	          raf.seek(curPosition+11);
	          raf.write(String.format("%-" + 10 + "s", lName.getText()).getBytes());
	          raf.seek(curPosition+21);
	          raf.write(String.format("%-" + 10 + "s", city.getText()).getBytes());
	          raf.seek(curPosition+31);
	          raf.write(String.format("%-" + 10 + "s", comboBox.getValue()).getBytes());
	          raf.seek(curPosition+41);
	          raf.write(String.format("%-" + 10 + "s", postal.getText()).getBytes());
	        } catch (IOException ex) {
	          ex.printStackTrace();
	        }
	      }
	    };
    btAdd.addEventFilter(MouseEvent.MOUSE_CLICKED, btAddHandler);
    EventHandler<MouseEvent> btFirstHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
          try {
            raf.seek(0);
            raf.read(bytes);
            fName.setText(new String(bytes));
            raf.seek(10);
            raf.read(bytes);
            lName.setText(new String(bytes));
            raf.seek(20);
            raf.read(bytes);
            city.setText(new String(bytes));
            raf.seek(30);
            raf.read(bytes);
            comboBox.setValue(new String(bytes));
            raf.seek(40);
            raf.read(bytes);
            postal.setText(new String(bytes));
          } catch (IOException ex) {
            ex.printStackTrace();
          }
        }
      };
      //Adding event Filter
      btFirst.addEventFilter(MouseEvent.MOUSE_CLICKED, btFirstHandler);

  
      //Creating the mouse event handler
      EventHandler<MouseEvent> btNextHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
          try {
            long curPosition = raf.getFilePointer() + 1;
            if (curPosition+49 < raf.length()) {
              raf.seek(curPosition);
              raf.read(bytes);
              fName.setText(new String(bytes));
              raf.seek(curPosition+10);
              raf.read(bytes);
              lName.setText(new String(bytes));
              raf.seek(curPosition+20);
              raf.read(bytes);
              city.setText(new String(bytes));
              raf.seek(curPosition+30);
              raf.read(bytes);
              comboBox.setValue(new String(bytes));
              raf.seek(curPosition+40);
              raf.read(bytes);
              postal.setText(new String(bytes));
            }
          } catch (IOException ex) {
            ex.printStackTrace();
          }
        }
      };
      //Adding event Filter
      btNext.addEventFilter(MouseEvent.MOUSE_CLICKED, btNextHandler);

      //Creating the mouse event handler
      EventHandler<MouseEvent> btPreviousHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
          System.out.println("Btn4 Clicked");

          try {
            long curPosition = raf.getFilePointer() - 101;
            if (curPosition < 0) {
              curPosition = 0;
            }
            raf.seek(curPosition);
            raf.read(bytes);
            fName.setText(new String(bytes));
            raf.seek(curPosition + 10);
            raf.read(bytes);
            lName.setText(new String(bytes));
            raf.seek(curPosition + 20);
            raf.read(bytes);
            city.setText(new String(bytes));
            raf.seek(curPosition + 30);
            raf.read(bytes);
            comboBox.setValue(new String(bytes));
            raf.seek(curPosition + 40);
            raf.read(bytes);
            postal.setText(new String(bytes));

          } catch (IOException ex) {
            ex.printStackTrace();
          }
        }
      };
      //Adding event Filter
      btPrevious.addEventFilter(MouseEvent.MOUSE_CLICKED, btPreviousHandler);
      //Creating the mouse event handler
      EventHandler<MouseEvent> btLastHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
          try {
            long curPosition = raf.length()-50;
            raf.seek(curPosition);
            raf.read(bytes);
            fName.setText(new String(bytes));
            raf.seek(curPosition+10);
            raf.read(bytes);
            lName.setText(new String(bytes));
            raf.seek(curPosition+20);
            raf.read(bytes);
            city.setText(new String(bytes));
            raf.seek(curPosition+30);
            raf.read(bytes);
            comboBox.setValue(new String(bytes));
            raf.seek(curPosition+40);
            raf.read(bytes);
            postal.setText(new String(bytes));
          } catch (IOException ex) {
            ex.printStackTrace();
          }
        }
      };
      //Adding event Filter
      btLast.addEventFilter(MouseEvent.MOUSE_CLICKED, btLastHandler);

      
      //Creating the mouse event handler
      EventHandler<MouseEvent> btUpdateHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
          try {
            long curPosition = raf.getFilePointer()-50;
            raf.seek(curPosition);
            raf.write(String.format("%-" + 10 + "s", fName.getText()).getBytes());
            raf.seek(curPosition+10);
            raf.write(String.format("%-" + 10 + "s", lName.getText()).getBytes());
            raf.seek(curPosition+20);
            raf.write(String.format("%-" + 10 + "s", city.getText()).getBytes());
            raf.seek(curPosition+30);
            raf.write(String.format("%-" + 10 + "s", comboBox.getValue()).getBytes());
            raf.seek(curPosition+40);
            raf.write(String.format("%-" + 10 + "s", postal.getText()).getBytes());
          } catch (IOException ex) {
            ex.printStackTrace();
          }
        }
      };
      //Adding event Filter
      btUpdate.addEventFilter(MouseEvent.MOUSE_CLICKED, btUpdateHandler);

	}

public static void main(String[] args) {
    launch(args);
  }
}

