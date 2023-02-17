package com.example.checkersaigame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class leaderboard {
    public static int thisUser;
    public static int thisUserID;
    public static int maxNumMoves;
    public static void saveLeader(){
        //getting connection
        try {
            String DataLoc = System.getProperty("user.dir") + "\\src//main//resources//databases//NEADatabase.accdb";
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + DataLoc, "", "");

            Statement st = con.createStatement();
            //getting this userID
            thisUser= database.Passwords.get(HelloController.userNum);
            ResultSet rsUserID = st.executeQuery("Select UserID from Login Where Password='"+thisUser+"'");
            thisUserID = rsUserID.getInt("UserID");
            //getting least num moves of user
            ResultSet rsNumMoves = st.executeQuery("Select numMoves from LeaderBoard Where UserID = '"+thisUserID+"'");
            maxNumMoves = rsNumMoves.getInt("numMoves");
            //if this game had less moves change database
            if (maxNumMoves>mouseHandling.turnAdding){
                int i = st.executeUpdate("INSERT INTO LeaderBoard(UserID,numMoves,winner) Values('"+thisUserID+"','"+mouseHandling.turnAdding+"','"+GameBoard.winner+"')");
            }
        }catch(Exception e){

        }
    }

}
