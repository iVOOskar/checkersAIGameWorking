package com.example.checkersaigame;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.TimeUnit;

public abstract class Input implements MouseListener {
    public boolean leftC;

    public static void mousePos() throws InterruptedException{


        while (true) {
            TimeUnit.SECONDS.sleep(1 / 2);
            double mouseX = MouseInfo.getPointerInfo().getLocation().getX();
            double mouseY = MouseInfo.getPointerInfo().getLocation().getY();
            System.out.println("X:" + mouseX);
            System.out.println("Y:" + mouseY);
            GameBoard gb = new GameBoard();
            if (mouseX > 700 && mouseX < 700 + gb.tileSize && mouseY > 264 && mouseY < 264 + gb.tileSize) {
                System.out.println("1");
            } else if (mouseX > 700 + 2 * gb.tileSize && mouseX < 700 + 3 * gb.tileSize && mouseY > 264 && mouseY < 264 + gb.tileSize) {
                System.out.println("2");
            } else if (mouseX > 700 + 4 * gb.tileSize && mouseX < 700 + 5 * gb.tileSize && mouseY > 264 && mouseY < 264 + gb.tileSize) {
                System.out.println("3");
            } else if (mouseX > 700 + 6 * gb.tileSize && mouseX < 700 + 7 * gb.tileSize && mouseY > 264 && mouseY < 264 + gb.tileSize) {
                System.out.println("4");
            } else if (mouseX > 700 + gb.tileSize && mouseX < 700 + 2 * gb.tileSize && mouseY > 264 + gb.tileSize && mouseY < 264 + 2 * gb.tileSize) {
                System.out.println("5");
            } else if (mouseX > 700 + 3 * gb.tileSize && mouseX < 700 + 4 * gb.tileSize && mouseY > 264 + gb.tileSize && mouseY < 264 + 2 * gb.tileSize) {
                System.out.println("6");
            } else if (mouseX > 700 + 5 * gb.tileSize && mouseX < 700 + 6 * gb.tileSize && mouseY > 264 + gb.tileSize && mouseY < 264 + 2 * gb.tileSize) {
                System.out.println("7");
            } else if (mouseX > 700 + 7 * gb.tileSize && mouseX < 700 + 8 * gb.tileSize && mouseY > 264 + gb.tileSize && mouseY < 264 + 2 * gb.tileSize) {
                System.out.println("8");
            } else if (mouseX > 700 && mouseX < 700 + gb.tileSize && mouseY > 264 + 2 * gb.tileSize && mouseY < 264 + 3 * gb.tileSize) {
                System.out.println("9");
            } else if (mouseX > 700 + 2 * gb.tileSize && mouseX < 700 + 3 * gb.tileSize && mouseY > 264 + 2 * gb.tileSize && mouseY < 264 + 3 * gb.tileSize) {
                System.out.println("10");
            } else if (mouseX > 700+ 4 * gb.tileSize && mouseX  < 700 + 5 * gb.tileSize && mouseY > 264 + 2 * gb.tileSize && mouseY < 264 + 3 * gb.tileSize) {
                System.out.println("11");
            } else if (mouseX > 700 + gb.tileSize&& mouseX  < 700 + 2* gb.tileSize && mouseY > 264 + 3 * gb.tileSize && mouseY < 264 + 4 * gb.tileSize) {
                System.out.println("12");
            } else if (mouseX > 700 +3 * gb.tileSize&& mouseX  < 700 + 4* gb.tileSize && mouseY > 264 + 3 * gb.tileSize && mouseY < 264 + 4 * gb.tileSize) {
            System.out.println("13");
            } else if (mouseX > 700 + 5*gb.tileSize&& mouseX  < 700 + 6* gb.tileSize && mouseY > 264 + 3 * gb.tileSize && mouseY < 264 + 4 * gb.tileSize) {
                System.out.println("14");
            } else if (mouseX > 700 + 7*gb.tileSize&& mouseX  < 700 + 8* gb.tileSize && mouseY > 264 + 3 * gb.tileSize && mouseY < 264 + 4 * gb.tileSize) {
                System.out.println("15");
            } else if (mouseX > 700 + 0*gb.tileSize&& mouseX  < 700 + 1* gb.tileSize && mouseY > 264 + 4 * gb.tileSize && mouseY < 264 + 5 * gb.tileSize) {
                System.out.println("16");
            } else if (mouseX > 700 + 2*gb.tileSize&& mouseX  < 700 + 3* gb.tileSize && mouseY > 264 + 4 * gb.tileSize && mouseY < 264 + 5 * gb.tileSize) {
                System.out.println("17");
            }else if (mouseX > 700 + 4*gb.tileSize&& mouseX  < 700 + 5* gb.tileSize && mouseY > 264 + 4 * gb.tileSize && mouseY < 264 + 5 * gb.tileSize) {
                System.out.println("18");
            }else if (mouseX > 700 + 6*gb.tileSize&& mouseX  < 700 + 7* gb.tileSize && mouseY > 264 + 4 * gb.tileSize && mouseY < 264 + 5 * gb.tileSize) {
                System.out.println("19");
            }
        }



    }
    @Override
    public void mousePressed(MouseEvent e){
        if (e.getButton()== MouseEvent.BUTTON1){
            leftC = true;
            System.out.println("pressed");
        }
    }
    @Override
    public void mouseReleased(MouseEvent e){
        if (e.getButton()==MouseEvent.BUTTON1){
            leftC = false;
        }
    }




}
