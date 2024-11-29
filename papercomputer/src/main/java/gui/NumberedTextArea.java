package gui;

import javafx.beans.property.StringProperty;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Priority;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class NumberedTextArea extends HBox {
    private final TextArea textArea;
    private final TextArea lineNumberArea;

    public NumberedTextArea() {
        // Haupt-Textbereich
        textArea = new TextArea();
        textArea.setWrapText(false); // Kein automatischer Zeilenumbruch

        // Zeilennummern-Bereich (als "read-only")
        lineNumberArea = new TextArea();
        lineNumberArea.setEditable(false);
        lineNumberArea.setFocusTraversable(false);
        lineNumberArea.setStyle("-fx-control-inner-background: #f0f0f0; -fx-font-weight: bold;");
        lineNumberArea.setPrefWidth(50); // Feste Breite für Zeilennummern
        lineNumberArea.setWrapText(false); // Kein Zeilenumbruch für Zeilennummern
        lineNumberArea.setMouseTransparent(true); // Zeilennummern nicht anklickbar

        // Synchronisiere Scrollen der TextArea mit den Zeilennummern
        textArea.scrollTopProperty().addListener((observable, oldValue, newValue) -> 
            lineNumberArea.setScrollTop(newValue.doubleValue())
        );

        // Aktualisiere Zeilennummern bei Textänderungen
        textArea.textProperty().addListener((observable, oldValue, newValue) -> updateLineNumbers());

        // Layout: Zeilennummern links, TextArea rechts
        this.getChildren().addAll(lineNumberArea, textArea);
        HBox.setHgrow(textArea, Priority.ALWAYS);
    }

    private void updateLineNumbers() {
        // Anzahl der Zeilen ermitteln
        int lineCount = textArea.getText().split("\n", -1).length;

        // Zeilennummern-Text generieren
        StringBuilder lineNumbers = new StringBuilder();
        for (int i = 1; i <= lineCount; i++) {
            lineNumbers.append(i).append("\n");
        }
        lineNumberArea.setText(lineNumbers.toString());
    }

    // Getter für die Haupt-TextArea (z. B. für den Controller)
    public TextArea getTextArea() {
        return textArea;
    }
}
