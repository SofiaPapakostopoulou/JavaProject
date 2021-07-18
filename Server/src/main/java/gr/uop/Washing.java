package gr.uop;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javafx.scene.control.ComboBox;

public class Washing {

    private String plate;
    private double cost;
    private String type;
    private List<Services> services = new ArrayList<Services>();
    private String time;
    private String date;
    private ComboBox cb;

    public Washing(String plate, double cost, String type) {

        this.plate = plate;
        this.cost = cost;
        this.type = type;
    }

    // date
    public String getDate() {
        return date;

    }

    public void setDate() {

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        this.date = dateFormat.format(cal.getTime());
    }

    public void setTheDate(String date) {
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

    public String getType() {
        return type;
    }

    public String toString() {
        return "Plate:" + plate + " Cost:" + cost + " Type:" + type;
    }

}
