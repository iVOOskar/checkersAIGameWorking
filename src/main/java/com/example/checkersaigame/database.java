package com.example.checkersaigame;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

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

            ResultSet rsUser = st.executeQuery("Select UserName from Login");
            ResultSet rsPass = st.executeQuery("Select Password from Login");

            while (true) {
                if (rsUser.next()) {
                    Users.add(rsUser.getString("UserName"));
                } else {
                    break;
                }
            }
            while (true) {
                if (rsPass.next()) {
                    Passwords.add(rsPass.getInt("Password"));
                } else {
                    break;
                }
            }
            System.out.println(Users);
            System.out.println(Passwords);

                con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
