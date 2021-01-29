package main.hero;

import main.*;
import main.items.UseWeapon;
import main.items.armor.Armor;
import main.items.armor.SlotType;
import main.items.ItemSlots;
import main.items.UseArmor;
import main.items.weapon.Weapon;

public abstract class Hero implements Printable, Stats, UseWeapon, UseArmor {
    private int level;

    private int health;
    private int strength;
    private int dexterity;
    private int intelligence;

    private int experience;
    private int experienceToNextLevel;

    private ItemSlots items;

    public Hero(int health, int strength, int dexterity, int intelligence) {
        level = 1;
        this.health = health;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        experience = 0;
        experienceToNextLevel = 100;
        items = new ItemSlots();
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
        experienceToNextLevel = RoundDown.roundDown(experienceToNextLevel * 1.1);
        level++;
        this.health += health;
        this.strength += strength;
        this.dexterity += dexterity;
        this.intelligence += intelligence;
    }

    protected void printStats() {
        //These are common part of printout to all heroes;
        System.out.println("HP: " + getHealth());
        System.out.println("Str: " + getStrength());
        System.out.println("Dex: " + getDexterity());
        System.out.println("Int: " + getIntelligence());
        System.out.println("Lvl: " + level);
        System.out.println("XP to next: " + (experienceToNextLevel - experience));
    }

    @Override
    public void addArmor(Armor armor) {
        items.addArmor(armor);
    }

    @Override
    public void addWeapon(Weapon weapon) {
        items.addWeapon(weapon);
    }

    @Override
    public void clearWeapon() {
        items.clearWeapon();
    }

    @Override
    public void clearArmor(SlotType slot) {
        items.clearArmor(slot);
    }

    public void clearArmor() {
        clearArmor(SlotType.Head);
        clearArmor(SlotType.Body);
        clearArmor(SlotType.Legs);
    }

    public int attack() {
        return items.attack(getStrength(), getDexterity(), getIntelligence());
    }

    public int getLevel() {
        return level;
    }

    @Override
    public int getHealth() {
        return health + items.getHealth();
    }

    @Override
    public int getStrength() {
        return strength + items.getStrength();
    }

    @Override
    public int getDexterity() {
        return dexterity + items.getDexterity();
    }

    @Override
    public int getIntelligence() {
        return intelligence + items.getIntelligence();
    }

    public int getExperience() {
        return experience;
    }

    public int getExperienceToNextLevel() {
        return experienceToNextLevel;
    }
}
