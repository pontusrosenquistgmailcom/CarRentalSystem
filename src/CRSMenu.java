import java.util.InputMismatchException;
import java.util.Scanner;

public class CRSMenu {

    public void run(){
        int userChoice;
        boolean keepRunning = true;
        do {
            this.displayMenu();
            userChoice = this.acceptUserMenuInput();

            System.out.println("Selected: " + userChoice);
            if(userChoice == 5){
                keepRunning = false;
                System.out.println("Exiting program...");
            }

        } while (keepRunning);
    }

    public void displayMenu(){
        System.out.println("Welcome to the Ride Rental system!");
        System.out.println("1. Book ride" +
                "\n2. Retrieve ride" +
                "\n3. Return ride" +
                "\n4. Manage inventory" +
                "\n5. Exit program");
    }

    public int acceptUserMenuInput(){
        Scanner scanner = new Scanner(System.in);

        try{
            int userInput = scanner.nextInt();

            return userInput;

        } catch (InputMismatchException e) {

            try{
                String strUserInput = scanner.nextLine();
                if(strUserInput.matches("e") || strUserInput.matches("x") || strUserInput.matches("exit")){
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
