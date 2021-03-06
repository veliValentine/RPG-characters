package main.hero;

public class Warrior extends Hero {

    public Warrior() {
        super(150, 10, 3, 1);
    }

    public void addExperience(int xp) {
        addExperienceToHero(xp, 30, 5, 2, 1);
    }

    @Override
    public void print() {
        System.out.println("Warrior details:");
        printStats();
    }
}
