package life.jacky.demo;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import life.jacky.demo.Notes.Note;

public class NoteController {
    Note note;
    @FXML
    private TextArea textArea;

    @FXML
    public void onKeyReleased(KeyEvent event) {
        saveNote();
    }
    void saveNote() {
        String content = textArea.getText();
        note.setContent(content);
    }
    public void setNote(Note note) {
        this.note = note;
        textArea.setText(note.getContent());
    }
}
