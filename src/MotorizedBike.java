public class MotorizedBike extends VehicleAssets{
    private double topSpeed;
    private boolean hasSideCar;

    public MotorizedBike(String vehicleID, String licenceNumber, String manufacturer, String model, boolean electric, boolean hybrid, boolean isBooked, boolean inUse, double topSpeed, boolean hasSideCar) {
        super(vehicleID, licenceNumber, manufacturer, model, electric, hybrid, isBooked, inUse);
        setTopSpeed(topSpeed);
        setHasSideCar(hasSideCar);
    }

    public double getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(double topSpeed) {
        this.topSpeed = topSpeed;
    }

    public boolean hasSideCar() {
        return hasSideCar;
    }

    public void setHasSideCar(boolean hasSideCar) {
        this.hasSideCar = hasSideCar;
    }
    @Override
    public void printVehicle() {
        System.out.print("Manufacturer: " + this.getManufacturer() +
                " | Model: " + this.getModel() +
                " | Top Speed: " + this.getTopSpeed() + " Km/h" +
                " | Sidecar: ");
        if(hasSideCar()){
            System.out.print("Yes");
        } else {
            System.out.print("No");
        }
        if (this.isBooked()) {
            System.out.print(" | This vehicle is booked by: " + this.getUser().getName());
        } else if (this.isInUse()) {
            System.out.print(" | This vehicle has been picked up by: " + this.getUser().getLastName());
        }
        System.out.println("");
    }
}
