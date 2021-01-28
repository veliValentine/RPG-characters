package main.armor;

public class PlateArmor extends Armor {

    public PlateArmor(String name, int level, SlotType slot) {
        super(name, level, slot, 30, 3, 1, 0);
    }

    @Override
    public int getHealth() {
        return scale(level * 12 + health);
    }

    @Override
    public int getStrength() {
        return scale(level * 2 + strength);
    }

    @Override
    public int getDexterity() {
        return scale(level + dexterity);
    }

    @Override
    public int getIntelligence() {
        return 0;
    }

    @Override
    public void print() {
        System.out.println("Armor type: Plate");
        System.out.println("Slot: " + slot);
        System.out.println("Armor level: " + level);
        System.out.println("Bonus HP: " + getHealth());
        System.out.println("Bonus Str: " + getStrength());
        System.out.println("Bonus Dex: " + getDexterity());
    }
}
