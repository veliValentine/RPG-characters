package main.armor;

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

    void checkValues(ClothArmor armor, int health, int strength, int dexterity, int intelligence) {
        assertEquals(health, armor.getHealth());
        assertEquals(strength, armor.getStrength());
        assertEquals(dexterity, armor.getDexterity());
        assertEquals(intelligence, armor.getIntelligence());
    }
}