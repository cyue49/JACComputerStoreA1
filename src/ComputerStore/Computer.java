package ComputerStore;

public class Computer {
    private String brand; // brand of the computer
    private String model; // model of the computer
    private double price; // price of the computer
    private final long serialNumber; // serial number of the computer
    private static long serialNumberCounter = 1000000; // counter for the next computer's serial number

    // Constructor
    public Computer(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        serialNumber = serialNumberCounter;
        serialNumberCounter++;
    }

    // Getters
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public long getSerialNumber() {
        return serialNumber;
    }

    // Setters
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
