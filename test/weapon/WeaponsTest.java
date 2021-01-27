package weapon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeaponsTest {
    @Test
    void meleeWeaponDealsRightAmountOfBaseDamage() {
        MeleeWeapon weapon = new MeleeWeapon("test weapon",0);
        assertEquals(15, weapon.damage());

        weapon = new MeleeWeapon("Great axe of the Exiled", 5);
        assertEquals(25, weapon.damage());
    }

    @Test
    void rangeWeaponDealsRightAmountOfBaseDamage() {
        RangeWeapon weapon = new RangeWeapon("test weapon", 0);
        assertEquals(5, weapon.damage());

        weapon = new RangeWeapon("Long bow of the lonely wolf", 10);
        assertEquals(35, weapon.damage());
    }
}