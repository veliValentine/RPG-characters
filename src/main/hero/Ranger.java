package main.hero;

public class Ranger extends Hero {

    public Ranger() {
        super(120, 5, 10, 2);
    }

    public void addExperience(int xp) {
        addExperienceToHero(xp, 20, 2, 5, 1);
    }

    @Override
    public void print() {
        System.out.println("Ranger details: ");
        printStats();
    }
}
