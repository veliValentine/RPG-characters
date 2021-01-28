package main.weapon;

public class MagicWeapon implements Weapon {
    private final int BASE_DAMAGE = 25;
    private final String name;
    private final int level;

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
        return BASE_DAMAGE + level * 2;
    }

    @Override
    public WeaponType getWeaponType() {
        return WeaponType.Magic;
    }

    @Override
    public String getName() {
        return name;
    }
}
