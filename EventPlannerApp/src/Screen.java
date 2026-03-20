package EventPlannerApp;
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
    
    Event event1 = new Event("brithday"); // New Event! manually created for now
    
	@FXML
	private TextField nameTextField;
    
	@FXML
	void saveButtonPressed(ActionEvent event) {
    	event1.setName( nameTextField.getText() ); // update event name
    	    
        
	}
    
    
}
