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

public abstract class Washing {
    /*
     * private LocalDate date; private LocalTime time; private String uniqueID;
     */
    private String plate;
    private double cost;
    private List<Services> services = new ArrayList<Services>();

    public Washing(String plate, double cost) {
        /*
         * uniqueID = UUID.randomUUID().toString(); date = LocalDate.now(); time =
         * LocalTime.now();
         */
        this.plate = plate;
        this.cost = cost;
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
        return "Plate:" + plate + " Cost:" + cost;
    }

    public static void Connect(Washing wc) {
        try (Socket clientSocket = new Socket("localhost", 7777);
                PrintWriter toServer = new PrintWriter(clientSocket.getOutputStream(), true);
                Scanner fromServer = new Scanner(clientSocket.getInputStream())) {

            // wc = new WashingCar("DJJ 9923", 44);
            // while (key.hasNextLine()) {
            String plate = wc.getPlate();
            toServer.println(plate);

            // toServer.flush();

            String response = fromServer.nextLine();
            System.out.println("Response: " + response);
            String cost = String.valueOf(wc.getCost());
            toServer.println(cost);
            String response2 = fromServer.nextLine();
            System.out.println("Response: " + response2);
            // }

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
