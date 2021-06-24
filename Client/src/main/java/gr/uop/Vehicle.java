package gr.uop;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Vehicle {
    Stage stage;

    public Vehicle(Stage stage, String plate, String nlanguage) {

        RadioButton rb1 = new RadioButton("Αυτοκίνητο");
        RadioButton rb2 = new RadioButton("Τζίπ");
        RadioButton rb3 = new RadioButton("Μοτοσυκλέτα");

        rb1.setFont(Font.font("LiHei Pro", 30));
        rb2.setFont(Font.font("LiHei Pro", 30));
        rb3.setFont(Font.font("LiHei Pro", 30));

        ToggleGroup radioGroup = new ToggleGroup();

        rb1.setToggleGroup(radioGroup);
        rb2.setToggleGroup(radioGroup);
        rb3.setToggleGroup(radioGroup);
        Button back = new Button();
        back.setMaxWidth(20);
        back.setMaxHeight(20);
        back.setAlignment(Pos.TOP_RIGHT);
        ImageView backImageView = new ImageView(new Image(getClass().getResourceAsStream("images/back.png")));
        back.setGraphic(backImageView);
        VBox backV = new VBox(back);
        backV.setPadding(new Insets(20, 0, 0, 20));
        VBox check = new VBox(rb1, rb2, rb3);

        TitledPane tp = new TitledPane();
        tp.setCollapsible(false);
        tp.setText("Επιλέξτε το όχημα σας");
        tp.setContent(check);
        tp.setMaxWidth(400);
        tp.setFont(Font.font("LiHei Pro", 30));
        if (nlanguage.equals("Greek")) {
            tp.setText("Please choose your vehicle");
            rb1.setText("Car");
            rb2.setText("Jeep");
            rb3.setText("Μotorcycle");
        }
        radioGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {

                if (radioGroup.getSelectedToggle() != null) {

                    if (radioGroup.getSelectedToggle() == rb1) {
                        new ServiceCar(stage, plate, nlanguage);
                    }
                    if (radioGroup.getSelectedToggle() == rb2) {
                        new ServiceJeep(stage, plate, nlanguage);
                    }
                    if (radioGroup.getSelectedToggle() == rb3) {
                        new ServiceMoto(stage, plate, nlanguage);
                    }

                }

            }
        });

        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                stage.close();
                new PrimaryStage(stage);
            }
        });

        VBox vb_f = new VBox(tp);
        vb_f.setAlignment(Pos.CENTER);
        // vb_f.setSpacing(20);
        vb_f.setPadding(new Insets(20, 20, 20, 20));
        vb_f.setBackground(new Background(new BackgroundFill(Color.web("#d5f4e6"), CornerRadii.EMPTY, Insets.EMPTY)));
        backV.setBackground(new Background(new BackgroundFill(Color.web("#d5f4e6"), CornerRadii.EMPTY, Insets.EMPTY)));
        BorderPane mainPane = new BorderPane();
        mainPane.setTop(backV);
        mainPane.setCenter(vb_f);

        // mainPane.setPadding(new Insets(10, 10, 10, 0));
        Scene scene = new Scene(mainPane, 1024, 768);
        stage.setMinWidth(1024);
        stage.setMinHeight(768);
        stage.setMaxWidth(1920);
        stage.setMaxHeight(1080);

        stage.setScene(scene);
        stage.setTitle("Υπηρεσίες");
        stage.show();
    }
}
