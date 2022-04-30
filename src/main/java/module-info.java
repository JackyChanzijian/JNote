module life.jacky.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens life.jacky.demo to javafx.fxml;
    exports life.jacky.demo;
    exports life.jacky.demo.LinkedList;
    opens life.jacky.demo.LinkedList to javafx.fxml;
    exports life.jacky.demo.Notes;
    opens life.jacky.demo.Notes to javafx.fxml;
}