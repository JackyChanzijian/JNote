package life.jacky.demo;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import life.jacky.demo.Notes.Blog;

public class BlogController {
    Blog blog;

    @FXML
    private TextField authorText;
    @FXML
    private TextField titleText;
    @FXML
    private TextArea contentText;

    @FXML
    public void onKeyReleased(KeyEvent event) {
        saveBlog();
    }

    void saveBlog() {
        String title = titleText.getText();
        String author = authorText.getText();
        String content = contentText.getText();

        blog.setTitle(title);
        blog.setAuthor(author);
        blog.setContent(content);
    }

    void setBlog(Blog blog) {
        this.blog = blog;
        titleText.setText(blog.getTitle());
        authorText.setText(blog.getAuthor());
        contentText.setText(blog.getContent());
    }

}
