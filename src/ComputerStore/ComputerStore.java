package ComputerStore;

import java.util.ArrayList;
import java.util.Scanner;

public class ComputerStore {
    private static final String PASSWORD = "password"; // password for the computer store
    private final int maxComputers; // maximum number of computers the Computer Store can hold
    private int emptySlots; // remaining empty slots in the Computer Store
    private ArrayList<Computer> inventory; // array list representing the inventory of the Computer Store

    // constructor
    public ComputerStore(int maxComputers) {
        this.maxComputers = maxComputers;
        this.emptySlots = maxComputers;
        inventory = new ArrayList<Computer>();
    }

    // ask user to enter password and check if correct
    private static boolean checkPassword(){
        Scanner kb = new Scanner(System.in);
        int tries = 3;
        while (tries>0){
            System.out.println("Please enter the password: ");
            String pwd = kb.nextLine();
            tries--;
            if (pwd.equals(PASSWORD)){
                return true;
            }else{
                System.out.println("Incorrect password attempt #" + (3-tries));
            }
        }
        System.out.println("You have entered the wrong password 3 attempts in a row. Returning back to main menu.");
        return false;
    }

    // add new computers to computer store
    public void addNewComputers(Computer c){
        inventory.add(c);
        emptySlots--;
    }

    // ask the user how many computers then want to add and add them if has enough space
    public void enterNewComputers(){
        if (!checkPassword())   return; // ask user to enter the password, if incorrect return
    }

    // change the information of an existing computer
    public void changeComputerInfo(Computer c){
        ;
    }

    // display all computer of a certain brand
    public void displayByBrand(String brand){
        System.out.println("Displaying all computers in the inventory of the following brand: " + brand);
        for (Computer c : inventory){
            if (c.getBrand().equals(brand)) System.out.println(c);
        }
    }

    // display all computers under a certain price
    public void displayByPrice(double price){
        System.out.println("Displaying all computers in the inventory under the following price: " + price);
        for (Computer c : inventory){
            if (c.getPrice() == price) System.out.println(c);
        }
    }
}
