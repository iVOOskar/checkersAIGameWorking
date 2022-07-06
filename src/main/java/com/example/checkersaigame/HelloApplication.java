package com.example.checkersaigame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class HelloApplication extends Application {

    @Override
    public void start(Stage stage){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("StartingMenu.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 400, 400);
            stage.setTitle("Menu");
            stage.setScene(scene);
            stage.show();
            stage.setResizable(false);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        database.DataBaseUserName();
        launch();
    }
}
