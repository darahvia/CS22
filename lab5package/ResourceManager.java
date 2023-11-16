package lab5package;

// encapsulation
// bundling of data and methods
// restricts direct access of object's components
public class ResourceManager {
    private int water;
    private int milk;
    private int beans;
    private double money;
    
    public ResourceManager(int water, int milk, int beans, double money) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.money = money;
    }

    // check resources
    public int checkWaterResource() {
        return water;
    }

    public int checkMilkResource() {
        return milk;
    }

    public int checkBeansResource() {
        return beans;
    }

    public void addProfit(double amount) {
        money += amount;
    }

    public void makeCoffee(Coffee coffee) {
        water -= coffee.getWaterCost();
        milk -= coffee.getMilkCost();
        beans -= coffee.getBeansCost();
    }

    public void printReport() {
        System.out.println("~~~ report ~~~");
        System.out.printf("Water: %d ml\n", water);
        System.out.printf("Milk: %d ml\n", milk);
        System.out.printf("Beans: %d g\n", beans);
        System.out.printf("Money: $%.2f\n", money);
        System.out.println("~~~~~~~~~~~~~~");
    }
}
