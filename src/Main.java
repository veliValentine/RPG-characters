import Hero.*;

public class Main {

    public static void main(String[] args) {
        Warrior hero = new Warrior();
        hero.printDetails();
        hero.addExperience(209);
        hero.printDetails();

        Mage mage = new Mage();
        while (mage.getLevel() < 10){
            mage.addExperience(100);
        }
        mage.printDetails();
    }
}
