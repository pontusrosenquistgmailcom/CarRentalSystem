public class MotorizedBike extends VehicleAssets implements VehicleRenting{
    private double topSpeed;
    private boolean hasSideCar;

    public MotorizedBike(int vehicleID, String licenceNumber, String manufacturer, String model, double topSpeed, boolean hasSideCar) {
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
        System.out.print("ID: " + this.getVehicleID() + " | Manufacturer: " + this.getManufacturer() +
                " | Model: " + this.getModel() +
                " | Top Speed: " + this.getTopSpeed() + " Km/h" +
                " | Sidecar: ");
        if(hasSideCar()){
            System.out.print("Yes");
        } else {
            System.out.print("No");
        }
        if (this.isInUse()) {
            System.out.print(" | This vehicle has been picked up by: " + this.getUser().getLastName());
        } else if (this.isBooked()) {
            System.out.print(" | This vehicle is booked by: " + this.getUser().getFullName());
        }
        System.out.println("");
    }



    @Override
    public boolean bookVehicle(Members m) {
        if(m.getAge() >= 24){
            this.setBooked(true);
            this.setUser(m);
            return true;
        } else {
            return false;
        }
    }
}
