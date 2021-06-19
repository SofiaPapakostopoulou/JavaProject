package gr.uop;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

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

    public void setType(String type){
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
            String response = fromServer.nextLine();
            System.out.println("Response: " + response);
            String cost = String.valueOf(wc.getCost());
            toServer.println(cost);
            String response2 = fromServer.nextLine();
            System.out.println("Response: " + response2);
            String type = wc.getType();
            toServer.println(type);
            String response3 = fromServer.nextLine();
            System.out.println("Response: " + response3);
            String size = String.valueOf(wc.getServices().size());
            toServer.println(size);
            String response4 = fromServer.nextLine();
            System.out.println("Response: " + response4);
            List<Services> ser = wc.getServices();
            for (Services m : ser) {
                String id = m.getID();
                toServer.println(id);
                String response5 = fromServer.nextLine();
                System.out.println("Response: " + response5);
                String name_services = m.getName_services();
                toServer.println(name_services);
                String response6 = fromServer.nextLine();
                System.out.println("Response: " + response6);
                String costserv = String.valueOf(m.getCost());
                toServer.println(costserv);
                String response7 = fromServer.nextLine();
                System.out.println("Response: " + response7);
            }

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
