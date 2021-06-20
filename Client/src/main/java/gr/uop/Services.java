package gr.uop;

public class Services {
    private String id;
    private String name_services;
    private double cost;

    public Services(String id, String name_services, double cost) {
        this.id = id;
        this.name_services = name_services;
        this.cost = cost;

    }

    public String getID() {
        return id;
    }

    public String getName_services() {
        return name_services;
    }

    public double getCost() {
        return cost;
    }

    public String toString() {
        return "ID: " + id + " Name of service: " + name_services + " Cost: " + cost;
    }
}
