package com.example.checkersaigame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;


public class starterMenuController {

    private Stage stage;
    private Scene scene;
    private FXMLLoader fxmlLoader;
    //public static ArrayList<String> users = new ArrayList<>();
    private ArrayList<Integer> Scores = new ArrayList<>();
    public static ArrayList<Integer> UserId = new ArrayList<>();
    private int user;

    @FXML
    public void pressButtonLoginMenu(ActionEvent event) {
        try {
            //go to login menu
            fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    public void pressButtonRegisterMenu(ActionEvent event) {
        try {
            //go to register menu
            fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("registerMenu.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    public void pressButtonLeaderboard(ActionEvent event) {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        try {
            String DataLoc = System.getProperty("user.dir") + "\\src//main//resources//databases//NEADatabase.accdb";

            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + DataLoc, "", "");

            Statement st = con.createStatement();

            ResultSet rsUserID = st.executeQuery("Select UserID From leaderboard");
            while(true) {

                if(rsUserID.next()) {
                    UserId.add(rsUserID.getInt("UserID"));
                }else{
                    break;
                }
            }
            //for (int i = 0; i < UserId.size(); i++) {
           //     ResultSet rsUser = st.executeQuery("Select UserName From Login Where UserID = '"+UserId.get(i)+"'");
            //    users.add(rsUser.getString("UserName"));
            //}

            ResultSet rsScores = st.executeQuery("Select numMoves From leaderboard");
            while (true) {
                //writing to the array from database usernames
                if (rsScores.next()) {
                    Scores.add(rsScores.getInt("numMoves"));
                } else {
                    break;
                }
            }
            int ScoresArray[] = new int[Scores.size()];
            for (int i = 0; i < Scores.size(); i++) {
                ScoresArray[i]=Scores.get(i);
            }

            mergeSort.merge(ScoresArray);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}

