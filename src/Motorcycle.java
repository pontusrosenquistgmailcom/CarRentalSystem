public class Motorcycle extends VehicleAssets implements VehicleRenting {
    private double topSpeed;
    private boolean hasSideCar;

    public Motorcycle(int vehicleID, String licenceNumber, String manufacturer, String model, double topSpeed, boolean hasSideCar) {
        super(vehicleID, licenceNumber, manufacturer, model);
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
        super.printVehicle();
        System.out.print(" | Top Speed: " + this.getTopSpeed() + " Km/h" +
                " | Sidecar: ");
        if (hasSideCar()) {
            System.out.print("Yes");
        } else {
            System.out.print("No");
        }
        if (this.isInUse()) {
            System.out.println(" | This motorcycle has been picked up by: " + this.getUser().getLastName());
        } else if (this.isBooked()) {
            System.out.println(" | This motorcycle is booked by: " + this.getUser().getFullName());
        } else {
            System.out.println();
        }
    }

    @Override
    public boolean bookVehicle(Members m) {
        if (m.getAge() >= 24) {
            this.setBooked(true);
            this.setUser(m);
            return true;
        } else {
            System.out.println("Customer: " + m.getFullName() + " is too young to rent a motorcycle.");
            return false;
        }
    }

    @Override
    public void pickUpVehicle() {
        super.pickUpVehicle();
    }

    @Override
    public void returnVehicle() {
        super.returnVehicle();
    }

}
