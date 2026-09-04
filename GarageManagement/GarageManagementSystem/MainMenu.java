import java.util.List;
import java.util.Scanner;

public class MainMenu {
    private static Scanner sc = new Scanner(System.in);
    private static GarageDAO dao = new GarageDAO();
    
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n" + "=".repeat(40));
            System.out.println("GARAGE MANAGEMENT SYSTEM");
            System.out.println("=".repeat(40));
            System.out.println("1. Add Customer + Vehicle");
            System.out.println("2. View All Customers");
            System.out.println("3. Add Service/Repair Job");
            System.out.println("4. View All Services");
            System.out.println("5. Update Service Status");
            System.out.println("6. Generate Invoice");
            System.out.println("7. Exit");
            System.out.print("Choose (1-7): ");
            
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline
            
            switch (choice) {
                case 1: addCustomer(); break;
                case 2: viewAllCustomers(); break;
                case 3: addService(); break;
                case 4: viewAllServices(); break;
                case 5: updateStatus(); break;
                case 6: generateInvoice(); break;
                case 7: 
                    System.out.println("Exiting... Thank you!");
                    System.exit(0);
                default: System.out.println("Invalid choice!");
            }
        }
    }
    
    // ========== MENU METHODS ==========
    
    // 1. Add Customer
    private static void addCustomer() {
        System.out.println("\n--- ADD CUSTOMER ---");
        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Phone: ");
        String phone = sc.nextLine();
        System.out.print("Enter Vehicle Number (e.g., MH-12-AB-1234): ");
        String vNumber = sc.nextLine();
        System.out.print("Enter Vehicle Model: ");
        String vModel = sc.nextLine();
        
        if (dao.addCustomer(name, phone, vNumber, vModel)) {
            System.out.println("Customer Added Successfully!");
        } else {
            System.out.println("Failed to add customer.");
        }
    }
    
    // 2. View All Customers
    private static void viewAllCustomers() {
        System.out.println("\n--- ALL CUSTOMERS ---");
        List<Customer> customers = dao.getAllCustomers();
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
            return;
        }
        for (Customer c : customers) {
            System.out.println(c);
        }
    }
    
    // 3. Add Service
    private static void addService() {
        System.out.println("\n--- ADD SERVICE ---");
        viewAllCustomers();
        System.out.print("Enter Customer ID: ");
        int custId = sc.nextInt();
        sc.nextLine();
        
        System.out.print("Enter Service Type (e.g., Oil Change/Engine Repair/Brake Service): ");
        String type = sc.nextLine();
        System.out.print("Enter Amount (₹): ");
        double amount = sc.nextDouble();
        sc.nextLine();
        
        if (dao.addService(custId, type, "Pending", amount)) {
            System.out.println("Service Added Successfully!");
        } else {
            System.out.println("Failed to add service.");
        }
    }
    
    // 4. View All Services
    private static void viewAllServices() {
        System.out.println("\n--- ALL SERVICES ---");
        List<Service> services = dao.getAllServices();
        if (services.isEmpty()) {
            System.out.println("No services found.");
            return;
        }
        for (Service s : services) {
            System.out.println(s);
        }
    }
    
    // 5. Update Status
    private static void updateStatus() {
        System.out.println("\n--- UPDATE STATUS ---");
        viewAllServices();
        System.out.print("Enter Service ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Status Options: Pending, In Progress, Completed, Cancelled");
        System.out.print("Enter New Status: ");
        String status = sc.nextLine();
        
        if (dao.updateServiceStatus(id, status)) {
            System.out.println("Status Updated Successfully!");
        } else {
            System.out.println("Failed to update status.");
        }
    }
    
    // 6. Generate Invoice
    private static void generateInvoice() {
        System.out.println("\n--- GENERATE INVOICE ---");
        viewAllServices();
        System.out.print("Enter Service ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        
        // Get service details
        List<Service> all = dao.getAllServices();
        Service found = null;
        for (Service s : all) {
            if (s.getId() == id) {
                found = s;
                break;
            }
        }
        
        if (found == null) {
            System.out.println("Service not found!");
            return;
        }
        
        // Get customer details
        Customer cust = dao.getCustomerById(found.getCustomerId());
        if (cust == null) {
            System.out.println("Customer not found!");
            return;
        }
        
        // Print Invoice
        System.out.println("\n" + "=".repeat(50));
        System.out.println("              INVOICE");
        System.out.println("=".repeat(50));
        System.out.println("Garage Management System");
        System.out.println("----------------------------------------");
        System.out.println("Customer: " + cust.getName());
        System.out.println("Phone: " + cust.getPhone());
        System.out.println("Vehicle: " + cust.getVehicleNumber() + " (" + cust.getVehicleModel() + ")");
        System.out.println("----------------------------------------");
        System.out.println("Service Type: " + found.getServiceType());
        System.out.println("Date: " + found.getServiceDate());
        System.out.println("Status: " + found.getStatus());
        System.out.println("----------------------------------------");
        System.out.println("Total Amount: ₹" + found.getAmount());
        System.out.println("=".repeat(50));
        System.out.println("Thank you for choosing us!");
        System.out.println("=".repeat(50));
    }
}