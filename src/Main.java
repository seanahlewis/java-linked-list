package assignment10;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        InventoryList inventory = new InventoryList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Inventory Menu ---");
            System.out.println("1. Add Item");
            System.out.println("2. Add Item to Front");
            System.out.println("3. Remove First Item");
            System.out.println("4. Remove Last Item");
            System.out.println("5. Remove Item by Index");
            System.out.println("6. Find Item");
            System.out.println("7. Update Quantity");
            System.out.println("8. View Inventory");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // clear newline

            switch (choice) {

                case 1: // Add item
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter quantity: ");
                    int qty = scanner.nextInt();

                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();

                    inventory.addItem(new Item(name, qty, price));
                    System.out.println("Item added.");
                    break;

                case 2: // Add to front
                    System.out.print("Enter name: ");
                    name = scanner.nextLine();

                    System.out.print("Enter quantity: ");
                    qty = scanner.nextInt();

                    System.out.print("Enter price: ");
                    price = scanner.nextDouble();
                    scanner.nextLine();

                    inventory.addFirst(new Item(name, qty, price));
                    System.out.println("Item added to front.");
                    break;

                case 3: // Remove first
                    Item removedFirst = inventory.removeFirst();
                    System.out.println("Removed: " + removedFirst);
                    break;

                case 4: // Remove last
                    Item removedLast = inventory.removeLast();
                    System.out.println("Removed: " + removedLast);
                    break;

                case 5: // Remove by index
                    System.out.print("Enter index: ");
                    int index = scanner.nextInt();
                    scanner.nextLine();

                    Item removed = inventory.removeItem(index);
                    if (removed != null) {
                        System.out.println("Removed: " + removed);
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;

                case 6: // Find item
                    System.out.print("Enter name to search: ");
                    name = scanner.nextLine();

                    Item found = inventory.findItem(name);
                    if (found != null) {
                        System.out.println("Found: " + found);
                    } else {
                        System.out.println("Item not found.");
                    }
                    break;

                case 7: // Update quantity
                    System.out.print("Enter name: ");
                    name = scanner.nextLine();

                    System.out.print("Enter new quantity: ");
                    qty = scanner.nextInt();
                    scanner.nextLine();

                    if (inventory.updateQuantity(name, qty)) {
                        System.out.println("Updated.");
                    } else {
                        System.out.println("Item not found.");
                    }
                    break;

                case 8: // View inventory
                    System.out.println("\nInventory:");
                    System.out.println(inventory);
                    break;

                case 9: // Exit
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
