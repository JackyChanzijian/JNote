package life.jacky.demo.Notes;

public class Essay extends Note {
    private String author;
    private String title;

    Essay() {
        super();
    }

    Essay(String content, String author, String title) {
        super(content);
        this.author = author;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
