package com.edu.playground;

public class Player {
    private String name;
    public int healthPoint;
    public int magicPoint;
    public int attackPoint;
    public int defensePoint;
    
    public Player(String name, int healthPoint, int magicPoint, int attackPoint, int defensePoint) {
        this.name = name;
        this.healthPoint = healthPoint;
        this.magicPoint  = magicPoint;
        this.attackPoint = attackPoint;
        this.defensePoint = defensePoint;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getStatus() {
        return name + " HP: " + healthPoint + " MP: " + magicPoint;
        
    }
    
    public void attack(Player other) {
        if(magicPoint < 10) {
            System.out.println("法力耗盡, 無法攻擊");
            return;
        }
        magicPoint -=10;
        int harm = attackPoint - other.defensePoint;
        other.healthPoint -= harm;
    }
    
    public boolean alive() {
        return healthPoint > 0;
    }
}
