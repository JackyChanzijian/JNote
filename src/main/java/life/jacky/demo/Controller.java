package life.jacky.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class Controller {
    @FXML
    Button submitButton;
    @FXML
    Label title;

    @FXML
    StackPane secondView;
    @FXML
    public void onSubmit(ActionEvent e) throws IOException {
        loadScene("AddNote.fxml");
    }

    void loadScene(String path) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource(path));
        secondView.getChildren().removeAll();
        secondView.getChildren().setAll(fxml);
    }
}
