package gui;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class PrimaryController {

    @FXML
    private TextArea textarea;
    @FXML
    private void switchToExecuteView() throws IOException {
        String s = textarea.getText();
        System.out.println(s);
        logic.memory.setCommand(s);
        App.setRoot("secondary");
        
    }
}
