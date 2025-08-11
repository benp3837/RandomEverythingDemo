package com.ben;

import com.ben.exceptions.YouDiedException;
import com.ben.models.Player;
import com.ben.models.Player.Race;
import com.ben.models.Weapon;
import com.ben.models.monsters.Dragon;
import com.ben.models.monsters.Monster;
import com.ben.models.monsters.Slime;
import com.ben.utils.MonsterFactory;
import com.ben.utils.WeaponFactory;

import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Scanner;

import static com.ben.models.Player.Race.*;

public class Main {
    public static void main(String[] args) {

        Player player = null; //Will get initialized after user input

        //-Generate 3-5 monsters
        //-While there are monsters, compare speeds, then fight() to the death
        //-If all monsters die before player dies, player wins
        //-Otherwise, death screen

        //Scanner for user input
        Scanner SCANNER = new Scanner(System.in);

        //CLI app - take in user input and give them options for race and ask their name
        //Dinky, yes, but it's a fun/easy way for me to review some core Java
        while (true) {
            System.out.println("~~Welcome to Baldur's Gate 4!~~ Please select a Class:");

            System.out.println("1 - Human");
            System.out.println("2 - Elf");
            System.out.println("3 - Orc");

            int chosenRace = SCANNER.nextInt();
            SCANNER.nextLine(); //Consume the newline character left by nextInt()

            if(chosenRace < 0 || chosenRace > 3){
                System.out.println("Invalid choice, please try again.");
                continue; //restart the loop if invalid input
            }

            System.out.println("Please enter your name:");

            String chosenName = SCANNER.nextLine();

            switch(chosenRace){
                case 1:
                    player = new Player(HUMAN, chosenName);
                    break;
                case 2:
                    player = new Player(ELF, chosenName);
                    break;
                case 3:
                    player = new Player(ORC, chosenName);
                    break;
            }

            break; //end menu after valid input

        }

        System.out.println("Hey " + player.getRace() + ", you're finally awake. " +
                "Welcome to the Arena, we're gonna throw monsters at you ok good luckkkkk");

        Weapon weapon = WeaponFactory.generateWeapon(player.getRace());

        System.out.println("Oh you need a weapon? Take this " + weapon.name);

        player.setWeapon(weapon);

        //"gameplay loop" starts here

        //Generate a LinkedList of monsters with MonsterFactory, see if you survive

        LinkedList<Monster> monsters = MonsterFactory.generateMonsters();

        while(!monsters.isEmpty()) {

            System.out.println("===============================");

            //Get and remove the next monster in line (or in "queue")
            Monster monster = monsters.poll();

            //invoke the fight!
            fight(monster, player);

        } //End of while loop!

        System.out.println("*//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//*");
        System.out.println("Wow you survived! You win gold or glory or something idk");
        System.out.println("*//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//*");

    }

    public static void fight(Monster monster, Player player) {

        System.out.println(monster.getMonsterName() + " appears!");
        System.out.println(monster.getMonsterSprite());

        //Find out who's faster
        boolean playerIsFaster = player.getSpeed() > monster.getSpeed();

        //Fight the monster until one of us dies
        while (monster.getHealth() > 0 && player.getHealth() > 0) {
            //Compare speeds, then attack
            if (playerIsFaster) {
                monster.takeDamage(player.attack());
                if (monster.getHealth() <= 0) {monster.die(); return;}

                player.takeDamage(monster.attack());
                if (player.getHealth() <= 0) {throw new YouDiedException();}
            }
            else {
                player.takeDamage(monster.attack());
                if (player.getHealth() <= 0) {throw new YouDiedException();}

                monster.takeDamage(player.attack());
                if (monster.getHealth() <= 0) {monster.die(); return;}
            }
        }

    }

}