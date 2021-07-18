package gr.uop;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;

public class Washing {
    /*
     * private LocalDate date; private LocalTime time; private String uniqueID;
     */
    private String plate;
    private double cost;
    private String type;
    private List<Services> services = new ArrayList<Services>();
    private String time;
    private String date;
    private ComboBox cb;

    public Washing(String plate, double cost, String type) {
        /*
         * uniqueID = UUID.randomUUID().toString(); date = LocalDate.now(); time =
         * LocalTime.now();
         */
        this.plate = plate;
        this.cost = cost;
        this.type = type;
    }

    public String getD() {
        return date;
    }

    // date
    public String getDate() {
        return date;
        //return dateFormat.format(cal.getTime());
    }

    public void setDate() {
        //this.date = date;
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        this.date = dateFormat.format(cal.getTime());
    }

    public void setTheDate(String date){
        this.date = date;
    }

    public String setTime() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        time = dateFormat.format(cal.getTime());
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getPlate() {
        return plate;
    }

    public double getCost() {
        return cost;
    }

    public List getServices() {
        return services;
    }

    public void setCb(ComboBox cb) {
        this.cb = cb;
    }

    public ComboBox getCb() {
        return cb;
    }
    // public ComboBox getServices() {
    // ObservableList<Services> options = FXCollections.observableArrayList();
    // for(int i =0; i<services.size(); i++){
    // options.add(services.get(i));
    // }
    // ComboBox comboBox = new ComboBox(options);
    // return comboBox;
    // }

    public String getType() {
        return type;
    }

    public String toString() {
        return "Plate:" + plate + " Cost:" + cost + " Type:" + type;
    }

}
