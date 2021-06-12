package gr.uop;

import java.util.Iterator;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * JavaFX App
 */
public class Client extends Application {

    private PopupWindow keyboard;

    @Override
    public void start(Stage stage) {

        var label = new Label("Καλωσήρθατε στο κατάστημα μας!");
        label.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 50));
        label.setStyle("-fx-background-color: grey;padding: 20px;");
        var label_plate = new Label("Παρακαλώ εισάγετε τον αριθμό της πινακίδας σας");
        TextField plate = new TextField();
        plate.setMinWidth(100);

        VBox vb = new VBox(label, label_plate, plate);
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(20);

        HBox keyboard = new HBox();

        GridPane gridLetters = new GridPane();
        gridLetters.setPadding(new Insets(5));
        gridLetters.setHgap(5);
        gridLetters.setVgap(5);
        int letbutton = 65;
        for (int r = 0; r < 2; r++) {
            for (int c = 0; c < 10; c++) {
                Button button = new Button(" " + (char) letbutton);
                letbutton++;
                gridLetters.add(button, c, r);
            }

            if (r == 0) {
                Button backspace = new Button("Backspace");
                gridLetters.add(backspace, 11, 0);
            }

        }

        for (int c = 0; c < 6; c++) {
            Button button = new Button(" " + (char) letbutton);
            letbutton++;
            gridLetters.add(button, c, 2);
        }
        Button space = new Button(" ");
        space.setMaxWidth(1200);
        gridLetters.add(space, 6, 2);
        VBox numbers = new VBox();
        GridPane gridNumber = new GridPane();
        gridNumber.setPadding(new Insets(5));
        gridNumber.setHgap(5);
        gridNumber.setVgap(5);
        // μηδεν ??!?!? :/
        int numbutton = 9;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                Button button = new Button(" " + numbutton);
                numbutton--;
                gridNumber.add(button, c, r);
            }
        }
        Button button0 = new Button("0");
        button0.setMinWidth(50);
        button0.setAlignment(Pos.BASELINE_CENTER);
        numbers.getChildren().addAll(gridNumber, button0);
        keyboard.getChildren().addAll(gridLetters, numbers);
        // BorderPane mainPane = new BorderPane();
        // mainPane.setTop(vb);
        // mainPane.setCenter(keyboard);
        // mainPane.setPadding(new Insets(0, 0, 10, 0));
        // var scene = new Scene(mainPane, 640, 480);
        keyboard.setAlignment(Pos.CENTER);
        vb.getChildren().addAll(keyboard);
        var scene = new Scene(new StackPane(vb), 640, 480);

        stage.setMinWidth(1024);
        stage.setMinHeight(768);
        stage.setMaxWidth(1920);
        stage.setMaxHeight(1080);

        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
