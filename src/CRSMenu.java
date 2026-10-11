import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CRSMenu {

    private void displayInventory(ArrayList<VehicleAssets> inv, int displaySort) {

        // 0 = display all
        // 1 = display available for booking (hide isBooked & inUse)
        // 2 = display all isBooked, for collection
        // 3 = display inUse for return
        switch (displaySort) {
            // 0 = display ALL
            case 0:
                for (VehicleAssets v : inv) {
                    v.printVehicle();
                }
                break;
            // 1 show available for booking
            case 1:
                for (VehicleAssets v : inv) {
                    if (!v.isInUse() && !v.isBooked()) {
                        v.printVehicle();
                    }
                }
                break;
            // 2 show booked for pickup
            case 2:
                for (VehicleAssets v : inv) {
                    if (v.isBooked()) {
                        v.printVehicle();
                    }
                }
                break;
            // 3 show inUse for return
            case 3:
                for (VehicleAssets v : inv) {
                    if (v.isInUse()) {
                        v.printVehicle();
                    }
                }
                break;
            default:
                // you should not end up here!
                System.out.println("CRSMenu displayInventory: DEFAULT");
                break;
        }
    }

    public void run() {

        ArrayList<VehicleAssets> inventory = new ArrayList<>();
        ArrayList<Members> members = new ArrayList<>();

        members.add(new Members(1, "Pontus", "Rosenquist"));

        inventory.add(new VehicleAssets(1, "ABC123", "Volvo", "Firebird", true, false, false, false));
        inventory.add(new VehicleAssets(2, "UFT901", "Toyota", "Ultra", true, true, false, false));
        inventory.add(new VehicleAssets(3, "LYX099", "Mercedes", "Crawler", false, false, false, false));
        inventory.add(new PassengerCar(4, "AAR009", "Opel", "Astra", true, true, false, false, 5));
        inventory.add(new Truck(5, "TRY999", "BYD", "XTK", true, false, false, false, 2.15, 2000));
        inventory.add(new MotorizedBike(6, "GAM", "Harley-Davidsson", "Extra", false, false, false, false, 190.5, false));


        inventory.getLast().bookVehicle(members.getFirst());


        int userChoice;
        boolean keepRunning = true;
        do {
            this.displayMenu();
            userChoice = this.acceptUserMenuInput();
            //debug printLine info dump. move acceptUserMenuInput into switch condition
            System.out.println("Selected: " + userChoice);

            switch (userChoice) {
                // HERE WE SELECT A VEHICLE AND A USER FOR BOOKING
                case 1:
                    while (true) {
                        System.out.println("Vehicles available for booking: ");
                        displayInventory(inventory, 1);

                        VehicleAssets vehicle = selectVehicle(inventory);
                        if (vehicle == null) {
                            System.out.println("CANCEL: Returning to Main menu.");
                            break;
                        }

                        Members member = searchSelectMembers(members);
                        if (member == null) {
                            System.out.println("CANCEL: returning to vehicle selection.");
                            continue;
                        }

                        System.out.println("Vehicle selected: [" + vehicle.getLicenceNumber() + "] " + vehicle.getManufacturer() + " " + vehicle.getModel());
                        System.out.println("Member selected: " + member.getFullName());
                        vehicle.printVehicle();
                        member.printUserInfo();

                        // DO THE BOOKING
                        vehicle.bookVehicle(member);
                        System.out.println("Booking successful!");
                        break;
                    }
                    break;
                case 2:
                    System.out.println("Vehicles available for pickup: ");
                    displayInventory(inventory, 2);
                    break;
                case 3:
                    System.out.println("Vehicles available for return");
                    displayInventory(inventory, 3);
                    break;
                case 4:
                    System.out.println("todo. implement add/remove vehicle");
                    displayInventory(inventory, 0);
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

    private void displayMenu() {
        System.out.println("Welcome to the Ride Rental system!");
        System.out.println("1. Book ride" +
                "\n2. Retrieve ride" +
                "\n3. Return ride" +
                "\n4. Manage inventory" +
                "\n5. Exit program");
    }

    private int acceptUserMenuInput() {
        Scanner scanner = new Scanner(System.in);

        try {
            int userInput = scanner.nextInt();

            return userInput;

        } catch (InputMismatchException e) {

            try {
                String strUserInput = scanner.nextLine();
                if (strUserInput.toLowerCase().matches("q") || strUserInput.toLowerCase().matches("x") || strUserInput.toLowerCase().matches("exit")) {
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
        boolean doIt = true;
        while (doIt) {
            System.out.println("enter userID to select member or search for user by name");

            Members selectedUser = null;
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
                    return null;
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


    private VehicleAssets selectVehicle(ArrayList<VehicleAssets> vehicles) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter vehicle ID to select vehicle: ");

            try {
                int userInput = scanner.nextInt();
                for (VehicleAssets v : vehicles) {
                    if (v.getVehicleID() == userInput) {
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
