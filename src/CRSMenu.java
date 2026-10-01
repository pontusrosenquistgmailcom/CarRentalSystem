import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CRSMenu {

    private void displayInventory(ArrayList<VehicleAssets> inv, int displaySort){

        // 0 = display all
        // 1 = display available for booking (hide isBooked & inUse)
        // 2 = display all isBooked, for collection
        // 3 = display inUse for return
        switch(displaySort){
            // 0 = display ALL
            case 0:
                for(VehicleAssets v : inv){
                    v.printVehicle();
                }
                break;
            // 1 show available for booking
            case 1:
                for(VehicleAssets v : inv){
                    if(!v.isInUse() && !v.isBooked()) {
                        v.printVehicle();
                    }
                }
                break;
            // 2 show booked for pickup
            case 2:
                for(VehicleAssets v : inv){
                    if(v.isBooked()) {
                        v.printVehicle();
                    }
                }
                break;
            // 3 show inUse for return
            case 3:
                for(VehicleAssets v : inv){
                    if (v.isInUse()){
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

        inventory.add(new VehicleAssets("01","ABC123","Volvo","Firebird", true, false, false, false));
        inventory.add(new VehicleAssets("02","UFT901","Toyota","Ultra", true, true, false, false));
        inventory.add(new VehicleAssets("03","LYX099","Mercedes","Crawler",false,false,false,false));

        members.add(new Members(0,"Pontus","Rosenquist"));

        inventory.getLast().bookVehicle(members.getFirst());


        int userChoice;
        boolean keepRunning = true;
        do {
            this.displayMenu();
            userChoice = this.acceptUserMenuInput();
            //debug printLine info dump. move acceptUserMenuInput into switch condition
            System.out.println("Selected: " + userChoice);

            switch (userChoice) {
                case 1:
                    System.out.println("implement book vehicle");
                    displayInventory(inventory, 1);
                    break;
                case 2:
                    System.out.println("imprelent retrieve vehicle");
                    displayInventory(inventory, 2);
                    break;
                case 3:
                    System.out.println("omplement return vehicle");
                    displayInventory(inventory,3);
                    break;
                case 4:
                    System.out.println("make add/remove vehicle");
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
                if (strUserInput.toLowerCase().matches("e") || strUserInput.toLowerCase().matches("x") || strUserInput.toLowerCase().matches("exit")) {
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




}
