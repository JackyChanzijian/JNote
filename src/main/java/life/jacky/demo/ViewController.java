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
import life.jacky.demo.Global;
import life.jacky.demo.LinkedList.LinkedList;
import life.jacky.demo.Notes.Note;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ViewController implements Initializable {
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
    public void setBlog(ActionEvent e) throws  IOException {
        loadScene("AddBlog.fxml");
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
        TreeItem<String> rootItem = new TreeItem<>("Root");
        treeView.setRoot(rootItem);

        List<LinkedList<? extends Note>> lists = new ArrayList<>();
        lists.add(Global.notes);
        lists.add(Global.essays);
        lists.add(Global.snippets);
        lists.add(Global.todos);

        for (LinkedList<? extends Note> list : lists) {
            // Title
            TreeItem<String> listRoot = new TreeItem<>(list.toString());
            rootItem.getChildren().add(listRoot);
            for (int i = 0; i < list.length; i++) {

                // Contents
                String content = list.get(i).toString();
                TreeItem<String> newTreeItem = new TreeItem<String>(content.substring(0, Math.min(20, content.length())));   // Remove the letters that are too long
                listRoot.getChildren().add(newTreeItem);
            }
        }
    }

}
