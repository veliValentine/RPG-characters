package main.hero;

import main.Utils;
import main.armor.Armor;
import main.weapon.Weapon;

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

    public void setBodyArmor(Armor bodyArmor) {
        this.bodyArmor = bodyArmor;
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
            int damage = weapon.damage() + Utils.roundDown(1.5 * getStrength());
            System.out.println();
            return damage;
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
