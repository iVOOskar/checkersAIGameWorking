package com.example.checkersaigame;

import javax.swing.*;

public class Screen  extends JFrame {
    Screen (){
        //set up screen for game
        this.setTitle("GameBoard");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setUndecorated(true);
    }
}
