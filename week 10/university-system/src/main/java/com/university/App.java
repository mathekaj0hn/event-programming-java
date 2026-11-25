
package com.university;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App extends Application {

    private ScheduledExecutorService scheduler;

    @Override
    public void start(Stage stage) throws Exception {

        // Start background heartbeat every 5 seconds
        scheduler = Executors.newSingleThreadScheduledExecutor();

        scheduler.scheduleAtFixedRate(() -> {
            System.out.println("University System Heartbeat: "
                    + System.currentTimeMillis());
        }, 0, 5, TimeUnit.SECONDS);

        // Load the main dashboard
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/university/MainView.fxml")
        );

        Parent root = loader.load();

        // Create the application window
        Scene scene = new Scene(root, 800, 600);

        stage.setTitle("University Management System");
        stage.setScene(scene);
        stage.show();
    }

    // Stop background scheduler when application closes
    @Override
    public void stop() {

        if (scheduler != null) {
            scheduler.shutdown();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}



