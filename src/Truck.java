public class Truck extends VehicleAssets{
    private double height;
    private int carryCapacity;


    public Truck(String vehicleID, String licenceNumber, String manufacturer, String model, boolean electric, boolean hybrid, boolean isBooked, boolean inUse, double height, int carryCapacity) {
        super(vehicleID, licenceNumber, manufacturer, model, electric, hybrid, isBooked, inUse);
        this.height = height;
        this.carryCapacity = carryCapacity;
    }
}
