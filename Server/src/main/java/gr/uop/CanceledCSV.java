package gr.uop;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import javafx.scene.control.ListView;


public class CanceledCSV {
    static Writer writer = null;
    static File file = new File("MobileP-canceledVehicles.csv");
    static ListView<String> dataList = new ListView<>();

    CanceledCSV(Washing wc){  
        String CsvFile = "MobileP-canceledVehicles.csv";
        
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
            dataList.getItems().add(wc.getDate()+ ",  " + wc.getTime() + ",  "
                    + wc.getPlate() + ",  " +wc.getType()+ ",  " + wc.getServices() 
                    + ",  " + wc.getCost() + "€");
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
    

