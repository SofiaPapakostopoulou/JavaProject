package gr.uop;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ServiceMoto {

    Stage stage;
    double f_cost = 0;

    public ServiceMoto(Stage stage, String plate) {

        var label = new Label("Επιλέξτε την υπηρεσία ή τις υπηρεσίες που επιθυμείτε απο τον παρακάτω τιμοκατάλογο.");
        label.setFont(Font.font("comic Sans MS", 30));

        CheckBox cb1 = new CheckBox("Πλύσιμο εξωτερικό, 6€");
        cb1.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 10));
        CheckBox cb2 = new CheckBox("Πλύσιμο εξωτερικό σπέσιαλ, 8€");
        cb2.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 10));
        CheckBox cb3 = new CheckBox("Κέρωμα - Γυάλισμα, 40€");
        cb3.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 10));
        CheckBox cb4 = new CheckBox("Καθαρισμός κινητήρα, 10€");
        cb4.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 10));

        VBox vbox = new VBox(cb1, cb2, cb3, cb4);
        vbox.setSpacing(10);
        vbox.setMaxWidth(600);

        // checkbox restrictions
        cb1.disableProperty().bind(cb2.selectedProperty());
        cb2.disableProperty().bind(cb1.selectedProperty());

        var price = new Label("Συνολικό Κόστος: ");
        price.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 10));
        price.setAlignment(Pos.CENTER_LEFT);
        Button btn = new Button("Καταχώρηση");
        btn.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 10));

        btn.disableProperty().bind(cb1.selectedProperty().not().and(cb2.selectedProperty().not())
                .and(cb3.selectedProperty().not()).and(cb4.selectedProperty().not()));

        //
        //
        EventHandler<ActionEvent> ev = new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e) {
                double cost = 0;
                if (cb1.isSelected()) {
                    cost = cost + 6;
                }
                if (cb2.isSelected()) {
                    cost = cost + 8;
                }
                if (cb3.isSelected()) {
                    cost = cost + 40;
                }
                if (cb4.isSelected()) {
                    cost = cost + 10;
                }

                price.setText("Συνολικό Κόστος: " + cost + "€");
                price.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 10));
                f_cost = cost;
            }

        };

        cb1.setOnAction(ev);
        cb2.setOnAction(ev);
        cb3.setOnAction(ev);
        cb4.setOnAction(ev);

        Alert alert = new Alert(AlertType.NONE);
        EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                alert.setAlertType(AlertType.CONFIRMATION);

                String contet = "Υπηρεσίες: \n";
                if (cb1.isSelected()) {
                    contet += cb1.getText() + "\n";
                }
                if (cb2.isSelected()) {
                    contet += cb2.getText() + "\n";
                }
                if (cb3.isSelected()) {
                    contet += cb3.getText() + "\n";
                }
                if (cb4.isSelected()) {
                    contet += cb4.getText() + "\n";
                }
                alert.setContentText(contet);
                alert.setHeaderText("Συνολικό κόστος: " + f_cost + "€");
                alert.setTitle("Επιβεβαίωση Επιλογών");

                Optional<ButtonType> result = alert.showAndWait();

                if (result.get() == ButtonType.OK) {

                    Washing wm = new Washing(plate, f_cost, "Moto");
                    if (cb1.isSelected()) {
                        wm.getServices().add(new Services("wm1", "Πλύσιμο εξωτερικό", 6.00));
                    }
                    if (cb2.isSelected()) {
                        wm.getServices().add(new Services("wm2", "Πλύσιμο εξωτερικό σπέσιαλ", 8.00));
                    }
                    if (cb3.isSelected()) {
                        wm.getServices().add(new Services("wm3", "Κέρωμα - Γυάλισμα", 40.00));
                    }
                    if (cb4.isSelected()) {
                        wm.getServices().add(new Services("wm4", "Καθαρισμός κινητήρα", 10.00));
                    }

                    Washing.Connect(wm);
                    stage.close();
                    new PrimaryStage(stage);

                }

            }
        };
        btn.setOnAction(event2);

        ///
        StackPane sp = new StackPane(price, btn);
        StackPane.setAlignment(price, Pos.CENTER_LEFT);
        StackPane.setAlignment(btn, Pos.CENTER_RIGHT);
        ///
        ///
        Button back = new Button();
        back.setMaxWidth(20);
        back.setMaxHeight(20);
        back.setAlignment(Pos.TOP_RIGHT);
        ImageView backImageView = new ImageView(new Image(getClass().getResourceAsStream("images/back.png")));
        back.setGraphic(backImageView);
        Button start = new Button("Αρχική Σελίδα");
        start.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 10));
        start.setAlignment(Pos.CENTER_LEFT);
        StackPane top = new StackPane(back, start);
        top.setPadding(new Insets(20, 50, 20, 50));
        StackPane.setAlignment(back, Pos.CENTER_LEFT);
        StackPane.setAlignment(start, Pos.CENTER_RIGHT);
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                stage.close();
                new Vehicle(stage, plate);
            }
        });
        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                stage.close();
                new PrimaryStage(stage);
            }
        });
        top.setBackground(new Background(new BackgroundFill(Color.web("#d5f4e6"), CornerRadii.EMPTY, Insets.EMPTY)));

        VBox vb_f = new VBox(label, vbox, sp);
        vb_f.setSpacing(20);
        vb_f.setPadding(new Insets(20, 110, 20, 110));
        vb_f.setAlignment(Pos.CENTER);
        vb_f.setBackground(new Background(new BackgroundFill(Color.web("#d5f4e6"), CornerRadii.EMPTY, Insets.EMPTY)));
        BorderPane mainPane = new BorderPane();
        mainPane.setTop(top);
        mainPane.setCenter(vb_f);
        Scene service = new Scene(mainPane, 1024, 768);
        service.setFill(Color.web("#d5f4e6"));

        stage.setMinWidth(1024);
        stage.setMinHeight(768);
        stage.setMaxWidth(1920);
        stage.setMaxHeight(1080);

        stage.setScene(service);
        stage.setTitle("Υπηρεσίες");
        stage.show();
    }

}
