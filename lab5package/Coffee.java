package lab5package;

public abstract class Coffee {
    protected String name;
    protected int waterCost;
    protected int milkCost;
    protected int beansCost;
    protected double moneyCost;

    public String getName() {
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

class CoffeeCappuccino extends Coffee {
    public CoffeeCappuccino() {
        name = "cappuccino";
        waterCost = 200;
        milkCost = 100;
        beansCost = 12;
        moneyCost = 2.50;
    }
}

class CoffeeEspresso extends Coffee {
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
