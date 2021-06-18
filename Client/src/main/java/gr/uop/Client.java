package gr.uop;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

import javafx.application.Application;

import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class Client extends Application {

    @Override
    public void start(Stage stage) {

        ArrayList<Washing> warray = new ArrayList<Washing>();

        new PrimaryStage(stage, warray);

        // Found how to have datetime and
        // LocalDate datetime = LocalDate.now();
        // String uniqueID = UUID.randomUUID().toString();
        // System.out.println("LD:" + datetime + " ID: " + uniqueID);

    }

    public static void main(String[] args) {
        launch(args);

    }

}
