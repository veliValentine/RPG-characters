package main;

import main.hero.*;
import main.items.weapon.*;
import main.items.armor.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Our heroes are summoned from the void
        Hero warrior = new Warrior();
        Hero ranged = new Ranger();
        Hero mage = new Mage();

        List<Hero> heroes = new ArrayList<>();
        heroes.add(warrior);
        heroes.add(ranged);
        heroes.add(mage);

        // 1. Print details
        System.out.println("Our heroes!");
        for (Hero hero : heroes) {
            hero.print();
            System.out.println();
        }

        // Add 1200xp to heroes => lvl 9
        for (Hero hero : heroes) {
            hero.addExperience(1200);
        }

        // 2. Print details
        System.out.println("Our heroes after leveling up!");
        for (Hero hero : heroes) {
            hero.print();
            System.out.println();
        }

        // Create weapons for our heroes
        Weapon meleeWeapon = new MeleeWeapon("Melee weapon of awesome", 5);
        Weapon rangeWeapon = new RangeWeapon("Range weapon for the handsome", 10);
        Weapon magicWeapon = new MagicWeapon("Mystic fork of hungry hippo", 12);

        List<Weapon> weapons = new ArrayList<>();
        weapons.add(meleeWeapon);
        weapons.add(rangeWeapon);
        weapons.add(magicWeapon);

        // 3. Print weapon details
        System.out.println("Weapons for our heroes!");
        for (Weapon weapon : weapons) {
            weapon.print();
            System.out.println();
        }

        // They are going to need some armor
        Armor helmet = new ClothArmor("cloth armor of frozen ears", 10, SlotType.Head);
        Armor body = new LeatherArmor("Leather armor of the cool guy", 4, SlotType.Body);
        Armor leggings = new PlateArmor("Plate armor for freezing toes", 99, SlotType.Legs);

        List<Armor> armors = new ArrayList<>();
        armors.add(helmet);
        armors.add(body);
        armors.add(leggings);

        // 4. Print armor details
        System.out.println("and some armor...");
        for (Armor armor : armors) {
            armor.print();
            System.out.println();
        }

        // Add armor to warrior
        warrior.addArmor(helmet);
        warrior.addArmor(body);
        warrior.addArmor(leggings);

        // Don't forget the melee weapon
        warrior.addWeapon(meleeWeapon);

        // 5. Print equipped warrior
        System.out.println("Warrior equipped with armor it can wear");
        warrior.print();
        warrior.attack();
        System.out.println();

        // Strip warrior from armor
        warrior.clearArmor();

        //Add 100 body armors to warrior
        for (int i = 0; i < 100; i++) {
            warrior.addArmor(body);
        }

        // 6. Only one body armor was added to our warrior
        System.out.println("Warrior with body armor and sword");
        warrior.print();
        warrior.attack();
        System.out.println();

        // Strip warrior of armor
        warrior.clearArmor();

        // Add leggings so it doesn't freeze
        warrior.addArmor(leggings);
        // leggings are not equipped since warrior level is not high enough

        // 7. print details
        System.out.println("Warrior without leggings and sword");
        warrior.print();
        warrior.attack();
        System.out.println();

        // create less awesome leggings and equip them
        Armor clothBodyArmor = new ClothArmor("Awesome name for awesome cloth armor", 1, SlotType.Legs);
        // not too cold and not too warm. Perfect...
        warrior.addArmor(clothBodyArmor);

        // 8. see that warrior stats are updated accordingly
        System.out.println("Warrior with less awesome leggings. And sword!");
        warrior.print();
        warrior.attack();
        System.out.println();
    }
}
