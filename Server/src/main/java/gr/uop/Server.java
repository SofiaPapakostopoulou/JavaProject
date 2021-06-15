package gr.uop;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class Server extends Application {

    @Override
    public void start(Stage stage) {
        try (ServerSocket serverSocket = new ServerSocket(7777);
             Socket connectionSocket = serverSocket.accept();
             Scanner fromClient = new Scanner(connectionSocket.getInputStream());
             PrintWriter toClient = new PrintWriter(connectionSocket.getOutputStream(), true)) {

            // do {
            //     String line = fromClient.nextLine();
            //     System.out.println("Received: " + line);

            //     toClient.println(line);
            // } while (fromClient.hasNextLine());
        }
        catch (IOException e) {
            System.out.println(e);
        }
        
    }

    public static void main(String[] args) {
        launch(args);
    }

}
