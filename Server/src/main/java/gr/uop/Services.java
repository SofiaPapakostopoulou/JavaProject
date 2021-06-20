package gr.uop;

public class Services {
    private String id;
    private String name_services;
    private double cost;
    // private Washing wtype;

    public Services(String id, String name_services, double cost) {
        this.id = id;
        this.name_services = name_services;
        this.cost = cost;
        // this.wtype = wtype;
    }

    // public String toString() {
    //     return "ID: " + id + " Name of service: " + name_services + " Cost: " + cost;
    // }

    public String toString() {
        return id + " " + name_services + " " + cost;
    }

}
