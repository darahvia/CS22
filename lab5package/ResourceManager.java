package lab5package;

public class ResourceManager {
    private int water;
    private int milk;
    private int beans;
    private double money;

    //maximum resourceavlues
    private final int MAX_WATER = 1000;
    private final int MAX_MILK = 1000;
    private final int MAX_BEANS = 500;

    public ResourceManager(int water, int milk, int beans, double money) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.money = money;
    }

    // check resources
    public boolean checkResources(Coffee coffee){
        return (water >= coffee.getWaterCost() && 
                milk >= coffee.getMilkCost() && 
                beans >= coffee.getBeansCost());
    }

    public int checkWaterResource(Coffee coffee) {
        return water;
    }

    public int checkMilkResource(Coffee coffee) {
        return milk;
    }

    public int checkBeansResource(Coffee coffee) {
        return beans;
    }

    //refill
    public void refillWater(int waterToAdd){
        water += waterToAdd;
    }

    public void refillMilk(int milkToAdd){
        milk += milkToAdd;
    }

    public void refillBeans(int beansToAdd){
        beans += beansToAdd;
    }

    public void refillResources(Coffee coffee) {
        if (checkWaterResource(coffee) < coffee.getWaterCost()) {
            System.out.printf("Sorry, there is not enough water to make %s.\n", coffee.getName());
            refillWater(MAX_WATER - checkWaterResource(coffee));
        }

        if (checkBeansResource(coffee) < coffee.getBeansCost()) {
            System.out.printf("Sorry, there is not enough beans to make %s.\n", coffee.getName());
            refillBeans(MAX_MILK - checkBeansResource(coffee));
        }

        if (checkMilkResource(coffee) < coffee.getMilkCost()) {
            System.out.printf("Sorry, there is not enough milk to make %s.\n", coffee.getName());
            refillMilk(MAX_BEANS - checkMilkResource(coffee));
        }
    }
    
    public void makeCoffee(Coffee coffee) {
        water -= coffee.getWaterCost();
        milk -= coffee.getMilkCost();
        beans -= coffee.getBeansCost();
    }

    public void addProfit(double amount) {
        money += amount;
    }

    public void printReport() {
        System.out.println("Water: " + water + "ml");
        System.out.println("Milk: " + milk + "ml");
        System.out.println("Beans: " + beans + "g");
        System.out.println("Money: $" + money);
    }
}
