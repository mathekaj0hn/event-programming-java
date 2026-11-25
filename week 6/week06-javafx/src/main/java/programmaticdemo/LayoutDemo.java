
package programmaticdemo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class LayoutDemo extends Application {

    @Override
    public void start(Stage stage) {

        // HBox: Horizontal layout
        HBox hbox = new HBox(10);
        hbox.getChildren().addAll(
            new Button("One"),
            new Button("Two"),
            new Button("Three")
        );

        // VBox: Vertical layout
        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(
            new Button("Home"),
            new Button("About"),
            new Button("Contact")
        );

        // GridPane: Rows and columns
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.add(new Button("A"), 0, 0);
        grid.add(new Button("B"), 1, 0);
        grid.add(new Button("C"), 0, 1);
        grid.add(new Button("D"), 1, 1);

        // BorderPane: Five regions
        BorderPane border = new BorderPane();
        border.setTop(new Button("Top"));
        border.setBottom(new Button("Bottom"));
        border.setLeft(new Button("Left"));
        border.setRight(new Button("Right"));
        border.setCenter(new Button("Center"));

        VBox mainLayout = new VBox(20, hbox, vbox, grid, border);

        Scene scene = new Scene(mainLayout, 500, 450);

        stage.setTitle("JavaFX Layout Demonstrations");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

