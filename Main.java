public class Main {
    public static void main(String[] args) {
        ItemDAO itemDAO = new ItemDAO();

        System.out.println("Trying to add a test item to the database...");

        // Test adding a lost item
        boolean success = itemDAO.addItem(
            "Black Wallet", 
            "Left near the campus cafeteria, contains ID card.", 
            "Cafeteria", 
            "2026-06-06", 
            "Lost"
        );

        if (success) {
            System.out.println("Item added successfully!\n");
        } else {
            System.out.println("Failed to add item.\n");
        }

        // Test fetching and displaying all active items
        System.out.println("Fetching all active items from database:");
        itemDAO.getAllItems();
    }
}