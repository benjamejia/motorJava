package games.towerDefense;

public class Player {
    private int money;
    private int health;

    public Player(){
        money = 0;
        health = 100;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
