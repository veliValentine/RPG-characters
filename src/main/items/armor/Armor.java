package main.items.armor;

import main.Printable;
import main.GetStats;
import main.RoundDown;

public abstract class Armor implements Printable, GetStats {
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

    // scales armor stats according to the armor slot
    protected int scale(int value) {
        if (slot == SlotType.Head) {
            return RoundDown.roundDown(value * HEAD);
        }
        if (slot == SlotType.Body) {
            return RoundDown.roundDown(value * BODY);
        }
        if (slot == SlotType.Legs) {
            return RoundDown.roundDown(value * LEGS);
        }
        return value;
    }

    public SlotType getSlot() {
        return slot;
    }

    public String getName() {
        return name;
    }

    public int getLevel(){
        return level;
    }
}
