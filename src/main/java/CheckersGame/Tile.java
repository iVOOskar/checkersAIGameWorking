package CheckersGame;

import java.awt.*;

public class Tile extends Rectangle {
    private Player player;
     public boolean haPlayer() {
         return player != null;
     }
     public Player getPlayer(){
         return player;
     }
     public void setPlayer(Player player){
         this.player = player;
     }

    public Tile(boolean light,int x, int y){
        setSize(x * Checkers.tileSize, y * Checkers.tileSize);

        //setColor(light ? Color.lightGray : Color.green);

    }

}
