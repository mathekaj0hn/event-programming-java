
package com.university;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class MainController {

    @FXML
    private StackPane contentArea;

    @FXML
    public void showDashboard() {

        contentArea.getChildren().clear();

        javafx.scene.control.Label welcome =
                new javafx.scene.control.Label(
                        "Welcome to the University Management System");

        welcome.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        contentArea.getChildren().add(welcome);
    }

    @FXML
    public void showStudents() {

        try {

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(
                            "/com/university/StudentView.fxml"));

            Parent studentView = loader.load();

            contentArea.getChildren().clear();
            contentArea.getChildren().add(studentView);

        } catch (IOException e) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Loading Error");
            alert.setHeaderText("Could not load student management");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }
}

