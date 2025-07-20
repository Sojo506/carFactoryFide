package model;

public class Player {

    private String name;
    private String position;
    private int currentFactory;
    private int capital;
    private Factory factory;
    private boolean hasWon;

    public Player() {
    }

    public Player(String name, int factoryLevel) {
        this.name = name;
        this.position = "";
        this.currentFactory = 1;
        this.capital = 0;
        this.factory = new Factory(currentFactory);
        this.hasWon = false;
    }

    public int getCurrentFactory() {
        return currentFactory;
    }

    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        switch (getCurrentFactory()) {
            case 1 ->
                position = "Gerente Regional";
            case 2 ->
                position = "Gerente Producción";
            case 3 ->
                position = "Gerente General";
        }

        return position;
    }

    public void addCapital(int capital) {
        this.capital += capital;
    }

    public void subtractCapital(int capital) {
        this.capital -= capital;
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
        return "Factory: " + currentFactory + " | Capital: $" + capital;
    }
}
