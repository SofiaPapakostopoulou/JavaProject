package gr.uop;

import java.io.File;

import java.io.IOException;

import java.io.Writer;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.scene.control.TableView;

import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class Server extends Application {

    Writer writer = null;
    File file = new File("MobileP.csv");
    File fout = new File("out.txt");
    TableView<Washing> table = new TableView<>();
    static ObservableList<Washing> data = FXCollections.observableArrayList();

    @Override
    public void start(Stage stage) throws Exception {

        ReadCSV.ReadCsv(data);

        try {
            for (Washing wc : data) {
                WriteCSV.writefile(wc);
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        new ServerStage(stage, table, data);

    }

    public static void main(String[] args) {

        launch(args);
    }

}
