package com.example.checkersaigame;
import javax.swing.*;
import java.awt.*;

public class GameBoard extends JPanel implements Runnable {
    final int originalTileSize = 16;
    final int characterSize = 16;
    final int characterScaling = 4;
    public final int tileSize = characterSize*characterScaling;
    final int maxScreenCol = 8; // how big actual window is
    final int maxScreenRow = 8;
    final int screenWidth = maxScreenCol * tileSize;
    final int screenHeight = maxScreenRow * tileSize;

    public final int maxWorldCol = 50; // how big map is
    public final int maxWorldRow = 50;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;
    public static String winner;
    Thread gameThread;




    public GameBoard(){
        //loading the board screen
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        mouseHandling mm1 = new mouseHandling();
        this.addMouseListener(mm1);

    }
    tileManager TileManager = new tileManager(this);

    public void StartThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run() {
        //games loop
        double drawInterval = 1000/60;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer =0;




        while (gameThread!= null){

            currentTime = System.nanoTime();
            timer += (currentTime - lastTime);
            delta += (currentTime - lastTime)/drawInterval;
            lastTime = currentTime;
            if (delta >= 1) {

                repaint();
                delta--;


            }
            if (timer >= 1000000000){
                //System.out.println("FPS:"+ drawCount);
                timer = 0;
            }
            //check if winners
            if(mouseHandling.greyTakes==12){
                System.out.println("Grey wins");
                //reset board
                mouseHandling mH = new mouseHandling();
                mH.mapToArray();
                mouseHandling.greyTakes =0;
                //check is winners
                winner = "grey";
                leaderboard.saveLeader();
            }else if(mouseHandling.whiteTakes==12){
                System.out.println("white wins");
                //reset board
                mouseHandling mH = new mouseHandling();
                mH.mapToArray();
                mouseHandling.whiteTakes=0;
                winner = "White";
                leaderboard.saveLeader();
            }
        }
    }

    public void paintComponent(Graphics g2){
        super.paintComponent(g2);
        Graphics2D g2D = (Graphics2D) g2;
        TileManager.draw(g2D);
        //g2D.dispose();

    }
}



