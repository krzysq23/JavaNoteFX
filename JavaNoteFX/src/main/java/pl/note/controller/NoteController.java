package pl.note.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class NoteController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}