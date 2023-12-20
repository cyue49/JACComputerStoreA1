package ComputerStore;

import java.util.ArrayList;
import java.util.Scanner;

public class ComputerStore {
    private static final String PASSWORD = "password"; // password for the computer store
    private final int maxComputers; // maximum number of computers the Computer Store can hold
    private int emptySlots; // remaining empty slots in the Computer Store
    private final ArrayList<Computer> inventory; // array list representing the inventory of the Computer Store

    // constructor
    public ComputerStore(int maxComputers) {
        this.maxComputers = maxComputers;
        this.emptySlots = maxComputers;
        inventory = new ArrayList<Computer>();
    }

    // ask user to enter password and check if correct
    private static boolean checkPassword(){
        Scanner kb = new Scanner(System.in);
        int tries = 3; // have 3 tries to enter the correct password
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
        System.out.println("You have entered the wrong password 3 attempts in a row. Returning back to main menu."); // used up all 3 tries, back to main menu
        return false;
    }

    // add new computers to computer store
    private void addNewComputers(Computer c){
        inventory.add(c);
        emptySlots--;
    }

    // ask the user how many computers they want to add and add them if computer store has enough space
    public void enterNewComputers(){
        if (!checkPassword())   return; // ask user to enter the password, if incorrect return
        Scanner kb = new Scanner(System.in);
        int num = 0; // number of computers to be added to the store
        while (true){
            try{
                System.out.println("Please input the number of computers you want to add: ");
                String input = kb.nextLine();
                num = Integer.parseInt(input);
                if (num > emptySlots){ // if not enough empty slots to add the number of computers the user wants to add, return back to main menu
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
            addNewComputers(new Computer(brand,model,price)); // add new computer to store
        }

        System.out.println(num + " computer(s) have been added to the store.");
    }

    // change the information of an existing computer
    private void changeComputerInfo(Computer c){
        Scanner kb = new Scanner(System.in);
        System.out.println("Here is the current information of the computer: \n" + c); // display current information of computer
        while (true){ // ask user which information they want to change
            System.out.println("""
                What information would you like to change?
                \t1.\tBrand
                \t2.\tModel
                \t3.\tPrice
                \t4.\tBack to menu
                Enter your choice:\s""");
            int choice = 0;
            try {
                String input = kb.nextLine();
                choice = Integer.parseInt(input);
            }catch (Exception e){
                System.out.println("Invalid input. Please try again.");
                continue;
            }
            switch (choice) {
                case 1: // change brand
                    System.out.println("Please enter the new brand: ");
                    String newBrand = kb.nextLine();
                    c.setBrand(newBrand);
                    System.out.println("The brand of the computer has been changed. Here is the updated information for the computer: \n" + c);
                    break;
                case 2: // change model
                    System.out.println("Please enter the new model: ");
                    String newModel = kb.nextLine();
                    c.setModel(newModel);
                    System.out.println("The model of the computer has been changed. Here is the updated information for the computer: \n" + c);
                    break;
                case 3: // change price
                    double price = 0;
                    while (true){
                        System.out.println("Please enter the new price: ");
                        try {
                            String input = kb.nextLine();
                            price = Double.parseDouble(input);
                            break;
                        }catch (Exception e){
                            System.out.println("Invalid input. Please try again. ");
                        }
                    }
                    c.setPrice(price);
                    System.out.println("The price of the computer has been changed. Here is the updated information for the computer: \n" + c);
                    break;
                case 4: // back to menu
                    return;
            }
        }
    }

    // ask the user how which computer they want to change information and change if that computer exists
    public void modifyComputerInfo(){
        if (!checkPassword())   return; // ask user to enter the password, if incorrect return
        Scanner kb = new Scanner(System.in);
        // ask for which computer user want to modify information
        while (true){
            System.out.println("Please enter the index number of the computer for which you wish to change information: ");
            try {
                String input = kb.nextLine();
                int idx = Integer.parseInt(input);
                if (idx < 0 || idx >= maxComputers-emptySlots){ // if computer of this index doesn't exist
                    while (true){
                        System.out.println("There is no computer at index " + idx + ". What do you want to do: \n"+
                                "\t1.\tEnter another computer\n" +
                                "\t2.\tGo back to the main menu\n" +
                                "Please make your choice: ");
                        try{
                            String input2 = kb.nextLine();
                            int choice = Integer.parseInt(input2);
                            if (choice == 2){ // user choice is 2, go back to main menu
                                return;
                            }else if (choice == 1){ // user choice is 1, enter another index
                                break;
                            } else {
                                System.out.println("Invalid choice. Please choose again.");
                            }
                        }catch (Exception e){
                            System.out.println("Invalid input. Please try again.");
                        }
                    }
                }else{ // correct input, change computer info at index idx
                    changeComputerInfo(inventory.get(idx)); // change information for the computer at that index
                    break;
                }
            }catch (Exception e){
                System.out.println("Invalid input. Please try again.");
            }
        }
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
            if (c.getPrice() <= price) System.out.println(c);
        }
    }
}
