package com.edu.playground;

public class Warrior extends Player{
    double combRate;

    public Warrior(String name, int healthPoint, int magicPoint, int attackPoint, int defensePoint, double combRate) {
        super(name, healthPoint, magicPoint, attackPoint, defensePoint);
        this.combRate = combRate;
    }
    
    @Override
    public void attack(Player other) {
        super.attack(other);
        double rate = Math.random();
        int harm = attackPoint - other.defensePoint;
        if(rate < combRate) {
            other.healthPoint -= harm;
        }
    }

    public double getCombRate() {
        return combRate;
    }

    public void setCombRate(double combRate) {
        this.combRate = combRate;
    }
}
