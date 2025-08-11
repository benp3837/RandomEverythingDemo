package com.ben.utils;

import com.ben.models.monsters.Dragon;
import com.ben.models.monsters.Monster;
import com.ben.models.monsters.Slime;
import com.ben.models.monsters.Troll;

import java.util.LinkedList;

public class MonsterFactory {

    //Returns a LinkedList of 5 randomly generated monsters
    //Why linkedList? We want the monsters returned in order, and we want to remove them as they're defeated
    public static LinkedList<Monster> generateMonsters(){

        LinkedList<Monster> monsters = new LinkedList<>();

        for(int i = 0; i < 5; i++){

            int monsterType = (int) (Math.random() * 3) + 1;

            //Generate random monster and add it to the list
            switch (monsterType) {
                case 1:
                    monsters.add(new Slime());
                    break;
                case 2:
                    monsters.add(new Dragon());
                    break;
                case 3:
                    monsters.add(new Troll());
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + monsterType);
            }

        }

        return monsters;

    }

}
