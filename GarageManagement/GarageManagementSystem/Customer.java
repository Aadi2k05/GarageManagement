public class Customer {
    private int id;
    private String name;
    private String phone;
    private String vehicleNumber;
    private String vehicleModel;
    
   
    public Customer(int id, String name, String phone, String vehicleNumber, String vehicleModel) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.vehicleNumber = vehicleNumber;
        this.vehicleModel = vehicleModel;
    }
    
    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    
    public String getVehicleNumber() { return vehicleNumber; }
    public void setVehicleNumber(String vehicleNumber) { this.vehicleNumber = vehicleNumber; }
    
    public String getVehicleModel() { return vehicleModel; }
    public void setVehicleModel(String vehicleModel) { this.vehicleModel = vehicleModel; }
    
    @Override
    public String toString() {
        return "ID: " + id + " | " + name + " | " + phone + " | Car: " + vehicleNumber + " (" + vehicleModel + ")";
    }
}