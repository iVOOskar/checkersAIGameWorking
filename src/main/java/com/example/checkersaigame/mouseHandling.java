package com.example.checkersaigame;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.sql.SQLOutput;
import java.util.Arrays;

public class mouseHandling implements MouseListener {
    public static int[][] maptoarrays =  new int[8][8];
    public int pieceX;
    public int pieceY;
    boolean valid = false;
    public static double mouseX;
    public static double mouseY;
    public static int turnAdding = 1;
    public static int turn;

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
        if(turnAdding%2==1){
            turn = 2;
        }else{
            turn = 3;
        }
        mouseX = MouseInfo.getPointerInfo().getLocation().getX();
       mouseY = MouseInfo.getPointerInfo().getLocation().getY();
       try {
           Input.mousePos();
       }catch (Exception e){
           System.out.println(e);
       }
        if (Input.posX == 999999999) {
            System.out.println("click on a valid space");
        } else {
            valid = true;
            //System.out.println(maptoarrays[Input.posX-1][Input.posY-1]);
            //System.out.println(Input.posX);
            //System.out.println(Input.posY);
            //System.out.println(Arrays.deepToString(maptoarrays));
            if (maptoarrays[Input.posX-1][Input.posY-1]!= turn){
                System.out.println("not your turn");
                valid = false;
            } else if ( (maptoarrays[Input.posX-1][Input.posY-1] == turn) ) {
                    pieceX = Input.posX-1;
                    pieceY = Input.posY-1;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        mouseX = MouseInfo.getPointerInfo().getLocation().getX();
        mouseY = MouseInfo.getPointerInfo().getLocation().getY();
        try {
            Input.mousePos();
        }catch (Exception e){
            System.out.println(e);
        }
        if (valid == true && maptoarrays[Input.posX-1][Input.posY-1] == 0 && Input.posX != 999999999) {
            maptoarrays[pieceX][pieceY] = 0;
            maptoarrays[Input.posX-1][Input.posY-1] = turn;
            System.out.println("");
            turnAdding++;
        } else if(Input.posX == 999999999) {
            System.out.println("select a valid place");
        }
        else{
            System.out.println("select a valid place");
        }
    }

    public void mapToArray(){
        try{
        InputStream is = new FileInputStream("map/boardMap.txt");
        BufferedReader sr = new BufferedReader(new InputStreamReader(is));

        int col = 0;
        int row = 0;

        while(col < 8 && row < 8) {
            String line = sr.readLine();

            while (col < 8) {
                String numbers[] = line.split(" ");
                int num = Integer.parseInt(numbers[col]);
                maptoarrays[col][row] = num;
                col++;

            }
            if (col == 8) {
                col = 0;
                row++;
            }
        }

        sr.close();
        System.out.println(Arrays.deepToString(maptoarrays));

    }catch(Exception e) {
        System.out.println(e);
    }
}




}
