package gr.uop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public class ReadCSV {
    static File filereader = new File("MobileP.csv");
    static File file = new File("MobilePc.csv");

    static void ReadCsv(ObservableList<Washing> data) {
        try (BufferedReader br = new BufferedReader(new FileReader("MobileP.csv"))) {
            String line;
            PrintWriter pw = new PrintWriter(new FileWriter("out.txt"));
            while (((line = br.readLine()) != null)) {

                String mry = line;
                if (!mry.contains("-")) {
                    String[] values = line.split(",  ");

                    Washing W = new Washing(values[2], 0, values[3]);

                    String str = line;
                    String result = str.substring(str.indexOf("[") + 1, str.indexOf("]"));
                    String[] v = result.split(",");

                    double c = 0;
                    for (int i = 0; i < v.length; i = i + 2) {
                        String id = v[i].substring(0, 4).trim();
                        String name_services = v[i].substring(4).trim();
                        String cost = v[i + 1].replace("€", " ");
                        Services ser = new Services(id, name_services, Double.parseDouble(cost));
                        c += Double.valueOf(cost);
                        W.getServices().add(ser);
                    }
                    List<Services> se = W.getServices();
                    ComboBox cb = new ComboBox();
                    for (Services m : se) {
                        cb.getItems().add(m.toString());

                    }
                    W.setCb(cb);
                    W.setTime(values[1].trim());
                    W.setTheDate(values[0].trim());
                    W.setCost(c);
                    data.add(W);
                }
                if (mry.contains("-")) {
                    pw.write(mry + "\n");
                }
            }
            pw.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
