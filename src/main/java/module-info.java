module com.example.checkersaigame {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens com.example.checkersaigame to javafx.fxml;
    exports com.example.checkersaigame;
}