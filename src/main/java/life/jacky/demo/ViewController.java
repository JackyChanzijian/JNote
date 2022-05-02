package life.jacky.demo;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import life.jacky.demo.Notes.Blog;
import life.jacky.demo.Notes.CodeSnippet;
import life.jacky.demo.Notes.Note;
import life.jacky.demo.Notes.Todo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewController implements Initializable {
    @FXML
    Button submitButton;
    @FXML
    Label title;

    @FXML
    StackPane secondView;

    @FXML
    ListView noteList, blogList, todoList, codeList;

    Note selectedNote;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            loadInfo();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        setupListView();
//        refreshTreeView();
    }

    @FXML
    public void loadInfo() throws IOException {
        String path = "ProjectInfo.fxml";
        FXMLLoader loader= new FXMLLoader(getClass().getResource(path));
        loadScene(loader.load());
    }

    public void showNote(Note target) throws IOException {
        String path = "AddNote.fxml";
        FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
        Parent parent = loader.load();
        // Get Controller
        NoteController controller =  loader.getController();
        // Create new Note
        controller.setNote(target);
        // Load scene
        loadScene(parent);
    }

    public void showBlog(Blog target) throws IOException {
        String path = "AddBlog.fxml";
        FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
        Parent parent = loader.load();
        // Get Controller
        BlogController controller =  loader.getController();
        // Create new Note
        controller.setBlog(target);
        // Load scene
        loadScene(parent);
    }

    public void showTodo(Todo target) throws IOException {
        String path = "Todo.fxml";
        FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
        Parent parent = loader.load();
        // Get Controller
        TodoController controller =  loader.getController();
        // Create new Note
        controller.setTodo(target);
        // Load scene
        loadScene(parent);
    }
    @FXML
    public void addNote(ActionEvent e) throws IOException {
        Note newNote = new Note();
        Global.notes.addLast(newNote);
        showNote(newNote);
    }

    @FXML
    public void addBlog(ActionEvent e) throws  IOException {
        Blog newBlog = new Blog();
        Global.blogs.addLast(newBlog);
        showBlog(newBlog);
    }

    @FXML
    public void addTodo(ActionEvent e) throws  IOException {
        Todo newBlog = new Todo();
        Global.todos.addLast(newBlog);
        showTodo(newBlog);
    }

    @FXML
    void onKeyReleased(KeyEvent event) {
        refreshListView();    // Update the tree view when typing
    }

    void loadScene(Parent fxml) throws IOException {
        secondView.getChildren().removeAll();
        secondView.getChildren().setAll(fxml);
    }
    void refreshListView() {
        noteList.getItems().setAll(Global.notes.toArray());
        blogList.getItems().setAll(Global.blogs.toArray());
        todoList.getItems().setAll(Global.todos.toArray());
        codeList.getItems().setAll(Global.codes.toArray());
    }
    void setupListView() {
        ListView[] lists = {noteList, blogList, todoList, codeList};
        // Add listener to every list
        for (ListView list : lists) {
            list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
                @Override
                public void changed(ObservableValue observableValue, Object o, Object t1) {
                    selectedNote = (Note) list.getSelectionModel().getSelectedItem();
                    if (selectedNote == null) return;   // Return if select nothing
                    // Check which type of note the selectedNote belong to
                    Class noteClass = selectedNote.getClass();
                    if (noteClass.equals(Note.class)) {
                        System.out.println("This is a Note");
                        // Display Note View
                        try {
                            showNote(selectedNote);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    else if (noteClass.equals(Blog.class)) {
                        System.out.println("This is a blog");
                        try {
                            showBlog((Blog) selectedNote);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    else if (noteClass.equals(Todo.class)) {
                        System.out.println("This is a todo");
                        try {
                            showTodo((Todo) selectedNote);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    else if (noteClass.equals(CodeSnippet.class)) {
                        System.out.println("This is a Code Snippet");
                    }
                    else {
                        System.out.println("Unknown Type");
                    }

                }
            });

        }

    }

}
