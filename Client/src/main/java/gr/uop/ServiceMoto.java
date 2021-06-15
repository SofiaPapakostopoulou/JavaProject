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

public class ServiceMoto {
    Stage stage;

    public ServiceMoto(Stage stage) {

        var label = new Label("Επιλέξτε την υπηρεσία ή τις υπηρεσίες που επιθυμείτε απο τον παρακάτω τιμοκατάλογο.");
        label.setFont(Font.font("comic Sans MS", 30));

        CheckBox cb1 = new CheckBox("Πλύσιμο εξωτερικό, 6€");
        CheckBox cb2 = new CheckBox("Πλύσιμο εξωτερικό σπέσιαλ, 8€");
        CheckBox cb3 = new CheckBox("Κέρωμα - Γυάλισμα, 40€");
        CheckBox cb4 = new CheckBox("Καθαρισμός κινητήρα, 10€");
                        
        VBox vbox = new VBox(cb1, cb2,cb3,cb4);
        vbox.setSpacing(10);
        vbox.setMaxWidth(600);

        //checkbox restrictions
        cb1.disableProperty().bind(cb2.selectedProperty());
        cb2.disableProperty().bind(cb1.selectedProperty());

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
