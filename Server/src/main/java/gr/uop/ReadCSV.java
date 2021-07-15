package gr.uop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

public class ReadCSV {
    static File filereader = new File("MobileP.csv");
    static File file = new File("MobilePc.csv");
    static Writer writer = null;

    static void ReadCsv(ObservableList<Washing> data) {
        try (BufferedReader br = new BufferedReader(new FileReader("MobileP.csv"))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",  ");
                int leng = values.length - 1;
                Washing W = new Washing(values[2], Double.parseDouble(values[leng].replace("€", " ")), values[3]);
                String str = line;
                String result = str.substring(str.indexOf("[") + 1, str.indexOf("]"));
                String[] v = result.split(",");

                for (int i = 0; i < v.length; i = i + 2) {

                    String id = v[i].substring(0, 4);
                    String name_services = v[i].substring(4);
                    String cost = v[i + 1].replace("€", " ");
                    Services ser = new Services(id, name_services, Double.parseDouble(cost));
                    W.getServices().add(ser);
                }
                List<Services> se = W.getServices();
                ComboBox cb = new ComboBox();
                for (Services m : se) {
                    cb.getItems().add(m.toString());

                }
                W.setCb(cb);
                W.setTime(values[1]);
                W.setDate(values[0]);
                // WriteCSV.writefile(W);
                data.add(W);
            }
            // return data;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
