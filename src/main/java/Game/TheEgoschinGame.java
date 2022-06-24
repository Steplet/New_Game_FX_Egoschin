package Game;

import Scenes.CreditsScenes;
import Scenes.GameScene;
import Scenes.MainScene;
import javafx.application.Application;
import javafx.stage.Stage;

public class TheEgoschinGame  extends Application {

    public static final int maxScenes = 2;
    public static final int gameScene = 0;
    public static final int creditsScene = 1;

    public static final MainScene[] scenes =
            new MainScene[maxScenes];

    public static Stage stage;

    @Override
    public void start(Stage stage) throws Exception {

        TheEgoschinGame.stage = stage;
        scenes[0] = new GameScene();
        scenes[1] = new CreditsScenes();

        stage.setTitle("The Egoschin Game");
        setScene(gameScene);
        stage.show();

    }

    public static void setScene(int numScene) {
        stage.setScene(scenes[numScene]);
        scenes[numScene].draw();
    }

    public static void exit(){
        stage.hide();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
