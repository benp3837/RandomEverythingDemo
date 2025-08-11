package com.ben.models;

public interface Entity {

    //Methods each entity (Players and Monsters) must implement

    int attack();

    void takeDamage(int damage);

}
