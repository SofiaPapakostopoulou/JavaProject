package gr.uop;

import java.net.Socket;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class Server extends Application {

    @Override
    public void start(Stage stage) {
        try{
            Socket calcSocket = new Socket("localhost", 8001);
            System.out.println("Just connected to " + calcSocket.getRemoteSocketAddress());

            var label = new Label("Hello, JavaFX Server");
            var scene = new Scene(new StackPane(label), 640, 480);
            stage.setScene(scene);
            stage.show();
        }catch(Exception e){e.printStackTrace();}
        //calcSocket.close();
        //OIS.close();
         
        
    }

    public static void main(String[] args) {
        launch(args);
    }

}
