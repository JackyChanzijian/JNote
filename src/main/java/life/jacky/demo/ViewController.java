package life.jacky.demo;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import life.jacky.demo.Notes.Blog;
import life.jacky.demo.Notes.CodeSnippet;
import life.jacky.demo.Notes.Note;
import life.jacky.demo.Notes.Todo;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewController implements Initializable {
    @FXML
    StackPane secondView;
    @FXML
    ListView noteList, blogList, todoList, codeList;
    @FXML
    CheckBox autoSaveCheckBox;

    Note selectedNote;
    Scene thisScene;
    boolean isNightMode;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            showInfoView();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Load data
        try {
            loadData();
        } catch (IOException | ClassNotFoundException | CloneNotSupportedException e) {

        }
        setupListView();
    }

    @FXML
    public void showInfoView() throws IOException {
        String path = "ProjectInfo.fxml";
        FXMLLoader loader= new FXMLLoader(getClass().getResource(path));
        loadScene(loader.load());
    }

    public void showNote(Note target) throws IOException {
        // Get the target note path
        Class noteClass = target.getClass();
        String path = "Note.fxml";
        if (noteClass.equals(Note.class)) path = "Note.fxml";
        else if (noteClass.equals(Blog.class)) path = "Blog.fxml";
        else if (noteClass.equals(Todo.class)) path = "Todo.fxml";
        else if (noteClass.equals(CodeSnippet.class)) path = "CodeSnippet.fxml";
        // Get Scene Loader
        FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
        Parent parent = loader.load();
        // Get Controller
        NoteControllerBase controller =  loader.getController();
        // Create new Note
        controller.setNote(target);
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
    public void addBlog(ActionEvent e) throws IOException {
        Blog newBlog = new Blog();
        Global.blogs.addLast(newBlog);
        showNote(newBlog);
    }
    @FXML
    public void addTodo(ActionEvent e) throws IOException {
        Todo newBlog = new Todo();
        Global.todos.addLast(newBlog);
        showNote(newBlog);
    }

    @FXML
    public void addCodeSnippet(ActionEvent e) throws IOException {
        CodeSnippet codeSnippet = new CodeSnippet();
        Global.codeSnippets.addLast(codeSnippet);
        showNote(codeSnippet);
    }

    @FXML
    public void saveData() throws IOException {
        DataManager.saveAll();
    }
    @FXML
    public void loadData() throws IOException, ClassNotFoundException, CloneNotSupportedException {
        DataManager.loadAll();
        refreshListView();
    }
    @FXML
    void onKeyReleased(KeyEvent event) throws IOException {
        // Auto Save
        if (autoSaveCheckBox.isSelected()) {
            saveData();
        }
        // Delete selected note
        if (event.getCode() == KeyCode.BACK_SPACE) {
            if (selectedNote != null) {
                deleteNote(selectedNote);
            }
        }
        // Manually Save
        if (event.getCode() == KeyCode.S) {
            saveData();
        }
        refreshListView();    // Update the list view when typing
    }
    @FXML
    void toggleNightMode() {
        if (isNightMode) {
            thisScene.getStylesheets().removeAll(getClass().getResource("GlobalDark.css").toExternalForm());
        }
        else {
            thisScene.getStylesheets().add(getClass().getResource("GlobalDark.css").toExternalForm());
        }
        isNightMode = !isNightMode;  // Toggle night mode
    }
    void deleteNote(Note note) {
        System.out.println(selectedNote.toString());
        Class noteClass = note.getClass();
        // Delete the note from its linked list
        if (noteClass.equals(Note.class)) {
            Global.notes.deleteNode(note);
            System.out.println(Global.notes.length);
        }
        else if (noteClass.equals(Todo.class)) {
            Global.todos.deleteNode((Todo) note);
        }
        else if (noteClass.equals(Blog.class)) {
            Global.blogs.deleteNode((Blog) note);
        }
        else if (noteClass.equals(CodeSnippet.class)) {
            Global.codeSnippets.deleteNode((CodeSnippet) note);
        }
    }

    void loadScene(Parent fxml) throws IOException {
        secondView.getChildren().removeAll();
        secondView.getChildren().setAll(fxml);
    }
    void refreshListView() {
        noteList.getItems().setAll(Global.notes.toArray());
        blogList.getItems().setAll(Global.blogs.toArray());
        todoList.getItems().setAll(Global.todos.toArray());
        codeList.getItems().setAll(Global.codeSnippets.toArray());
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
                    try {
                        showNote(selectedNote);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });

        }
    }

}
