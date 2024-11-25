package gui;

import java.io.IOException;
import java.util.ResourceBundle;
import java.net.URL;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import logic.memory;

public class SecondaryController implements Initializable{

    @FXML
    Label lbOutput;
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lbOutput.setText(memory.getCommandString());

    }
}