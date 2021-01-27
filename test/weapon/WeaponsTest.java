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

}