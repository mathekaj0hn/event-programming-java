
package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class LayoutDemo extends Application {

    @Override
    public void start(Stage stage) {

        // Create tabbed pane
        TabPane tabPane = new TabPane();

        // TAB 1: VBox
        VBox vbox = new VBox(15);

        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(30));

        Label vboxTitle = new Label("VBox Layout");
        Label vboxDescription = new Label(
                "VBox arranges components vertically."
        );

        Button vboxButton1 = new Button("Button One");
        Button vboxButton2 = new Button("Button Two");
        Button vboxButton3 = new Button("Button Three");

        vbox.getChildren().addAll(
                vboxTitle,
                vboxDescription,
                vboxButton1,
                vboxButton2,
                vboxButton3
        );

        Tab vboxTab = new Tab("VBox", vbox);
        vboxTab.setClosable(false);

        // TAB 2: HBox
        HBox hbox = new HBox(15);

        hbox.setAlignment(Pos.CENTER);
        hbox.setPadding(new Insets(30));

        Label hboxTitle = new Label("HBox Layout");

        Button hboxButton1 = new Button("Save");
        Button hboxButton2 = new Button("Edit");
        Button hboxButton3 = new Button("Delete");

        hbox.getChildren().addAll(
                hboxTitle,
                hboxButton1,
                hboxButton2,
                hboxButton3
        );

        Tab hboxTab = new Tab("HBox", hbox);
        hboxTab.setClosable(false);

        // TAB 3: GridPane
        GridPane grid = new GridPane();

        grid.setAlignment(Pos.CENTER);
        grid.setHgap(15);
        grid.setVgap(15);
        grid.setPadding(new Insets(30));

        Label gridTitle = new Label("Student Registration");

        TextField nameField = new TextField();
        nameField.setPromptText("Enter full name");

        TextField emailField = new TextField();
        emailField.setPromptText("Enter email");

        TextField regField = new TextField();
        regField.setPromptText("Enter registration number");

        Button registerButton = new Button("Register");

        grid.add(gridTitle, 0, 0, 2, 1);

        grid.add(new Label("Full Name:"), 0, 1);
        grid.add(nameField, 1, 1);

        grid.add(new Label("Email:"), 0, 2);
        grid.add(emailField, 1, 2);

        grid.add(new Label("Registration Number:"), 0, 3);
        grid.add(regField, 1, 3);

        grid.add(registerButton, 1, 4);

        registerButton.setOnAction(event -> {

            if (nameField.getText().trim().isEmpty()
                    || emailField.getText().trim().isEmpty()
                    || regField.getText().trim().isEmpty()) {

                showAlert(
                        "Validation Error",
                        "Please fill in all registration fields."
                );

            } else {

                showAlert(
                        "Registration Successful",
                        "Welcome, " + nameField.getText() + "!"
                );

                nameField.clear();
                emailField.clear();
                regField.clear();
            }
        });

        Tab gridTab = new Tab("GridPane", grid);
        gridTab.setClosable(false);

        // TAB 4: BorderPane
        BorderPane border = new BorderPane();

        Label top = new Label("TOP REGION");
        top.setAlignment(Pos.CENTER);
        top.setMaxWidth(Double.MAX_VALUE);
        top.setPadding(new Insets(20));
        top.setStyle("-fx-background-color: lightblue;");

        Label left = new Label("LEFT");
        left.setPadding(new Insets(20));
        left.setStyle("-fx-background-color: lightyellow;");

        Label center = new Label("CENTER REGION");
        center.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        center.setAlignment(Pos.CENTER);
        center.setStyle("-fx-background-color: lightgreen;");

        Label right = new Label("RIGHT");
        right.setPadding(new Insets(20));
        right.setStyle("-fx-background-color: lightpink;");

        Label bottom = new Label("BOTTOM REGION");
        bottom.setAlignment(Pos.CENTER);
        bottom.setMaxWidth(Double.MAX_VALUE);
        bottom.setPadding(new Insets(20));
        bottom.setStyle("-fx-background-color: lightgray;");

        border.setTop(top);
        border.setLeft(left);
        border.setCenter(center);
        border.setRight(right);
        border.setBottom(bottom);

        Tab borderTab = new Tab("BorderPane", border);
        borderTab.setClosable(false);

        // TAB 5: FlowPane
        FlowPane flow = new FlowPane();

        flow.setAlignment(Pos.CENTER);
        flow.setHgap(15);
        flow.setVgap(15);
        flow.setPadding(new Insets(30));

        Label flowTitle = new Label("FlowPane Layout");

        for (int i = 1; i <= 12; i++) {
            Button button = new Button("Button " + i);
            flow.getChildren().add(button);
        }

        flow.getChildren().add(0, flowTitle);

        Tab flowTab = new Tab("FlowPane", flow);
        flowTab.setClosable(false);

        // Add tabs
        tabPane.getTabs().addAll(
                vboxTab,
                hboxTab,
                gridTab,
                borderTab,
                flowTab
        );

        // Main layout
        BorderPane root = new BorderPane();

        Label heading = new Label("JAVAFX LAYOUT MANAGERS");

        heading.setStyle(
                "-fx-font-size: 22px; -fx-font-weight: bold;"
        );

        heading.setAlignment(Pos.CENTER);
        heading.setMaxWidth(Double.MAX_VALUE);
        heading.setPadding(new Insets(20));

        root.setTop(heading);
        root.setCenter(tabPane);

        Scene scene = new Scene(root, 750, 500);

        stage.setTitle("JavaFX Layout Managers");
        stage.setScene(scene);
        stage.show();
    }

    private void showAlert(String title, String message) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}