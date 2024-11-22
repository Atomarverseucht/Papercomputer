package gui;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToExecuteView() throws IOException {
        App.setRoot("secondary");
    }
}
