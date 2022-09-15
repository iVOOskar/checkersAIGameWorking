package com.example.checkersaigame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class registerMenuController {
    private Stage stage;
    private Scene scene;
    private FXMLLoader fxmlLoader;

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
            int Password = RegPassWord.getText().hashCode();

            String DataLoc = System.getProperty("user.dir") + "\\src//main//resources//databases//NEADatabase.accdb";

            Connection con = DriverManager.getConnection("jdbc:ucanaccess://"+ DataLoc, "","");

            Statement st = con.createStatement();

            int i = st.executeUpdate("INSERT INTO Login(Username,Password) Values('"+Username+"','"+Password+"')");

            ReglblStatus.setText("Register Success");

            database.DataBaseUserName();
            fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("StartingMenu.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.show();



        }catch (Exception e){
            System.out.println(e);
            ReglblStatus.setText("Register Failed");
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
