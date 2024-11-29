package gui;

import java.net.URL;
import java.util.ResourceBundle;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import logic.memory;

public class PrimaryController implements Initializable {

    @FXML
    private NumberedTextArea textarea;

    @FXML
    private NumberedTextArea textRegister;

    @FXML
    private void switchToExecuteView() throws IOException {
        // Holen des Textes aus der TextArea
        String s = textarea.getTextArea().getText();
        memory.setCommand(s);
        App.setRoot("secondary");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TextArea taCmd = textarea.getTextArea();
        TextArea taReg = textRegister.getTextArea();
        // Initialer Text für die TextAreas
        taCmd.setText(memory.getCommandString());
        taReg.setText(memory.getStartRegisterString());

        // Listener für automatisches Scrollen
        taCmd.textProperty().addListener((observable, oldValue, newValue) -> {
            taCmd.setScrollTop(Double.MAX_VALUE); // Scrollt automatisch nach unten
        });

        taReg.textProperty().addListener((observable, oldValue, newValue) -> {
            taReg.setScrollTop(Double.MAX_VALUE); // Scrollt automatisch nach unten
        });
    }
}

