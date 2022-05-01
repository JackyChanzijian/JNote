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
import life.jacky.demo.LinkedList.LinkedList;
import life.jacky.demo.Notes.Blog;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            loadInfo();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        refreshTreeView();
    }

    @FXML
    public void loadInfo() throws IOException {
        String path = "ProjectInfo.fxml";
        FXMLLoader loader= new FXMLLoader(getClass().getResource(path));
        loadScene(loader.load());
    }

    @FXML
    public void addNote(ActionEvent e) throws IOException {
        String path = "AddNote.fxml";
        FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
        Parent parent = loader.load();
        // Get Controller
        NoteController controller =  loader.getController();
        // Create new Note
        Note newNote = new Note();
        Global.notes.addLast(newNote);
        controller.setNote(newNote);
        // Load scene
        loadScene(parent);
    }

    @FXML
    public void addBlog(ActionEvent e) throws  IOException {
        String path = "AddBlog.fxml";
        FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
        Parent parent = loader.load();
        // Get Controller
        BlogController controller =  loader.getController();
        // Create new Note
        Blog newBlog = new Blog();
        Global.blogs.addLast(newBlog);
        controller.setBlog(newBlog);
        // Load scene
        loadScene(parent);
    }

    @FXML
    void onKeyReleased(KeyEvent event) {
        refreshTreeView();    // Update the tree view when typing
    }

    void loadScene(Parent fxml) throws IOException {
        secondView.getChildren().removeAll();
        secondView.getChildren().setAll(fxml);
    }
    void refreshTreeView() {
        TreeItem<String> rootItem = new TreeItem<>("Root");
        treeView.setRoot(rootItem);

        List<LinkedList<? extends Note>> lists = new ArrayList<>();
        lists.add(Global.notes);
        lists.add(Global.blogs);
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
