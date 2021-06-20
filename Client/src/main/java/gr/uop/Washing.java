package gr.uop;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Washing {

    private String plate;
    private double cost;
    private String type;
    private List<Services> services = new ArrayList<Services>();

    public Washing(String plate, double cost, String type) {

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

    public void setType(String type) {
        this.type = type;
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

    public String getType() {
        return type;
    }

    public String toString() {
        return "Plate:" + plate + " Cost:" + cost + " Type:" + type;
    }

    public static void Connect(Washing wc) {
        try (Socket clientSocket = new Socket("localhost", 7777);
                PrintWriter toServer = new PrintWriter(clientSocket.getOutputStream(), true);
                Scanner fromServer = new Scanner(clientSocket.getInputStream())) {

            String plate = wc.getPlate();
            toServer.println(plate);

            String cost = String.valueOf(wc.getCost());
            toServer.println(cost);

            String type = wc.getType();
            toServer.println(type);

            String size = String.valueOf(wc.getServices().size());
            toServer.println(size);

            List<Services> ser = wc.getServices();
            for (Services m : ser) {
                String id = m.getID();
                toServer.println(id);

                String name_services = m.getName_services();
                toServer.println(name_services);

                String costserv = String.valueOf(m.getCost());
                toServer.println(costserv);

            }

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
