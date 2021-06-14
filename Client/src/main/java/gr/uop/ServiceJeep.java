package gr.uop;

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

public class ServiceJeep {

    Stage stage;

    public ServiceJeep(Stage stage) {

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
                        
        VBox vbox = new VBox(cb1, cb2,cb3,cb4,cb5,cb6,cb7,cb8,cb9,cb10);
        vbox.setSpacing(10);
        vbox.setMaxWidth(600);
        

        var price = new Label("Συνολικό Κόστος: ");
        price.setAlignment(Pos.CENTER_LEFT);
        Button btn = new Button("Καταχώρηση");
        
        
        StackPane sp = new StackPane(price,btn);
        StackPane.setAlignment(price, Pos.CENTER_LEFT);
        StackPane.setAlignment(btn, Pos.CENTER_RIGHT);

        VBox vb_f = new VBox(label,vbox,sp);
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
    }
    
}
