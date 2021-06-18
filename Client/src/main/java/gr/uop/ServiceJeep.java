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
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ServiceJeep {

    Stage stage;
    double f_cost = 0;

    public ServiceJeep(Stage stage, String plate, ArrayList<Washing> warray) {

        var label = new Label("Επιλέξτε την υπηρεσία ή τις υπηρεσίες που επιθυμείτε απο τον παρακάτω τιμοκατάλογο.");
        label.setFont(Font.font("comic Sans MS", 30));

        CheckBox cb1 = new CheckBox("Πλύσιμο εξωτερικό,  8€");
        CheckBox cb2 = new CheckBox("Πλύσιμο εσωτερικό,  7€");
        CheckBox cb3 = new CheckBox("Πλύσιμο εξωτερικό και εσωτερικό,    14€");
        CheckBox cb4 = new CheckBox("Πλύσιμο εξωτερικό σπέσιαλ,  10€");
        CheckBox cb5 = new CheckBox("Πλύσιμο εσωτερικό σπέσιαλ,  9€");
        CheckBox cb6 = new CheckBox("Πλύσιμο εσωτερικό και εξωτερικό σπέσιαλ,    17€");
        CheckBox cb7 = new CheckBox("Βιολογικός καθαρισμός εσωτερικός,   80€");
        CheckBox cb8 = new CheckBox("Κέρωμα - Γυάλισμα,  90€");
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
        //
        EventHandler<ActionEvent> ev = new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e) {
                double cost = 0;
                if (cb1.isSelected()) {
                    cost = cost + 8;
                }
                if (cb2.isSelected()) {
                    cost = cost + 7;
                }
                if (cb3.isSelected()) {
                    cost = cost + 14;
                }
                if (cb4.isSelected()) {
                    cost = cost + 10;
                }
                if (cb5.isSelected()) {
                    cost = cost + 9;
                }
                if (cb6.isSelected()) {
                    cost = cost + 17;
                }
                if (cb7.isSelected()) {
                    cost = cost + 80;
                }
                if (cb8.isSelected()) {
                    cost = cost + 90;
                }
                if (cb9.isSelected()) {
                    cost = cost + 20;
                }
                if (cb10.isSelected()) {
                    cost = cost + 3;
                }
                price.setText("Συνολικό Κόστος: " + cost + "€");
                f_cost = cost;
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

        btn.disableProperty().bind(cb1.selectedProperty().not().and(cb2.selectedProperty().not())
                .and(cb3.selectedProperty().not()).and(cb4.selectedProperty().not()).and(cb5.selectedProperty().not())
                .and(cb6.selectedProperty().not()).and(cb7.selectedProperty().not()).and(cb8.selectedProperty().not())
                .and(cb9.selectedProperty().not()).and(cb10.selectedProperty().not()));

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
                if (cb5.isSelected()) {
                    contet += cb5.getText() + "\n";
                }
                if (cb6.isSelected()) {
                    contet += cb6.getText() + "\n";
                }
                if (cb7.isSelected()) {
                    contet += cb7.getText() + "\n";
                }
                if (cb8.isSelected()) {
                    contet += cb8.getText() + "\n";
                }
                if (cb9.isSelected()) {
                    contet += cb9.getText() + "\n";
                }
                if (cb10.isSelected()) {
                    contet += cb10.getText() + "\n";
                }
                alert.setContentText(contet);
                alert.setHeaderText("Συνολικό κόστος: " + f_cost + "€");
                alert.setTitle("Επιβεβαίωση Επιλογών");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    // System.out.println("OK");
                    WashingJeep wj = new WashingJeep(plate, f_cost);
                    if (cb1.isSelected()) {
                        wj.getServices().add(new Services("wj1", "Πλύσιμο εξωτερικό", 8.00));
                    }
                    if (cb2.isSelected()) {
                        wj.getServices().add(new Services("wj2", "Πλύσιμο εσωτερικό", 7.00));
                    }
                    if (cb3.isSelected()) {
                        wj.getServices().add(new Services("wj3", "Πλύσιμο εξωτερικό και εσωτερικό", 14.00));
                    }
                    if (cb4.isSelected()) {
                        wj.getServices().add(new Services("wj4", "Πλύσιμο εξωτερικό σπέσιαλ", 10.00));
                    }
                    if (cb5.isSelected()) {
                        wj.getServices().add(new Services("wj5", "Πλύσιμο εσωτερικό σπέσιαλ", 9.00));
                    }
                    if (cb6.isSelected()) {
                        wj.getServices().add(new Services("wj6", "Πλύσιμο εσωτερικό και εξωτερικό σπέσιαλ", 17.00));
                    }
                    if (cb7.isSelected()) {
                        wj.getServices().add(new Services("wj7", "Βιολογικός καθαρισμός εσωτερικός", 80.00));
                    }
                    if (cb8.isSelected()) {
                        wj.getServices().add(new Services("wj8", "Κέρωμα - Γυάλισμα", 90.00));
                    }
                    if (cb9.isSelected()) {
                        wj.getServices().add(new Services("wj9", "Καθαρισμός κινητήρα", 20.00));
                    }
                    if (cb10.isSelected()) {
                        wj.getServices().add(new Services("wj10", "Πλύσιμο σασί", 3.00));
                    }
                    warray.add(wj);

                    for (Washing a : warray) {
                        System.out.println(a.toString());
                        List<Services> services = a.getServices();
                        for (Services s : services) {
                            System.out.println(s.toString());
                        }
                    }
                    Washing.Connect(wj);
                    stage.close();
                    new PrimaryStage(stage, warray);
                }

            }
        };
        btn.setOnAction(event2);

        //

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
        start.setAlignment(Pos.CENTER_LEFT);
        StackPane top = new StackPane(back, start);
        top.setPadding(new Insets(20, 50, 20, 50));
        StackPane.setAlignment(back, Pos.CENTER_LEFT);
        StackPane.setAlignment(start, Pos.CENTER_RIGHT);
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                new Vehicle(stage, plate, warray);
            }
        });
        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                stage.close();
                new PrimaryStage(stage, warray);
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
