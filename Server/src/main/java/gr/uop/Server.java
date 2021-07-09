package gr.uop;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.io.Writer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.scene.control.ListView;

import javafx.scene.control.TableView;

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
            dataList.getItems().add(text.getDate() + "  " + text.getTime() + "  " + text.getPlate() + "  "
                    + text.getServices() + "  " + text.getCost() + "€");
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
