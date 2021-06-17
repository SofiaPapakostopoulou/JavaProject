package gr.uop;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Optional;
import java.util.Scanner;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
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

    Writer writer = null;
    File file = new File("MobileP.csv");
    

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
            TableColumn<String, String> tableColumn = new TableColumn<>("Name");

            tableColumn.setCellValueFactory(param -> new ReadOnlyStringWrapper(param.getValue()));

            table.getColumns().add(tableColumn);
            ObservableList<String> items = FXCollections.observableArrayList("Itachi");
            table.setItems(items);
            table.setMaxSize(900, 1300);
            //table.setItems(value);
            table.getItems().add("lel");
            table.getItems().add("lal");

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
                    //alert.showAndWait();
                    Optional<ButtonType> result = alert.showAndWait();

                    if (result.get() == ButtonType.OK) {
                        try {
                            writeExcel(table.getSelectionModel().getSelectedItem());
                            System.out.println(table.getSelectionModel().getSelectedItem());
                        }
                        catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                    // if (result.get() == ButtonType.OK) {
                    //     final Button export = new Button("Export to Excel");
                    //     export.setOnAction(new EventHandler<ActionEvent>() {

                    //         @Override
                    //         public void handle(ActionEvent e)  {
                    //             try {
                    //                 writeExcel(table.getSelectionModel().getSelectedItem());
                    //             }
                    //             catch (Exception ex) {
                    //                 ex.printStackTrace();
                    //             }
                    //         }
                    //     });
                    // }
                }
            };
            submit.setOnAction(event);
            // table.setOnMouseReleased(new EventHandler<ActionEvent>() {

            //     @Override
            //     public void handle(ActionEvent e)  {
            //         try {
            //             writeExcel(table.getSelectionModel().getSelectedItem());
            //         }
            //         catch (Exception ex) {
            //             ex.printStackTrace();
            //         }
            //     }
            // });

        // } catch (IOException e) {
        //     System.out.println(e);
        // }

    }

    public static void main(String[] args) {
        launch(args);
    }

    public void writeExcel(String text) throws Exception {
        
        try {
            writer = new FileWriter(file);
            // for (String person : table) {

            //     String text = person.getFirstName() + "," + person.getLastName() + "," + person.getEmail() + "\n";

            //     writer.write(text);
            // }
            writer.write(text);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {

            writer.flush();
             writer.close();
        }
    }

}
