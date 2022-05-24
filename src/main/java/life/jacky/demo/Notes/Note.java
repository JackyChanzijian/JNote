package life.jacky.demo.Notes;

import java.io.Serializable;
import java.util.Date;

public class Note implements Serializable {
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
    public Date getCreatedDate() {
        return createdDate;
    }
    @Override
    public String toString() {
        return content;
    }

//    protected abstract void loadFromFile();
//    protected abstract void saveToFile();
}
