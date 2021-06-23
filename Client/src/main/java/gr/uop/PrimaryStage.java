package gr.uop;

import javafx.stage.Stage;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import java.util.ArrayList;

public class PrimaryStage {
    Stage stage;

    public PrimaryStage(Stage stage) {

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
        logoBox.setAlignment(Pos.TOP_CENTER);
        logoBox.setPadding(new Insets(0, 0, 0, 0));

        var label = new Label("Καλωσήρθατε στο κατάστημα μας!");
        label.setFont(Font.font("LiHei Pro", FontWeight.BOLD, 50));
        var label_plate = new Label("Παρακαλώ εισάγετε τον αριθμό της πινακίδας σας");
        label_plate.setFont(Font.font("LiHei Pro", 30));
        var plate = new Label("");
        plate.setAlignment(Pos.CENTER_RIGHT);
        plate.setFont(Font.font("LiHei Pro", FontWeight.BOLD, 20));
        plate.setMinWidth(200);
        plate.setMaxWidth(200);
        plate.setMinHeight(50);
        plate.setMaxHeight(100);
        var check = new Label("");

        VBox vb = new VBox(logoBox, label, label_plate, plate, check);

        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(20);

        HBox keyboard = new HBox();

        GridPane gridLetters = new GridPane();
        gridLetters.setPadding(new Insets(5));
        gridLetters.setHgap(5);
        gridLetters.setVgap(5);

        ArrayList<Button> letList = new ArrayList<Button>();
        for (int r = 0; r < 3; r++) {
            switch (r) {
                case 0:
                    Button Q = new Button("Q");
                    gridLetters.add(Q, 0, r);
                    letList.add(Q);
                    Button W = new Button("W");
                    gridLetters.add(W, 1, r);
                    letList.add(W);
                    Button E = new Button("E");
                    gridLetters.add(E, 2, r);
                    letList.add(E);
                    Button R = new Button("R");
                    gridLetters.add(R, 3, r);
                    letList.add(R);
                    Button T = new Button("T");
                    gridLetters.add(T, 4, r);
                    letList.add(T);
                    Button Y = new Button("Y");
                    gridLetters.add(Y, 5, r);
                    letList.add(Y);
                    Button U = new Button("U");
                    gridLetters.add(U, 6, r);
                    letList.add(U);
                    Button I = new Button("I");
                    gridLetters.add(I, 7, r);
                    letList.add(I);
                    Button O = new Button("O");
                    gridLetters.add(O, 8, r);
                    letList.add(O);
                    Button P = new Button("P");
                    gridLetters.add(P, 9, r);
                    letList.add(P);
                    break;
                case 1:
                    Button A = new Button("A");
                    gridLetters.add(A, 1, r);
                    letList.add(A);
                    Button S = new Button("S");
                    gridLetters.add(S, 2, r);
                    letList.add(S);
                    Button D = new Button("D");
                    gridLetters.add(D, 3, r);
                    letList.add(D);
                    Button F = new Button("F");
                    gridLetters.add(F, 4, r);
                    letList.add(F);
                    Button G = new Button("G");
                    gridLetters.add(G, 5, r);
                    letList.add(G);
                    Button H = new Button("H");
                    gridLetters.add(H, 6, r);
                    letList.add(H);
                    Button J = new Button("J");
                    gridLetters.add(J, 7, r);
                    letList.add(J);
                    Button K = new Button("K");
                    gridLetters.add(K, 8, r);
                    letList.add(K);
                    Button L = new Button("L");
                    gridLetters.add(L, 9, r);
                    letList.add(L);
                    break;
                case 2:
                    Button Z = new Button("Z");
                    gridLetters.add(Z, 2, r);
                    letList.add(Z);
                    Button X = new Button("X");
                    gridLetters.add(X, 3, r);
                    letList.add(X);
                    Button C = new Button("C");
                    gridLetters.add(C, 4, r);
                    letList.add(C);
                    Button V = new Button("V");
                    gridLetters.add(V, 5, r);
                    letList.add(V);
                    Button B = new Button("B");
                    gridLetters.add(B, 6, r);
                    letList.add(B);
                    Button N = new Button("N");
                    gridLetters.add(N, 7, r);
                    letList.add(N);
                    Button M = new Button("M");
                    gridLetters.add(M, 8, r);
                    letList.add(M);
                    break;
            }
        }
        for (Button b : letList) {
            b.setMinWidth(40);
            b.setFont(Font.font("LiHei Pro", 15));
        }
        GridPane gridLettersGreek = new GridPane();
        gridLettersGreek.setPadding(new Insets(5));
        gridLettersGreek.setHgap(5);
        gridLettersGreek.setVgap(5);

        ArrayList<Button> letListGreek = new ArrayList<Button>();
        for (int r = 0; r < 3; r++) {
            switch (r) {
                case 0:
                    Button E = new Button("E");
                    gridLettersGreek.add(E, 2, r);
                    letListGreek.add(E);
                    Button R = new Button("Ρ");
                    gridLettersGreek.add(R, 3, r);
                    letListGreek.add(R);
                    Button T = new Button("T");
                    gridLettersGreek.add(T, 4, r);
                    letListGreek.add(T);
                    Button Y = new Button("Y");
                    gridLettersGreek.add(Y, 5, r);
                    letListGreek.add(Y);
                    Button U = new Button("Θ");
                    gridLettersGreek.add(U, 6, r);
                    letListGreek.add(U);
                    Button I = new Button("I");
                    gridLettersGreek.add(I, 7, r);
                    letListGreek.add(I);
                    Button O = new Button("O");
                    gridLettersGreek.add(O, 8, r);
                    letListGreek.add(O);
                    Button P = new Button("Π");
                    gridLettersGreek.add(P, 9, r);
                    letListGreek.add(P);
                    break;
                case 1:
                    Button A = new Button("A");
                    gridLettersGreek.add(A, 1, r);
                    letListGreek.add(A);
                    Button S = new Button("Σ");
                    gridLettersGreek.add(S, 2, r);
                    letListGreek.add(S);
                    Button D = new Button("Δ");
                    gridLettersGreek.add(D, 3, r);
                    letListGreek.add(D);
                    Button F = new Button("Φ");
                    gridLettersGreek.add(F, 4, r);
                    letListGreek.add(F);
                    Button G = new Button("Γ");
                    gridLettersGreek.add(G, 5, r);
                    letListGreek.add(G);
                    Button H = new Button("H");
                    gridLettersGreek.add(H, 6, r);
                    letListGreek.add(H);
                    Button J = new Button("Ξ");
                    gridLettersGreek.add(J, 7, r);
                    letListGreek.add(J);
                    Button K = new Button("K");
                    gridLettersGreek.add(K, 8, r);
                    letListGreek.add(K);
                    Button L = new Button("Λ");
                    gridLettersGreek.add(L, 9, r);
                    letListGreek.add(L);
                    break;
                case 2:
                    Button Z = new Button("Z");
                    gridLettersGreek.add(Z, 2, r);
                    letListGreek.add(Z);
                    Button X = new Button("X");
                    gridLettersGreek.add(X, 3, r);
                    letListGreek.add(X);
                    Button C = new Button("Ψ");
                    gridLettersGreek.add(C, 4, r);
                    letListGreek.add(C);
                    Button V = new Button("Ω");
                    gridLettersGreek.add(V, 5, r);
                    letListGreek.add(V);
                    Button B = new Button("B");
                    gridLettersGreek.add(B, 6, r);
                    letListGreek.add(B);
                    Button N = new Button("N");
                    gridLettersGreek.add(N, 7, r);
                    letListGreek.add(N);
                    Button M = new Button("M");
                    gridLettersGreek.add(M, 8, r);
                    letListGreek.add(M);
                    break;
            }
        }
        for (Button b : letListGreek) {
            b.setMinWidth(40);
            b.setFont(Font.font("LiHei Pro", 15));
        }

        Button backspace = new Button("Backspace");
        backspace.setFont(Font.font("LiHei Pro", 15));
        gridLetters.add(backspace, 10, 0);
        gridLettersGreek.add(backspace, 10, 0);
        Button space = new Button(" ");
        space.setMinWidth(280);
        Button greng = new Button("Greek");
        HBox down = new HBox(greng, space);

        down.setSpacing(50);
        VBox letters = new VBox(gridLetters, down);

        greng.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                // TODO Auto-generated method stub

                if (greng.getText().equals("Greek")) {
                    letters.getChildren().remove(gridLetters);
                    letters.getChildren().remove(down);
                    letters.getChildren().addAll(gridLettersGreek, down);
                    greng.setText("English");
                } else {
                    letters.getChildren().remove(gridLettersGreek);
                    letters.getChildren().remove(down);
                    letters.getChildren().addAll(gridLetters, down);
                    greng.setText("Greek");
                }
            }

        });

        VBox numbers = new VBox();
        GridPane gridNumber = new GridPane();
        gridNumber.setPadding(new Insets(5));
        gridNumber.setHgap(5);
        gridNumber.setVgap(5);
        ArrayList<Button> numbList = new ArrayList<Button>();
        for (int r = 0; r < 3; r++) {
            switch (r) {
                case 0:
                    Button n7 = new Button("7");
                    gridNumber.add(n7, 2, r);
                    numbList.add(n7);
                    Button n8 = new Button("8");
                    gridNumber.add(n8, 1, r);
                    numbList.add(n8);
                    Button n9 = new Button("9");
                    gridNumber.add(n9, 0, r);
                    numbList.add(n9);
                    break;
                case 1:
                    Button n4 = new Button("4");
                    gridNumber.add(n4, 2, r);
                    numbList.add(n4);
                    Button n5 = new Button("5");
                    gridNumber.add(n5, 1, r);
                    numbList.add(n5);
                    Button n6 = new Button("6");
                    gridNumber.add(n6, 0, r);
                    numbList.add(n6);
                    break;
                case 2:
                    Button n1 = new Button("1");
                    gridNumber.add(n1, 2, r);
                    numbList.add(n1);
                    Button n2 = new Button("2");
                    gridNumber.add(n2, 1, r);
                    numbList.add(n2);
                    Button n3 = new Button("3");
                    gridNumber.add(n3, 0, r);
                    numbList.add(n3);
                    break;
            }
        }
        Button n0 = new Button("0");

        numbList.add(n0);
        for (Button b : numbList) {
            b.setMinWidth(40);
            b.setFont(Font.font("LiHei Pro", 15));
        }
        numbers.setAlignment(Pos.CENTER);
        numbers.getChildren().addAll(gridNumber, n0);
        letters.setAlignment(Pos.CENTER);
        keyboard.getChildren().addAll(letters, numbers);
        keyboard.setAlignment(Pos.CENTER);
        vb.getChildren().addAll(keyboard);

        //////

        for (Button b : letList) {
            b.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    String letter = b.getText();

                    plate.setText(plate.getText() + letter);

                }
            });
        }
        for (Button b : letListGreek) {
            b.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    String letter = b.getText();

                    plate.setText(plate.getText() + letter);

                }
            });
        }
        for (Button b : numbList) {
            b.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    String n = b.getText();

                    plate.setText(plate.getText() + n);

                }
            });
        }
        space.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                plate.setText(plate.getText() + " ");

            }
        });

        backspace.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (!plate.getText().equals("")) {
                    plate.setText(plate.getText().substring(0, plate.getText().length() - 1));

                }
            }
        });

        Button enter = new Button("Καταχώρηση Πινακίδας");
        enter.setFont(Font.font("LiHei Pro", 15));
        vb.getChildren().add(enter);

        enter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                new Vehicle(stage, plate.getText());
            }
        });
        enter.setDisable(true);
        plate.textProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

                if (plate.getText().equals("")) {
                    check.setText("Ο αριθμός κυκλοφορίας δεν μπορεί να είναι κενός.");
                    check.setFont(Font.font("LiHei Pro", 15));
                    enter.setDisable(true);
                    backspace.setDisable(true);

                } else {
                    enter.setDisable(false);
                    backspace.setDisable(false);
                    int let = 0;
                    int numb = 0;
                    for (char a : plate.getText().toCharArray()) {
                        if ((a >= 'A' && a <= 'Z')) {
                            let++;
                        }
                        if ((a >= 'Α' && a <= 'Ω')) {
                            let++;
                        }
                        if ((a >= '0' && a <= '9')) {
                            numb++;
                        }
                    }
                    if ((let > 1) && (numb > 0)) {
                        enter.setDisable(false);
                        check.setText(" ");
                    } else {
                        check.setText("Ο αριθμός κυκλοφορίας πρέπει να περιέχει τουλάχιστον 2 γράμματα και 1 αριθμό.");
                        check.setFont(Font.font("LiHei Pro", FontWeight.BOLD, 15));
                        enter.setDisable(true);
                    }

                }

            }
        });
        /////

        vb.setBackground(new Background(new BackgroundFill(Color.web("#d5f4e6"), CornerRadii.EMPTY, Insets.EMPTY)));
        var scene = new Scene(new StackPane(vb), 640, 480);

        stage.setMinWidth(1024);
        stage.setMinHeight(768);
        stage.setMaxWidth(1920);
        stage.setMaxHeight(1080);

        stage.setScene(scene);
        stage.show();
    }

}