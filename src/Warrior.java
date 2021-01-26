public class Warrior {
    private int level;
    private int health;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int experience;
    private int experienceToNextLevel;

    public Warrior(){
        health = 150;
        level = 1;
        strength = 10;
        dexterity = 3;
        intelligence = 1;
        experienceToNextLevel = 100;
    }

    public void addExperience(int xp){
        experience += xp;
        while(experience >= experienceToNextLevel){
            levelUp();
        }
    }

    private void levelUp() {
        experience -= experienceToNextLevel;
        experienceToNextLevel = (int) Math.floor(experienceToNextLevel * 1.1);
        level++;
        health += 30;
        strength += 5;
        dexterity += 2;
        intelligence += 1;
    }

    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getExperience() {
        return experience;
    }

    public int getExperienceToNextLevel() {
        return experienceToNextLevel;
    }
}
