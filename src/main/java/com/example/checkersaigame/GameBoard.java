package com.example.checkersaigame;

import javax.swing.*;

public class GameBoard{
    static Thread gameThread;


    public static class Board {

        final int originalTileSize = 16; //16x16
        final int scale = 3;

        final int tileSize = originalTileSize * scale; ///48x48
        final int maxScreenCol = 8;
        final int maxScreenRow = 8;

        final int screenWidth = tileSize * maxScreenCol;//384 Pixels
        final int screenHeight = tileSize *maxScreenRow;//384 Pixels
        private JFrame frame = new JFrame();
        private JPanel backBoard = new JPanel();


        Board() {

            frame.setSize(screenWidth+5, screenHeight+5);
            backBoard.setSize(screenWidth, screenHeight);
            frame.setTitle("Checkers");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            backBoard.setVisible(true);
            frame.setResizable(false);
        }
    }




        public static void createBoard() {
            Board game = new Board();
        }




    }


