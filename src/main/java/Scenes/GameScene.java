package Scenes;

import Game.TheEgoschinGame;
import Levels.LevelData;
import Sprites.MainCharacter;
import Sprites.Platform;
import Sprites.Sprite;
import javafx.animation.AnimationTimer;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


public class GameScene extends MainScene{

    private static final String BG_image = "src/main/java/Images/ГК.jpg";
    private Image background;
    private MainCharacter player;
    private Platform platform;
    public static final ArrayList<Platform> platforms = new ArrayList<>();
    public static Point2D playerVelocity = new Point2D(0,0);



    public GameScene() {
        super();
        try {
            background = new Image(Files.newInputStream(Paths.get(BG_image)));
            player = new MainCharacter();
            platform = new Platform();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void draw() {
        activeKeys.clear();
        player.moveTo(200, 100);
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                gc.setFill(Color.BLACK);
                gc.fillRect(0, 0, gameWidth, gameHeight);

                gc.drawImage(background, 0 ,0);
                for (int i = 0; i < LevelData.level.length;i++){
                    String line = LevelData.level[i];
                    for (int j =0; j < line.length();j++){
                        switch (line.charAt(j)){
                            case '0':
                                break;
                            case '1':
                                platform.moveTo(j*60, i*60+60);
                                platform.draw(gc);
                                platforms.add(platform);



                        }
                    }
                }
                player.draw(gc);
//                gc.fillRect(player.getX(), player.getY(), MainCharacter.characterWidth, MainCharacter.characterHeight);




                if (activeKeys.contains(KeyCode.ENTER)){
                    this.stop();
                    TheEgoschinGame.setScene(TheEgoschinGame.creditsScene);

                }else if (activeKeys.contains(KeyCode.ESCAPE)){
                    this.stop();
                    TheEgoschinGame.exit();

                } if (activeKeys.contains(KeyCode.A) && player.getX() >= 5){
                    player.moveX(-5);
                } if (activeKeys.contains(KeyCode.D) && player.getX() + 40 <= gameWidth - 5){
                    player.moveX(5);
                } if (activeKeys.contains(KeyCode.SPACE)&& player.getY() >= 5){
                    player.moveY(5);
                }




            }
        };
        timer.start();




    }
}
