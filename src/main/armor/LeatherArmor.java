package main.armor;

public class LeatherArmor extends Armor {
    public LeatherArmor(String name, int level, SlotType slot) {
        super(name, level, slot, 20, 1, 3, 0);
    }

    @Override
    public int getHealth() {
        return scale(8 * level + health);
    }

    @Override
    public int getStrength() {
        return scale(level + strength);
    }

    @Override
    public int getDexterity() {
        return scale(2 * level + dexterity);
    }

    @Override
    public int getIntelligence() {
        return 0;
    }

    @Override
    public void print() {
        System.out.println("Armor type: Leather");
        System.out.println("Slot: " + slot);
        System.out.println("Armor level: " + level);
        System.out.println("Bonus HP: " + getHealth());
        System.out.println("Bonus Str: " + getStrength());
        System.out.println("Bonus Dex: " + getDexterity());
    }
}
