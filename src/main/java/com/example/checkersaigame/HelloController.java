package com.example.checkersaigame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;

public class HelloController {
    private Stage stage;
    private Scene scene;
    private FXMLLoader fxmlLoader;
    @FXML
    private Label lblStatus;

    @FXML
    private TextField txtUserName;

    @FXML
    private TextField txtPassWord;
    @FXML
    private Button loginButton;

    @FXML
   public void pressButtonLogin(ActionEvent event){

        for (int i = 0; i < database.Users.size(); i++) {
            if (txtUserName.getText().equals(database.Users.get(i)) && txtPassWord.getText().hashCode() == (database.Passwords.get(i))) {
                lblStatus.setText("Login Success");
                ((Node)(event.getSource())).getScene().getWindow().hide();
                GameBoard gb = new GameBoard();
                Screen gameScreen = new Screen();
                gameScreen.add(gb);
                gameScreen.pack();
                gameScreen.setLocationRelativeTo(null);
                gameScreen.setVisible(true);

                gb.StartThread();
                break;
            }
            lblStatus.setText("Login Failed");
        }


   }
    @FXML
    public void pressButtonBack(ActionEvent event){
        try {
            fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("StartingMenu.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.show();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}