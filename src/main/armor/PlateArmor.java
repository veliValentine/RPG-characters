package main.armor;

public class PlateArmor extends Armor {
    public PlateArmor(String name, int level, SlotType slot) {
        super(name, level, slot, 30, 3, 1, 0);
    }

    @Override
    public int getHealth() {
        return scale(12 * level + health);
    }

    @Override
    public int getStrength() {
        return scale(2 * level + strength);
    }

    @Override
    public int getDexterity() {
        return scale(level + dexterity);
    }

    @Override
    public int getIntelligence() {
        return 0;
    }
}
