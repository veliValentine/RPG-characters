package Hero;

public abstract class Hero {
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

    public abstract void addExperience(int xp);

    protected void levelUp(int health, int strength, int dexterity, int intelligence) {
        experience -= experienceToNextLevel;
        experienceToNextLevel = (int) Math.floor(experienceToNextLevel * 1.1);
        level++;
        this.health += health;
        this.strength += strength;
        this.dexterity += dexterity;
        this.intelligence += intelligence;
    }

    public abstract void printDetails();

    protected void printStats(){
        System.out.println("HP: " + getHealth());
        System.out.println("Str: " + getStrength());
        System.out.println("Dex: " + getDexterity());
        System.out.println("Int: " + getIntelligence());
        System.out.println("Lvl: " + level);
        System.out.println("XP to next: " + (experienceToNextLevel - experience));
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
