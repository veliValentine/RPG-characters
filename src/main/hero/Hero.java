package main.hero;

import main.Utils;
import main.armor.Armor;
import main.armor.SlotType;
import main.weapon.Weapon;
import main.weapon.WeaponType;

public abstract class Hero {
    private int level;

    private int health;
    private int strength;
    private int dexterity;
    private int intelligence;

    private int experience;
    private int experienceToNextLevel;

    private Items items;

    public Hero(int health, int strength, int dexterity, int intelligence) {
        level = 1;
        this.health = health;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        experience = 0;
        experienceToNextLevel = 100;
        items = new Items();
    }

    public abstract void addExperience(int xp);

    //Takes care of addedExperience and calls levelUp() when needed
    protected void addExperienceToHero(int xp, int health, int strength, int dexterity, int intelligence) {
        if (xp < 0) {
            return;
        }
        experience += xp;
        while (experience >= experienceToNextLevel) {
            levelUp(health, strength, dexterity, intelligence);
        }
    }

    private void levelUp(int health, int strength, int dexterity, int intelligence) {
        experience -= experienceToNextLevel;
        experienceToNextLevel = Utils.roundDown(experienceToNextLevel * 1.1);
        level++;
        this.health += health;
        this.strength += strength;
        this.dexterity += dexterity;
        this.intelligence += intelligence;
    }

    public abstract void printDetails();

    protected void printStats() {
        //These are common part of printout to all heroes;
        System.out.println("HP: " + getHealth());
        System.out.println("Str: " + getStrength());
        System.out.println("Dex: " + getDexterity());
        System.out.println("Int: " + getIntelligence());
        System.out.println("Lvl: " + level);
        System.out.println("XP to next: " + (experienceToNextLevel - experience));
    }

    public void addArmor(Armor armor) {
        items.addArmor(armor);
    }

    public void addWeapon(Weapon weapon) {
        items.addWeapon(weapon);
    }

    public void clearWeapon() {
        items.clearWeapon();
    }

    public void clearArmor(SlotType slot) {
        items.clearArmor(slot);
    }

    public void clearArmor() {
        items.clearArmor(SlotType.Head);
        items.clearArmor(SlotType.Body);
        items.clearArmor(SlotType.Legs);
    }

    public int attack() {
        return items.attack(getStrength(), getDexterity(), getIntelligence());
    }

    public int getLevel() {
        return level;
    }

    public int getHealth() {
        return health + items.itemsHP();
    }

    public int getStrength() {
        return strength + items.itemsStrength();
    }

    public int getDexterity() {
        return dexterity + items.itemsDexterity();
    }

    public int getIntelligence() {
        return intelligence + items.itemsIntelligence();
    }

    public int getExperience() {
        return experience;
    }

    public int getExperienceToNextLevel() {
        return experienceToNextLevel;
    }
}
