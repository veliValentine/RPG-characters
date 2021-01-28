package main.weapon;

public class MagicWeapon implements Weapon {
    private final int BASE_DAMAGE = 25;
    private String name;
    private int level;


    public MagicWeapon(String name, int level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public void print() {
        System.out.println("Weapon type: Magic");
        System.out.println("Weapon level: " + level);
        System.out.println("Damage: " + damage());
    }

    @Override
    public int damage() {
        return BASE_DAMAGE + 2 * level;
    }

    @Override
    public WeaponType getWeaponType() {
        return WeaponType.Magic;
    }
}
