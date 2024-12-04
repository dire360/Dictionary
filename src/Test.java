// Dylan Wilson

import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws Exception {
        Dictionary dict = new Dictionary();
        Scanner input = new Scanner(System.in);
        int choice = 0;

     /* 5 nodes for testing
        dict.add("5", "kathie", "allen", "2213 mill street", "seattle", "WA", "98012", "kathie@gmail.com", "(206)453-1231");
        dict.add("2", "gale", "rynolds", "1234 8th ave.", "seattle", "WA", "91201", "gale303@gmail.com", "(415)221-8860");
        dict.add("6", "bella", "smith", "2219 state street", "bellingham", "WA", "98229", "bella101@icloud.com", "(206)992-1231");
        dict.add("1", "andrew", "west", "6639 meridian", "bellingham", "WA", "9226", "and555@gmail.com", "(360)453-9237");
        dict.add("3", "dean", "hall", "4436 4th ave.", "seattle", "WA", "98012", "dean2@gmail.com", "(206)453-3482");
      */

        while (choice != 6) { // print menu untill user chooses 6 to exit
            System.out.println("\nEmployee Dictionary");
            System.out.println("");
            System.out.println("+ Menu Options +");
            System.out.println("1. Add");
            System.out.println("2. Delete");
            System.out.println("3. Modify");
            System.out.println("4. Search");
            System.out.println("5. Print");
            System.out.println("6. Exit");
            System.out.print("Enter (1-6): ");
            choice = input.nextInt();
            input.nextLine(); // Consume newline

            switch (choice) {
                case 1: // add method with user parameters
                    System.out.print("Enter Employee key: ");
                    String key = input.nextLine();
                    System.out.print("Enter first name: ");
                    String firstName = input.nextLine();
                    System.out.print("Enter last name: ");
                    String lastName = input.nextLine();
                    System.out.print("Enter street address: ");
                    String address = input.nextLine();
                    System.out.print("Enter city: ");
                    String city = input.nextLine();
                    System.out.print("Enter state: ");
                    String state = input.nextLine();
                    System.out.print("Enter zip: ");
                    String zip = input.nextLine();
                    System.out.print("Enter email: ");
                    String email = input.nextLine();
                    System.out.print("Enter phone: ");
                    String phone = input.nextLine();
                    dict.add(key, firstName, lastName, address, city, state, zip, email, phone);
                    break;

                case 2: // delete method used with key provided by user
                    System.out.print("Enter employee key to delete: ");
                    String delKey = input.nextLine();
                    dict.delete(delKey);
                    break;

                case 3: // modify method, with key user can modify any field
                    System.out.print("Enter employee key to modify: ");
                    String modKey = input.nextLine();
                    System.out.print("Enter field to modify (firstname, lastname, address, city, state, zip, email, phone): ");
                    String field = input.nextLine();
                    System.out.print("Enter new value: ");
                    String newValue = input.nextLine();
                    dict.modify(modKey, field, newValue);
                    break;

                case 4: // search by key and print
                    System.out.print("Enter employee key to search: ");
                    String searchKey = input.nextLine();
                    Node inputKey = dict.search(dict.root, searchKey);
                    if (inputKey != null) {
                        dict.printNode(inputKey);
                    } else {
                        System.out.println("key is not in use");
                    }
                    break;
                case 5: // print menu with options
                    printMenu(dict, input);
                    break;
                case 6: // quit
                    System.out.println("Quit Program");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
        input.close();
    }

    // Helper method for 3 printing options
    private static void printMenu(Dictionary dict, Scanner input) {
        System.out.println("(1) Pre-order");
        System.out.println("(2) In-order");
        System.out.println("(3) Post-order");
        System.out.print("Enter (1-3): ");
        int printChoice = input.nextInt();
        input.nextLine(); // Consume newline

        switch (printChoice) {
            case 1:
                System.out.println("\nPre-order Dictionary:");
                dict.printPreOrder(dict.root);
                break;
            case 2:
                System.out.println("\nIn-order Dictionary:");
                dict.printInOrder(dict.root);
                break;
            case 3:
                System.out.println("\nPost-order Dictionary:");
                dict.printPostOrder(dict.root);
                break;
            default:
                System.out.println("input not valid");
                break;
        }
    }
}

