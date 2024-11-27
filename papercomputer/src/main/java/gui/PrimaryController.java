package gui;

import java.net.URL;
import java.util.ResourceBundle;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.Region;
import javafx.geometry.Orientation; // **WICHTIG: Dies importieren!**
import logic.memory;

public class PrimaryController implements Initializable {

    @FXML
    private TextArea textarea;

    @FXML
    private TextArea textRegister;

    private ScrollBar textareaScrollBar;
    private ScrollBar textRegisterScrollBar;

    @FXML
    private void switchToExecuteView() throws IOException {
        // Holen des Textes aus der TextArea
        String s = textarea.getText();
        memory.setCommand(s);
        App.setRoot("secondary");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialer Text für die TextAreas
        textarea.setText(memory.getCommandString());
        textRegister.setText(memory.getStartRegisterString());

        // Zugriff auf die vertikale ScrollBar der TextArea
        textareaScrollBar = findScrollBar(textarea);
        textRegisterScrollBar = findScrollBar(textRegister);

        // Listener für Autoscroll in textarea
        textarea.textProperty().addListener((observable, oldValue, newValue) -> {
            if (textareaScrollBar != null && isScrolledToBottom(textareaScrollBar)) {
                textareaScrollBar.setValue(textareaScrollBar.getMax());
            }
        });

        // Listener für Autoscroll in textRegister
        textRegister.textProperty().addListener((observable, oldValue, newValue) -> {
            if (textRegisterScrollBar != null && isScrolledToBottom(textRegisterScrollBar)) {
                textRegisterScrollBar.setValue(textRegisterScrollBar.getMax());
            }
        });
    }

    /**
     * Findet die vertikale ScrollBar einer TextArea.
     */
    private ScrollBar findScrollBar(TextArea textArea) {
        for (var node : textArea.lookupAll(".scroll-bar")) {
            if (node instanceof ScrollBar) {
                ScrollBar scrollBar = (ScrollBar) node;
                if (scrollBar.getOrientation() == Orientation.VERTICAL) { // Orientation importieren
                    return scrollBar;
                }
            }
        }
        return null;
    }

    /**
     * Überprüft, ob die ScrollBar sich am unteren Ende befindet.
     */
    private boolean isScrolledToBottom(ScrollBar scrollBar) {
        return scrollBar.getValue() >= scrollBar.getMax() - 1;
    }
}
