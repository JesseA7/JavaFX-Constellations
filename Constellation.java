import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.swing.*;
import java.util.Random;

/**
 * Create a star field and prompt the user for an amount of stars to display to form a constellation
 * January 18, 2023
 *
 * @author Jesse Atkinson
 */
public class Constellation extends Application {
    /**
     * Start method
     * @param stage The FX stage to draw on
     */
    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root);
        Canvas canvas = new Canvas(600, 600); // Set canvas size
        stage.setTitle("A1 - Constellation"); // Set window title
        root.getChildren().add(canvas);
        stage.setScene(scene);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        // *** Input, Ask the user the number of stars they want to display
        int num = Integer.parseInt(JOptionPane.showInputDialog("Create a constellation: Enter the number of stars:"));
        // Create an array to store the stars' coordinates
        double[][] stars = new double[num][2];
        // Loop the number of stars
        for (int i = 0; i < num; i++) {
            // *** Input, prompt for the X and Y coordinates
            int starX = Integer.parseInt(JOptionPane.showInputDialog("Enter an X coordinate between 0-600: "));
            int starY = Integer.parseInt(JOptionPane.showInputDialog("Enter a Y coordinate between 0-600: "));
            // Determine if the entered X and Y coordinates are within the bounds of the canvas
            if (starX >= 600 || starY >= 600) {
                JOptionPane.showMessageDialog(null, "Invalid Coordinates");
            } else {
                // Display the star on the canvas
                gc.setFill(Color.YELLOW);
                gc.fillOval(starX - 2.5, starY - 2.5, 5, 5);
                // Store the X and Y coordinates in the stars array
                stars[i][0] = starX;
                stars[i][1] = starY;
            }
        }
        // *** Input, ask for the title of the program and display it
        String title = JOptionPane.showInputDialog("Enter the title of your constellation:");
        gc.setFill(Color.YELLOW);
        gc.fillText(title, 15, 15);
        gc.fillText("Program by: Jesse Atkinson", 15, 30);
        gc.setStroke(Color.YELLOW);
        // Draw the lines to form the constellation
        for (int i = 0; i < num - 1; i++) {
            gc.strokeLine(stars[i][0], stars[i][1], stars[i + 1][0], stars[i + 1][1]);
        }
        gc.strokeLine(stars[num - 1][0], stars[num - 1][1], stars[0][0], stars[0][1]);

        Random rand = new Random();
        // Initialize min and max value of stars
        final int MAX = 200;
        int randomValue = (int) (Math.random() * MAX);
        // Loop through the amount of stars and generate them
        for (int i = 0; i <= randomValue; i++) {
            // Generate random X and Y coordinates for each star
            int starX = rand.nextInt(600);
            int starY = rand.nextInt(600);
            // Generate random size for each star
            int starWidth = rand.nextInt(5);
            int starHeight = rand.nextInt(5);
            // Display the stars
            gc.setFill(Color.WHITE);
            gc.fillOval(starX, starY, starWidth, starHeight);
        }
        scene.setFill(Color.BLACK);
        stage.show();
    }
    /**
     * The actual main method that launches the app.
     * @param args unused
     */
    public static void main(String[] args) {
        launch(args);
    }
}
