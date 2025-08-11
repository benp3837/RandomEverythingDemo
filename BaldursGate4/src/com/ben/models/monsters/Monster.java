package com.ben.models.monsters;

import com.ben.models.Entity;

public abstract class Monster implements Entity {

    //All fields will vary by subclass, but we'll initially define them here
    int health;
    int attack;
    int defense;
    int speed;

    String monsterName;
    String monsterSprite;

    @Override
    public int attack() {
        System.out.println(this.monsterName + " attacks for " + this.attack + " damage!");
        return this.attack;
    }

    @Override
    public void takeDamage(int damage) {
        this.health -= damage - this.defense;
        System.out.println(this.monsterName + " takes " + (damage - this.defense) + " damage! " +
                "Remaining health: " + this.health);
    }

    //die() will be implemented by subclasses
    public abstract void die();


    //Defining the getters and setters here so subclasses can skip writing them
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }

    public String getMonsterSprite() {
        return monsterSprite;
    }

    public void setMonsterSprite(String monsterSprite) {
        this.monsterSprite = monsterSprite;
    }
}
