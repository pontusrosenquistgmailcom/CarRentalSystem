public class Truck extends VehicleAssets{
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
        System.out.print("ID: " + this.getVehicleID() + " | Manufacturer: " + this.getManufacturer() +
                " | Model: " + this.getModel() +
                " | Height: " + this.getHeight() + " m" +
                " | Capacity: " + this.getCarryCapacity() + " Kg");
        if (this.isInUse()) {
            System.out.print(" | This vehicle has been picked up by: " + this.getUser().getLastName());
        } else if (this.isBooked()) {
            System.out.print(" | This vehicle is booked by: " + this.getUser().getName());
        }
        System.out.println("");
    }
}
