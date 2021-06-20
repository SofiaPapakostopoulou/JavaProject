package gr.uop;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javafx.application.Application;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
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
    TableView<Washing> table = new TableView<>();
    static ObservableList<Washing> data = FXCollections.observableArrayList();

    @Override
    public void start(Stage stage) {

        Button logobtn = new Button();
        logobtn.setMaxSize(30, 30);
        logobtn.setMouseTransparent(true);
        logobtn.setBackground(
                new Background(new BackgroundFill(Color.web("#d5f4e6"), CornerRadii.EMPTY, Insets.EMPTY)));
        ImageView logoImageView = new ImageView(new Image(getClass().getResourceAsStream("images/car.png")));
        logobtn.setGraphic(logoImageView);
        var logoLabel = new Label("MobileP");
        logoLabel.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 50));
        HBox logoBox = new HBox(logobtn, logoLabel);
        logoBox.setSpacing(15);
        logoBox.setAlignment(Pos.TOP_LEFT);
        logoBox.setPadding(new Insets(20, 0, 0, 40));

        table.setMaxWidth(900);
        TableColumn<Washing, String> tbc1 = new TableColumn<>("Αρ. Συναλλαγής");
        TableColumn<Washing, String> tbc2 = new TableColumn<>("Αρ. Κυκλοφορίας");
        TableColumn<Washing, ComboBox> tbc3 = new TableColumn<>("Υπηρεσίες");
        TableColumn<Washing, String> tbc4 = new TableColumn<>("Συνολικό Κόστος");
        TableColumn<Washing, String> tbc5 = new TableColumn<>("Όχημα");
        TableColumn<Washing, String> tbc6 = new TableColumn<>("Ώρα Άφιξης");

        tbc1.setCellValueFactory(new PropertyValueFactory<Washing, String>("uniqueID"));
        tbc2.setCellValueFactory(new PropertyValueFactory<Washing, String>("plate"));
        tbc3.setCellValueFactory(new PropertyValueFactory<Washing, ComboBox>("cb"));
        tbc4.setCellValueFactory(new PropertyValueFactory<Washing, String>("cost"));
        tbc5.setCellValueFactory(new PropertyValueFactory<Washing, String>("type"));
        tbc6.setCellValueFactory(new PropertyValueFactory<Washing, String>("time"));

        table.getColumns().add(tbc1);
        table.getColumns().add(tbc2);
        table.getColumns().add(tbc3);
        table.getColumns().add(tbc4);
        table.getColumns().add(tbc5);
        table.getColumns().add(tbc6);

        tbc1.prefWidthProperty().bind(table.widthProperty().divide(6));
        tbc2.prefWidthProperty().bind(table.widthProperty().divide(6));
        tbc3.prefWidthProperty().bind(table.widthProperty().divide(6));
        tbc4.prefWidthProperty().bind(table.widthProperty().divide(6));
        tbc5.prefWidthProperty().bind(table.widthProperty().divide(6));
        tbc6.prefWidthProperty().bind(table.widthProperty().divide(6));

        table.setItems(data);

        Button cancel = new Button("Ακύρωση Οχήματος");
        cancel.setMinWidth(200);
        cancel.setMaxWidth(200);
        Button submit = new Button("Έκδοση Απόδειξης");
        submit.setMinWidth(200);
        submit.setMaxWidth(200);
        StackPane bottomBtns = new StackPane(cancel, submit);
        bottomBtns.setPadding(new Insets(20, 50, 20, 50));
        StackPane.setAlignment(cancel, Pos.CENTER_LEFT);
        StackPane.setAlignment(submit, Pos.CENTER_RIGHT);

        VBox finalsp = new VBox(logoBox, table, bottomBtns);
        finalsp.setAlignment(Pos.CENTER);
        finalsp.setSpacing(40);
        finalsp.setBackground(
                new Background(new BackgroundFill(Color.web("#d5f4e6"), CornerRadii.EMPTY, Insets.EMPTY)));

        var scene = new Scene(finalsp, 1024, 768);

        stage.setMinWidth(1024);
        stage.setMinHeight(768);
        stage.setMaxWidth(1920);
        stage.setMaxHeight(1080);

        stage.setScene(scene);
        stage.show();

        // Λειτουργίες κουμπιών
        Alert alert = new Alert(AlertType.NONE);

        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                alert.setAlertType(AlertType.CONFIRMATION);
                // needs improvment
                String contet = "Υπηρεσίες για το " + table.getSelectionModel().getSelectedItem().getPlate() + ": \n";

                List<Services> ap = table.getSelectionModel().getSelectedItem().getServices();
                for (Services s : ap) {
                    contet += s.toString() + "\n";
                }
                alert.setContentText(contet);
                alert.setHeaderText("Συνολικό κόστος: " + table.getSelectionModel().getSelectedItem().getCost() + "€");
                alert.setTitle("Έκδοση Απόδειξης");
                Optional<ButtonType> result = alert.showAndWait();

                if (result.get() == ButtonType.OK) {
                    try {
                        //writeExcel(table.getSelectionModel().getSelectedItem());
                        WriteCSV.updatefile(table.getSelectionModel().getSelectedItem());
                        System.out.println(
                                "Selected for receipt and deletion: " + table.getSelectionModel().getSelectedItem());
                        table.getItems().remove(table.getSelectionModel().getSelectedIndex());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        };
        submit.setOnAction(event);

        EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                alert.setAlertType(AlertType.CONFIRMATION);

                alert.setHeaderText("Ακύρωση Οχήματος ");
                alert.setTitle("Διαγραφή Οχήματος");
                Optional<ButtonType> result = alert.showAndWait();

                if (result.get() == ButtonType.OK) {
                    try {
                        WriteCSV.removefromfile(table.getSelectionModel().getSelectedItem());
                        System.out.println("Selected for deletion: " + table.getSelectionModel().getSelectedItem());
                        table.getItems().remove(table.getSelectionModel().getSelectedIndex());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        };
        cancel.setOnAction(event2);

        // On KeyPressed Εκδoση Απόδειξης

        // Iσως αυτο να μη χρειάζεται
        // table.setOnMouseClicked((MouseEvent ev) -> {
        //     ActionEvent e = new ActionEvent();
        //     event.handle(e);
        // });
        table.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent evt) {
                ActionEvent e = new ActionEvent();
                event.handle(e);
            }

        });

        ///
        stage.setOnCloseRequest((e) -> {
            if (data.size() != 0) {
                Alert al = new Alert(AlertType.ERROR);
                al.setTitle("Σφάλμα.");
                al.setHeaderText("Υπάρχουν ακόμα οχήματα προς εξυπηρέτηση.");
                al.setContentText("Το προγραμμα δεν μπορεί να τερματιστεί.");

                al.showAndWait();
                e.consume();
            }
            if (data.size() == 0) {
                System.exit(1);

            }
        });
        ///
        new Thread(() -> {

            while (true) {
                try (ServerSocket serverSocket = new ServerSocket(7777);
                        Socket connectionSocket = serverSocket.accept();
                        Scanner fromClient = new Scanner(connectionSocket.getInputStream());
                        PrintWriter toClient = new PrintWriter(connectionSocket.getOutputStream(), true)) {

                    String plate = fromClient.nextLine();
                    toClient.println(plate);
                    System.out.println("Received: " + plate);
                    String cost = fromClient.nextLine();
                    toClient.println(cost);
                    System.out.println("Received: " + cost);
                    String type = fromClient.nextLine();
                    toClient.println(type);
                    System.out.println("Received: " + type);
                    Washing wc = new Washing(plate, Double.parseDouble(cost), type);
                    System.out.println(wc);
                    String size = fromClient.nextLine();
                    toClient.println(size);
                    System.out.println("Received: " + size);
                    int sizelist = Integer.parseInt(size);
                    for (int i = 0; i < sizelist; i++) {
                        String id = fromClient.nextLine();
                        toClient.println(id);
                        System.out.println("Received: " + id);
                        String name_services = fromClient.nextLine();
                        toClient.println(name_services);
                        System.out.println("Received: " + name_services);
                        String costserv = fromClient.nextLine();
                        toClient.println(costserv);
                        System.out.println("Received: " + costserv);
                        Services ser = new Services(id, name_services, Double.parseDouble(costserv));
                        wc.getServices().add(ser);
                    }
                    List<Services> se = wc.getServices();
                    ComboBox cb = new ComboBox();
                    for (Services m : se) {
                        cb.getItems().add(m.toString());
                        System.out.println(m.toString());
                    }
                    cb.setMaxHeight(3);
                    wc.setCb(cb);
                    wc.setTime();
                    wc.setUniqueID();
                    data.add(wc);
                    WriteCSV.writefile(wc);
                    System.out.println(data.size());
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        }).start();

    }

    public static void main(String[] args) {

        launch(args);
    }

    public void writeExcel(Washing text) throws Exception {
        String CsvFile = "MobileP.csv";
        ListView<String> dataList = new ListView<>();
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        String departureTime = dateFormat.format(cal.getTime());

        BufferedReader br;

        try {
            br = new BufferedReader(new FileReader(CsvFile));

            String line;
            while ((line = br.readLine()) != null) {
                String fields = line;
                dataList.getItems().add(fields);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            dataList.getItems().add(text.getDate() + "  " + text.getTime() + "  "
                    + text.getPlate() + "  " + text.getServices() + "  " + text.getCost() + "€");
            writer = new FileWriter(file);
            for (int i = 0; i < dataList.getItems().size(); i++) {
                writer.write(dataList.getItems().get(i) + "\n");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            writer.flush();
            writer.close();
        }
            
        
    }

}
