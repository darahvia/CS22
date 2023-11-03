package lab5package;

// abstraction
public abstract class Coffee {      // abstract classes that serves as a blueprint for different types of coffee
    protected String name;          // defines the common attributes and methods for all coffee types
    protected int waterCost;
    protected int milkCost;
    protected int beansCost;
    protected double moneyCost;

    public String getName() {       // getter methods
        return name;
    }

    public int getWaterCost() {
        return waterCost;
    }

    public int getMilkCost() {
        return milkCost;
    }

    public int getBeansCost() {
        return beansCost;
    }

    public double getCost() {
        return moneyCost;
    }
}

// inheritance
class CoffeeEspresso extends Coffee {       // concrete subclasses that provide speicific implementations for different types of coffee
    public CoffeeEspresso() {
        name = "espresso";
        waterCost = 300;
        milkCost = 0;
        beansCost = 16;
        moneyCost = 1.50;
    }
}

class CoffeeLatte extends Coffee {
    public CoffeeLatte() {
        name = "latte";
        waterCost = 225;
        milkCost = 75;
        beansCost = 20;
        moneyCost = 3.00;
    }
}

class CoffeeCappuccino extends Coffee {
    public CoffeeCappuccino() {
        name = "cappuccino";
        waterCost = 200;
        milkCost = 100;
        beansCost = 12;
        moneyCost = 2.50;
    }
}
