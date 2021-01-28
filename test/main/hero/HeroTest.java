package main.hero;

import main.armor.Armor;
import main.armor.PlateArmor;
import main.armor.SlotType;
import main.weapon.MagicWeapon;
import main.weapon.MeleeWeapon;
import main.weapon.RangeWeapon;
import main.weapon.Weapon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {
    @Test
    void createdWarriorsInitialValuesAreCorrect() {
        checkStats(new Warrior(), 1, 150, 10, 3, 1, 0, 100);
    }

    @Test
    void equippingItemsChangesWarriorsStats() {
        Warrior warrior = new Warrior();
        warrior.addExperience(xpToReachLevel(9));
        checkStats(warrior, 9, 390, 50, 19, 9, 0, 212);
        assertEquals(0, warrior.attack());

        Weapon weapon = new MeleeWeapon("Great axe of the ", 5);
        Armor armor = new PlateArmor("Armor with holes", 5, SlotType.Body);

        warrior.addWeapon(weapon);
        warrior.addArmor(armor);

        checkStats(warrior, 9, 480, 63, 25, 9, 0, 212);

        assertEquals(119, warrior.attack());

        warrior.clearWeapon();
        warrior.clearArmor();

        checkStats(warrior, 9, 390, 50, 19, 9, 0, 212);
        assertEquals(0, warrior.attack());

    }

    @Test
    void weaponDamageScaledRight() {
        Hero warrior = new Warrior();
        warrior.addExperience(xpToReachLevel(9));
        checkStats(warrior, 9, 390, 50, 19, 9, 0, 212);

        Weapon melee = new MeleeWeapon("Melee", 100);
        Weapon ranged = new RangeWeapon("Ranged", 100);
        Weapon magic = new MagicWeapon("magic", 100);

        warrior.addWeapon(melee);
        assertEquals(290, warrior.attack());
        warrior.addWeapon(ranged);
        assertEquals(343, warrior.attack());
        warrior.addWeapon(magic);
        assertEquals(252, warrior.attack());
        warrior.clearWeapon();
        assertEquals(0, warrior.attack());
    }

    @Test
    void createdRangerHasCorrectInitialValues() {
        checkStats(new Ranger(), 1, 120, 5, 10, 2, 0, 100);
    }

    @Test
    void rangerLevelsUpCorrectly() {
        Ranger ranger = new Ranger();
        ranger.addExperience(xpToReachLevel(12));
        checkStats(ranger, 12, 340, 27, 65, 13, 0, 281);
    }

    @Test
    void createdMageHasCorrectInitialValues() {
        checkStats(new Mage(), 1, 100, 2, 3, 10, 0, 100);
    }

    @Test
    void mageLevelsUpCorrectly() {
        Mage mage = new Mage();
        mage.addExperience(xpToReachLevel(10));
        checkStats(mage, 10, 235, 2 + 9, 3 + 9 * 2, 10 + 5 * 9, 0, 233);
    }

    @Test
    void warriorCanLevelUp() {
        Warrior warrior = new Warrior();
        warrior.addExperience(100);
        checkStats(warrior, 2, 180, 15, 5, 2, 0, 110);

        warrior = new Warrior();
        warrior.addExperience(50);
        checkStats(warrior, 1, 150, 10, 3, 1, 50, 100);
        warrior.addExperience(50);
        checkStats(warrior, 2, 180, 15, 5, 2, 0, 110);

        warrior = new Warrior();
        warrior.addExperience(xpToReachLevel(3));
        checkStats(warrior, 3, 210, 20, 7, 3, 0, 121);

        warrior = new Warrior();
        warrior.addExperience(xpToReachLevel(9));
        checkStats(warrior, 9, 390, 50, 19, 9, 0, 212);
    }

    void checkStats(Hero hero, int level, int health, int strength, int dexterity, int intelligence, int experience, int experienceToNextLevel) {
        assertEquals(level, hero.getLevel());
        assertEquals(health, hero.getHealth());
        assertEquals(strength, hero.getStrength());
        assertEquals(dexterity, hero.getDexterity());
        assertEquals(intelligence, hero.getIntelligence());
        assertEquals(experience, hero.getExperience());
        assertEquals(experienceToNextLevel, hero.getExperienceToNextLevel());
    }

    int xpToReachLevel(int level) {
        if (level < 2) return 0;
        int xpToNextLevel = 100;
        int sum = 100;
        while (--level > 1) {
            xpToNextLevel = (int) Math.floor(1.1 * xpToNextLevel);
            sum += xpToNextLevel;
        }
        return sum;
    }
}