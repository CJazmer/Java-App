package eventplannerpackage;
import java.io.IOException;

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
import java.util.ArrayList;
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
    
    int currEventPos = -1;
    
    Button currButton;
    
    @FXML
    private VBox eventsBox;

    @FXML
    private TextField descriptionTextField;
   
	@FXML
	private TextField nameTextField;    

	@FXML
	private TextField textFieldTotalPeople;  
	
	@FXML
	private TextField textFieldTotalCost;  
	
	@FXML
	private TextArea textAreaOutput; 
	
	@FXML
	private Button newEventButton;
	
	@FXML
	private Button deleteEventButton;
	
	@FXML
	private Button saveButton;
    
	
	@FXML
	void saveButtonPressed(ActionEvent event) {
		
		
		if(currEventPos==-1) {
		Event newEvent = new Event(nameTextField.getText());
    	
    	Button newButton = new Button(nameTextField.getText());
    	eventsBox.getChildren().add(newButton);
    	
    	if(descriptionTextField.getText() != "") {
    		newEvent.setDescription(descriptionTextField.getText());
    	}
    	if(textFieldTotalCost.getText() != "") {
    		newEvent.setTotalCost(Double.parseDouble(textFieldTotalCost.getText()));
    	}
    	if(textFieldTotalPeople.getText() != "") {
    		newEvent.setTotalPeople(Integer.parseInt(textFieldTotalPeople.getText()));
    	}
    	
    	events.add(newEvent);
    	newButton.setOnAction(e -> {
    		if(currButton!=null) {
    			currButton.setUnderline(false);
    		}
    		
    		newButton.setUnderline(true);
    		saveButton.setText("Save Changes");
    		newEventButton.setVisible(true);
    		deleteEventButton.setVisible(true);
    		currButton = newButton;
    		//nameTextField.setEditable(false);
    		showEvent(newEvent);
        });
		}else {
			if(nameTextField.getText() != "") {
	    		events.get(currEventPos).setName(nameTextField.getText());
	    		currButton.setText(nameTextField.getText());
	    	}
			if(descriptionTextField.getText() != "") {
	    		events.get(currEventPos).setDescription(descriptionTextField.getText());
	    	}
	    	if(textFieldTotalCost.getText() != "") {
	    		events.get(currEventPos).setTotalCost(Double.parseDouble(textFieldTotalCost.getText()));
	    	}
	    	if(textFieldTotalPeople.getText() != "") {
	    		events.get(currEventPos).setTotalPeople(Integer.parseInt(textFieldTotalPeople.getText()));
	    	}
		}
    	
    	
	}
	
	@FXML
	void newEventButtonPressed(ActionEvent event) {
		currButton.setUnderline(false);
		saveButton.setText("Save Event");
		newEventButton.setVisible(false);
		deleteEventButton.setVisible(false);
		currEventPos = -1;
		//nameTextField.setEditable(true);
		nameTextField.setText("");
		descriptionTextField.setText("");
		textFieldTotalCost.setText("");
		textFieldTotalPeople.setText("");
	}
	
	@FXML
	void deleteEventButtonPressed(ActionEvent event) {
		events.remove(currEventPos);
		eventsBox.getChildren().remove(currButton);
		
		saveButton.setText("Save Event");
		newEventButton.setVisible(false);
		deleteEventButton.setVisible(false);
		currEventPos = -1;
		//nameTextField.setEditable(true);
		nameTextField.setText("");
		descriptionTextField.setText("");
		textFieldTotalCost.setText("");
		textFieldTotalPeople.setText("");
	}
	
	
	private void showEvent(Event e) {
		currEventPos = findEvent(e);
		System.out.print(currEventPos);
		
		nameTextField.setText(e.getName());
		descriptionTextField.setText(e.getDescription());
		textFieldTotalCost.setText(Double.toString(e.getTotalCost()));  
		textFieldTotalPeople.setText(Integer.toString(e.getTotalPeople()));
		
		// Cool text event explainer
    	textAreaOutput.setText(
    		"Event: " + e.getName() + 
    		" will have " + e.getTotalPeople() + " people."
    	);
	} 
	
	private int findEvent(Event e) {
		int pos = -1;
		for (int i = 0; i < events.size(); i++) {
			if (events.get(i) == e) {
				pos = i;
			}
		}
		return pos;
	}
}
