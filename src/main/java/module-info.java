module life.jacky.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens life.jacky.demo to javafx.fxml;
    exports life.jacky.demo;
}