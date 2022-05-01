package life.jacky.demo.Notes;

import java.util.Date;

public class Todo extends Note {
    private boolean isComplete = false;
    private Date dueDate;

    Todo() {
        super();
    }

    Todo(String content, Date dueDate) {
        super(content);
        this.dueDate = dueDate;
    }

    public void toggleIsComplete() {
        isComplete = !isComplete;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}
