import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CRSMenu {

// "main" program loop.
    public void run() {

        ArrayList<VehicleAssets> inventory = new ArrayList<>();
        ArrayList<Members> members = new ArrayList<>();

        //preprogrammed members and vehicles
        members.add(new Members(1, "Pontus", "Rosenquist", 36));
        members.add(new Members(2, "Baltazar", "Andersson", 19));

        inventory.add(new PassengerCar(1, "ABC123", "Volvo", "Firebird", 4));
        inventory.add(new PassengerCar(2, "UFT901", "Toyota", "Ultra", 4));
        inventory.add(new Truck(3, "LYX099", "Mercedes", "Crawler", 3.35, 4500));
        inventory.add(new PassengerCar(4, "AAR009", "Opel", "Astra", 5));
        inventory.add(new Truck(5, "TRY999", "BYD", "XTK", 2.15, 2000));
        inventory.add(new MotorizedBike(6, "GAM", "Harley-Davidsson", "Extra", 190.5, false));


        VehicleAssets vehicle;
        int i;
        int userChoice;
        boolean keepRunning = true;
        do {
            this.displayMenu();
            userChoice = acceptUserMenuInput();
            //debug printLine info dump. move acceptUserMenuInput into switch condition
            //System.out.println("Selected: " + userChoice);

            switch (userChoice) {
                // HERE WE SELECT A VEHICLE AND A USER FOR BOOKING
                case 1:
                    while (true) {
                        System.out.println("Vehicles available for booking: ");
                        i = displayInventory(inventory, 1);
                        if (i == 0) {
                            System.out.println("\u001B[33mAll vehicles are currently unavailable and cannot be booked\u001B[0m");
                            break;
                        }

                        vehicle = selectVehicleForBooking(inventory);
                        if (vehicle == null) {
                            System.out.println("\u001B[33mCANCEL\u001B[0m: Returning to Main menu.");
                            break;
                        }

                        Members member = searchSelectMembers(members);
                        if (member == null) {
                            System.out.println("\u001B[33mCANCEL\u001B[0m: returning to vehicle selection.");
                            continue;
                        }

                        System.out.println("Vehicle selected: [" + vehicle.getLicenceNumber() + "] " + vehicle.getManufacturer() + " " + vehicle.getModel());
                        System.out.println("Member selected: " + member.getFullName());
                        vehicle.printVehicle();
                        member.printUserInfo();

                        // DO THE BOOKING
                        if(vehicle.bookVehicle(member)){
                            System.out.println("Booking successful!");
                        } else {
                            System.out.println( member.getFullName() + " cannot rent that vehicle!");
                        }
                        break;
                    }
                    break;
                case 2:
                    System.out.println("Vehicles available for pickup: ");
                    i = displayInventory(inventory, 2);
                    if (i == 0) {
                        System.out.println("\u001B[33mThere are no booked vehicles.\u001B[0m");
                        break;
                    }
                    vehicle = selectVehicleForPickUp(inventory);
                    if (vehicle == null) {
                        System.out.println("\u001B[33mCANCEL\u001B[0m: Returning to main menu.");
                        break;
                    }
                    vehicle.pickUpVehicle();
                    System.out.println("[" + vehicle.getLicenceNumber() + "] " + vehicle.getManufacturer() + " " + vehicle.getModel() + " successfully delivered to customer");
                    break;
                case 3:
                    System.out.println("Vehicles available for return");
                    i = displayInventory(inventory, 3);
                    if (i == 0) {
                        System.out.println("\u001B[33mThere are no vehicles to return!\u001B[0m");
                        break;
                    }
                    vehicle = selectVehicleForReturn(inventory);
                    if (vehicle == null) {
                        System.out.println("\u001B[33mCANCEL\u001B[0m: Returning to Main menu.");
                        break;
                    }
                    vehicle.returnVehicle();
                    System.out.println("[" + vehicle.getLicenceNumber() + "] returned successfully.");
                    break;
                case 4:
                    //System.out.println("todo. implement add/remove vehicle");
                    //displayInventory(inventory, 0);
                    ManageInventory.managementMenu(inventory);
                    break;
                case 5:
                    keepRunning = false;
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Please select option 1-5!");
                    break;
            }


        } while (keepRunning);
    }

    private int displayInventory(ArrayList<VehicleAssets> inv, int displaySort) {
        int counter = 0;
        // 0 = display all
        // 1 = display available for booking (hide isBooked & inUse)
        // 2 = display all isBooked, for collection
        // 3 = display inUse for return
        switch (displaySort) {
            // 0 = display ALL
            case 0:
                for (VehicleAssets v : inv) {
                    v.printVehicle();
                    counter++;
                }
                break;
            // 1 show available for booking
            case 1:
                for (VehicleAssets v : inv) {
                    if (!v.isInUse() && !v.isBooked()) {
                        v.printVehicle();
                        counter++;
                    }
                }
                break;
            // 2 show booked for pickup
            case 2:
                for (VehicleAssets v : inv) {
                    if (v.isBooked() && !v.isInUse()) {
                        v.printVehicle();
                        counter++;
                    }
                }
                break;
            // 3 show inUse for return
            case 3:
                for (VehicleAssets v : inv) {
                    if (v.isInUse()) {
                        v.printVehicle();
                        counter++;
                    }
                }
                break;
            default:
                // you should not end up here!
                System.out.println("CRSMenu displayInventory: DEFAULT");
                break;
        }
        return counter;
    }

    private void displayMenu() {
        System.out.println("Welcome to the Car Rental System!");
        System.out.println("""
                1. Book ride
                2. Retrieve ride
                3. Return ride
                4. Manage inventory
                5. Exit program""");
    }

    public static int acceptUserMenuInput() {
        Scanner scanner = new Scanner(System.in);

        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {

            try {
                String strUserInput = scanner.nextLine();
                if (strUserInput.equalsIgnoreCase("q") || strUserInput.equalsIgnoreCase("x") || strUserInput.toLowerCase().matches("exit")) {
                    return 5;
                }
            } catch (Exception e2) {
                System.out.println("Error: Incorrect user input. please use numbers!");
                return 0;
            }

            System.out.println("Error: Incorrect user input. please use numbers!");
            return 0;
        }

    }


    // search for and select user loop returns Members object, on user CANCEL returns NULL
    private Members searchSelectMembers(ArrayList<Members> members) {
        while (true) {
            System.out.println("enter userID to select member or search for user by name");

            Scanner scanner = new Scanner(System.in);

            try {
                int uID = scanner.nextInt();
                //System.out.println("you entered (INT): " + uID);

                for (Members m : members) {
                    if (m.getUserID() == uID) {
                        return m;
                    }
                }
                //no matching user found, keep looping with user text ERROR feedback
                System.out.println("ERROR: userID mismatch. Please enter an existing userID.");
            } catch (InputMismatchException e) {
                String name = scanner.nextLine();


                //System.out.println("you entered (STRING): " + name);
                if (name.equalsIgnoreCase("new")) {
                    System.out.println("to do: IMPLEMENT NEW USER WORKFLOW HERE---");
                } else if (name.equalsIgnoreCase("cancel") || name.equalsIgnoreCase("x")) {
                    break;
                }
                System.out.println("Listing matching Members: ");
                for (Members m : members) {
                    if (m.getFullName().toLowerCase().contains(name.toLowerCase())) {
                        m.printUserInfo();
                    }
                }
            }
            //System.out.println("No user was selected.");
        }
        return null;
    }

    // select vehicle that is available for booking. on user CANCEL returns NULL
    private VehicleAssets selectVehicleForBooking(ArrayList<VehicleAssets> vehicles) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter vehicleID to select vehicle for booking: ");

            try {
                int userInput = scanner.nextInt();
                for (VehicleAssets v : vehicles) {
                    if (v.getVehicleID() == userInput) {

                        if (v.isBooked() || v.isInUse()) {
                            System.out.println("ID: [" + userInput + "] vehicle \u001B[31mis not available\u001B[0m.");
                            break;
                        }
                        return v;
                    }
                }
                System.out.println("ERROR: No matching vehicle ID");

            } catch (InputMismatchException e) {
                String userInputString = scanner.nextLine();
                if (userInputString.equalsIgnoreCase("cancel") || userInputString.equalsIgnoreCase("x")) {
                    //System.out.println("user input : " + userInputString + " returning NULL");
                    return null;
                }
                System.out.println("ERROR: incorrect input format.");

            }
        }

    }

    private VehicleAssets selectVehicleForPickUp(ArrayList<VehicleAssets> vehicles) {

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter vehicleID to select vehicle for pick up: ");

            try {
                int userInput = scanner.nextInt();
                for (VehicleAssets v : vehicles) {
                    if (v.getVehicleID() == userInput) {

                        if (!v.isBooked() || v.isInUse()) {
                            System.out.println("ID: [" + userInput + "] vehicle \u001B[31mis not available\u001B[0m for pick up.");
                            break;
                        }
                        return v;
                    }
                }
                System.out.println("ERROR: No matching vehicle ID");

            } catch (InputMismatchException e) {
                String userInputString = scanner.nextLine();
                if (userInputString.equalsIgnoreCase("cancel") || userInputString.equalsIgnoreCase("x")) {
                    //System.out.println("user input : " + userInputString + " returning NULL");
                    return null;
                }
                System.out.println("ERROR: incorrect input format.");

            }
        }

    }

    private VehicleAssets selectVehicleForReturn(ArrayList<VehicleAssets> vehicles) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter vehicleID to select vehicle for return: ");

            try {
                int userInput = scanner.nextInt();
                for (VehicleAssets v : vehicles) {
                    if (v.getVehicleID() == userInput && v.isInUse()) {
                        return v;
                    }
                }
                System.out.println("ERROR: No matching vehicle ID");

            } catch (InputMismatchException e) {
                String userInputString = scanner.nextLine();
                if (userInputString.equalsIgnoreCase("cancel") || userInputString.equalsIgnoreCase("x")) {
                    //System.out.println("user input : " + userInputString + " returning NULL");
                    return null;
                }
                System.out.println("ERROR: incorrect input format.");

            }
        }

    }


}
