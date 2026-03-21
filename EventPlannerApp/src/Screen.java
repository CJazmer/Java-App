package EventPlannerApp;
import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;


// Makes Screen Pop Up =====================================================
public class Screen extends Application {
	@Override
	public void start(Stage screen) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Screen.fxml"));
        Scene scene = new Scene(root);
        screen.setScene(scene);
        screen.show();
	}
	
    public static void main(String[] args) {
        launch(args);
        
    }
    
    
    
    
    
    // Code =======================================================================
    
    ArrayList<Event> events = new ArrayList<Event>();
    
    
    @FXML
    private VBox eventsBox;
    
    @FXML
    private TextField descriptionTextField;
   
	@FXML
	private TextField nameTextField;
	
    
	@FXML
	void saveButtonPressed(ActionEvent event) {
		
		Event newEvent = new Event(nameTextField.getText());
    	
    	Button newButton = new Button(nameTextField.getText());
    	eventsBox.getChildren().add(newButton);
    	
    	if(descriptionTextField.getText() != "") {
    		newEvent.setDescription(descriptionTextField.getText());
    	}
    	
    	events.add(newEvent);
    	newButton.setOnAction(e -> {
    		showEvent(newEvent);
        });
	}
	
	
	private void showEvent(Event e) {
		nameTextField.setText(e.getName());
		descriptionTextField.setText(e.getDescription());
	}
    
    
}
