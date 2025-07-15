package model;

public class Player {

    private String name;
    private String position;
    private int currentFactory;
    private int money;
    private Factory factory;
    private boolean hasWon;

    public Player() {
    }

    public Player(String name, int factoryLevel) {
        this.name = name;
        this.position = "";
        this.currentFactory = 1;
        this.money = 0;
        this.factory = new Factory(currentFactory);
        this.hasWon = false;
    }

    public int getCurrentFactory() {
        return currentFactory;
    }

    public int getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        switch (getCurrentFactory()) {
            case 1:
                position += "Gerente Regional";
                break;
            case 2:
                position += "Gerente Producción";
                break;
            case 3:
                position += "Gerente General";
                break;
        }

        return position;
    }

    public void addMoney(int amount) {
        this.money += amount;
    }

    public void subtractMoney(int amount) {
        this.money -= amount;
    }

    public void advanceFactory() {
        if (currentFactory < 3) {
            currentFactory++;
            factory = new Factory(currentFactory);
        } else if (currentFactory == 3) {
            hasWon = true;
        }
    }

    public Factory getFactory() {
        return factory;
    }

    public boolean hasWon() {
        return hasWon;
    }

    @Override
    public String toString() {
        return "Factory: " + currentFactory + " | Money: ¢" + money;
    }
}
