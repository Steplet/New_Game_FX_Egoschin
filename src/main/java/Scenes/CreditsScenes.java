package Scenes;

import Game.TheEgoschinGame;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class CreditsScenes extends MainScene {

    public CreditsScenes() {
        super();
    }

    private void showCreditsMessage(){

        Font font = Font.font("Arial", FontWeight.NORMAL, 24);
        gc.setFont(font);
        gc.setFill(Color.GHOSTWHITE);
        gc.fillText("Lose", 330, 150);
    }

    @Override
    public void draw() {
        activeKeys.clear();
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                gc.setFill(Color.BLACK);
                gc.fillRect(0, 0, gameWidth, gameHeight);

                showCreditsMessage();

                if (activeKeys.contains(KeyCode.ENTER)){
                    this.stop();
                    TheEgoschinGame.setScene(TheEgoschinGame.gameScene);

                }else if (activeKeys.contains(KeyCode.ESCAPE)){
                    this.stop();
                    TheEgoschinGame.exit();
                }

            }
        };
        timer.start();
    }
}
