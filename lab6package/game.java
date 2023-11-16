import java.util.Scanner;

public class game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user to input the name of the character
        System.out.print("Enter the name of the character: ");
        String characterName = scanner.nextLine();

        // Create a character and set its name
        Character2 character = new Character2();
        System.out.println(characterName + " has been created.");

        // Start the character in the Lobby
        Lobby lobby = new Lobby();
        character = lobby; // Move to the lobby

        // Main loop
        while (true) {
            // Display menu
            System.out.println("\n1. Feed\n2. Play\n3. Train\n4. Display Status\n5. Transfer Location\n6. Exit");
            System.out.print("Choose an action (1-6): ");

            // Get user input
            int choice = scanner.nextInt();

            // Perform the chosen action
            switch (choice) {
                case 1:
                    character.feed();
                    break;
                case 2:
                    character.play();
                    break;
                case 3:
                    character.train();
                    break;
                case 4:
                    displayStatus(character);
                    break;
                case 5:
                    System.out.println("\n1. Lobby\n2. Kitchen\n3. Playground\n4. Training Room");
                    System.out.print("Choose a location to transfer (1-4): ");
                    int locationChoice = scanner.nextInt();
                    character = transferLocation(locationChoice);
                    break;
                case 6:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please choose a number from 1 to 6.");
            }
        }
    }

    // Display the status of the character
    private static void displayStatus(Character2 character) {
        System.out.println("\nStatus:");
        System.out.println("Hunger: " + character.getHunger());
        System.out.println("Happiness: " + character.getHappiness());
        System.out.println("Train: " + character.getTrain());
    }

    // Transfer the character to a new location
    private static Character2 transferLocation(int locationChoice) {
        switch (locationChoice) {
            case 1:
                System.out.println("Transferring to Lobby");
                return new Lobby();
            case 2:
                System.out.println("Transferring to Kitchen");
                return new Kitchen();
            case 3:
                System.out.println("Transferring to Playground");
                return new Playground();
            case 4:
                System.out.println("Transferring to Training Room");
                return new TrainingRoom();
            default:
                System.out.println("Invalid location choice. Returning to Lobby.");
                return new Lobby();
        }
    }
}
