package com.example.checkersaigame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class tileManager {
    GameBoard gp;
    public Tile[] tile;
    public int mapTileNum[][];
    public tileManager (GameBoard gp){
        this.gp = gp;
        tile = new Tile[2];
        getTileImage();
        loadMap();
    }


    public void getTileImage() {
        try {
            tile[0] = new Tile(ImageIO.read(getClass().getResourceAsStream("/com.example.checkersaigame/sprites/black square.png")));

            tile[1] = new Tile(ImageIO.read(getClass().getResourceAsStream("/com.example.checkersaigame/sprites/red square.png")));

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public void loadMap(){
        try {

            InputStream is = getClass().getResourceAsStream("/map/boardMap.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while(col < 9 && row < 9) {
                String line = br.readLine();

                while (col < 9) {
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;

                }
                if (col == 9) {
                    col = 0;
                    row++;
                }
            }
            br.close();

        }catch(Exception e) {

        }
    }

    public void draw(Graphics2D g2D) {
        int currentCol = 0;
        int currentRow = 0;

        while(currentCol<9 && currentRow<9){

            int tileNum = mapTileNum[currentCol][currentRow];
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
