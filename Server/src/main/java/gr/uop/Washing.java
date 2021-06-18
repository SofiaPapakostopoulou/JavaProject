package gr.uop;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Washing {
    /*
     * private LocalDate date; private LocalTime time; private String uniqueID;
     */
    private String plate;
    private double cost;
    private String type;
    private List<Services> services = new ArrayList<Services>();

    public Washing(String plate, double cost, String type) {
        /*
         * uniqueID = UUID.randomUUID().toString(); date = LocalDate.now(); time =
         * LocalTime.now();
         */
        this.plate = plate;
        this.cost = cost;
        this.type = type;
    }

    // date
    public String getDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Calendar cal = Calendar.getInstance();
        return dateFormat.format(cal.getTime());
    }

    public String getTime() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        return dateFormat.format(cal.getTime());
    }

    // public String getID(){ return uniqueID; }

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

    public String toString() {
        return "Plate:" + plate + " Cost:" + cost + " Type:" + type;
    }

}
