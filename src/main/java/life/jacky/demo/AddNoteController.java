package life.jacky.demo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import life.jacky.demo.Notes.Note;

import java.net.URL;
import java.util.ResourceBundle;

public class AddNoteController implements Initializable {
    Note newNote = new Note();
    @FXML
    private TextArea textArea;

    @FXML
    public void onKeyReleased(KeyEvent event) {
        System.out.println(123);
        saveText();
    }
    void saveText() {
        String content = textArea.getText();
        newNote.setContent(content);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Global.notes.addLast(newNote);
        System.out.println(Global.notes.length);
    }
}
