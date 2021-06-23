package gr.uop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

public class ReadCSV {
    static File filereader = new File("MobileP.csv");

    static void ReadCsv(ObservableList<Washing> data) {
        try (BufferedReader br = new BufferedReader(new FileReader("MobileP.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",  ");

                Washing W = new Washing(values[2], Double.parseDouble(values[5].replace("€", " ")), values[3]);
                String str = values[4];
                String result = str.substring(str.indexOf("[") + 1, str.indexOf("]"));
                String[] v = result.split(",");

                ComboBox cb = new ComboBox();
                for (int i = 0; i < v.length; i += 2) {
                    cb.getItems().add(v[i] + "," + v[1 + i]);
                    W.getServices().add(v[i] + "," + v[1 + i]);
                }
                W.setCb(cb);
                W.setTime(values[1]);
                W.setDate(values[0]);
                data.add(W);
            }
            // return data;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
