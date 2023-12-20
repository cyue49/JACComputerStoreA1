package ComputerStore;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        // get max number of computers that can be stored in the computer store from user
        System.out.println("=== Welcome to Chen's Computer Store ===\nEnter the maximum number of computers the computer store can contain: ");
        int storeSize;
        while (true){
            try{
                String input = kb.nextLine();
                storeSize = Integer.parseInt(input);
                break;
            }catch (Exception e){
                System.out.println("Invalid input. Please try again: ");
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
                case 1:
                    computerStore.enterNewComputers();
                    break;
                case 2:
                    System.out.println("choice 2");
                    break;
                case 3:
                    System.out.println("choice 3");
                    break;
                case 4:
                    System.out.println("choice 4");
                    break;
                case 5:
                    System.out.println("=== Quitting Chen's Computer Store ===");
                    System.exit(0);
            }
        }
    }

    // display menu and ask user for menu choice
    public static void displayMenu(){
        System.out.println("""
                What do you want to do?
                \t1.\tEnter new computers (password required)
                \t2.\tChange information of a computer (password required)
                \t3.\tDisplay all computers by a specific brand
                \t4.\tDisplay all computers under a certain price
                \t5.\tQuit
                Please enter your choice:\s""");
    }
}
