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
       if(txtUserName.getText().equals("user") && txtPassWord.getText().equals("pass")){
           lblStatus.setText("Login Success");
       } else {
           lblStatus.setText("Login Failed");
       }
   }
}