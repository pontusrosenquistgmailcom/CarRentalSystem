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
    private Members user;

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
        if (vehicleID == null || vehicleID.isBlank()) {
            throw new IllegalArgumentException("ERROR: vehicleID cannot be blank");
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
        System.out.print("Manufacturer: " + this.getManufacturer() +
                " | Model: " + this.getModel());
        if (this.isBooked) {
            System.out.print(" | This vehicle is booked by: " + this.user.getName());
        } else if (this.isInUse()) {
            System.out.print(" | This vehicle has been picked up by: " + this.user.getLastName());
        }
        System.out.println("");
    }

    public void bookVehicle(Members m) {
        this.setBooked(true);
        this.user = m;
    }

    public void returnVehicle() {
        this.setBooked(false);
        this.user = null;
    }
}
