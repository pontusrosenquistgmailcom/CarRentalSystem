public class MotorizedBike extends VehicleAssets{
    private double topSpeed;
    boolean hasSideCar;

    public MotorizedBike(String vehicleID, String licenceNumber, String manufacturer, String model, boolean electric, boolean hybrid, boolean isBooked, boolean inUse, double topSpeed, boolean hasSideCar) {
        super(vehicleID, licenceNumber, manufacturer, model, electric, hybrid, isBooked, inUse);
        this.topSpeed = topSpeed;
        this.hasSideCar = hasSideCar;
    }
}
