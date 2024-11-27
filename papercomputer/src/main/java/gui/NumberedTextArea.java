package gui;

import javafx.scene.control.TextArea;
import javafx.scene.layout.Priority;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class NumberedTextArea extends HBox {
    private final VBox lineNumbers;
    private final TextArea textArea;

    public NumberedTextArea() {
        // Initialisiere Zeilennummern-Bereich
        lineNumbers = new VBox();
        lineNumbers.setStyle("-fx-background-color: #f0f0f0; -fx-padding: 5;");

        // Initialisiere TextArea
        textArea = new TextArea();
        textArea.setStyle("-fx-padding: 5;");

        // Synchronisiere Zeilennummern mit TextArea-Inhalt
        textArea.textProperty().addListener((obs, oldText, newText) -> updateLineNumbers());

        // Synchronisiere die Scroll-Position der Zeilennummern mit der TextArea
        textArea.scrollTopProperty().addListener((obs, oldVal, newVal) -> 
            lineNumbers.setTranslateY(-newVal.doubleValue())
        );

        // Layout: Zeilennummern links, TextArea rechts
        getChildren().addAll(lineNumbers, textArea);
        HBox.setHgrow(textArea, Priority.ALWAYS);

        // Initialisiere die Zeilennummern
        updateLineNumbers();
    }

    private void updateLineNumbers() {
        // Anzahl der Zeilen berechnen
        int lines = textArea.getText().split("\n", -1).length;

        // Zeilennummern aktualisieren
        lineNumbers.getChildren().clear();
        for (int i = 1; i <= lines; i++) {
            Text lineNumber = new Text(String.valueOf(i));
            lineNumber.setStyle("-fx-fill: gray;");
            lineNumbers.getChildren().add(lineNumber);
        }
    }

    public TextArea getTextArea() {
        return textArea;
    }
}
