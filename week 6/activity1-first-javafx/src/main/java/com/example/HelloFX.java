package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HelloFX extends Application {

    @Override
    public void start(Stage stage) {

        // Heading
        Label heading = new Label("WELCOME TO JAVAFX");

        heading.setFont(Font.font("Arial", 24));

        // Welcome message
        Label message = new Label(
                "This is my first JavaFX application."
        );

        message.setFont(Font.font("Arial", 16));

        // Button
        Button button = new Button("Click Me");

        button.setFont(Font.font("Arial", 14));

        // Button event
        button.setOnAction(event -> {
            message.setText(
                    "Congratulations! Your JavaFX button works."
            );
        });

        // Layout
        VBox root = new VBox(20);

        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(30));

        root.getChildren().addAll(
                heading,
                message,
                button
        );

        // Scene
        Scene scene = new Scene(root, 500, 350);

        // Stage
        stage.setTitle("My First JavaFX Application");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
