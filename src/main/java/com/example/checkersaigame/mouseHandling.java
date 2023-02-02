package com.example.checkersaigame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class mouseHandling implements MouseListener {
    public int pieceX;
    public int pieceY;
    boolean valid = false;

    @Override
    public void mouseClicked(MouseEvent arg0) {
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        if (Input.posX == 999999999) {
            System.out.println("click on a valid space");
        } else {
            valid = true;
            if (tileManager.mapTileNum[Input.posX][Input.posY] == 2) {
                pieceX = Input.posX;
                pieceY = Input.posY;

            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        if (valid == true && tileManager.mapTileNum[Input.posX][Input.posY] == 0 && Input.posX != 999999999) {
            tileManager.mapTileNum[pieceX][pieceY] = 0;
            tileManager.mapTileNum[Input.posX][Input.posY] = 2;
        } else {
            System.out.println("select a valid place");
        }
    }
}
