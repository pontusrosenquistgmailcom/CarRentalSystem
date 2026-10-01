public class Truck extends VehicleAssets{
    private double height;
    private int carryCapacity;


    public Truck(String vehicleID, String licenceNumber, String manufacturer, String model, boolean electric, boolean hybrid, boolean isBooked, boolean inUse, double height, int carryCapacity) {
        super(vehicleID, licenceNumber, manufacturer, model, electric, hybrid, isBooked, inUse);
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
        System.out.print("Manufacturer: " + this.getManufacturer() +
                " | Model: " + this.getModel() +
                " | Height: " + this.getHeight() + " m" +
                " | Capacity: " + this.getCarryCapacity() + " Kg");
        if (this.isBooked()) {
            System.out.print(" | This vehicle is booked by: " + this.getUser().getName());
        } else if (this.isInUse()) {
            System.out.print(" | This vehicle has been picked up by: " + this.getUser().getLastName());
        }
        System.out.println("");
    }
}
