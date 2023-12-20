package ComputerStore;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        // get max number of computers that can be stored in the computer store from user
        System.out.println("=== Welcome to Chen's Computer Store ===");
        int storeSize;
        while (true){
            System.out.println("Enter the maximum number of computers the computer store can contain: ");
            try{
                String input = kb.nextLine();
                storeSize = Integer.parseInt(input);
                break;
            }catch (Exception e){
                System.out.println("Invalid input. Please try again.");
            }
        }

        // creating the computer store
        ComputerStore computerStore = new ComputerStore(storeSize);

        // loop main menu until user wants to quit
        int choice;
        while (true){
            // get menu choice from user
            displayMenu();
            try {
                String input = kb.nextLine();
                choice = Integer.parseInt(input);
                if (!(choice >=1 && choice <=5)){ // while choice is invalid, keep asking
                    System.out.println("You have entered an invalid choice, please make sure to enter an integer between 1 and 5 (inclusive).");
                    continue;
                }
            }catch (Exception e){
                System.out.println("You have entered an invalid choice, please make sure to enter an integer between 1 and 5 (inclusive).");
                continue;
            }

            // perform the appropriate menu action
            switch (choice){
                case 1: // enter new computers to the store
                    computerStore.enterNewComputers();
                    break;
                case 2: // modify information of a computer in the store
                    computerStore.modifyComputerInfo();
                    break;
                case 3: // display all computers of a certain brand
                    System.out.println("Please enter a brand name: ");
                    String brand = kb.nextLine();
                    computerStore.displayByBrand(brand);
                    break;
                case 4: // display all computers under a certain price
                    double price;
                    while (true){
                        System.out.println("Please enter a price value: ");
                        try{
                            String input = kb.nextLine();
                            price = Double.parseDouble(input);
                            break;
                        }catch (Exception e){
                            System.out.println("Invalid input. Please try again.");
                        }
                    }
                    computerStore.displayByPrice(price);
                    break;
                case 5: // quit
                    System.out.println("=== Quitting Chen's Computer Store ===");
                    kb.close();
                    System.exit(0);
            }
        }
    }

    // display menu and ask user for menu choice
    public static void displayMenu(){
        System.out.println("""
                ===========================================================
                What do you want to do?
                \t1.\tEnter new computers (password required)
                \t2.\tChange information of a computer (password required)
                \t3.\tDisplay all computers by a specific brand
                \t4.\tDisplay all computers under a certain price
                \t5.\tQuit
                Please enter your choice:
                ===========================================================""");
    }
}
