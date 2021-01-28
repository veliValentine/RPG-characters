package main.hero;

import main.Utils;
import main.armor.Armor;
import main.armor.SlotType;
import main.weapon.Weapon;
import main.weapon.WeaponType;

public abstract class Hero {
    protected int level;

    protected int health;
    protected int strength;
    protected int dexterity;
    protected int intelligence;

    protected int experience;
    protected int experienceToNextLevel;

    protected Weapon weapon;
    protected Armor bodyArmor;
    protected Armor helmet;
    protected Armor leggings;

    public Hero(int health, int strength, int dexterity, int intelligence) {
        level = 1;
        this.health = health;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        experience = 0;
        experienceToNextLevel = 100;
    }

    public abstract void addExperience(int xp);

    protected void addExperienceToHero(int xp, int health, int strength, int dexterity, int intelligence) {
        if (xp < 0) {
            return;
        }
        experience += xp;
        while (experience >= experienceToNextLevel) {
            levelUp(health, strength, dexterity, intelligence);
        }
    }

    protected void levelUp(int health, int strength, int dexterity, int intelligence) {
        experience -= experienceToNextLevel;
        experienceToNextLevel = (int) Math.floor(experienceToNextLevel * 1.1);
        level++;
        this.health += health;
        this.strength += strength;
        this.dexterity += dexterity;
        this.intelligence += intelligence;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setArmor(Armor armor){
        SlotType armorSlotType = armor.getSlot();
        if(armorSlotType == SlotType.Head){
            helmet = armor;
        }
        if(armorSlotType == SlotType.Body){
            bodyArmor = armor;
        }
        if(armorSlotType == SlotType.Legs){
            leggings = armor;
        }
    }

    public void clearArmor(SlotType slot){
        if(slot == SlotType.Head){
            helmet = null;
        }
        if(slot == SlotType.Body){
            bodyArmor = null;
        }
        if(slot == SlotType.Legs){
            leggings = null;
        }
    }

    public abstract void printDetails();

    protected void printStats() {
        System.out.println("HP: " + getHealth());
        System.out.println("Str: " + getStrength());
        System.out.println("Dex: " + getDexterity());
        System.out.println("Int: " + getIntelligence());
        System.out.println("Lvl: " + level);
        System.out.println("XP to next: " + (experienceToNextLevel - experience));
    }

    public int attack() {
        if (weapon != null) {
            //If weapon type melee
            int totalDamage = weapon.damage();

            if (weapon.getWeaponType() == WeaponType.Melee) {
                totalDamage += +Utils.roundDown(1.5 * getStrength());
            }
            if (weapon.getWeaponType() == WeaponType.Ranged) {
                totalDamage += +Utils.roundDown(1.5 * getDexterity());
            }
            if (weapon.getWeaponType() == WeaponType.Magic) {
                totalDamage += +Utils.roundDown(1.5 * getIntelligence());
            }
            System.out.println("Attacking for " + totalDamage);
            return totalDamage;
        }
        return 0;
    }

    public int getLevel() {
        return level;
    }

    public int getHealth() {
        int gearHP = 0;
        if (bodyArmor != null) {
            gearHP += bodyArmor.getHealth();
        }
        return health + gearHP;
    }

    public int getStrength() {
        int gear = 0;
        if (bodyArmor != null) {
            gear += bodyArmor.getStrength();
        }
        return strength + gear;
    }

    public int getDexterity() {
        int gear = 0;
        if (bodyArmor != null) {
            gear += bodyArmor.getDexterity();
        }
        return dexterity + gear;
    }

    public int getIntelligence() {
        int gear = 0;
        if (bodyArmor != null) {
            gear += bodyArmor.getIntelligence();
        }
        return intelligence + gear;
    }

    public int getExperience() {
        return experience;
    }

    public int getExperienceToNextLevel() {
        return experienceToNextLevel;
    }
}
