package gr.uop;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public abstract class Washing {
    /*
     * private LocalDate date; private LocalTime time; private String uniqueID;
     */
    private String plate;
    private double cost;
    private Map<String, Double> servises = new HashMap<String, Double>();

    public Washing() {

    }

    public Washing(String plate, double cost) {
        /*
         * uniqueID = UUID.randomUUID().toString(); date = LocalDate.now(); time =
         * LocalTime.now();
         */
        this.plate = plate;
        this.cost = cost;
    }

    /*
     * public LocalDate getLocalDate(){ return date; }
     * 
     * public LocalTime getLocalTime(){ return time; }
     * 
     * public String getID(){ return uniqueID; }
     */
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

    public Map getServices() {
        return servises;
    }

    public String toString() {
        return "Plate:" + plate + " Cost:" + cost;
    }
}
