
package com.example;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TaskStateDemo extends Application {

    @Override
    public void start(Stage primaryStage) {

        Label statusLabel = new Label("Ready");

        Button successButton = new Button("Successful Task");
        Button errorButton = new Button("Failed Task");

        successButton.setOnAction(e -> {

            Task<String> task = new Task<String>() {

                @Override
                protected String call() throws Exception {

                    Thread.sleep(3000);

                    return "Task completed successfully!";
                }
            };

            statusLabel.setText("Processing...");

            task.setOnSucceeded(event -> {
                statusLabel.setText(task.getValue());
            });

            task.setOnFailed(event -> {
                statusLabel.setText("Task failed!");
            });

            new Thread(task).start();
        });

        errorButton.setOnAction(e -> {

            Task<String> task = new Task<String>() {

                @Override
                protected String call() throws Exception {

                    Thread.sleep(2000);

                    throw new Exception("Something went wrong!");
                }
            };

            statusLabel.setText("Processing...");

            task.setOnSucceeded(event -> {
                statusLabel.setText(task.getValue());
            });

            task.setOnFailed(event -> {
                statusLabel.setText(
                    "Error: " + task.getException().getMessage()
                );
            });

            new Thread(task).start();
        });

        VBox root = new VBox(
            20,
            successButton,
            errorButton,
            statusLabel
        );

        root.setStyle("-fx-padding: 20; -fx-alignment: center;");

        Scene scene = new Scene(root, 450, 220);

        primaryStage.setTitle("JavaFX Task States");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


