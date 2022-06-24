package Sprites;

import Scenes.GameScene;
import Scenes.MainScene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class MainCharacter extends Sprite {

    public static final int characterWidth = 40;
    public static final int characterHeight = 40;

    private static final String imageSpritePath = "src/main/java/Images/Ira.jpg";
    public static boolean canJump;


    public MainCharacter() {
        super(characterWidth, characterHeight);
        try {


        spriteImage = new Image(Files.newInputStream(Paths.get(imageSpritePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        spriteX = 200;
        spriteY = 300;

        rectangle = new Rectangle(x, y, characterWidth, characterHeight);

    }

    public void moveX(int movement){
        boolean moveRight = movement > 0;
        for (int i = 0; i < Math.abs(movement); i++) {
            for (Platform plt : GameScene.platforms){
                if (rectangle.getBoundsInParent().intersects(plt.getRectangle().getBoundsInParent())){
                    if (moveRight){
                        if ( rectangle.getTranslateX() + 40 == plt.getRectangle().getTranslateX() ){
//                            moveTo(this.getX() - 1,this.getY());
                                rectangle.setTranslateX(rectangle.getTranslateX() - 1);
                            return;
                        }
                    }else if (rectangle.getTranslateX() - 60 == plt.getRectangle().getTranslateX()){
//                            moveTo(this.getX() + 1, this.getY());
                            rectangle.setTranslateX(rectangle.getTranslateX() - 1);
                            return;
                        }
                }
            }
            rectangle.setTranslateX(rectangle.getTranslateX() + (moveRight ? 1:-1));
        }

        }


    public void moveY(int movement){
        boolean moveDown = movement > 0;
        for (int i = 0; i < Math.abs(movement); i++) {
            for (Platform plt : GameScene.platforms){
                if (rectangle.getBoundsInParent().intersects(plt.getRectangle().getBoundsInParent())){
                    if (moveDown){
                        if ( rectangle.getTranslateY() + 40 == plt.getRectangle().getTranslateY() ){
//                            moveTo(this.getX(),this.getY() - 1);
                            rectangle.setTranslateY(rectangle.getTranslateY() - 1);
                            canJump = true;
                            return;
                        }
                    }else {
                        if (rectangle.getTranslateY() - 60 == plt.getRectangle().getTranslateY()){
                            return;

                        }
                    }
                }
            }
            rectangle.setTranslateY(rectangle.getTranslateY() + (moveDown ? 1:-1));
        }

    }

    public void jumpPlayer(){
        if (canJump){
            GameScene.playerVelocity =GameScene.playerVelocity.add(0, -30);
            canJump = false;
        }
    }



}

