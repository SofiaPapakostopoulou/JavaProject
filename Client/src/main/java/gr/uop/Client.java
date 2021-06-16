package gr.uop;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

import javafx.application.Application;

import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class Client extends Application {

    @Override
    public void start(Stage stage) {

        /*
         * try (Socket clientSocket = new Socket("localhost", 7777); PrintWriter
         * toServer = new PrintWriter(clientSocket.getOutputStream(), true); Scanner
         * fromServer = new Scanner(clientSocket.getInputStream())) {
         * 
         * Scanner key = new Scanner(System.in); while (key.hasNextLine()) { String line
         * = key.nextLine(); toServer.println(line); // toServer.flush();
         * 
         * String response = fromServer.nextLine(); System.out.println("Response: " +
         * response); }
         */
        ArrayList<Washing> warray = new ArrayList<Washing>();

        new PrimaryStage(stage, warray);

        // Found how to have datetime and
        // LocalDate datetime = LocalDate.now();
        // String uniqueID = UUID.randomUUID().toString();
        // System.out.println("LD:" + datetime + " ID: " + uniqueID);
        /*
         * } catch (IOException e) { System.out.println(e); }
         */

    }

    public static void main(String[] args) {
        launch(args);

    }

}
