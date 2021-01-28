package main.armor;

import main.Utils;

public abstract class Armor {
    private static final double HEAD = 0.8;
    private static final double BODY = 1.0;
    private static final double LEGS = 0.6;

    protected String name;
    protected int level;
    protected SlotType slot;


    protected int health;
    protected int strength;
    protected int dexterity;
    protected int intelligence;

    public Armor(String name, int level, SlotType slot, int health, int strength, int dexterity, int intelligence) {
        this.name = name;
        this.level = level;
        this.slot = slot;
        this.health = health;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    protected int scale(int value) {
        if (slot == SlotType.HEAD) {
            return Utils.roundDown(value * HEAD);
        }
        if (slot == SlotType.BODY) {
            return Utils.roundDown(value * BODY);
        }
        return Utils.roundDown(value * LEGS);
    }

    public abstract int getHealth();

    public abstract int getStrength();

    public abstract int getDexterity();

    public abstract int getIntelligence();
}
