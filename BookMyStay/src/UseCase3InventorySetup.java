public class UseCase3InventorySetup {

    public static void main(String[] args) {

        System.out.println("Use Case 3: Centralized Room Inventory Management\n");

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Display initial inventory
        inventory.displayInventory();

        // Update availability
        System.out.println("\nUpdating Inventory...\n");

        inventory.updateAvailability("Single", 4);
        inventory.updateAvailability("Double", 2);

        // Display updated inventory
        inventory.displayInventory();
    }
}