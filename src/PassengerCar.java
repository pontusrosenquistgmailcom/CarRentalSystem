public class PassengerCar extends VehicleAssets{
    private int numberOfSeats;

    public PassengerCar(String vehicleID, String licenceNumber, String manufacturer, String model, boolean electric, boolean hybrid, boolean isBooked, boolean inUse, int numberOfSeats) {
        super(vehicleID, licenceNumber, manufacturer, model, electric, hybrid, isBooked, inUse);
        setNumberOfSeats(numberOfSeats);
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public void printVehicle() {
        System.out.print("Manufacturer: " + this.getManufacturer() +
                " | Model: " + this.getModel() +
                " | Seats: " + this.getNumberOfSeats());
        if (this.isBooked()) {
            System.out.print(" | This vehicle is booked by: " + this.getUser().getName());
        } else if (this.isInUse()) {
            System.out.print(" | This vehicle has been picked up by: " + this.getUser().getLastName());
        }
        System.out.println("");
    }
}
