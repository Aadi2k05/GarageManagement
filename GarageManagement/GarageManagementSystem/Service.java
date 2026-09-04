import java.sql.Date;

public class Service {
    private int id;
    private int customerId;
    private String serviceType;
    private Date serviceDate;
    private String status;
    private double amount;
    
    public Service(int id, int customerId, String serviceType, Date serviceDate, String status, double amount) {
        this.id = id;
        this.customerId = customerId;
        this.serviceType = serviceType;
        this.serviceDate = serviceDate;
        this.status = status;
        this.amount = amount;
    }
    
   
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }
    
    public String getServiceType() { return serviceType; }
    public void setServiceType(String serviceType) { this.serviceType = serviceType; }
    
    public Date getServiceDate() { return serviceDate; }
    public void setServiceDate(Date serviceDate) { this.serviceDate = serviceDate; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    
    @Override
    public String toString() {
        return "Service ID: " + id + " | Customer ID: " + customerId + 
               " | Type: " + serviceType + " | Status: " + status + 
               " | ₹" + amount;
    }
}