package com.example.checkersaigame;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.TimeUnit;

import static com.example.checkersaigame.mouseHandling.mouseX;
import static com.example.checkersaigame.mouseHandling.mouseY;

public abstract class Input{
    public static int posX;
    public static int posY;



    public static void mousePos() throws InterruptedException{
        //laptop mouse co-ods, x = 512
        //laptop mouse co-ods, y = 158
        //pc mouse co-ods, x = 700
        //pc mouse co-ods, y = 264
        int xBuffer = 700;
        int yBuffer = 264;

        //finding mouse position on board
            GameBoard gb = new GameBoard();
            if (mouseX > xBuffer && mouseX < xBuffer + gb.tileSize && mouseY > yBuffer && mouseY < yBuffer + gb.tileSize) {
                posX = 1;
                posY = 1;
            } else if (mouseX > xBuffer + 2 * gb.tileSize && mouseX < xBuffer + 3 * gb.tileSize && mouseY > yBuffer && mouseY < yBuffer + gb.tileSize) {
               posX = 3;
                posY = 1;
            } else if (mouseX > xBuffer + 4 * gb.tileSize && mouseX < xBuffer + 5 * gb.tileSize && mouseY > yBuffer && mouseY < yBuffer + gb.tileSize) {
                posX = 5;
                posY = 1;
            } else if (mouseX > xBuffer + 6 * gb.tileSize && mouseX < xBuffer + 7 * gb.tileSize && mouseY > yBuffer && mouseY < yBuffer + gb.tileSize) {
                posX = 7;
                posY = 1;
            } else if (mouseX > xBuffer + gb.tileSize && mouseX < xBuffer + 2 * gb.tileSize && mouseY > yBuffer + gb.tileSize && mouseY < yBuffer + 2 * gb.tileSize) {
                posX = 2;
                posY = 2;
            } else if (mouseX > xBuffer + 3 * gb.tileSize && mouseX < xBuffer + 4 * gb.tileSize && mouseY > yBuffer + gb.tileSize && mouseY < yBuffer + 2 * gb.tileSize) {
                posX = 4;
                posY = 2;
            } else if (mouseX > xBuffer + 5 * gb.tileSize && mouseX < xBuffer + 6 * gb.tileSize && mouseY > yBuffer + gb.tileSize && mouseY < yBuffer + 2 * gb.tileSize) {
                posX = 6;
                posY = 2;
            } else if (mouseX > xBuffer + 7 * gb.tileSize && mouseX < xBuffer + 8 * gb.tileSize && mouseY > yBuffer + gb.tileSize && mouseY < yBuffer + 2 * gb.tileSize) {
                posX = 8;
                posY = 2;
            } else if (mouseX > xBuffer && mouseX < xBuffer + gb.tileSize && mouseY > yBuffer + 2 * gb.tileSize && mouseY < yBuffer + 3 * gb.tileSize) {
                posX = 1;
                posY = 3;
            } else if (mouseX > xBuffer + 2 * gb.tileSize && mouseX < xBuffer + 3 * gb.tileSize && mouseY > yBuffer + 2 * gb.tileSize && mouseY < yBuffer + 3 * gb.tileSize) {
                posX = 3;
                posY = 3;
            } else if (mouseX > xBuffer+ 4 * gb.tileSize && mouseX  < xBuffer + 5 * gb.tileSize && mouseY > yBuffer + 2 * gb.tileSize && mouseY < yBuffer + 3 * gb.tileSize) {
                posX = 5;
                posY = 3;
            } else if (mouseX > xBuffer+ 6 * gb.tileSize && mouseX  < xBuffer + 7 * gb.tileSize && mouseY > yBuffer + 2 * gb.tileSize && mouseY < yBuffer + 3 * gb.tileSize) {
                posX = 7;
                posY = 3;
            }else if (mouseX > xBuffer + gb.tileSize&& mouseX  < xBuffer + 2* gb.tileSize && mouseY > yBuffer + 3 * gb.tileSize && mouseY < yBuffer + 4 * gb.tileSize) {
                posX = 2;
                posY = 4;
            } else if (mouseX > xBuffer +3 * gb.tileSize&& mouseX  < xBuffer + 4* gb.tileSize && mouseY > yBuffer + 3 * gb.tileSize && mouseY < yBuffer + 4 * gb.tileSize) {
                posX = 4;
                posY = 4;
            } else if (mouseX > xBuffer + 5*gb.tileSize&& mouseX  < xBuffer + 6* gb.tileSize && mouseY > yBuffer + 3 * gb.tileSize && mouseY < yBuffer + 4 * gb.tileSize) {
                posX = 6;
                posY = 4;
            } else if (mouseX > xBuffer + 7*gb.tileSize&& mouseX  < xBuffer + 8* gb.tileSize && mouseY > yBuffer + 3 * gb.tileSize && mouseY < yBuffer + 4 * gb.tileSize) {
                posX = 8;
                posY = 4;
            } else if (mouseX > xBuffer + 0*gb.tileSize&& mouseX  < xBuffer + 1* gb.tileSize && mouseY > yBuffer + 4 * gb.tileSize && mouseY < yBuffer + 5 * gb.tileSize) {
                posX = 1;
                posY = 5;
            } else if (mouseX > xBuffer + 2*gb.tileSize&& mouseX  < xBuffer + 3* gb.tileSize && mouseY > yBuffer + 4 * gb.tileSize && mouseY < yBuffer + 5 * gb.tileSize) {
                posX = 3;
                posY = 5;
            }else if (mouseX > xBuffer + 4*gb.tileSize&& mouseX  < xBuffer + 5* gb.tileSize && mouseY > yBuffer + 4 * gb.tileSize && mouseY < yBuffer + 5 * gb.tileSize) {
                posX = 5;
                posY = 5;
            }else if (mouseX > xBuffer + 6*gb.tileSize&& mouseX  < xBuffer + 7* gb.tileSize && mouseY > yBuffer + 4 * gb.tileSize && mouseY < yBuffer + 5 * gb.tileSize) {
                posX = 7;
                posY = 5;
            }else if (mouseX > xBuffer + 1*gb.tileSize&& mouseX  < xBuffer + 2* gb.tileSize && mouseY > yBuffer+ 5 * gb.tileSize && mouseY < yBuffer + 6 * gb.tileSize) {
                posX = 2;
                posY = 8;
            }else if (mouseX > xBuffer + 3*gb.tileSize&& mouseX  < xBuffer + 4* gb.tileSize && mouseY > yBuffer + 5 * gb.tileSize && mouseY < yBuffer + 6 * gb.tileSize) {
                posX = 4;
                posY = 6;
            }else if (mouseX > xBuffer + 5*gb.tileSize&& mouseX  < xBuffer + 6* gb.tileSize && mouseY > yBuffer + 5 * gb.tileSize && mouseY < yBuffer + 6 * gb.tileSize) {
                posX = 6;
                posY = 6;
            }else if (mouseX > xBuffer + 7*gb.tileSize&& mouseX  < xBuffer + 8* gb.tileSize && mouseY > yBuffer + 5 * gb.tileSize && mouseY < yBuffer + 6 * gb.tileSize) {
                posX = 8;
                posY = 6;
            }else if (mouseX > xBuffer + 0*gb.tileSize&& mouseX  < xBuffer + 1* gb.tileSize && mouseY > yBuffer + 6 * gb.tileSize && mouseY < yBuffer + 7 * gb.tileSize) {
                posX = 1;
                posY = 7;
            }else if (mouseX > xBuffer + 2*gb.tileSize&& mouseX  < xBuffer + 3* gb.tileSize && mouseY > yBuffer + 6 * gb.tileSize && mouseY < yBuffer + 7 * gb.tileSize) {
                posX = 3;
                posY = 7;
            }else if (mouseX > xBuffer + 4*gb.tileSize&& mouseX  < xBuffer + 5* gb.tileSize && mouseY > yBuffer + 6 * gb.tileSize && mouseY < yBuffer + 7 * gb.tileSize) {
                posX = 5;
                posY = 7;
            }else if (mouseX > xBuffer + 6*gb.tileSize&& mouseX  < xBuffer + 7* gb.tileSize && mouseY > yBuffer + 6 * gb.tileSize && mouseY < yBuffer + 7 * gb.tileSize) {
                posX = 7;
                posY = 7;
            }else if (mouseX > xBuffer + 1*gb.tileSize&& mouseX  < xBuffer + 2* gb.tileSize && mouseY > yBuffer + 7 * gb.tileSize && mouseY < yBuffer + 8 * gb.tileSize) {
                posX = 2;
                posY = 8;
            }else if (mouseX > xBuffer + 3*gb.tileSize&& mouseX  < xBuffer + 4* gb.tileSize && mouseY > yBuffer + 7 * gb.tileSize && mouseY < yBuffer + 8 * gb.tileSize) {
                posX = 4;
                posY = 8;
            }else if (mouseX > xBuffer + 5*gb.tileSize&& mouseX  < xBuffer + 6* gb.tileSize && mouseY > yBuffer + 7 * gb.tileSize && mouseY < yBuffer + 8 * gb.tileSize) {
                posX = 6;
                posY = 8;
            }else if (mouseX > xBuffer + 7*gb.tileSize&& mouseX  < xBuffer + 8* gb.tileSize && mouseY > yBuffer + 7 * gb.tileSize && mouseY < yBuffer + 8 * gb.tileSize) {
                posX = 8;
                posY = 8;
            }else{
                //invalid position
                posX = 999999999;
                posY = 999999999;
            }
        }
    }
