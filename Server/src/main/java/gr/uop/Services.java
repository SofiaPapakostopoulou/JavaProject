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

    public String toString() {
        return id + " " + name_services + ", " + cost + "€";
    }
    // public String toString() {
    //     return name_services + ", " + cost + "€";
    // }

}
