package life.jacky.demo;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import life.jacky.demo.Notes.Note;
import life.jacky.demo.Notes.Todo;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class TodoController extends NoteControllerBase {
    @FXML
    Label createdDate;
    @FXML
    CheckBox checkBox;
    @FXML
    TextField todoField;
    @FXML
    TextArea detailField;

    @FXML
    DatePicker datePicker;
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

    @FXML
    void onDateSelected() {
        if (datePicker.getValue() != null)
            todo.setDueDate(localDateToDate(datePicker.getValue()));
    }
    @Override
    public void setNote(Note note) {
        this.todo = (Todo) note;
        createdDate.setText(note.getCreatedDate().toString());
        checkBox.setSelected(todo.isComplete());
        todoField.setText(todo.getContent());
        detailField.setText(todo.getDetail());
        if (todo.getDueDate() != null)
            datePicker.setValue(dateToLocalDate(todo.getDueDate()));
    }
    static LocalDate dateToLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
    static Date localDateToDate(LocalDate localDate) {
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        return Date.from(instant);
    }
}
