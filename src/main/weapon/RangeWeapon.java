package main.weapon;

public class RangeWeapon implements Weapon {
    private final int BASE_DAMAGE = 5;
    private final String name;
    private final int level;

    public RangeWeapon(String name, int level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public void print() {
        System.out.println("Weapon type: Ranged");
        System.out.println("Weapon level: " + level);
        System.out.println("Damage: " + damage());
    }

    @Override
    public int damage() {
        return BASE_DAMAGE + level * 3;
    }

    @Override
    public WeaponType getWeaponType() {
        return WeaponType.Ranged;
    }

    @Override
    public String getName() {
        return name;
    }
}
