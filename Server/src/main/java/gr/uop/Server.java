package gr.uop;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Optional;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class Server extends Application {

    @Override
    public void start(Stage stage) {
        // try (ServerSocket serverSocket = new ServerSocket(7777);
        //     Socket connectionSocket = serverSocket.accept();
        //     Scanner fromClient = new Scanner(connectionSocket.getInputStream());
        //     PrintWriter toClient = new PrintWriter(connectionSocket.getOutputStream(), true)) {
            
            Button logobtn = new Button();
            logobtn.setMaxSize(30, 30);
            logobtn.setMouseTransparent(true);
            logobtn.setBackground(new Background(new BackgroundFill(Color.web("#d5f4e6"), CornerRadii.EMPTY, Insets.EMPTY)));
            ImageView logoImageView = new ImageView(new Image(getClass().getResourceAsStream("images/car.png")));
            logobtn.setGraphic(logoImageView);
            var logoLabel = new Label("MobileP");
            logoLabel.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 50));
            HBox logoBox = new HBox(logobtn,logoLabel);
            logoBox.setSpacing(15);
            logoBox.setAlignment(Pos.TOP_LEFT);
            logoBox.setPadding(new Insets(20, 0, 0, 40));

            //εδω εβαλα ενδεικτηκα tableview για να δω το συνολο. Βαζουμε οτι πινακα βολευει
            TableView<String> table = new TableView<>();
            table.setMaxSize(900, 1300);

            Button cancel = new Button("Ακύρωση Οχήματος");
            cancel.setMinWidth(200);
            cancel.setMaxWidth(200);
            Button submit = new Button("Καταχώρηση Οχήματος");
            submit.setMinWidth(200);
            submit.setMaxWidth(200);
            StackPane bottomBtns = new StackPane(cancel,submit);
            bottomBtns.setPadding(new Insets(20, 50, 20, 50));
            StackPane.setAlignment(cancel, Pos.CENTER_LEFT);
            StackPane.setAlignment(submit, Pos.CENTER_RIGHT);


            VBox finalsp = new VBox(logoBox,table,bottomBtns);
            finalsp.setAlignment(Pos.CENTER);
            finalsp.setSpacing(40);
            //StackPane. 
            finalsp.setBackground(new Background(new BackgroundFill(Color.web("#d5f4e6"), CornerRadii.EMPTY, Insets.EMPTY)));

            var scene = new Scene(finalsp, 1024, 768);

            stage.setMinWidth(1024);
            stage.setMinHeight(768);
            stage.setMaxWidth(1920);
            stage.setMaxHeight(1080);

            stage.setScene(scene);
            stage.show();

            //Λειτουργίες κουμπιών
            Alert alert = new Alert(AlertType.NONE);
            EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    alert.setAlertType(AlertType.CONFIRMATION);
                    String contet = "Υπηρεσίες: \n";
                    alert.setContentText(contet);
                    alert.setHeaderText("Συνολικό κόστος: " + 1120 + "€");
                    alert.setTitle("Επιβεβαίωση Επιλογών");
                    //leitourgies gia kataxorisi
                    alert.showAndWait();
                }
            };
            submit.setOnAction(event);

        // } catch (IOException e) {
        //     System.out.println(e);
        // }

    }

    public static void main(String[] args) {
        launch(args);
    }

}
