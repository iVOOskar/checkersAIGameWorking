package com.example.checkersaigame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label lblStatus;

    @FXML
    private TextField txtUserName;

    @FXML
    private TextField txtPassWord;

    @FXML
   public void pressButton(ActionEvent event){

        for (int i = 0; i < database.Users.size(); i++) {
            if(txtUserName.getText().equals(database.Users.get(i)) && txtPassWord.getText().equals(database.Passwords.get(i))){
                lblStatus.setText("Login Success");
                break;
            }
            lblStatus.setText("Login Failed");
        }

   }
}