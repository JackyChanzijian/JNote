package life.jacky.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    Button submitButton;
    @FXML
    Label title;

    @FXML
    StackPane secondView;

    @FXML
    TreeView treeView;

    @FXML
    public void onSubmit(ActionEvent e) throws IOException {
        loadScene("AddNote.fxml");
    }

    @FXML
    void onKeyReleased(KeyEvent event) {
        setupTreeView();    // Update the tree view when typing
    }

    void loadScene(String path) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource(path));
        secondView.getChildren().removeAll();
        secondView.getChildren().setAll(fxml);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setupTreeView();
    }
    void setupTreeView() {
        TreeItem<String> rootItem = new TreeItem<>("Note");
        treeView.setRoot(rootItem);
        for (int i = 0; i < Global.notes.length; i++) {
            TreeItem<String> newTreeItem = new TreeItem<String>(Global.notes.get(i).getContent());
            rootItem.getChildren().add(newTreeItem);
        }
    }

}
