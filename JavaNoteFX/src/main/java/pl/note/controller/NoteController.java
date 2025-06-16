package pl.note.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import pl.note.model.Note;
import pl.note.service.Database;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import static java.time.LocalDateTime.now;

public class NoteController {

    @FXML
    private ListView<Note> noteListView;
    @FXML
    private TextField titleTextArea;
    @FXML
    private TextArea noteTextArea;
    @FXML
    public TextField noteId;

    @FXML
    public void initialize() {

        noteListView.setItems(Database.getAllNotes());

        noteListView.setCellFactory(listView -> new ListCell<Note>() {
            @Override
            protected void updateItem(Note note, boolean empty) {
                super.updateItem(note, empty);
                if (empty || note == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    Label titleLabel = new Label(note.getTitle());
                    titleLabel.getStyleClass().add("note-title");
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
                    Label dateLabel = new Label(note.getEditDate().format(formatter));
                    dateLabel.getStyleClass().add("note-date");
                    VBox vBox = new VBox(titleLabel, dateLabel);
                    vBox.setSpacing(2);
                    setGraphic(vBox);
                }
            }
        });

        noteListView.getSelectionModel().selectedItemProperty().addListener((obs, oldNote, newNote) -> {
            if (newNote != null) noteSelected(newNote);
        });
    }

    public void noteSelected(Note note) {
        noteId.setText(String.valueOf(note.getId()));
        titleTextArea.setText(note.getTitle());
        noteTextArea.setText(note.getContent());
    }

    @FXML
    private void addNewNote(ActionEvent event) throws IOException {
        noteId.setText("0");
        titleTextArea.setText("");
        noteTextArea.setText("");
    }

    @FXML
    private void saveNote(ActionEvent event) throws IOException {
        Note note = new Note(Integer.parseInt(noteId.getText()), titleTextArea.getText(), noteTextArea.getText(), now(), now());
        if(noteId.getText().equals("0")) {
            Database.add(note);
        } else {
            Database.edit(note);
            noteListView.refresh();
        }
    }

    @FXML
    private void removeNote(ActionEvent event) throws IOException {
        if(noteId.getText().equals("0")) {
            titleTextArea.setText("");
            noteTextArea.setText("");
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Uwaga!");
            alert.setHeaderText(null);
            alert.setContentText("Czy na pewno chcesz usunąć notatkę?");
            Optional<ButtonType> result = alert.showAndWait();
            if(result.isPresent() && result.get() == ButtonType.OK) {
                Database.removeById(Integer.parseInt(noteId.getText()));
                noteId.setText("0");
                titleTextArea.setText("");
                noteTextArea.setText("");
            }
        }
    }

}