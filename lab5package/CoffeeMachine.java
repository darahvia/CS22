package lab5package;
import java.util.Scanner;

public class CoffeeMachine {
    private ResourceManager resourceManager;        // initialize resource manager for handling resources
    private TextDisplay textDisplay;        // initialize text display for user interaction
    private Coins coins;        // initialize coin handling object

    //maximum resource values
    private int water = 1000;
    private int milk = 1000;
    private int beans = 500;
    private int money = 0;

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();  // create instance of coffeemachine
        coffeeMachine.on(); // start the coffee machine
    }

    public CoffeeMachine() {
        resourceManager = new ResourceManager(water, milk, beans, money);   // initialize the resource manager with maximum values
        textDisplay = new TextDisplay();    // to be used displaying text 
        coins = new Coins();    // create coin handling object
    }

    public void on() {
        Scanner scanner = new Scanner(System.in);
        boolean machineOn = true;

        // turn on the machine and prompt the user to choose the drink
        while (machineOn) {
            textDisplay.printWelcomeBanner();
            String choice = scanner.nextLine().toLowerCase();

            switch (choice) {
                case "espresso":
                case "latte":
                case "cappuccino":
                    prepareCoffee(choice);
                    break;
                case "off":
                    machineOn = false;
                    break;
                case "report":
                    resourceManager.printReport();
                    break;
                default:
                    System.out.println("This machine only serves Espresso, Latte, and Capuccino. Try them!");
                    break;
            }
        }
    }

    // create chosen coffee object
    private void prepareCoffee(String choice) {
        Coffee chosenCoffee;
        switch (choice) {
            case "espresso":
                chosenCoffee = new CoffeeEspresso();
                break;
            case "latte":
                chosenCoffee = new CoffeeLatte();
                break;
            case "cappuccino":
                chosenCoffee = new CoffeeCappuccino();
                break;
            default:
                return;
        }

        // check if there are enough resources 
        boolean hasEnoughWater = resourceManager.checkWaterResource() > chosenCoffee.getWaterCost();
        boolean hasEnoughMilk = resourceManager.checkMilkResource() > chosenCoffee.getMilkCost();
        boolean hasEnoughBeans = resourceManager.checkBeansResource() > chosenCoffee.getBeansCost();

        // proceed preparing if enough resources
        if (hasEnoughWater && hasEnoughMilk && hasEnoughBeans){
            double cost = chosenCoffee.getCost();
            textDisplay.printCoinChute();
            double coinsInserted = coins.insertCoins();
            boolean insertedEnoughCoins = coinsInserted >= cost;

            // proceed if enough coins are inserted
            if (insertedEnoughCoins) {
                System.out.printf("Total Payment: $%.2f\n", coinsInserted);
                double change = coinsInserted - cost;
                if (!(change == 0)){
                    System.out.printf("Your change is $%.2f.\n", change);
                }
                
                resourceManager.addProfit(cost);
                resourceManager.makeCoffee(chosenCoffee);
                textDisplay.printCoffeeCup();
                System.out.printf("Here is your %s. Enjoy! ^_^\n", chosenCoffee.getName());
            
            // restart if coin inserted is not enough
            } else {
                System.out.println("Sorry, not enough money :<. Money refunded.");
            }
        } 

        // show what resources is insufficient
        else{
            System.out.printf("I'm sorry but the resources is insufficient to make the %s.\n", chosenCoffee.getName());
            System.out.println("Insufficient resources:");
            if (!hasEnoughWater){
                System.out.printf("Water: %d ml\n", chosenCoffee.getWaterCost() -  resourceManager.checkWaterResource());
            }
            if (!hasEnoughMilk){
                System.out.printf("Milk: %d ml\n", chosenCoffee.getMilkCost() - resourceManager.checkMilkResource());
            }
            if (!hasEnoughBeans){
                System.out.printf("Beans: %d g\n", chosenCoffee.getBeansCost() - resourceManager.checkBeansResource());
            }
            }
        }
}
