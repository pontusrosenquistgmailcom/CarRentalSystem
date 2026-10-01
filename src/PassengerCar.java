public class PassengerCar extends VehicleAssets{
    private int numberOfSeats;

    public PassengerCar(String vehicleID, String licenceNumber, String manufacturer, String model, boolean electric, boolean hybrid, boolean isBooked, boolean inUse, int numberOfSeats) {
        super(vehicleID, licenceNumber, manufacturer, model, electric, hybrid, isBooked, inUse);
        this.numberOfSeats = numberOfSeats;
    }
}
