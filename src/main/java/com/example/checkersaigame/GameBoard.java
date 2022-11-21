package com.example.checkersaigame;
import javax.swing.*;
import java.awt.*;

public class GameBoard extends JPanel implements Runnable{
    Thread gameThread;
    final int originalTileSize = 16; //16x16
    final int scale = 6;

    final int tileSize = originalTileSize * scale; //96x96
    final int maxScreenCol = 8;
    final int maxScreenRow = 8;
    public tileManager tm = new tileManager(this);
    final int screenWidth = tileSize * maxScreenCol;//768 Pixels
    final int screenHeight = tileSize *maxScreenRow;//768 Pixels
    private Graphics g2;

    public class Board {


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
        long timer=0;
        int drawCount=0;
        paintComponent(g2);


        while (gameThread!= null){
            //System.out.println("update");
            currentTime = System.currentTimeMillis();
            timer += (currentTime - lastTime);
            delta += (currentTime - lastTime)/drawInterval;
            lastTime = currentTime;
            if (delta >= 1) {
                repaint();
                delta--;
                drawCount++;
            }
            if (timer >= 1000){
                drawCount = 0;
                timer = 0;
            }
        }
    }


    public void paintComponent(Graphics g2){
        this.g2 = g2;
        System.out.println("painting");
        super.paintComponent(g2);
        Graphics2D g2D = (Graphics2D) g2;
        tm.draw(g2D);
        g2D.dispose();
    }
}



