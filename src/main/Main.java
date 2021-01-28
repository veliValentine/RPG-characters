package main;

import main.hero.*;
import main.weapon.*;
import main.armor.*;

public class Main {

    public static void main(String[] args) {
        Warrior hero = new Warrior();
        while (hero.getLevel() < 9){
            hero.addExperience(100);
        }
        hero.printDetails();
        System.out.println();
        Weapon weapon = new MeleeWeapon("Great axe of the ", 5);
        weapon.print();
        System.out.println();

        Armor armor = new PlateArmor("Armor with holes", 5, SlotType.Body);
        armor.print();
        System.out.println();

        hero.setArmor(armor);
        hero.setWeapon(weapon);
        hero.printDetails();

        System.out.println("Should be: 480, 63, 25, 9, 9");
    }
}
