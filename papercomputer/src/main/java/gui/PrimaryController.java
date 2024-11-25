package gui;

import java.net.URL;
import java.util.ResourceBundle;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import logic.memory;

public class PrimaryController implements Initializable{

    @FXML
    private TextArea textarea;
    @FXML
    private void switchToExecuteView() throws IOException {
        String s = textarea.getText();
        logic.memory.setCommand(s);
        App.setRoot("secondary"); 
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        textarea.setText(memory.getCommandString());

    }
}
