package gr.uop;

import java.util.ArrayList;

import javafx.application.Application;

import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class Client extends Application {

    @Override
    public void start(Stage stage) {

        new PrimaryStage(stage);

    }

    public static void main(String[] args) {
        launch(args);

    }

}
