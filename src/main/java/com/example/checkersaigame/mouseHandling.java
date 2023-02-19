package com.example.checkersaigame;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.util.Arrays;

public class mouseHandling implements MouseListener {
    public static int[][] maptoarrays = new int[8][8];
    public int pieceX;
    public int pieceY;
    boolean valid = false;
    public static double mouseX;
    public static double mouseY;
    public static int turnAdding = 1;
    public static int turn;
    public static int takes;
    public static int whiteTakes = 0;
    public static int greyTakes = 0;
    public static int newX;
    public static int newY;
    public static int king;
    public static int takesKing;

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
        //who turn it is white or grey
        if (turnAdding % 2 == 1) {
            turn = 2;
            takes = 3;
            king = 4;
            takesKing = 5;
        } else {
            turn = 3;
            takes = 2;
            king = 5;
            takesKing = 4;
        }
        mouseX = MouseInfo.getPointerInfo().getLocation().getX();
        mouseY = MouseInfo.getPointerInfo().getLocation().getY();

        try {
            Input.mousePos();
        } catch (Exception e) {
            System.out.println(e);
        }

        if (Input.posX == 999999999) {
            System.out.println("click on a valid space");
        } else {
            valid = true;
            //testing
            //System.out.println(maptoarrays[Input.posX - 1][Input.posY - 1]);
            //System.out.println(Input.posX);
            //System.out.println(Input.posY);
            //System.out.println(Arrays.deepToString(maptoarrays));

            //checking its clicking on the correct space
            if (maptoarrays[Input.posX - 1][Input.posY - 1] == takes) {
                System.out.println("not your turn");
                valid = false;
            }
            //saving selected mouse position to variable
            else if ((maptoarrays[Input.posX - 1][Input.posY - 1] == turn || maptoarrays[Input.posX - 1][Input.posY - 1] == king)) {
                pieceX = Input.posX - 1;
                pieceY = Input.posY - 1;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        //getting new position
        mouseX = MouseInfo.getPointerInfo().getLocation().getX();
        mouseY = MouseInfo.getPointerInfo().getLocation().getY();


        try {
            Input.mousePos();
        } catch (Exception e) {
            System.out.println(e);
        }
        //testing
        //System.out.println(maptoarrays[Input.posX - 1][Input.posY - 1]);
        //System.out.println(Input.posX);
        //System.out.println(Input.posY);
        newX = Input.posX - 1;
        newY = Input.posY - 1;
        //valid place location
        if (Input.posX != 999999999 || Input.posY != 999999999) {
            if (valid && maptoarrays[Input.posX - 1][Input.posY - 1] == 0 && Input.posX != 999999999 &&
                    //valid move diagonal
                    ((pieceX == newX - 1 && pieceY == Input.posY && (turn == 2 || maptoarrays[pieceX][pieceY] == king)) || (pieceX == newX + 1 && pieceY == Input.posY && (turn == 2 || maptoarrays[pieceX][pieceY] == king)) || (pieceX == newX + 1 && pieceY == Input.posY - 2 && (turn == 3 || maptoarrays[pieceX][pieceY] == king)) || (pieceX == newX - 1 && pieceY == Input.posY - 2 && (turn == 3 || maptoarrays[pieceX][pieceY] == king)))) {
                //king move back and forward
                if (maptoarrays[pieceX][pieceY] == king) {
                    maptoarrays[pieceX][pieceY] = 0;
                    maptoarrays[Input.posX - 1][Input.posY - 1] = king;
                } else {
                    maptoarrays[pieceX][pieceY] = 0;
                    maptoarrays[Input.posX - 1][Input.posY - 1] = turn;
                }

                System.out.println("");
                turnAdding++;


                //white+king taking diagonal left
            } else if (valid && maptoarrays[Input.posX - 1][Input.posY - 1] == 0 && Input.posX != 999999999
                    && ((pieceX == newX - 2 && pieceY == newY + 2 && (maptoarrays[newX - 1][newY + 1] == takes || maptoarrays[newX - 1][newY + 1] == takesKing) && (turn == 2 || maptoarrays[pieceX][pieceY] == king))
            )) {
                //changing board
                //check if king
                if (maptoarrays[pieceX][pieceY] == king) {
                    maptoarrays[pieceX][pieceY] = 0;
                    maptoarrays[newX][newY] = king;
                    maptoarrays[newX - 1][newY + 1] = 0;
                } else {
                    //if not king
                    maptoarrays[pieceX][pieceY] = 0;
                    maptoarrays[newX][newY] = turn;
                    maptoarrays[newX - 1][newY + 1] = 0;
                }
                //how many piece left
                if (turn == 2) {
                    whiteTakes++;
                } else if (turn == 3) {
                    greyTakes++;
                }
                turnAdding++;


                //white+king taking diagonal right
            } else if (valid && maptoarrays[Input.posX - 1][Input.posY - 1] == 0 && Input.posX != 999999999
                    && (pieceX == newX + 2 && pieceY == newY + 2 && (maptoarrays[newX + 1][newY + 1] == takes || maptoarrays[newX + 1][newY + 1] == takesKing) && (turn == 2 || maptoarrays[pieceX][pieceY] == king))
            ) {
                //changing on board
                //check if king
                if (maptoarrays[pieceX][pieceY] == king) {
                    maptoarrays[pieceX][pieceY] = 0;
                    maptoarrays[newX][newY] = king;
                    maptoarrays[newX + 1][newY + 1] = 0;
                } else {
                    //if not king
                    maptoarrays[pieceX][pieceY] = 0;
                    maptoarrays[newX][newY] = turn;
                    maptoarrays[newX + 1][newY + 1] = 0;
                }
                //how many pieces left
                if (turn == 2) {
                    whiteTakes++;
                } else if (turn == 3) {
                    greyTakes++;
                }
                turnAdding++;
                //grey+king taking left
            } else if (valid && maptoarrays[Input.posX - 1][Input.posY - 1] == 0 && Input.posX != 999999999
                    && (pieceX == newX + 2 && pieceY == newY - 2 && (maptoarrays[newX + 1][newY - 1] == takes || maptoarrays[newX + 1][newY - 1] == takesKing) && (turn == 3 || maptoarrays[pieceX][pieceY] == king))) {
                //check if king and keep the king
                if (maptoarrays[pieceX][pieceY] == king) {
                    maptoarrays[pieceX][pieceY] = 0;
                    maptoarrays[newX][newY] = king;
                    maptoarrays[newX + 1][newY - 1] = 0;
                } else {
                    //if not king
                    maptoarrays[pieceX][pieceY] = 0;
                    maptoarrays[newX][newY] = turn;
                    maptoarrays[newX + 1][newY - 1] = 0;
                }
                if (turn == 2) {
                    whiteTakes++;
                } else if (turn == 3) {
                    greyTakes++;
                }
                turnAdding++;
                //grey+king taking right
            } else if (valid && maptoarrays[Input.posX - 1][Input.posY - 1] == 0 && Input.posX != 999999999
                    && (pieceX == newX - 2 && pieceY == newY - 2 && (maptoarrays[newX - 1][newY - 1] == takes || (turn == 3 || maptoarrays[newX - 1][newY - 1] == takesKing) && maptoarrays[pieceX][pieceY] == king))) {
                if (maptoarrays[pieceX][pieceY] == king) {
                    //check if king
                    maptoarrays[pieceX][pieceY] = 0;
                    maptoarrays[newX][newY] = king;
                    maptoarrays[newX - 1][newY - 1] = 0;
                } else {
                    //if not king
                    maptoarrays[pieceX][pieceY] = 0;
                    maptoarrays[newX][newY] = turn;
                    maptoarrays[newX - 1][newY - 1] = 0;
                }
                if (turn == 2) {
                    whiteTakes++;
                } else if (turn == 3) {
                    greyTakes++;
                }
                turnAdding++;


            } else if (Input.posX == 999999999) {
                System.out.println("select a valid place");
            } else if (maptoarrays[Input.posX - 1][Input.posY - 1] != 0) {
                System.out.println("a piece is on that space");
            } else {
                System.out.println("select a valid place");
            }
            //see if king is made
            if (Input.posY - 1 == 0 && turn == 2) {
                maptoarrays[Input.posX - 1][Input.posY - 1] = king;
            } else if (Input.posY - 1 == 7 && turn == 3) {
                maptoarrays[Input.posX - 1][Input.posY - 1] = king;
            }
        }else{
            System.out.println("not valid");
        }
    }

    public void mapToArray() {
        try {
            //puts map text file into an array
            InputStream is = new FileInputStream("map/boardMap.txt");
            BufferedReader sr = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col < 8 && row < 8) {
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
            //test
            //System.out.println(Arrays.deepToString(maptoarrays));

        } catch (Exception e) {
            System.out.println(e);
        }
    }


}
