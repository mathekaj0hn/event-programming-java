
package com.example;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TaskDemo extends Application {

    @Override
    public void start(Stage primaryStage) {

        Label statusLabel = new Label("Ready");
        Button startButton = new Button("Start Processing");

        startButton.setOnAction(e -> {

            Task<Void> task = new Task<Void>() {

                @Override
                protected Void call() throws Exception {

                    Thread.sleep(5000);

                    return null;
                }
            };

            statusLabel.setText("Processing...");
            startButton.setDisable(true);

            task.setOnSucceeded(event -> {
                statusLabel.setText("Done!");
                startButton.setDisable(false);
            });

            Thread thread = new Thread(task);
            thread.setDaemon(true);
            thread.start();
        });

        VBox root = new VBox(20, startButton, statusLabel);
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");

        Scene scene = new Scene(root, 400, 200);

        primaryStage.setTitle("JavaFX Task Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
