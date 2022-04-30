package life.jacky.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {
    @FXML
    Button submitButton;
    @FXML
    Label title;
    @FXML
    public void onSubmit(ActionEvent e) {
      title.setText("123");
    }
}
