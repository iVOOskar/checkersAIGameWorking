package com.example.checkersaigame;
import java.sql.*;
import java.util.ArrayList;


public class database {
    public static ArrayList<String> Users = new ArrayList<>();
    public static ArrayList<Integer> Passwords = new ArrayList<>();
    public static void DataBaseUserName() {
        try {
            //clearing arrays for reading from array
            Users.clear();
            Passwords.clear();
            //getting connection to database
            String DataLoc = System.getProperty("user.dir") + "\\src//main//resources//databases//NEADatabase.accdb";

            Connection con = DriverManager.getConnection("jdbc:ucanaccess://"+ DataLoc, "","");

            Statement st = con.createStatement();
            //SQL for usernames
            ResultSet rsUser = st.executeQuery("Select UserName from Login");
            //SQL for passwords
            ResultSet rsPass = st.executeQuery("Select Password from Login");

            while (true) {
                //writing to the array from database usernames
                if (rsUser.next()) {
                    Users.add(rsUser.getString("UserName"));
                } else {
                    break;
                }
            }
            while (true) {
                //writing to the array from database passwords
                if (rsPass.next()) {
                    Passwords.add(rsPass.getInt("Password"));
                } else {
                    break;
                }
            }
            //testing
            //System.out.println(Users);
            //System.out.println(Passwords);

                con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
