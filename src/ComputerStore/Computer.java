package ComputerStore;

public class Computer {
    private String brand; // brand of the computer
    private String model; // model of the computer
    private double price; // price of the computer
    private final long serialNumber; // serial number of the computer
    private static long serialNumberCounter = 1000000; // counter for the next computer's serial number
    private static int count = 0; // the number of computers created

    // Constructor
    public Computer(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        serialNumber = serialNumberCounter;
        serialNumberCounter++;
        count++;
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

    // String representation
    @Override
    public String toString() {
        return "=== Computer Info ==="
                + "\n\tBrand: " + brand
                + "\n\tModel: " + model
                + "\n\tSerial Number: " + serialNumber
                + "\n\tPrice: " + "$" + price;
    }

    // Returns the total number of Computer objects created
    public int findNumberOfCreatedComputers(){
        return count;
    }

    // checking equality between two Computer objects
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Computer computer = (Computer) o;
        return Double.compare(price, computer.price) == 0 && brand.equals(computer.brand) && model.equals(computer.model);
    }
}
