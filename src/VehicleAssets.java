public class VehicleAssets {
    // vehicleID is an internal ID for the vehicle
    private String vehicleID;
    // licenceNumber is the official/legal ID of the vehicle
    private String licenceNumber;

    private String manufacturer;
    private String model;
    private boolean electric;
    private boolean hybrid;
    private boolean isBooked;
    private boolean inUse;

    public VehicleAssets(String vehicleID, String licenceNumber, String manufacturer, String model, boolean electric, boolean hybrid, boolean isBooked, boolean inUse) {
        setVehicleID(vehicleID);
        setLicenceNumber(licenceNumber);
        setManufacturer(manufacturer);
        setModel(model);
        setElectric(electric);
        setHybrid(hybrid);
        setBooked(isBooked);
        setInUse(inUse);
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean getElectric() {
        return electric;
    }

    public void setElectric(boolean electric) {
        this.electric = electric;
    }

    public boolean getHybrid(){
        return hybrid;
    }

    public void setHybrid(boolean hybrid){
        this.hybrid = hybrid;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public boolean isInUse() {
        return inUse;
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }

    public void printVehicle(){
        System.out.println("Manufacturer: " + this.getManufacturer() +
                "\nModel: " + this.getModel());
        if(this.isBooked){
            System.out.println("This vehicle is booked");
        } else if (this.isInUse()){
            System.out.println("This vehicle is on the road already");
        }
    }
}
