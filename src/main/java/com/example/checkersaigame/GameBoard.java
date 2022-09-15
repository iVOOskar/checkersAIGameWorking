package com.example.checkersaigame;
import javax.swing.*;
import java.awt.*;

public class GameBoard {
    public static class Board
    {
        private JFrame frame = new JFrame();
        private JPanel backBoard = new JPanel();

        Board()
        {

            frame.setSize(905,905);
            backBoard.setSize(900,900);
            frame.setTitle("Checkers");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            backBoard.setVisible(true);


            boardSquare bs;
            String type = null;
            //Filling in Red Side
            for (int i = 0; i <=1; i++)
            {
                for(int j = 0; j < 9; j++)
                {
                    if(j % 2 == 0)
                    {
                        type = "Red";
                    }
                    else
                    {
                        type = "Blank";
                    }

                    bs = new boardSquare(100*j,100*i,type);
                    backBoard.add(bs);

                }

            }
            //Filling in empty middle
            type = "Blank";
            for (int i = 2; i < 7; i++)
            {
                for(int j = 0; j < 9; j++)
                {

                    bs = new boardSquare(100*j,100*i,type);
                    backBoard.add(bs);

                }

            }

            //Filling in Black side
            for (int i = 7; i < 9; i++)
            {
                for(int j = 0; j < 9; j++)
                {
                    if(j % 2 != 0)
                    {
                        type = "Black";
                    }
                    else
                    {
                        type = "Blank";
                    }

                    bs = new boardSquare(100*j,100*i,type);
                    backBoard.add(bs);

                }

            }

            backBoard.repaint();
            frame.add(backBoard);
            frame.repaint();


        }

        private class boardSquare extends JComponent
        {
            private int x; //x position of the rectangle measured from top left corner
            private int y; //y position of the rectangle measured from top left corner

            private boolean isBlack = false;
            private boolean isRed = false;

            public boardSquare(int p, int q, String type)
            {
                x = p;
                y = q;
                if (type.equals("Black"))
                {
                    isBlack = true;
                    isRed = false;
                }
                else if (type.equals("Red"))
                {
                    isRed = true;
                    isBlack = false;
                }
                else if (type.equals("Blank"))
                {
                    isBlack = false;
                    isRed = false;
                }

            }
            public void paintComponent(Graphics g)
            {
                Graphics2D g2 = (Graphics2D) g;
                Rectangle box = new Rectangle(x,y,100,100);
                g2.draw(box);
                g2.setPaint(Color.BLUE);
                g2.fill(box);

                if(isBlack)
                {
                    g2.fillOval(x, y,100 ,100 );
                    g2.setColor(Color.black);
                    g2.drawOval(x, y, 100, 100);
                }

                else if(isRed)
                {
                    g2.fillOval(x, y,100 ,100 );
                    g2.setColor(Color.red);
                    g2.drawOval(x, y, 100, 100);
                }

            }
        }


    }
    public static void createBoard(){
        Board game = new Board();
    }


}
