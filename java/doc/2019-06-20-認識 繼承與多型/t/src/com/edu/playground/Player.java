package com.edu.playground;

public class Player {
    String name;
    int healthPoint;
    int magicPoint;
    int attackPoint;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    int defensePoint;

    public Player(String name, int healthPoint,  int magicPoint, int attackPoint, int defensePoint) {
        this.name = name;
        this.healthPoint = healthPoint;
        this.magicPoint = magicPoint;
        this.attackPoint = attackPoint;
        this.defensePoint = defensePoint;
    }
    
    public void attack(Player other) {
        if(!canattack()) {
            System.out.println("法力耗盡, 無法攻擊");
            return;
        }
        magicPoint -= 10;
        int harm = attackPoint - other.defensePoint;
        other.healthPoint -= harm;
    }
    
    public String getStatus() {
        return name + " HP: " + healthPoint + " MP: " + magicPoint;
    }
    
    public boolean alive() {
        return healthPoint > 0;
    }
    
    public boolean canattack() {
        return magicPoint > 10;
    }

}
