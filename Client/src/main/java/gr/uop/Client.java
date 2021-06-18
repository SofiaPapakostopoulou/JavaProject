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
        // launch(args);

        try (Socket clientSocket = new Socket("localhost", 7777);
                PrintWriter toServer = new PrintWriter(clientSocket.getOutputStream(), true);
                Scanner fromServer = new Scanner(clientSocket.getInputStream())) {

            WashingCar wc = new WashingCar("DJJ 9923", 44);
            // while (key.hasNextLine()) {
            String plate = wc.getPlate();
            toServer.println(plate);

            // toServer.flush();

            String response = fromServer.nextLine();
            System.out.println("Response: " + response);
            String cost = String.valueOf(wc.getCost());
            toServer.println(cost);
            String response2 = fromServer.nextLine();
            System.out.println("Response: " + response2);
            // }

        } catch (IOException e) {
            System.out.println(e);
        }

    }

}
