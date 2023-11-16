interface Actions{
    void feed();
    void play();
    void train();
}

class Character implements Actions{
    protected int hunger;
    protected int happiness;
    protected int train;

    public Character(){
        this.hunger = 50;
        this.happiness = 50;
        this.train = 50;
    }

    @Override
    public void feed(){
        System.out.println("Feeding");
    }

    @Override
    public void play(){
        System.out.println("Playing");
    }

    @Override
    public void train(){
        System.out.println("training");
    }

    //getter methods
    public int getHunger(){
        return hunger;
    }

    public int getHappiness(){
        return happiness;
    }

    public int getTrain(){
        return train;
    }
}

class Lobby extends Character{
    @Override
    public void feed(){
        System.out.println("Feeding");
        this.hunger -= 15;
    }

    @Override
    public void play(){ 
        System.out.println("Playing");
        this.happiness += 10;
    }

    @Override
    public void train(){
        System.out.println("Training");
        this.train += 10;
    }
}

class Kitchen extends Character{
    @Override
    public void feed(){
        this.hunger -= 30;
    }
}

class Playground extends Character{
    @Override
    public void play(){
        this.happiness += 30;
    }
}

class TrainingRoom extends Character{
    @Override
    public void train(){
        this.train += 20;
    }
}