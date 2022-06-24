package Scenes;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;

import javax.swing.*;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public abstract class  MainScene extends Scene {

    public static final int gameWidth = 720;
    public static final int gameHeight = 300;
    protected final StackPane root;
    protected GraphicsContext gc;
    protected Set<KeyCode> activeKeys;
    protected Set<KeyCode> releasedKeys;

    public MainScene() {
        super(new StackPane(), gameWidth, gameHeight );

        root = new StackPane();
        this.setRoot(root);

        Canvas canvas = new Canvas(gameWidth, gameHeight);
        root.getChildren().addAll(canvas);
        gc = canvas.getGraphicsContext2D();

        activeKeys = new HashSet<>();
        releasedKeys = new HashSet<>();
        this.setOnKeyPressed(e -> {
            activeKeys.add(e.getCode());
        });
        this.setOnKeyReleased(e -> {
            activeKeys.remove(e.getCode());
            releasedKeys.add(e.getCode());
        });
    }

    public abstract void draw();
}
