import java.util.ArrayList;

public class PassengerCar extends VehicleAssets implements VehicleRenting {
    private int numberOfSeats;

    public PassengerCar(int vehicleID, String licenceNumber, String manufacturer, String model, int numberOfSeats) {
        super(vehicleID, licenceNumber, manufacturer, model);
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
        super.printVehicle();
        System.out.print(" | Seats: " + this.getNumberOfSeats());
        if (this.isInUse()) {
            System.out.println(" | This car has been picked up by: " + this.getUser().getFullName());
        } else if (this.isBooked()) {
            System.out.println(" | This car is booked by: " + this.getUser().getFullName());
        } else{
            System.out.println();
        }
    }

    @Override
    public boolean bookVehicle(Members m) {
        this.setBooked(true);
        this.setUser(m);
        return true;
    }
}
