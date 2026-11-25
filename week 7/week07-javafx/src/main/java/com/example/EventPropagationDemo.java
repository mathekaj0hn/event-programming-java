
package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

public class EventPropagationDemo extends Application {

    @Override
    public void start(Stage primaryStage) {

        Label logLabel = new Label("Click the button...");
        Button btn = new Button("Click Me!");

        VBox root = new VBox(20, logLabel, btn);
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");

        // EVENT FILTER
        root.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
            System.out.println("1. [FILTER] Root intercepted the click!");
        });

        // EVENT HANDLER ON ROOT
        root.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            System.out.println("3. [HANDLER] Root saw the click bubbling up!");
        });

        // EVENT HANDLER ON BUTTON
        btn.setOnMouseClicked(e -> {
            System.out.println("2. [HANDLER] Button was clicked!");
            logLabel.setText("Button was clicked!");
        });

        Scene scene = new Scene(root, 400, 300);

        primaryStage.setTitle("Event Propagation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

