package life.jacky.demo.Notes;

import java.util.Date;

public class Note {
    private String content;
    private Date createdDate;

    public Note() {
        createdDate = new Date();
    }

    public Note(String content) {
        this.setContent(content);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return content;
    }

//    protected abstract void loadFromFile();
//    protected abstract void saveToFile();
}
