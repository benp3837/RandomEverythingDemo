package com.ben.models;

public class Player implements Entity {

    private int health;
    private int attack;
    private int defense;
    private int speed;

    String name;

    //enum - good for type safety (you can only ever have 1 of these 3 races)
    //also makes the 3 options clear to the reader
    public enum Race {
        HUMAN,
        ELF,
        ORC
    }

    private Race race; //Will determine stats and weapon

    private Weapon weapon; //Will be created by WeaponFactory


    @Override
    public int attack() {

        //damage calculation will factor in attack and weapon stats
        int damage = this.attack + this.weapon.damage / 2;

        System.out.println(this.name + " attacks for " + damage + " damage!");
        return damage;
    }

    @Override
    public void takeDamage(int damage) {

        //Negate weak damage entirely
        if(damage <= this.defense){
            System.out.println("ATTACK BLOCKED!");
            return;
        }

        this.health -= damage - this.defense;
        System.out.println(this.name + " takes " + (damage - this.defense) + " damage! " +
                "Remaining health: " + this.health);
    }


    //boilerplate code------------------------------

    public Player() {
    }

    //We won't use an all-args constructor. Instead, we'll supply name + race (which sets stats)
    public Player(Race race, String name) {
        this.race = race;
        this.name = name;

        switch (race) {
            case HUMAN:
                this.health = 120; this.attack = 10; this.defense = 8;
                this.speed = 6; break;
            case ELF:
                this.health = 110; this.attack = 13; this.defense = 6;
                this.speed = 8; break;
            case ORC:
                this.health = 130; this.attack = 15; this.defense = 10;
                this.speed = 2; break;
        }
    }

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

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return "Player{" +
                "health=" + health +
                ", attack=" + attack +
                ", defense=" + defense +
                ", speed=" + speed +
                ", race='" + race + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
