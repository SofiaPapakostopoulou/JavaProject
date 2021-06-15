package gr.uop;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ServiceCar {

    Stage stage;

    public ServiceCar(Stage stage) {

        var label = new Label("Επιλέξτε την υπηρεσία ή τις υπηρεσίες που επιθυμείτε απο τον παρακάτω τιμοκατάλογο.");
        label.setFont(Font.font("comic Sans MS", 20));

        CheckBox cb1 = new CheckBox("Πλύσιμο εξωτερικό,  7€");
        CheckBox cb2 = new CheckBox("Πλύσιμο εσωτερικό,  6€");
        CheckBox cb3 = new CheckBox("Πλύσιμο εξωτερικό και εσωτερικό,    12€");
        CheckBox cb4 = new CheckBox("Πλύσιμο εξωτερικό σπέσιαλ,  9€");
        CheckBox cb5 = new CheckBox("Πλύσιμο εσωτερικό σπέσιαλ,  8€");
        CheckBox cb6 = new CheckBox("Πλύσιμο εσωτερικό και εξωτερικό σπέσιαλ,    15€");
        CheckBox cb7 = new CheckBox("Βιολογικός καθαρισμός εσωτερικός,   80€");
        CheckBox cb8 = new CheckBox("Κέρωμα - Γυάλισμα,  80€");
        CheckBox cb9 = new CheckBox("Καθαρισμός κινητήρα, 20€");
        CheckBox cb10 = new CheckBox("Πλύσιμο σασί,   3€");

        VBox vbox = new VBox(cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8, cb9, cb10);
        vbox.setSpacing(10);
        vbox.setMaxWidth(600);

        // checkbox restrictions
        cb1.disableProperty().bind(cb3.selectedProperty().or(cb4.selectedProperty()).or(cb6.selectedProperty()));
        cb2.disableProperty().bind(cb3.selectedProperty().or(cb5.selectedProperty()).or(cb6.selectedProperty())
                .or(cb7.selectedProperty()));
        cb3.disableProperty().bind(cb1.selectedProperty().or(cb2.selectedProperty()).or(cb4.selectedProperty())
                .or(cb5.selectedProperty()).or(cb6.selectedProperty()).or(cb7.selectedProperty()));
        cb4.disableProperty().bind(cb1.selectedProperty().or(cb3.selectedProperty()).or(cb6.selectedProperty()));
        cb5.disableProperty().bind(cb2.selectedProperty().or(cb3.selectedProperty()).or(cb6.selectedProperty())
                .or(cb7.selectedProperty()));
        cb6.disableProperty().bind(cb1.selectedProperty().or(cb2.selectedProperty()).or(cb3.selectedProperty())
                .or(cb4.selectedProperty()).or(cb5.selectedProperty()).or(cb7.selectedProperty()));
        cb7.disableProperty().bind(cb2.selectedProperty().or(cb3.selectedProperty()).or(cb5.selectedProperty())
                .or(cb6.selectedProperty()));

        var price = new Label("Συνολικό Κόστος: ");
        price.setAlignment(Pos.CENTER_LEFT);
        Button btn = new Button("Καταχώρηση");
        // try

        EventHandler<ActionEvent> ev = new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e) {
                double cost = 0;
                if (cb1.isSelected()) {
                    cost = cost + 7;
                }
                if (cb2.isSelected()) {
                    cost = cost + 6;
                }
                if (cb3.isSelected()) {
                    cost = cost + 12;
                }
                if (cb4.isSelected()) {
                    cost = cost + 9;
                }
                if (cb5.isSelected()) {
                    cost = cost + 8;
                }
                if (cb6.isSelected()) {
                    cost = cost + 15;
                }
                if (cb7.isSelected()) {
                    cost = cost + 80;
                }
                if (cb8.isSelected()) {
                    cost = cost + 80;
                }
                if (cb9.isSelected()) {
                    cost = cost + 20;
                }
                if (cb10.isSelected()) {
                    cost = cost + 3;
                }
                price.setText("Συνολικό Κόστος: " + cost + "€");
            }

        };

        cb1.setOnAction(ev);
        cb2.setOnAction(ev);
        cb3.setOnAction(ev);
        cb4.setOnAction(ev);
        cb5.setOnAction(ev);
        cb6.setOnAction(ev);
        cb7.setOnAction(ev);
        cb8.setOnAction(ev);
        cb9.setOnAction(ev);
        cb10.setOnAction(ev);
        //

        StackPane sp = new StackPane(price, btn);
        StackPane.setAlignment(price, Pos.CENTER_LEFT);
        StackPane.setAlignment(btn, Pos.CENTER_RIGHT);

        VBox vb_f = new VBox(label, vbox, sp);
        vb_f.setSpacing(20);
        vb_f.setPadding(new Insets(20, 110, 20, 110));
        vb_f.setAlignment(Pos.CENTER);
        vb_f.setBackground(new Background(new BackgroundFill(Color.web("#d5f4e6"), CornerRadii.EMPTY, Insets.EMPTY)));
        Scene service = new Scene(vb_f, 1024, 768);
        service.setFill(Color.web("#d5f4e6"));

        stage.setMinWidth(1024);
        stage.setMinHeight(768);
        stage.setMaxWidth(1920);
        stage.setMaxHeight(1080);

        stage.setScene(service);
        stage.setTitle("Υπηρεσίες");
        stage.show();
        stage.setOnCloseRequest(event -> {
            stage.getScene().getWindow().hide();
        });
    }

}
