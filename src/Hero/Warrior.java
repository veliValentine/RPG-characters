package Hero;

import Hero.Hero;

public class Warrior extends Hero {
    public Warrior() {
        super(150, 10, 3, 1);
    }

    @Override
    public void addExperience(int xp) {
        experience += xp;
        while (experience >= experienceToNextLevel) {
            levelUp(30, 5, 2, 1);
        }
    }

    @Override
    public void printDetails() {
        System.out.println("Warrior details:");
        printStats();
    }
}
