package life.jacky.demo.Notes;

import java.util.Date;

public class Todo extends Note {
    private boolean isComplete = false;
    private String detail;
    private Date dueDate;

    public Todo() {
        super();
    }

    Todo(String content, Date dueDate) {
        super(content);
        this.dueDate = dueDate;
    }

    public void toggleIsComplete() {
        setComplete(!isComplete());
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
