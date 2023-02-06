package com.example.checkersaigame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class HelloApplication extends Application {

    @Override
    public void start(Stage stage){
        try {
            //loading the start menu with 3 choices
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
        //loading database
        database.DataBaseUserName();
        //loading game map into array
        mouseHandling mH = new mouseHandling();
        mH.mapToArray();
        launch();
    }
}
