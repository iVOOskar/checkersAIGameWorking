package com.example.checkersaigame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class tileManager {
    GameBoard gp;
    public Tile[] tile;

    public tileManager(GameBoard gp) {
        this.gp = gp;
        tile = new Tile[10];
        getTileImage();
    }


    public void getTileImage() {
        try {
            //loading tiles
            tile[0] = new Tile(ImageIO.read(new FileInputStream("sprites/blacksquare.png")));
            tile[1] = new Tile(ImageIO.read(new FileInputStream("sprites/redsquare.png")));
            tile[2] = new Tile(ImageIO.read(new FileInputStream("sprites/redpiece.png")));
            tile[3] = new Tile(ImageIO.read(new FileInputStream("sprites/greypiece.png")));
            tile[4] = new Tile(ImageIO.read(new FileInputStream("sprites/redking.png")));
            tile[5] = new Tile(ImageIO.read(new FileInputStream("sprites/greyking.png")));

        } catch (Exception e) {
            System.out.println(e);
        }
    }





    public void draw(Graphics2D g2D) {
        int currentCol = 0;
        int currentRow = 0;
        //System.out.println("drawing");
        while(currentRow<8){
            int tileNum = mouseHandling.maptoarrays[currentCol][currentRow];
            int screenX = currentCol * gp.tileSize;
            int screenY = currentRow * gp.tileSize;
            g2D.drawImage(tile[tileNum].image,screenX,screenY,gp.tileSize,gp.tileSize,null);
            currentCol++;
            if (currentCol == gp.maxScreenCol){
                currentCol = 0;
                currentRow ++;
            }
        }
    }

}
