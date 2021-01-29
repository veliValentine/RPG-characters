package main.items.armor;

public class ClothArmor extends Armor {

    public ClothArmor(String name, int level, SlotType slot) {
        super(name, level, slot, 10, 0, 1, 3);
    }

    @Override
    public int getHealth() {
        return scale(level * 5 + health);
    }

    @Override
    public int getStrength() {
        return 0;
    }

    @Override
    public int getDexterity() {
        return scale(level + dexterity);
    }

    @Override
    public int getIntelligence() {
        return scale(level * 2 + intelligence);
    }

    @Override
    public void print() {
        System.out.println("Armor type: Cloth");
        System.out.println("Slot: " + slot);
        System.out.println("Armor level: " + level);
        System.out.println("Bonus HP: " + getHealth());
        System.out.println("Bonus Dex: " + getDexterity());
        System.out.println("Bonus Int: " + getIntelligence());
    }
}
