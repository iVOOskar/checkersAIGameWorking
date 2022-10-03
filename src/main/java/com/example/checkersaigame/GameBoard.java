package com.example.checkersaigame;

import javax.swing.*;
import java.awt.*;

public class GameBoard extends JPanel implements Runnable{
    Thread gameThread;
    final int originalTileSize = 16; //16x16
    final int scale = 3;

    final int tileSize = originalTileSize * scale; ///48x48
    final int maxScreenCol = 8;
    final int maxScreenRow = 8;
    public tileManager tm = new tileManager(this);


    public class Board {

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

    public void createBoard() {
        Board game = new Board();

    }


    public void StartThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run() {
        double drawInterval = 1000/60;
        double delta = 0;
        long lastTime = System.currentTimeMillis();
        long currentTime;

        while (gameThread!= null){

            currentTime = System.currentTimeMillis();
            delta += (currentTime - lastTime)/drawInterval;
            lastTime = currentTime;
            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }

    public void update(){

    }


    public void paintComponent(Graphics g2){
        super.paintComponent(g2);
        Graphics2D g2D = (Graphics2D) g2;
        tm.draw(g2D);
    }
}



