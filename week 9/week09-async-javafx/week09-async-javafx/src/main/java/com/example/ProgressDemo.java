
package com.example;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ProgressDemo extends Application {

    @Override
    public void start(Stage primaryStage) {

        Label statusLabel = new Label("Ready");

        ProgressBar progressBar = new ProgressBar(0);

        Button startButton = new Button("Start Task");

        startButton.setOnAction(e -> {

            Task<Void> task = new Task<Void>() {

                @Override
                protected Void call() throws Exception {

                    for (int i = 1; i <= 10; i++) {

                        Thread.sleep(500);

                        updateProgress(i, 10);

                        updateMessage("Processing " + (i * 10) + "%");
                    }

                    return null;
                }
            };

            progressBar.progressProperty().bind(task.progressProperty());

            statusLabel.textProperty().bind(task.messageProperty());

            startButton.setDisable(true);

            task.setOnSucceeded(event -> {
                statusLabel.textProperty().unbind();
                statusLabel.setText("Completed!");
                startButton.setDisable(false);
            });

            Thread thread = new Thread(task);
            thread.setDaemon(true);
            thread.start();
        });

        VBox root = new VBox(20, startButton, progressBar, statusLabel);

        root.setStyle("-fx-padding: 20; -fx-alignment: center;");

        Scene scene = new Scene(root, 400, 200);

        primaryStage.setTitle("JavaFX Progress Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

