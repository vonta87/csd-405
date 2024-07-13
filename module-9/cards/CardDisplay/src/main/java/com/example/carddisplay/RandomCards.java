/* Javonta Young
 *July 7, 2024
 * CSD405-J318 Intermediate Java Programming
 *
 * Module 8 Programming Assignment
 * Write a program that displays four images randomly selected from a deck of 52 cards.
 * The attached zip file has card files titled 1.png, 2.png, 3.png, 4.png, …, 52.png.
 * For this application:
 * 1. Store the images in a “cards” subdirectory.
 * 2. Using these cards, randomly select four cards for display.
 * 3.You may use a different set of images you either have or decide to make.
 *
 */
package com.example.carddisplay;


// All the imports required
import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
// Normal Java imports
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomCards extends Application {

    // Constants
    private static final int IMAGE_COUNT = 4;
    // Folder locations need to be changed to where your files are
    private static final String CARDS_FOLDER
            = "/Users/javontayoung/csd/csd-405/module-9/cards/CardDisplay/src/main/resources/cards/";
    private static final String INITIAL_IMAGE_PATH
            = "file:/Users/javontayoung/csd/csd-405/module-9/cards/CardDisplay/src/main/resources/cards/b1fh.png";
    private final List<ImageView> imageViews = new ArrayList<>();

    // Main
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        root.setPadding(new Insets(10));
        root.setSpacing(10);
        root.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));

        HBox imageBox = new HBox();
        imageBox.setSpacing(10);

        // Loop for loading the card images
        for (int i = 0; i < IMAGE_COUNT; i++) {
            ImageView imageView = new ImageView();
            imageView.setFitWidth(100);
            imageView.setFitHeight(200);
            imageView.setImage(new Image(INITIAL_IMAGE_PATH)); // Set initial image
            imageView.setOpacity(0); // Initially invisible
            imageViews.add(imageView);
            imageBox.getChildren().add(imageView);

            // Initial slide animation.
            TranslateTransition transition = new TranslateTransition(Duration.seconds(1), imageView);
            transition.setFromX(-200);
            transition.setToX(0);
            transition.setDelay(Duration.seconds(i * 0.2));

            // Fade transition to make cards appear smoothly.
            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), imageView);
            fadeTransition.setFromValue(0);
            fadeTransition.setToValue(1);
            fadeTransition.setDelay(Duration.seconds(i * 0.2));

            // Run the two animation sequences.
            SequentialTransition sequentialTransition = new SequentialTransition(transition, fadeTransition);
            sequentialTransition.play();
        }
        //Create a button to press
        Button changeImagesButton = new Button("Deal Cards");
        changeImagesButton.setOnAction(event -> changeImages());
        // Add the button to the root window
        root.getChildren().addAll(imageBox, changeImagesButton);

        // Create the Scene and display it
        Scene scene = new Scene(root, 660, 250);
        primaryStage.setTitle("RandomCards");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method to randomize and display new cards
    private void changeImages() {
        File folder = new File(CARDS_FOLDER);
        File[] files = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".png"));

        if (files != null && files.length >= IMAGE_COUNT) {
            Random random = new Random();
            List<File> filelist = new ArrayList<>(Arrays.asList(files));
            for (ImageView imageView : imageViews) {
                imageView.setOpacity(0); // Initially invisible
                int randomIndex = random.nextInt(filelist.size());
                File randomFile = filelist.remove(randomIndex);
                imageView.setImage(new Image(randomFile.toURI().toString()));

                // Fade transition to make cards appear smoothly could break this out into a method
                // to be used by both initial and the change image, but that's a TODO
                FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), imageView);
                fadeTransition.setFromValue(0);
                fadeTransition.setToValue(1);
                fadeTransition.setDelay(Duration.seconds(0.2));
                fadeTransition.play();
            }
        } else {
            // just in case we can't reach resource assets
            System.out.println("Not enough images in the cards folder!");
        }
    }
}