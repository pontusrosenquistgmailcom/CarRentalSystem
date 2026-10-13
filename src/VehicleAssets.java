public class VehicleAssets implements VehicleRenting{
    // vehicleID is an internal ID for the vehicle
    private int vehicleID;
    // licenceNumber is the official/legal ID of the vehicle
    private String licenceNumber;

    private String manufacturer;
    private String model;
    private boolean electric;
    private boolean hybrid;
    private boolean isBooked;
    private boolean inUse;
    private Members user;

    public VehicleAssets(int vehicleID, String licenceNumber, String manufacturer, String model) {
        setVehicleID(vehicleID);
        setLicenceNumber(licenceNumber);
        setManufacturer(manufacturer);
        setModel(model);
        setElectric(false);
        setHybrid(false);
        setBooked(false);
        setInUse(false);
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        if (vehicleID < 1) {
            throw new IllegalArgumentException("ERROR: vehicleID must be positive integer");
        }
        this.vehicleID = vehicleID;
    }

    public String getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(String licenceNumber) {
        if (licenceNumber == null || licenceNumber.isBlank()) {
            throw new IllegalArgumentException("ERROR: licenseNumber cannot be blank.");
        }
        this.licenceNumber = licenceNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        if (manufacturer == null || manufacturer.isBlank()) {
            throw new IllegalArgumentException("ERROR: manufacturer cannot be blank.");
        }
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (model == null || model.isBlank()) {
            throw new IllegalArgumentException("ERROR: model cannot be blank.");
        }
        this.model = model;
    }

    public boolean getElectric() {
        return electric;
    }

    public void setElectric(boolean electric) {
        this.electric = electric;
    }

    public boolean getHybrid() {
        return hybrid;
    }

    public void setHybrid(boolean hybrid) {
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

    public void printVehicle() {
        printDefaultInfo();
        //printConditionalInfo();
    }

    //maybe split print to make it less copied code?? idk
    private void printDefaultInfo() {
        System.out.print("ID: " + this.getVehicleID() + " | Manufacturer: " + this.getManufacturer() +
                " | Model: " + this.getModel());
    }

    private void printConditionalInfo(){
        if (this.isInUse()) {
            System.out.print(" | This vehicle has been picked up by: " + this.getUser().getFullName());
        } else if (this.isBooked()) {
            System.out.print(" | This vehicle is booked by: " + this.getUser().getFullName());
        }
        System.out.println("");
    }

    public void setUser(Members member){
        this.user = member;
    }

    public Members getUser(){
        return this.user;
    }

    public boolean bookVehicle(Members m) {
        this.setBooked(true);
        this.user = m;
        return true;
    }

    public void returnVehicle() {
        this.setBooked(false);
        this.setInUse(false);
        this.user = null;
    }
    public void pickUpVehicle(){
        this.setInUse(true);
    }
}


