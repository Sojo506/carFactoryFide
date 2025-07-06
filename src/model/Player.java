package model;

public class Player {

    private int currentFactory;
    private int money;
    private Factory factory;

    public Player() {
        this.currentFactory = 1;
        this.money = 0;
        this.factory = new Factory(currentFactory);
    }

    public int getCurrentFactory() {
        return currentFactory;
    }

    public int getMoney() {
        return money;
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
        }
    }

    public Factory getFactory() {
        return factory;
    }

    public boolean hasWon() {
        return currentFactory > 3;
    }

    @Override
    public String toString() {
        return "Factory: " + currentFactory + " | Money: ¢" + money;
    }
}
