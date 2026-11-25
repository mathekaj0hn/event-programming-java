
package programmaticdemo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        Label title = new Label("Welcome to JavaFX!");

        Button button = new Button("Click Me");

        button.setOnAction(e ->
            title.setText("Button Clicked Successfully!")
        );

        VBox layout = new VBox(15);
        layout.getChildren().addAll(title, button);

        Scene scene = new Scene(layout, 400, 250);

        primaryStage.setTitle("Week 6 JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
