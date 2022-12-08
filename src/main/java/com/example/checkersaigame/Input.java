package com.example.checkersaigame;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.TimeUnit;

public abstract class Input implements MouseListener {
    public boolean leftC;

    public void mousePos() throws InterruptedException{
        while (true) {
            TimeUnit.SECONDS.sleep(1 / 2);
            double mouseX = MouseInfo.getPointerInfo().getLocation().getX();
            double mouseY = MouseInfo.getPointerInfo().getLocation().getY();
            System.out.println("X:" + mouseX);
            System.out.println("Y:" + mouseY);

        }
    }
    @Override
    public void mousePressed(MouseEvent e){
        if (e.getButton()== MouseEvent.BUTTON1){
            leftC = true;
        }
    }
    @Override
    public void mouseReleased(MouseEvent e){
        if (e.getButton()==MouseEvent.BUTTON1){
            leftC = false;
        }
    }




}
