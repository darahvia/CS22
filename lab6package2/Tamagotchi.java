import java.util.Scanner;

public class Tamagotchi {

    public static void main(String[] args) {
        Tamagotchi tamagotchi = new Tamagotchi();
        tamagotchi.on();
    }

    public void on() {
        Scanner scanner = new Scanner(System.in);
        boolean gameOn = true;

        System.out.print("Name your player: ");
        String characterName = scanner.nextLine();
        Character character = new Lobby(characterName);
        System.out.println(characterName + " has been created");

        while (gameOn) {
            System.out.print("What do you want to do? ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "feed":
                case "play":
                case "train":
                    character.performAction();
                    break;
                case "display status":
                    displayStatus(character);
                    break;
                case "transfer location":
                    System.out.print("Choose a location (lobby, kitchen, playground, training room): ");
                    String locationChoice = scanner.nextLine();
                    character = transferLocation(locationChoice, characterName);
                    break;
                case "exit":
                    System.out.println("Exiting game. Adios amigo!");
                    gameOn = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void displayStatus(Character character) {
        System.out.println("Status");
        System.out.println("Hunger: " + character.getHunger());
        System.out.println("Happiness: " + character.getHappiness());
        System.out.println("Training: " + character.getTrain());
    }

    private static Character transferLocation(String transferLocation, String characterName) {
        switch (transferLocation) {
            case "lobby":
                System.out.println(characterName + " is transferring to Lobby");
                return new Lobby(characterName);
            case "kitchen":
                System.out.println(characterName + " is transferring to Kitchen");
                return new Kitchen(characterName);
            case "playground":
                System.out.println(characterName + " is transferring to Playground");
                return new Playground(characterName);
            case "training room":
                System.out.println(characterName + " is transferring to Training Room");
                return new TrainingRoom(characterName);
            default:
                System.out.println("Invalid location choice. " + characterName + " is returning to Lobby.");
                return new Lobby(characterName);
        }
    }
}
