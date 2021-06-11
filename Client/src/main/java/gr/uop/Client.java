package gr.uop;


import java.util.Iterator;

//import com.sun.javafx.scene.control.skin.FXVK;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Bounds;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * JavaFX App
 */
public class Client extends Application {

    private PopupWindow keyboard;
    
    @Override
    public void start(Stage stage) {
        
        var label = new Label("Καλωσήρθατε στο κατάστημα μας!");
        label.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 50));
        label.setStyle("-fx-background-color: grey;padding: 20px;");
        var label_plate = new Label("Παρακαλώ εισάγετε τον αριθμό της πινακίδας σας");
        TextField plate = new TextField();
        plate.setMinWidth(100);


        VBox vb = new VBox(label,label_plate,plate);
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(20);
        var scene = new Scene(new StackPane(vb), 640, 480);

        stage.setMinWidth(1024);
        stage.setMinHeight(768);
        stage.setMaxWidth(1920);
        stage.setMaxHeight(1080);

        stage.setScene(scene);
        stage.show();

        Node first = scene.getRoot().getChildrenUnmodifiable().get(0);
        if (first != null) {
            // FXVK.init(first);
            // FXVK.attach(first);
            keyboard = getPopupWindow();
        }

        plate.focusedProperty().addListener((ob, b, b1) -> {
            if (keyboard == null) {
                keyboard = getPopupWindow();
            }

            keyboard.setHideOnEscape(Boolean.FALSE);
            keyboard.setAutoHide(Boolean.FALSE);
            keyboard.centerOnScreen();
            keyboard.requestFocus();

            keyboard.yProperty().addListener(obs -> {

                Platform.runLater(() -> {
                    // Double y = Bounds.getHeight() - taskbarHeight - keyboard.getY();
                    // plate.setMaxHeight((Bounds.getHeight() - y) * 0.4);
                    // plate.setMinHeight((Bounds.getHeight() - y) * 0.4);
                });
            });

        });
    }

    public static void main(String[] args) {
        launch(args);
    }

    private PopupWindow getPopupWindow() {

        // @SuppressWarnings("deprecation") 
        // final Iterator<Window> windows = Window.impl_getWindows();

        // while (windows.hasNext()) {
        //     final Window window = windows.next();
        //     if (window instanceof PopupWindow) {
        //         if (window.getScene() != null && window.getScene().getRoot() != null) { 
        //             Parent root = window.getScene().getRoot();
        //             if (root.getChildrenUnmodifiable().size() > 0) {
        //                 Node popup = root.getChildrenUnmodifiable().get(0);
        //                 if (popup.lookup(".fxvk") != null) {
        //                     FXVK vk = (FXVK) popup.lookup(".fxvk");
        //                     // hide the key:
        //                     vk.lookup(".hide").setVisible(false);
        //                     return (PopupWindow) window;
        //                 }
        //             }
        //         }
        //         return null;
        //     }
        // }
        return null;
    }
}
