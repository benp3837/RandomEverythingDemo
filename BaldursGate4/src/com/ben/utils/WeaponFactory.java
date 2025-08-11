package com.ben.utils;

import com.ben.models.Player.Race;
import com.ben.models.Weapon;

//Factory Design Pattern - classic example of abstraction.
//Object creation can get long and ugly. Good practice to abstract it away into a Util type class.
public class WeaponFactory {

    //Generate a weapon for the user based on their race... Whoops that sounds bad.
    //HELLO HR - BY "RACE" I REALLY MEAN "CLASS" BUT CLASS IS A JAVA KEYWORD :((((((

    public static Weapon generateWeapon(Race race) {

        //check out the "enhanced switch", introduced in Java 12
        return switch (race) {
            case HUMAN -> new Weapon("Sword", 10);
            case ELF -> new Weapon("Bow", 8);
            case ORC -> new Weapon("Axe", 12);
            default -> throw new IllegalArgumentException("Unknown Race");
            //default is less necessary here since Race is an enum! Enums promote type safety
        };

    }

}
