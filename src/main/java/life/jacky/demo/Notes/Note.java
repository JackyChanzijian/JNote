package life.jacky.demo.Notes;

import java.util.Date;

public class Note {
    private String content;
    private Date createdDate;

    Note() {
        createdDate = new Date();
    }

    public Note(String content) {
        this.content = content;
    }
}
