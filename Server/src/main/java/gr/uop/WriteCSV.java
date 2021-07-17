package gr.uop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javafx.scene.control.ListView;

public class WriteCSV {

    static Writer writer = null;
    static File file = new File("MobileP.csv");
    static ListView<String> dataList = new ListView<>();

    WriteCSV(Washing wc) {
        String CsvFile = "MobileP.csv";

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
    }

    public static void writefile(Washing wc) throws IOException {
        try {
            dataList.getItems().add(wc.getDate() + ",  " + wc.getTime().trim() + ",  " + wc.getPlate() + ",  "
                    + wc.getType() + ",  " + wc.getServices());
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

    public static void updatefile(Washing wc) throws IOException {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        String departureTime = dateFormat.format(cal.getTime());
        String temp = "";
        String newstr = "";

        try {
            temp = wc.getDate() + ",  " + wc.getTime().trim() + ",  " + wc.getPlate() + ",  " + wc.getType() + ",  "
                    + wc.getServices();
            newstr = wc.getDate() + ",  " + wc.getTime() + "-" + departureTime + ",  " + wc.getPlate() + ",  "
                    + wc.getType() + ",  " + wc.getServices() + ",  " + wc.getCost() + "€";

            for (int i = 0; i < dataList.getItems().size(); i++) {
                if (dataList.getItems().get(i).equals(temp)) {
                    dataList.getItems().set(i, newstr);
                }
            }
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

    public static void removefromfile(Washing wc) throws IOException {
        String temp = "";

        try {
            temp = wc.getDate() + ",  " + wc.getTime().trim() + ",  " + wc.getPlate() + ",  " + wc.getType() + ",  "
                    + wc.getServices();

            for (int i = 0; i < dataList.getItems().size(); i++) {
                if (dataList.getItems().get(i).equals(temp)) {
                    dataList.getItems().remove(i);
                }
            }
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