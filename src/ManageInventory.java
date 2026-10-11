//menus inside menus
//creating this might have been a mistake...

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ManageInventory {
    public static void managementMenu(ArrayList<VehicleAssets> assets){
        System.out.println("CRS Manage Inventory options:\n1: add new vehicle asset.\n2: edit vehicle asset.\n3: remove vehicle asset.\n4: Return to Main menu");

        System.out.print("Select option: ");
        int userInputInt = getUserInputInt();

        switch(userInputInt){
            // add new
            case 1:
                newVehicle(assets);
                break;
            // edit existing
            case 2:
                printAllAssets(assets);
                System.out.println("COMMING SOON...");
                break;
            // remove
            case 3:
                removeVehicleAsset(assets);
                break;
            default:
                System.out.println("\u001B[33mCANCEL\u001B[0m: Returning to Main Menu.");
                break;
        }

    }

    private static void printAllAssets(ArrayList<VehicleAssets> assets){
        for(VehicleAssets v : assets){
            v.printVehicle();
        }
    }

    private static void removeVehicleAsset(ArrayList<VehicleAssets> assets){
        while (true) {
            printAllAssets(assets);
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter vehicleID for DELETION: ");
            try {
                int userInput = scanner.nextInt();
                if(assets.removeIf(v -> v.getVehicleID() == userInput)){
                    System.out.println("Asset successfully deleted.");
                    return;
                }else {
                    System.out.println("ERROR: No matching vehicle ID");
                }

            } catch (InputMismatchException e) {
                String userInputString = scanner.nextLine();
                if (userInputString.equalsIgnoreCase("cancel") || userInputString.equalsIgnoreCase("x")) {
                    //System.out.println("user input : " + userInputString + " returning NULL");
                    return;
                }
                System.out.println("ERROR: incorrect input format.");

            }
        }


    }

    public static void newVehicle(ArrayList<VehicleAssets> assets) {

        int newVehicleID = assets.size();

        boolean match;
        do {
            match = false;
            newVehicleID++;
            //System.out.println("New vehicleID: " + newVehicleID);
            for (VehicleAssets v : assets) {
                if (v.getVehicleID() == newVehicleID) {
                    match = true;
                    break;
                }
            }

        } while (match);

        System.out.println("""
                1. Passenger Car
                2. Truck
                3. Motorized Bike
                4. Return to Main menu""");
        System.out.print("Select vehicle type (1-3): ");
        int userInputInt = getUserInputInt();
        if (userInputInt < 1 || userInputInt > 3) {
            System.out.println("\u001B[33mCANCEL\u001B[0m: Returning to Main Menu.");
            return;
        }

        System.out.print("Enter vehicle license number: ");
        String newLicenseNumber = getUserinputString();
        if (newLicenseNumber == null) {
            System.out.println("\u001B[33mCANCEL\u001B[0m: Returning to Main Menu.");
            return;
        }


        System.out.print("Enter vehicle manufacturer: ");
        String newManufacturer = getUserinputString();
        if (newManufacturer == null) {
            System.out.println("\u001B[33mCANCEL\u001B[0m: Returning to Main Menu.");
            return;
        }

        System.out.print("Enter vehicle Model: ");
        String newModel = getUserinputString();
        if (newModel == null) {
            System.out.println("\u001B[33mCANCEL\u001B[0m: Returning to Main Menu.");
            return;
        }

        switch (userInputInt) {
            case 1:
                System.out.print("Enter number of seats(int): ");
                int newNumberOfSeats = getUserInputInt();
                if (newNumberOfSeats < 0) {
                    System.out.println("\u001B[33mCANCEL\u001B[0m: Returning to Main Menu.");
                    return;
                }
                assets.add(new PassengerCar(newVehicleID, newLicenseNumber, newManufacturer, newModel,newNumberOfSeats));
                break;
            case 2:
                System.out.print("Enter truck height (double, m): ");
                double newTruckHeight = getUserInputDouble();
                if (newTruckHeight < 0) {
                    System.out.println("\u001B[33mCANCEL\u001B[0m: Returning to Main Menu.");
                    return;
                }
                System.out.print("Enter truck carry capacity (int, Kg): ");
                int newTruckCarry = getUserInputInt();
                if (newTruckCarry < 0) {
                    System.out.println("\u001B[33mCANCEL\u001B[0m: Returning to Main Menu.");
                    return;
                }
                assets.add(new Truck(newVehicleID, newLicenseNumber, newManufacturer, newModel,newTruckHeight, newTruckCarry));
                break;
            case 3:
                System.out.print("Enter bike top speed (double, Km/h): ");
                double newTopSpeed = getUserInputDouble();
                if (newTopSpeed < 0) {
                    System.out.println("\u001B[33mCANCEL\u001B[0m: Returning to Main Menu.");
                    return;
                }
                System.out.print("Does the bike have a sidecar (boolean, y/n):");
                boolean newSideCar = getUserInputBoolean();
                assets.add(new MotorizedBike(newVehicleID, newLicenseNumber, newManufacturer, newModel, newTopSpeed, newSideCar));
                break;
            default:
                break;
        }


    }

    private static int getUserInputInt() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                int input = scanner.nextInt();
                if (input >= 0) {
                    return input;
                } else {
                    System.out.println("Please provide a positive integer.");
                }
            } catch (InputMismatchException e) {
                String inputStr = scanner.nextLine();
                if (inputStr.equalsIgnoreCase("cancel") || inputStr.equalsIgnoreCase("x")) {
                    return -1;
                }
                System.out.println("Please provide a positive integer.");
            }
        }
    }

    private static double getUserInputDouble() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                double input = scanner.nextDouble();
                if (input >= 0) {
                    return input;
                } else {
                    System.out.println("Please provide a positive double.");
                }
            } catch (InputMismatchException e) {
                String inputStr = scanner.nextLine();
                if (inputStr.equalsIgnoreCase("cancel") || inputStr.equalsIgnoreCase("x")) {
                    return -1.0;
                }
                System.out.println("Please provide a positive double.");
            }
        }
    }

    private static String getUserinputString() {
        while (true) {
            Scanner scanner = new Scanner(System.in);

            String input = scanner.nextLine();
            if (input.trim().isBlank()) {
                System.out.println("Blank input data disallowed");
                continue;
            }
            if (input.equalsIgnoreCase("cancel") || input.equalsIgnoreCase("x")) {
                return null;
            }
            return input;

        }
    }

    private static boolean getUserInputBoolean() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("y");
    }


}
