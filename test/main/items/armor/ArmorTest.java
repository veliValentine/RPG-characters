package main.items.armor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArmorTest {

    @Test
    void clothArmorRightValues() {
        ClothArmor armor = new ClothArmor("test", 0, SlotType.Body);
        checkValues(armor, 10, 0, 1, 3);

        armor = new ClothArmor("test2", 11, SlotType.Body);
        checkValues(armor, 10 + 11 * 5, 0, 1 + 11, 3 + 11 * 2);

        armor = new ClothArmor("test3", 0, SlotType.Legs);
        checkValues(armor, 6, 0, 0, 1);

        armor = new ClothArmor("cloth Leggings of Magic", 10, SlotType.Legs);
        checkValues(armor, 36, 0, 6, 13);
    }

    @Test
    void leatherArmorHasRightValues(){
        LeatherArmor armor = new LeatherArmor("test", 0, SlotType.Body);
        checkValues(armor, 20,1,3,0);

        armor = new LeatherArmor("test", 10, SlotType.Legs);
        checkValues(armor, 60,6,13,0);
    }

    @Test
    void plateArmorHasRightValues(){
        PlateArmor armor = new PlateArmor("test", 0, SlotType.Body);
        checkValues(armor, 30,3,1,0);

        armor = new PlateArmor("test", 15, SlotType.Body);
        checkValues(armor, 210, 33, 16, 0);

        armor = new PlateArmor("test", 15, SlotType.Legs);
        checkValues(armor, 126, 19, 9, 0);
    }

    void checkValues(Armor armor, int health, int strength, int dexterity, int intelligence) {
        assertEquals(health, armor.getHealth());
        assertEquals(strength, armor.getStrength());
        assertEquals(dexterity, armor.getDexterity());
        assertEquals(intelligence, armor.getIntelligence());
    }
}