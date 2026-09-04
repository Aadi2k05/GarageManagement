import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GarageDAO {
    
    
  
    public boolean addCustomer(String name, String phone, String vehicleNumber, String vehicleModel) {
        String query = "INSERT INTO customers (name, phone, vehicle_number, vehicle_model) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, name);
            pstmt.setString(2, phone);
            pstmt.setString(3, vehicleNumber);
            pstmt.setString(4, vehicleModel);
            
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    

    public List<Customer> getAllCustomers() {
        List<Customer> list = new ArrayList<>();
        String query = "SELECT * FROM customers";
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            
            while (rs.next()) {
                Customer c = new Customer(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("phone"),
                    rs.getString("vehicle_number"),
                    rs.getString("vehicle_model")
                );
                list.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    // Search Customer by ID
    public Customer getCustomerById(int id) {
        String query = "SELECT * FROM customers WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return new Customer(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("phone"),
                    rs.getString("vehicle_number"),
                    rs.getString("vehicle_model")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    
    public boolean addService(int customerId, String serviceType, String status, double amount) {
        String query = "INSERT INTO services (customer_id, service_type, service_date, status, amount) VALUES (?, ?, CURDATE(), ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setInt(1, customerId);
            pstmt.setString(2, serviceType);
            pstmt.setString(3, status);
            pstmt.setDouble(4, amount);
            
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    public List<Service> getAllServices() {
        List<Service> list = new ArrayList<>();
        String query = "SELECT * FROM services";
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            
            while (rs.next()) {
                Service s = new Service(
                    rs.getInt("id"),
                    rs.getInt("customer_id"),
                    rs.getString("service_type"),
                    rs.getDate("service_date"),
                    rs.getString("status"),
                    rs.getDouble("amount")
                );
                list.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
  
    public boolean updateServiceStatus(int serviceId, String newStatus) {
        String query = "UPDATE services SET status = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, newStatus);
            pstmt.setInt(2, serviceId);
            
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}