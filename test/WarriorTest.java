import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {
    @Test
    void createdWarriorsInitialValuesAreCorrect() {
        checkStats(new Warrior(), 1, 150, 10, 3, 1, 0, 100);
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
        warrior.addExperience(210);
        checkStats(warrior, 3, 210, 20, 7, 3, 0, 121);

        warrior = new Warrior();
        warrior.addExperience(1140);
        checkStats(warrior, 9, 390, 50, 19, 9, 1, 212);
    }

    void checkStats(Warrior warrior, int level, int health, int strength, int dexterity, int intelligence, int experience, int experienceToNextLevel) {
        assertEquals(level, warrior.getLevel());
        assertEquals(health, warrior.getHealth());
        assertEquals(strength, warrior.getStrength());
        assertEquals(dexterity, warrior.getDexterity());
        assertEquals(intelligence, warrior.getIntelligence());
        assertEquals(experience, warrior.getExperience());
        assertEquals(experienceToNextLevel, warrior.getExperienceToNextLevel());
    }
}