package Hero;

public class Hero {
    protected int level;
    protected int health;
    protected int strength;
    protected int dexterity;
    protected int intelligence;
    protected int experience;
    protected int experienceToNextLevel;

    public Hero(int health, int strength, int dexterity, int intelligence) {
        level = 1;
        this.health = health;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        experience = 0;
        experienceToNextLevel = 100;
    }

    public void addExperience(int xp){
        experience += xp;
        while(experience >= experienceToNextLevel){
            levelUp(10, 1, 1, 1);
        }
    }

    protected void levelUp(int health, int strength, int dexterity, int intelligence) {
        experience -= experienceToNextLevel;
        experienceToNextLevel = (int) Math.floor(experienceToNextLevel * 1.1);
        level++;
        this.health += health;
        this.strength += strength;
        this.dexterity += dexterity;
        this.intelligence += intelligence;
    }

    public int getLevel() {
        return level;
    }

    public int getHealth() {
        return health;
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
