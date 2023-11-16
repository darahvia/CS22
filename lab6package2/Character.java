interface Actions {
    void performAction();
}

class Character implements Actions {
    protected int hunger;
    protected int happiness;
    protected int train;
    protected String name;

    public Character(String name) {
        this.name = name;
        this.hunger = 50;
        this.happiness = 50;
        this.train = 50;
    }

    @Override
    public void performAction() {
        System.out.println(name + " is performing an action.");
    }

    public int getHunger() {
        return hunger;
    }

    public int getHappiness() {
        return happiness;
    }

    public int getTrain() {
        return train;
    }
}

class Lobby extends Character {
    public Lobby(String name) {
        super(name);
    }

    @Override
    public void performAction() {
        super.performAction();
        System.out.println("Feeding");
        this.hunger -= 15;
        this.train += 10;
        this.happiness += 15;
    }
}

class Kitchen extends Character {
    public Kitchen(String name) {
        super(name);
    }

    @Override
    public void performAction() {
        super.performAction();
        System.out.println("Feeding");
        this.hunger -= 30;
    }
}

class Playground extends Character {
    public Playground(String name) {
        super(name);
    }

    @Override
    public void performAction() {
        super.performAction();
        System.out.println("Playing");
        this.happiness += 30;
    }
}

class TrainingRoom extends Character {
    public TrainingRoom(String name) {
        super(name);
    }

    @Override
    public void performAction() {
        super.performAction();
        System.out.println("Training");
        this.train += 20;
    }
}
