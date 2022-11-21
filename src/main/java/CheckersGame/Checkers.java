package CheckersGame;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Checkers extends Application {

    public static final int tileSize = 100;
    public static final int screenWidth = 8;
    public static final int screenHeight = 8;

    private Group tileGroup = new Group();
    private Group playerGroup = new Group();


    private Parent createContent(){
        Pane root = new Pane();
        root.setPrefSize(screenWidth  * tileSize,screenHeight*tileSize );
        root.getChildren().addAll(tileGroup,playerGroup);
        for (int i = 0; i < screenHeight; i++) {
            for (int j = 0; j < screenWidth; j++) {
                Tile tile = new Tile((j + i) % 2 == 0,j ,i);

                tileGroup.getChildren().add(tile.getPlayer());
            }
        }

        return root;
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            Scene scene = new Scene(createContent());
            primaryStage.setTitle("checkersGame");
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch( Exception e){
            System.out.println(e);
        }


    }
    public static void main(String[] args){ launch(args); }
}

