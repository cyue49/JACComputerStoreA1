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
    private void addNewComputers(Computer c){
        inventory.add(c);
        emptySlots--;
    }

    // ask the user how many computers then want to add and add them if computer store has enough space
    public void enterNewComputers(){
        if (!checkPassword())   return; // ask user to enter the password, if incorrect return
        Scanner kb = new Scanner(System.in);
        int num = 0; // number of computers to be added to the store
        while (true){
            try{
                System.out.println("Please input the number of computers you want to add: ");
                String input = kb.nextLine();
                num = Integer.parseInt(input);
                if (num > emptySlots){ // if not enough empty slots to add the number of computers the user wants to add
                    System.out.println("Action cannot be performed. There is only " + emptySlots + " empty slots available in the computer store. \nReturning to main menu.");
                    return;
                }
                break;
            }catch (Exception e){
                System.out.println("An invalid input for the number of computers has been entered. Please make sure to enter an integer and try again.");
            }
        }

        // valid input for number of computers, asking the user about the computer(s) to be added and add them
        for (int i=0; i<num; i++){
            System.out.println("For computer #" + i + ", please enter the following information:");
            System.out.println("Brand name: ");
            String brand = kb.nextLine();
            System.out.println("Model: ");
            String model = kb.nextLine();
            System.out.println("Price: ");
            double price = 0;
            while (true){
                try {
                    String input = kb.nextLine();
                    price = Double.parseDouble(input);
                    break;
                }catch (Exception e){
                    System.out.println("Invalid input. Please try again: ");
                }
            }
            addNewComputers(new Computer(brand,model,price));
        }

        System.out.println(num + " computer(s) have been added to the store.");

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
