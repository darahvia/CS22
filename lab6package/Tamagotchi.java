import java.util.Scanner;

public class Tamagotchi {

    public static void main(String[] args){
        Tamagotchi tamodatchi = new Tamagotchi();
        tamodatchi.on();
    }

    public void on(){
        Scanner scanner = new Scanner(System.in);
        boolean gameOn = true;

        System.out.print("name ur player: ");
        String characterName = scanner.nextLine();
        Character character = new Character();
        System.out.println(characterName + " has been created");
        Lobby lobby = new Lobby();
        character = lobby;
        while (gameOn){
            
            System.out.print("wachow wana dooo: ");
            String choice = scanner.nextLine();

            switch(choice){
                case "feed":
                    character.feed();
                    break;
                case "play":
                    character.play();
                    break;
                case "train":
                    character.train();
                    break;
                case "display status":
                    displayStatus(character);
                    break;
                case "transfer location":
                    String locationChoice = scanner.nextLine();
                    character = transferLocation(locationChoice);
                    break;
                case "exit":
                    System.out.println("exiting game adios amigo");
                    gameOn = false;
                    break;
                default:
                    System.out.println("sala choice mo mads");
            }            
        }
    }
    public void displayStatus(Character character){
        System.out.println("status");
        System.out.println("hunger: " + character.getHunger());
        System.out.println("happiness: " + character.getHappiness());
        System.out.println("train: " + character.getTrain());
    }

    private static Character transferLocation (String transferLocation){
        switch (transferLocation) { 
            case "lobby":
                System.out.println("Transferring to Lobby");
                return new Lobby();
            case "kitchen":
                System.out.println("Transferring to Kitchen");
                return new Kitchen();
            case "playground":
                System.out.println("Transferring to Playground");
                return new Playground();
            case "training room":
                System.out.println("Transferring to Training Room");
                return new TrainingRoom();
            default:
                System.out.println("Invalid location choice. Returning to Lobby.");
                return new Lobby();
        }
    }
}

