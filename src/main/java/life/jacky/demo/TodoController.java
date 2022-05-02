package life.jacky.demo;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import life.jacky.demo.Notes.Note;
import life.jacky.demo.Notes.Todo;

public class TodoController extends NoteControllerBase {
    @FXML
    CheckBox checkBox;
    @FXML
    TextField todoField;
    @FXML
    TextArea detailField;
    Todo todo;

    @FXML
    void onChecked(MouseEvent event) {
        todo.setComplete(checkBox.isSelected());
    }

    @FXML
    void onContentTyped(KeyEvent event) {
        todo.setContent(todoField.getText());
    }

    @FXML
    void onDetailTyped(KeyEvent event) {
        todo.setDetail(detailField.getText());
    }
    @Override
    public void setNote(Note note) {
        this.todo = (Todo) note;
        checkBox.setSelected(todo.isComplete());
        todoField.setText(todo.getContent());
        detailField.setText(todo.getDetail());
    }
}
