import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemDAO {

    // 1. Method to add a lost or found item to the database
    public boolean addItem(String itemName, String description, String location, String itemDate, String type) {
        String query = "INSERT INTO items (item_name, description, location, item_date, type, status) VALUES (?, ?, ?, ?, ?, 'Active')";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, itemName);
            pstmt.setString(2, description);
            pstmt.setString(3, location);
            pstmt.setString(4, itemDate);
            pstmt.setString(5, type);
            
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 2. Method to fetch all active items
    public void getAllItems() {
        String query = "SELECT * FROM items WHERE status = 'Active'";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            
            while (rs.next()) {
                System.out.println("Item: " + rs.getString("item_name") + " | Location: " + rs.getString("location"));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 3. Method to update an item's status (e.g., when it gets claimed/resolved)
    public boolean updateItemStatus(int itemId, String newStatus) {
        String query = "UPDATE items SET status = ? WHERE id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, newStatus);
            pstmt.setInt(2, itemId);
            
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}