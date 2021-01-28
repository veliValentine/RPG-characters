package main.weapon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeaponsTest {
    @Test
    void meleeWeaponDealsRightAmountOfBaseDamage() {
        MeleeWeapon weapon = new MeleeWeapon("test java.weapon", 0);
        assertEquals(15, weapon.damage());

        weapon = new MeleeWeapon("Great axe of the Exiled", 5);
        assertEquals(25, weapon.damage());
    }

    @Test
    void rangeWeaponDealsRightAmountOfBaseDamage() {
        RangeWeapon weapon = new RangeWeapon("test java.weapon", 0);
        assertEquals(5, weapon.damage());

        weapon = new RangeWeapon("Long bow of the lonely wolf", 10);
        assertEquals(35, weapon.damage());
    }

    @Test
    void magicWeaponsDealsRightAmountOfBaseDamage() {
        MagicWeapon weapon = new MagicWeapon("test java.weapon", 0);
        assertEquals(25, weapon.damage());

        weapon = new MagicWeapon("Magic fork of hungry hippo", 87);
        assertEquals(25 + 2 * 87, weapon.damage());
    }
}