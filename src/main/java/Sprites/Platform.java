package Sprites;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Platform extends Sprite{
    private static final String imagePath = "src/main/java/Images/platform.png";
    public static int platformWidth = 60;
    public static int platformHeight = 60;


    public Platform() {
        super(platformWidth, platformHeight);
    try {

        spriteImage = new Image(Files.newInputStream(Paths.get(imagePath)));
    } catch (IOException e) {
        e.printStackTrace();
    }
    spriteX = 0;
    spriteY = 0;
    rectangle = new Rectangle(x, y, platformWidth, platformHeight);

    }



}
