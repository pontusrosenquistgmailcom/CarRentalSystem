public class Truck extends VehicleAssets implements VehicleRenting{
    private double height;
    private int carryCapacity;


    public Truck(int vehicleID, String licenceNumber, String manufacturer, String model, double height, int carryCapacity) {
        super(vehicleID, licenceNumber, manufacturer, model);
        setHeight(height);
        setCarryCapacity(carryCapacity);
    }


    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getCarryCapacity() {
        return carryCapacity;
    }

    public void setCarryCapacity(int carryCapacity) {
        this.carryCapacity = carryCapacity;
    }

    @Override
    public void printVehicle() {
        super.printVehicle();
        System.out.print(" | Height: " + this.getHeight() + " m" +
                " | Capacity: " + this.getCarryCapacity() + " Kg");
        if (this.isInUse()) {
            System.out.println(" | This truck has been picked up by: " + this.getUser().getFullName());
        } else if (this.isBooked()) {
            System.out.println(" | This truck is booked by: " + this.getUser().getFullName());
        } else {
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
