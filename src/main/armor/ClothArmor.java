package main.armor;

public class ClothArmor extends Armor {

    public ClothArmor(String name, int level, SlotType slot) {
        super(name, level, slot, 10, 0, 1, 3);
    }

    public int getHealth() {
        return scale(5 * level + health);
    }

    public int getStrength() {
        return 0;
    }

    public int getDexterity() {
        return scale(level + dexterity);
    }

    public int getIntelligence() {
        return scale(2 * level + intelligence);
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
