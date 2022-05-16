package life.jacky.demo;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import life.jacky.demo.Notes.CodeSnippet;
import life.jacky.demo.Notes.Note;
import life.jacky.demo.Notes.Todo;

public class CodeSnippetController extends NoteControllerBase {
    CodeSnippet snippet;
    @FXML
    TextArea textArea;
    @FXML
    ChoiceBox<String> choiceBox;

    @FXML
    void onContentTyped() {
        snippet.setContent(textArea.getText());
    }
    @FXML
    void onChoiceBoxSelected() {
        snippet.setLanguage(choiceBox.getValue());
    }
    @Override
    public void setNote(Note note) {
        setupChoiceBox();
        this.snippet = (CodeSnippet) note;
        textArea.setText(snippet.getContent());
        choiceBox.getSelectionModel().select(snippet.getLanguage());
    }

    void setupChoiceBox() {
        choiceBox.setItems(FXCollections.observableArrayList(CodeSnippet.languageList));
    }
}
