package com.example.checkersaigame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class registerMenuController {
    @FXML
    private TextField RegUserName;

    @FXML
    private TextField RegPassWord;

    @FXML
    private Label ReglblStatus;

    @FXML
    public void pressButtonRegister(ActionEvent event){
        try {
            String Username = RegUserName.getText();
            String Password = RegPassWord.getText();

            database.Users.add(Username);
            database.Passwords.add(Password);

            ReglblStatus.setText("Register Success");
        }catch (Exception e){
            System.out.println(e);
            ReglblStatus.setText("Register Failed");
        }



    }

}
