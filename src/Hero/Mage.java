package Hero;

public class Mage extends Hero{
    public Mage() {
        super(100, 2, 3, 10);
    }

    @Override
    public void addExperience(int xp) {
        addExperienceToHero(xp, 15, 1, 2, 5);
    }

    @Override
    public void printDetails() {
        System.out.println("Mage details: ");
        printStats();
    }
}
