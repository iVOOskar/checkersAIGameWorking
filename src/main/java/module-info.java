module com.example.checkersaigame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.checkersaigame to javafx.fxml;
    exports com.example.checkersaigame;
}