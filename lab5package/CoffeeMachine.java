package lab5package;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CoffeeMachine {
    private ResourceManager resourceManager;
    private Coffee coffee;
    private textDisplay display;

    public CoffeeMachine() {
        resourceManager = new ResourceManager(1000, 1000, 500, 0);
        display = new textDisplay();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean machineOn = true;

        while (machineOn) {
            display.printWelcomeBanner();

            System.out.println("What would you like?");
            System.out.println("Drink      | Price");
            System.out.println("--------------------");
            System.out.println("Espresso   | $1.5");
            System.out.println("Latte      | $3");
            System.out.println("Cappuccino | $2.5");
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

        while (true){
            if (resourceManager.checkResources(chosenCoffee)) {
                double cost = chosenCoffee.getCost();
                double coinsInserted = insertCoins();

                if (coinsInserted >= cost) {
                    double change = coinsInserted - cost;
                    resourceManager.addProfit(cost);
                    if (change > 0) {
                        System.out.printf("Your change is $%.2f.\n", change);
                    }
                    resourceManager.makeCoffee(chosenCoffee);
                    display.printCoffeeCup();
                    System.out.println("Here is your " + chosenCoffee.getName() + ". Enjoy!");
                    break;
                    
                } else {
                    System.out.println("Sorry, not enough money. Money refunded.");
                    break;
                }
            } 
            else{
                resourceManager.refillResources(chosenCoffee);
                System.out.println("refilling...");
                }
            }
        }


    private double insertCoins() {
        Scanner scanner = new Scanner(System.in);
        double total = 0;

        System.out.println("Please insert coins:");
        display.printCoinChute();
        double coinValue[] = {0.25, 0.10, 0.05, 0.01};
        double coin;
        String coinName[] = {"Quarters", "Dimes", "Nickels", "Pennies"};

        for (int i = 0; i < 4; i++){
            while(true){
                try{
                System.out.print(coinName[i] + ": ");
                coin = scanner.nextDouble();
                if (coin < 0){
                    throw new InputMismatchException();
                } 
                total += coin * coinValue[i];
                break;
                }catch (InputMismatchException e){
                    System.out.println("Invalid coin.");
                    scanner.nextLine();
                }
            }
        }

        return total;
    }

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.start();
    }
}
