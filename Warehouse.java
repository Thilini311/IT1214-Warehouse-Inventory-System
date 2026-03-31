import java.util.*;

public class Warehouse{
    private static Inventory inventory=new Inventory();
    private static Scanner scanner=new Scanner(System.in);

    public static void main(String[] args){
        int choice;

        do{
            System.out.println("\n--- Warehouse Inventory System ---");
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. Update Quantity");
            System.out.println("4. Search Item");
            System.out.println("5. View All Items");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice){
                case 1: addItem(); break;
                case 2: removeItem(); break;
                case 3: updateQuantity(); break;
                case 4: searchItem(); break;
                case 5: inventory.displayAll(); break;
                case 0: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice!");
            }
        } while(choice != 0);
    }

    private static void addItem(){
        System.out.print("Enter ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Quantity: ");
        int qty = scanner.nextInt();

        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();

        inventory.addItem(new Item(id, name, qty, price));
    }

    private static void removeItem(){
        System.out.print("Enter ID to remove: ");
        String id=scanner.nextLine();
        inventory.removeItem(id);
    }

    private static void updateQuantity(){
        System.out.print("Enter ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter new quantity: ");
        int qty = scanner.nextInt();

        inventory.updateQuantity(id, qty);
    }

    private static void searchItem(){
        System.out.print("Search by (1-ID / 2-Name): ");
        int option=scanner.nextInt();
        scanner.nextLine();

        if(option == 1){
            System.out.print("Enter ID: ");
            String id=scanner.nextLine();
            Item item=inventory.searchById(id);
            System.out.println(item!=null ? item : "Item not found.");
        }else if (option==2){
            System.out.print("Enter Name: ");
            String name=scanner.nextLine();
            List<Item>results=inventory.searchByName(name);

            if(results.isEmpty()){
                System.out.println("No items found.");
            }else{
                for(Item item : results){
                    System.out.println(item);
                }
            }
        }else{
            System.out.println("Invalid option.");
        }
    }
}