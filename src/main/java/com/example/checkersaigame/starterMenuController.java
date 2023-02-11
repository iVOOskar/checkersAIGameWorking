package com.example.checkersaigame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;




public class starterMenuController {

    private Stage stage;
    private Scene scene;
    private FXMLLoader fxmlLoader;

    @FXML
    public void pressButtonLoginMenu(ActionEvent event){
        try {
            //go to login menu
            fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.show();

        }catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    public void pressButtonRegisterMenu(ActionEvent event){
        try {
            //go to register menu
            fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("registerMenu.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.show();

        }catch (Exception e){
            System.out.println(e);
        }
    }


}
