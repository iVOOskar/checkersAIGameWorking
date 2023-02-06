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
    public static boolean Mouse = true;



    public static void mousePos() throws InterruptedException{


            GameBoard gb = new GameBoard();
            if (mouseX > 700 && mouseX < 700 + gb.tileSize && mouseY > 264 && mouseY < 264 + gb.tileSize) {
                posX = 1;
                posY = 1;
            } else if (mouseX > 700 + 2 * gb.tileSize && mouseX < 700 + 3 * gb.tileSize && mouseY > 264 && mouseY < 264 + gb.tileSize) {
               posX = 3;
                posY = 1;
            } else if (mouseX > 700 + 4 * gb.tileSize && mouseX < 700 + 5 * gb.tileSize && mouseY > 264 && mouseY < 264 + gb.tileSize) {
                posX = 5;
                posY = 1;
            } else if (mouseX > 700 + 6 * gb.tileSize && mouseX < 700 + 7 * gb.tileSize && mouseY > 264 && mouseY < 264 + gb.tileSize) {
                posX = 7;
                posY = 1;
            } else if (mouseX > 700 + gb.tileSize && mouseX < 700 + 2 * gb.tileSize && mouseY > 264 + gb.tileSize && mouseY < 264 + 2 * gb.tileSize) {
                posX = 2;
                posY = 2;
            } else if (mouseX > 700 + 3 * gb.tileSize && mouseX < 700 + 4 * gb.tileSize && mouseY > 264 + gb.tileSize && mouseY < 264 + 2 * gb.tileSize) {
                posX = 4;
                posY = 2;
            } else if (mouseX > 700 + 5 * gb.tileSize && mouseX < 700 + 6 * gb.tileSize && mouseY > 264 + gb.tileSize && mouseY < 264 + 2 * gb.tileSize) {
                posX = 6;
                posY = 2;
            } else if (mouseX > 700 + 7 * gb.tileSize && mouseX < 700 + 8 * gb.tileSize && mouseY > 264 + gb.tileSize && mouseY < 264 + 2 * gb.tileSize) {
                posX = 8;
                posY = 2;
            } else if (mouseX > 700 && mouseX < 700 + gb.tileSize && mouseY > 264 + 2 * gb.tileSize && mouseY < 264 + 3 * gb.tileSize) {
                posX = 1;
                posY = 3;
            } else if (mouseX > 700 + 2 * gb.tileSize && mouseX < 700 + 3 * gb.tileSize && mouseY > 264 + 2 * gb.tileSize && mouseY < 264 + 3 * gb.tileSize) {
                posX = 3;
                posY = 3;
            } else if (mouseX > 700+ 4 * gb.tileSize && mouseX  < 700 + 5 * gb.tileSize && mouseY > 264 + 2 * gb.tileSize && mouseY < 264 + 3 * gb.tileSize) {
                posX = 5;
                posY = 3;
            } else if (mouseX > 700+ 6 * gb.tileSize && mouseX  < 700 + 7 * gb.tileSize && mouseY > 264 + 2 * gb.tileSize && mouseY < 264 + 3 * gb.tileSize) {
                posX = 7;
                posY = 3;
            }else if (mouseX > 700 + gb.tileSize&& mouseX  < 700 + 2* gb.tileSize && mouseY > 264 + 3 * gb.tileSize && mouseY < 264 + 4 * gb.tileSize) {
                posX = 2;
                posY = 4;
            } else if (mouseX > 700 +3 * gb.tileSize&& mouseX  < 700 + 4* gb.tileSize && mouseY > 264 + 3 * gb.tileSize && mouseY < 264 + 4 * gb.tileSize) {
                posX = 4;
                posY = 4;
            } else if (mouseX > 700 + 5*gb.tileSize&& mouseX  < 700 + 6* gb.tileSize && mouseY > 264 + 3 * gb.tileSize && mouseY < 264 + 4 * gb.tileSize) {
                posX = 6;
                posY = 4;
            } else if (mouseX > 700 + 7*gb.tileSize&& mouseX  < 700 + 8* gb.tileSize && mouseY > 264 + 3 * gb.tileSize && mouseY < 264 + 4 * gb.tileSize) {
                posX = 8;
                posY = 4;
            } else if (mouseX > 700 + 0*gb.tileSize&& mouseX  < 700 + 1* gb.tileSize && mouseY > 264 + 4 * gb.tileSize && mouseY < 264 + 5 * gb.tileSize) {
                posX = 1;
                posY = 5;
            } else if (mouseX > 700 + 2*gb.tileSize&& mouseX  < 700 + 3* gb.tileSize && mouseY > 264 + 4 * gb.tileSize && mouseY < 264 + 5 * gb.tileSize) {
                posX = 3;
                posY = 5;
            }else if (mouseX > 700 + 4*gb.tileSize&& mouseX  < 700 + 5* gb.tileSize && mouseY > 264 + 4 * gb.tileSize && mouseY < 264 + 5 * gb.tileSize) {
                posX = 5;
                posY = 5;
            }else if (mouseX > 700 + 6*gb.tileSize&& mouseX  < 700 + 7* gb.tileSize && mouseY > 264 + 4 * gb.tileSize && mouseY < 264 + 5 * gb.tileSize) {
                posX = 7;
                posY = 5;
            }else if (mouseX > 700 + 1*gb.tileSize&& mouseX  < 700 + 2* gb.tileSize && mouseY > 264 + 5 * gb.tileSize && mouseY < 264 + 6 * gb.tileSize) {
                posX = 2;
                posY = 8;
            }else if (mouseX > 700 + 3*gb.tileSize&& mouseX  < 700 + 4* gb.tileSize && mouseY > 264 + 5 * gb.tileSize && mouseY < 264 + 6 * gb.tileSize) {
                posX = 4;
                posY = 6;
            }else if (mouseX > 700 + 5*gb.tileSize&& mouseX  < 700 + 6* gb.tileSize && mouseY > 264 + 5 * gb.tileSize && mouseY < 264 + 6 * gb.tileSize) {
                posX = 6;
                posY = 6;
            }else if (mouseX > 700 + 7*gb.tileSize&& mouseX  < 700 + 8* gb.tileSize && mouseY > 264 + 5 * gb.tileSize && mouseY < 264 + 6 * gb.tileSize) {
                posX = 8;
                posY = 6;
            }else if (mouseX > 700 + 0*gb.tileSize&& mouseX  < 700 + 1* gb.tileSize && mouseY > 264 + 6 * gb.tileSize && mouseY < 264 + 7 * gb.tileSize) {
                posX = 1;
                posY = 7;
            }else if (mouseX > 700 + 2*gb.tileSize&& mouseX  < 700 + 3* gb.tileSize && mouseY > 264 + 6 * gb.tileSize && mouseY < 264 + 7 * gb.tileSize) {
                posX = 3;
                posY = 7;
            }else if (mouseX > 700 + 4*gb.tileSize&& mouseX  < 700 + 5* gb.tileSize && mouseY > 264 + 6 * gb.tileSize && mouseY < 264 + 7 * gb.tileSize) {
                posX = 5;
                posY = 7;
            }else if (mouseX > 700 + 6*gb.tileSize&& mouseX  < 700 + 7* gb.tileSize && mouseY > 264 + 6 * gb.tileSize && mouseY < 264 + 7 * gb.tileSize) {
                posX = 7;
                posY = 7;
            }else if (mouseX > 700 + 1*gb.tileSize&& mouseX  < 700 + 2* gb.tileSize && mouseY > 264 + 7 * gb.tileSize && mouseY < 264 + 8 * gb.tileSize) {
                posX = 2;
                posY = 8;
            }else if (mouseX > 700 + 3*gb.tileSize&& mouseX  < 700 + 4* gb.tileSize && mouseY > 264 + 7 * gb.tileSize && mouseY < 264 + 8 * gb.tileSize) {
                posX = 4;
                posY = 8;
            }else if (mouseX > 700 + 5*gb.tileSize&& mouseX  < 700 + 6* gb.tileSize && mouseY > 264 + 7 * gb.tileSize && mouseY < 264 + 8 * gb.tileSize) {
                posX = 6;
                posY = 8;
            }else if (mouseX > 700 + 7*gb.tileSize&& mouseX  < 700 + 8* gb.tileSize && mouseY > 264 + 7 * gb.tileSize && mouseY < 264 + 8 * gb.tileSize) {
                posX = 8;
                posY = 8;
            }else{
                posX = 999999999;
                posY = 999999999;
            }
        }
    }
